/*
 * (C) Copyright IBM Corp. 2019
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package com.ibm.fhir.model.test;

import static com.ibm.fhir.model.type.String.string;
import static org.testng.AssertJUnit.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.Properties;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.json.JsonReaderFactory;

import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;

import com.ibm.fhir.core.FHIRUtilities;
import com.ibm.fhir.examples.ExamplesUtil;
import com.ibm.fhir.exception.FHIRException;
import com.ibm.fhir.model.format.Format;
import com.ibm.fhir.model.generator.FHIRGenerator;
import com.ibm.fhir.model.parser.FHIRParser;
import com.ibm.fhir.model.resource.Observation;
import com.ibm.fhir.model.resource.Resource;
import com.ibm.fhir.model.type.Reference;

public class FHIRModelTestBase {
    private static final JsonReaderFactory JSON_READER_FACTORY = Json.createReaderFactory(null);
    protected static final String NL = System.getProperty("line.separator");
    public static boolean DEBUG_JSON = false;
    public static boolean DEBUG_XML = false;
    
    /**
     * This is a list of pre-defined locations that we'll search in when looking for a mock data file.
     */
    protected static String[] searchPaths = { "./", "src/test/resources/", "src/test/resources/testdata/", "src/main/resources/" };
    
    /**
     * This function finds the specified file on the searchPath, 
     * then de-serializes that into a Resource.
     * 
     * @implNote By default, the search path includes the following relative paths:
     * <li>./
     * <li>src/main/resources/
     * <li>src/test/resources/
     * <li>src/test/resources/testdata/
     * 
     * @param fileName
     *            the name of the file containing the local resource (e.g. "testdata/Patient1.json")
     * @return the de-serialized mock resource
     * @throws Exception
     */
    protected <T extends Resource> T readLocalResource(String fileName) throws Exception {

        // We'll use the filename suffix to determine the format that we're reading.
        Format fmt = (fileName.endsWith(".json") ? Format.JSON : Format.XML);

        // Deserialize the file contents.
        try (Reader reader = new InputStreamReader(resolveFileLocation(fileName), Charset.forName("UTF-8"))) {
            T resource = FHIRParser.parser(fmt).parse(reader);
            return resource;
        }
    }
    
    /**
     * This function reads the contents of an example resource from the specified path in fhir-examples into a Resource.
     * 
     * @param fileName
     *            the name of the file containing the example resource (e.g. "json/ibm/minimal/Patient-1.json")
     * @return the de-serialized resource
     * @throws Exception
     */
    protected <T extends Resource> T readExampleResource(String fileName) throws Exception {

        // Use the filename suffix to determine the format that we're reading, defaulting to JSON
        Format fmt = (fileName.endsWith(".xml") ? Format.XML : Format.JSON);
        
        try (Reader reader = ExamplesUtil.reader(fileName)) {
            return FHIRParser.parser(fmt).parse(reader);
        }
    }
    
    /**
     * @return
     */
    public static JsonObjectBuilder getEmptyBundleJsonObjectBuilder() {
        JsonObjectBuilder bundleObject = Json.createBuilderFactory(null).createObjectBuilder();
        bundleObject.add("resourceType", "Bundle")
            .add("type", "batch");
        return bundleObject;  
    }
    
    
    public static JsonObject getRequestJsonObject(String method, String url) {
        JsonObjectBuilder requestObject = Json.createBuilderFactory(null).createObjectBuilder();
        requestObject.add("method", method)
            .add("url", url);
        return requestObject.build();  
    }    
    
    
    /**
     * @param fileName
     * @return
     * @throws IOException
     * @throws Exception
     */
    public static JsonObject readJsonObjectFromFile(String fileName) throws IOException, Exception {
        try (Reader reader = new InputStreamReader(resolveFileLocation(fileName), Charset.forName("UTF-8"));
                JsonReader jsonReader = JSON_READER_FACTORY.createReader(reader)) {
            return jsonReader.readObject();
            
        }
    }

    /**
     * Loads an Observation resource from the specified file, then associates it with
     * the specified patient via a subject attribute.
     */
    protected Observation buildPatientObservation(String patientId, String fileName) throws Exception {
        // TODO review Reference id
        Observation observation = readLocalResource(fileName);
        
        observation = observation
            .toBuilder()
            .subject(Reference.builder().reference(string("Patient/" + patientId)).build())
            .build();
        return observation;
    } 
    
    /**
     * Returns an InputStream for the specified fileName after searching in a few pre-defined locations.
     */
    protected static InputStream resolveFileLocation(String fileName) throws Exception {

        // First, try to use the filename as-is.
        File f = new File(fileName);
        if (f.exists()) {
            return new FileInputStream(f);
        }

        // Otherwise, look in our configured search path, one directory at a time.
        for (String path : searchPaths) {
            f = new File(path + fileName);
            if (f.exists()) {
                return new FileInputStream(f);
            }
        }
        
        // If we didn't find the file yet, then look on the classpath.
        String resourceName = (fileName.startsWith("json/spec/") ? fileName : "json/spec/" + fileName);
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(resourceName);
        if (is != null) {
            return is;
        }

        throw new FileNotFoundException("File '" + fileName + "' was not found.");
    }
    

    /**
     * Asserts that the "actual" resource contains all the fields and values from the "expected" resource.
     * The comparison is performed in a "lenient" manner, meaning that we'll ensure that all the fields
     * contained in the "expected" resource are also contained in the "actual" resource, but not vice-versa.
     * 
     * @param expected the known-good resource to compare against
     * @param actual the resource to be validated.
     */
    protected void assertResourceEquals(Resource expected, Resource actual) {
        assertResourceEquals(null, expected, actual);
    }
    
    /**
     * Asserts that the "actual" resource contains all the fields and values from the "expected" resource.
     * The comparison is performed in a "lenient" manner, meaning that we'll ensure that all the fields
     * contained in the "expected" resource are also contained in the "actual" resource, but not vice-versa.
     * 
     * @param msg a string to be included in any error messages
     * @param expected the known-good resource to compare against
     * @param actual the resource to be validated.
     */
    protected void assertResourceEquals(String msg, Resource expected, Resource actual) {
        String cleanMsg = (msg != null ? msg : "");
        if (!expected.getClass().equals(actual.getClass())) {
            fail(cleanMsg + ": resource type mismatch, expected resource of type: " + expected.getClass() + 
                    ", but was of type: " + actual.getClass());
        }

        // Serialize the 'expected' resource.
        String jsonExpected = null;
        try {
            jsonExpected = FHIRUtilities.stripNewLineWhitespaceIfPresentInDiv(
                                   FHIRUtilities.stripNamespaceIfPresentInDiv(writeResource(expected, Format.JSON, true)));
        } catch (Throwable t) {
            fail(cleanMsg + ": error serializing expected resource: " + t);
        }
        
        // Serialize the 'actual' resource.
        String jsonActual = null;
        try {
            jsonActual = FHIRUtilities.stripNewLineWhitespaceIfPresentInDiv(
                                FHIRUtilities.stripNamespaceIfPresentInDiv(writeResource(actual, Format.JSON, true)));
        } catch (Throwable t) {
            fail(cleanMsg + ": error serializing actual resource: " + t);
        }
        
        // Finally, make sure the expected and actual resources are equivalent.
        // Note that we'll do a "lenient" comparison which means we'll make sure
        // that all the fields contained in "expected" also exist in "actual".
        // The "actual" resource in the REST API response will likely contain a couple of additional
        // fields (e.g. "id" and "meta") so we can't do a "strict" comparison.
        try {
            JSONAssert.assertEquals(jsonExpected, jsonActual, false);
        } catch (JSONException e) {
            fail(cleanMsg + ": expected resource: \n" + jsonExpected + "\nbut actual resource was:\n" + jsonActual);
        }
    }
    
    /**
     * Reads a properties file containing test related properties used by subclasses.
     * @return Properties - A Properties object containing the contents of the test.properties file.
     * @throws Exception
     */
    protected static Properties readTestProperties(String fileName) throws Exception {
        Properties properties = new Properties();
        try (InputStream is = resolveFileLocation(fileName)) {
            properties.load(is);
            return properties;
        }
    }
    
    /**
     * Serializes the specified resource according to 'fmt' (JSON/XML).
     */
    public static <T extends Resource> String writeResource(T resource, Format fmt, boolean prettyPrint) throws FHIRException {
        StringWriter sw = new StringWriter();
        FHIRGenerator.generator(fmt, prettyPrint).generate(resource, sw);
        return sw.toString();
    }
    
    /**
     * Reads a JSON object from the specified file.
     */
    protected JsonObject readJsonObject(String fileName) throws Exception {
        try (JsonReader jsonReader = JSON_READER_FACTORY.createReader(resolveFileLocation(fileName))) {
            return jsonReader.readObject();
            
        }
    }
}