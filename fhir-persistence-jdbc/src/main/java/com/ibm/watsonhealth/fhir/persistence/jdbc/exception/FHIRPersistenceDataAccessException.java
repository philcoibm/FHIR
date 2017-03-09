/**
 * (C) Copyright IBM Corp. 2017,2018,2019
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package com.ibm.watsonhealth.fhir.persistence.jdbc.exception;

import javax.ws.rs.core.Response.Status;

import com.ibm.watsonhealth.fhir.persistence.exception.FHIRPersistenceException;

/**
 * This exception class represents failures encountered while attempting to access (read, write) data in the FHIR DB. 
 * @author markd
 *
 */
public class FHIRPersistenceDataAccessException extends FHIRPersistenceException {

	private static final long serialVersionUID = -8350452448890342596L;

	
	public FHIRPersistenceDataAccessException() {
		super();
	}

	public FHIRPersistenceDataAccessException(String message) {
		super(message);
		
	}

	public FHIRPersistenceDataAccessException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public FHIRPersistenceDataAccessException(String message, Status httpStatus, Throwable cause) {
		super(message, httpStatus, cause);
	}

	public FHIRPersistenceDataAccessException(String message, Status httpStatus) {
		super(message, httpStatus);
		
	}

	public FHIRPersistenceDataAccessException(Throwable cause) {
		super(cause);
		
	}

}