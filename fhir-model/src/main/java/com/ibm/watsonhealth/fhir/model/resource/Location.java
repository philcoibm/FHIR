/**
 * (C) Copyright IBM Corp. 2019
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package com.ibm.watsonhealth.fhir.model.resource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import javax.annotation.Generated;

import com.ibm.watsonhealth.fhir.model.type.Address;
import com.ibm.watsonhealth.fhir.model.type.BackboneElement;
import com.ibm.watsonhealth.fhir.model.type.Boolean;
import com.ibm.watsonhealth.fhir.model.type.Code;
import com.ibm.watsonhealth.fhir.model.type.CodeableConcept;
import com.ibm.watsonhealth.fhir.model.type.Coding;
import com.ibm.watsonhealth.fhir.model.type.ContactPoint;
import com.ibm.watsonhealth.fhir.model.type.DaysOfWeek;
import com.ibm.watsonhealth.fhir.model.type.Decimal;
import com.ibm.watsonhealth.fhir.model.type.Extension;
import com.ibm.watsonhealth.fhir.model.type.Id;
import com.ibm.watsonhealth.fhir.model.type.Identifier;
import com.ibm.watsonhealth.fhir.model.type.LocationMode;
import com.ibm.watsonhealth.fhir.model.type.LocationStatus;
import com.ibm.watsonhealth.fhir.model.type.Meta;
import com.ibm.watsonhealth.fhir.model.type.Narrative;
import com.ibm.watsonhealth.fhir.model.type.Reference;
import com.ibm.watsonhealth.fhir.model.type.String;
import com.ibm.watsonhealth.fhir.model.type.Time;
import com.ibm.watsonhealth.fhir.model.type.Uri;
import com.ibm.watsonhealth.fhir.model.util.ValidationSupport;
import com.ibm.watsonhealth.fhir.model.visitor.Visitor;

/**
 * <p>
 * Details and position information for a physical place where services are provided and resources and participants may 
 * be stored, found, contained, or accommodated.
 * </p>
 */
@Generated("com.ibm.watsonhealth.fhir.tools.CodeGenerator")
public class Location extends DomainResource {
    private final List<Identifier> identifier;
    private final LocationStatus status;
    private final Coding operationalStatus;
    private final String name;
    private final List<String> alias;
    private final String description;
    private final LocationMode mode;
    private final List<CodeableConcept> type;
    private final List<ContactPoint> telecom;
    private final Address address;
    private final CodeableConcept physicalType;
    private final Position position;
    private final Reference managingOrganization;
    private final Reference partOf;
    private final List<HoursOfOperation> hoursOfOperation;
    private final String availabilityExceptions;
    private final List<Reference> endpoint;

    private volatile int hashCode;

    private Location(Builder builder) {
        super(builder);
        identifier = Collections.unmodifiableList(builder.identifier);
        status = builder.status;
        operationalStatus = builder.operationalStatus;
        name = builder.name;
        alias = Collections.unmodifiableList(builder.alias);
        description = builder.description;
        mode = builder.mode;
        type = Collections.unmodifiableList(builder.type);
        telecom = Collections.unmodifiableList(builder.telecom);
        address = builder.address;
        physicalType = builder.physicalType;
        position = builder.position;
        managingOrganization = builder.managingOrganization;
        partOf = builder.partOf;
        hoursOfOperation = Collections.unmodifiableList(builder.hoursOfOperation);
        availabilityExceptions = builder.availabilityExceptions;
        endpoint = Collections.unmodifiableList(builder.endpoint);
    }

    /**
     * <p>
     * Unique code or number identifying the location to its users.
     * </p>
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link Identifier}.
     */
    public List<Identifier> getIdentifier() {
        return identifier;
    }

    /**
     * <p>
     * The status property covers the general availability of the resource, not the current value which may be covered by the 
     * operationStatus, or by a schedule/slots if they are configured for the location.
     * </p>
     * 
     * @return
     *     An immutable object of type {@link LocationStatus}.
     */
    public LocationStatus getStatus() {
        return status;
    }

    /**
     * <p>
     * The operational status covers operation values most relevant to beds (but can also apply to rooms/units/chairs/etc. 
     * such as an isolation unit/dialysis chair). This typically covers concepts such as contamination, housekeeping, and 
     * other activities like maintenance.
     * </p>
     * 
     * @return
     *     An immutable object of type {@link Coding}.
     */
    public Coding getOperationalStatus() {
        return operationalStatus;
    }

    /**
     * <p>
     * Name of the location as used by humans. Does not need to be unique.
     * </p>
     * 
     * @return
     *     An immutable object of type {@link String}.
     */
    public String getName() {
        return name;
    }

    /**
     * <p>
     * A list of alternate names that the location is known as, or was known as, in the past.
     * </p>
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link String}.
     */
    public List<String> getAlias() {
        return alias;
    }

    /**
     * <p>
     * Description of the Location, which helps in finding or referencing the place.
     * </p>
     * 
     * @return
     *     An immutable object of type {@link String}.
     */
    public String getDescription() {
        return description;
    }

    /**
     * <p>
     * Indicates whether a resource instance represents a specific location or a class of locations.
     * </p>
     * 
     * @return
     *     An immutable object of type {@link LocationMode}.
     */
    public LocationMode getMode() {
        return mode;
    }

    /**
     * <p>
     * Indicates the type of function performed at the location.
     * </p>
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link CodeableConcept}.
     */
    public List<CodeableConcept> getType() {
        return type;
    }

    /**
     * <p>
     * The contact details of communication devices available at the location. This can include phone numbers, fax numbers, 
     * mobile numbers, email addresses and web sites.
     * </p>
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link ContactPoint}.
     */
    public List<ContactPoint> getTelecom() {
        return telecom;
    }

    /**
     * <p>
     * Physical location.
     * </p>
     * 
     * @return
     *     An immutable object of type {@link Address}.
     */
    public Address getAddress() {
        return address;
    }

    /**
     * <p>
     * Physical form of the location, e.g. building, room, vehicle, road.
     * </p>
     * 
     * @return
     *     An immutable object of type {@link CodeableConcept}.
     */
    public CodeableConcept getPhysicalType() {
        return physicalType;
    }

    /**
     * <p>
     * The absolute geographic location of the Location, expressed using the WGS84 datum (This is the same co-ordinate system 
     * used in KML).
     * </p>
     * 
     * @return
     *     An immutable object of type {@link Position}.
     */
    public Position getPosition() {
        return position;
    }

    /**
     * <p>
     * The organization responsible for the provisioning and upkeep of the location.
     * </p>
     * 
     * @return
     *     An immutable object of type {@link Reference}.
     */
    public Reference getManagingOrganization() {
        return managingOrganization;
    }

    /**
     * <p>
     * Another Location of which this Location is physically a part of.
     * </p>
     * 
     * @return
     *     An immutable object of type {@link Reference}.
     */
    public Reference getPartOf() {
        return partOf;
    }

    /**
     * <p>
     * What days/times during a week is this location usually open.
     * </p>
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link HoursOfOperation}.
     */
    public List<HoursOfOperation> getHoursOfOperation() {
        return hoursOfOperation;
    }

    /**
     * <p>
     * A description of when the locations opening ours are different to normal, e.g. public holiday availability. Succinctly 
     * describing all possible exceptions to normal site availability as detailed in the opening hours Times.
     * </p>
     * 
     * @return
     *     An immutable object of type {@link String}.
     */
    public String getAvailabilityExceptions() {
        return availabilityExceptions;
    }

    /**
     * <p>
     * Technical endpoints providing access to services operated for the location.
     * </p>
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link Reference}.
     */
    public List<Reference> getEndpoint() {
        return endpoint;
    }

    @Override
    public void accept(java.lang.String elementName, Visitor visitor) {
        if (visitor.preVisit(this)) {
            visitor.visitStart(elementName, this);
            if (visitor.visit(elementName, this)) {
                // visit children
                accept(id, "id", visitor);
                accept(meta, "meta", visitor);
                accept(implicitRules, "implicitRules", visitor);
                accept(language, "language", visitor);
                accept(text, "text", visitor);
                accept(contained, "contained", visitor, Resource.class);
                accept(extension, "extension", visitor, Extension.class);
                accept(modifierExtension, "modifierExtension", visitor, Extension.class);
                accept(identifier, "identifier", visitor, Identifier.class);
                accept(status, "status", visitor);
                accept(operationalStatus, "operationalStatus", visitor);
                accept(name, "name", visitor);
                accept(alias, "alias", visitor, String.class);
                accept(description, "description", visitor);
                accept(mode, "mode", visitor);
                accept(type, "type", visitor, CodeableConcept.class);
                accept(telecom, "telecom", visitor, ContactPoint.class);
                accept(address, "address", visitor);
                accept(physicalType, "physicalType", visitor);
                accept(position, "position", visitor);
                accept(managingOrganization, "managingOrganization", visitor);
                accept(partOf, "partOf", visitor);
                accept(hoursOfOperation, "hoursOfOperation", visitor, HoursOfOperation.class);
                accept(availabilityExceptions, "availabilityExceptions", visitor);
                accept(endpoint, "endpoint", visitor, Reference.class);
            }
            visitor.visitEnd(elementName, this);
            visitor.postVisit(this);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Location other = (Location) obj;
        return Objects.equals(id, other.id) && 
            Objects.equals(meta, other.meta) && 
            Objects.equals(implicitRules, other.implicitRules) && 
            Objects.equals(language, other.language) && 
            Objects.equals(text, other.text) && 
            Objects.equals(contained, other.contained) && 
            Objects.equals(extension, other.extension) && 
            Objects.equals(modifierExtension, other.modifierExtension) && 
            Objects.equals(identifier, other.identifier) && 
            Objects.equals(status, other.status) && 
            Objects.equals(operationalStatus, other.operationalStatus) && 
            Objects.equals(name, other.name) && 
            Objects.equals(alias, other.alias) && 
            Objects.equals(description, other.description) && 
            Objects.equals(mode, other.mode) && 
            Objects.equals(type, other.type) && 
            Objects.equals(telecom, other.telecom) && 
            Objects.equals(address, other.address) && 
            Objects.equals(physicalType, other.physicalType) && 
            Objects.equals(position, other.position) && 
            Objects.equals(managingOrganization, other.managingOrganization) && 
            Objects.equals(partOf, other.partOf) && 
            Objects.equals(hoursOfOperation, other.hoursOfOperation) && 
            Objects.equals(availabilityExceptions, other.availabilityExceptions) && 
            Objects.equals(endpoint, other.endpoint);
    }

    @Override
    public int hashCode() {
        int result = hashCode;
        if (result == 0) {
            result = Objects.hash(id, 
                meta, 
                implicitRules, 
                language, 
                text, 
                contained, 
                extension, 
                modifierExtension, 
                identifier, 
                status, 
                operationalStatus, 
                name, 
                alias, 
                description, 
                mode, 
                type, 
                telecom, 
                address, 
                physicalType, 
                position, 
                managingOrganization, 
                partOf, 
                hoursOfOperation, 
                availabilityExceptions, 
                endpoint);
            hashCode = result;
        }
        return result;
    }

    @Override
    public Builder toBuilder() {
        return new Builder().from(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends DomainResource.Builder {
        // optional
        private List<Identifier> identifier = new ArrayList<>();
        private LocationStatus status;
        private Coding operationalStatus;
        private String name;
        private List<String> alias = new ArrayList<>();
        private String description;
        private LocationMode mode;
        private List<CodeableConcept> type = new ArrayList<>();
        private List<ContactPoint> telecom = new ArrayList<>();
        private Address address;
        private CodeableConcept physicalType;
        private Position position;
        private Reference managingOrganization;
        private Reference partOf;
        private List<HoursOfOperation> hoursOfOperation = new ArrayList<>();
        private String availabilityExceptions;
        private List<Reference> endpoint = new ArrayList<>();

        private Builder() {
            super();
        }

        /**
         * <p>
         * The logical id of the resource, as used in the URL for the resource. Once assigned, this value never changes.
         * </p>
         * 
         * @param id
         *     Logical id of this artifact
         * 
         * @return
         *     A reference to this Builder instance
         */
        @Override
        public Builder id(Id id) {
            return (Builder) super.id(id);
        }

        /**
         * <p>
         * The metadata about the resource. This is content that is maintained by the infrastructure. Changes to the content 
         * might not always be associated with version changes to the resource.
         * </p>
         * 
         * @param meta
         *     Metadata about the resource
         * 
         * @return
         *     A reference to this Builder instance
         */
        @Override
        public Builder meta(Meta meta) {
            return (Builder) super.meta(meta);
        }

        /**
         * <p>
         * A reference to a set of rules that were followed when the resource was constructed, and which must be understood when 
         * processing the content. Often, this is a reference to an implementation guide that defines the special rules along 
         * with other profiles etc.
         * </p>
         * 
         * @param implicitRules
         *     A set of rules under which this content was created
         * 
         * @return
         *     A reference to this Builder instance
         */
        @Override
        public Builder implicitRules(Uri implicitRules) {
            return (Builder) super.implicitRules(implicitRules);
        }

        /**
         * <p>
         * The base language in which the resource is written.
         * </p>
         * 
         * @param language
         *     Language of the resource content
         * 
         * @return
         *     A reference to this Builder instance
         */
        @Override
        public Builder language(Code language) {
            return (Builder) super.language(language);
        }

        /**
         * <p>
         * A human-readable narrative that contains a summary of the resource and can be used to represent the content of the 
         * resource to a human. The narrative need not encode all the structured data, but is required to contain sufficient 
         * detail to make it "clinically safe" for a human to just read the narrative. Resource definitions may define what 
         * content should be represented in the narrative to ensure clinical safety.
         * </p>
         * 
         * @param text
         *     Text summary of the resource, for human interpretation
         * 
         * @return
         *     A reference to this Builder instance
         */
        @Override
        public Builder text(Narrative text) {
            return (Builder) super.text(text);
        }

        /**
         * <p>
         * These resources do not have an independent existence apart from the resource that contains them - they cannot be 
         * identified independently, and nor can they have their own independent transaction scope.
         * </p>
         * <p>
         * Adds new element(s) to the existing list
         * </p>
         * 
         * @param contained
         *     Contained, inline Resources
         * 
         * @return
         *     A reference to this Builder instance
         */
        @Override
        public Builder contained(Resource... contained) {
            return (Builder) super.contained(contained);
        }

        /**
         * <p>
         * These resources do not have an independent existence apart from the resource that contains them - they cannot be 
         * identified independently, and nor can they have their own independent transaction scope.
         * </p>
         * <p>
         * Replaces existing list with a new one containing elements from the Collection
         * </p>
         * 
         * @param contained
         *     Contained, inline Resources
         * 
         * @return
         *     A reference to this Builder instance
         */
        @Override
        public Builder contained(Collection<Resource> contained) {
            return (Builder) super.contained(contained);
        }

        /**
         * <p>
         * May be used to represent additional information that is not part of the basic definition of the resource. To make the 
         * use of extensions safe and manageable, there is a strict set of governance applied to the definition and use of 
         * extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part 
         * of the definition of the extension.
         * </p>
         * <p>
         * Adds new element(s) to the existing list
         * </p>
         * 
         * @param extension
         *     Additional content defined by implementations
         * 
         * @return
         *     A reference to this Builder instance
         */
        @Override
        public Builder extension(Extension... extension) {
            return (Builder) super.extension(extension);
        }

        /**
         * <p>
         * May be used to represent additional information that is not part of the basic definition of the resource. To make the 
         * use of extensions safe and manageable, there is a strict set of governance applied to the definition and use of 
         * extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part 
         * of the definition of the extension.
         * </p>
         * <p>
         * Replaces existing list with a new one containing elements from the Collection
         * </p>
         * 
         * @param extension
         *     Additional content defined by implementations
         * 
         * @return
         *     A reference to this Builder instance
         */
        @Override
        public Builder extension(Collection<Extension> extension) {
            return (Builder) super.extension(extension);
        }

        /**
         * <p>
         * May be used to represent additional information that is not part of the basic definition of the resource and that 
         * modifies the understanding of the element that contains it and/or the understanding of the containing element's 
         * descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe and 
         * manageable, there is a strict set of governance applied to the definition and use of extensions. Though any 
         * implementer is allowed to define an extension, there is a set of requirements that SHALL be met as part of the 
         * definition of the extension. Applications processing a resource are required to check for modifier extensions.
         * </p>
         * <p>
         * Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot 
         * change the meaning of modifierExtension itself).
         * </p>
         * <p>
         * Adds new element(s) to the existing list
         * </p>
         * 
         * @param modifierExtension
         *     Extensions that cannot be ignored
         * 
         * @return
         *     A reference to this Builder instance
         */
        @Override
        public Builder modifierExtension(Extension... modifierExtension) {
            return (Builder) super.modifierExtension(modifierExtension);
        }

        /**
         * <p>
         * May be used to represent additional information that is not part of the basic definition of the resource and that 
         * modifies the understanding of the element that contains it and/or the understanding of the containing element's 
         * descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe and 
         * manageable, there is a strict set of governance applied to the definition and use of extensions. Though any 
         * implementer is allowed to define an extension, there is a set of requirements that SHALL be met as part of the 
         * definition of the extension. Applications processing a resource are required to check for modifier extensions.
         * </p>
         * <p>
         * Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot 
         * change the meaning of modifierExtension itself).
         * </p>
         * <p>
         * Replaces existing list with a new one containing elements from the Collection
         * </p>
         * 
         * @param modifierExtension
         *     Extensions that cannot be ignored
         * 
         * @return
         *     A reference to this Builder instance
         */
        @Override
        public Builder modifierExtension(Collection<Extension> modifierExtension) {
            return (Builder) super.modifierExtension(modifierExtension);
        }

        /**
         * <p>
         * Unique code or number identifying the location to its users.
         * </p>
         * <p>
         * Adds new element(s) to the existing list
         * </p>
         * 
         * @param identifier
         *     Unique code or number identifying the location to its users
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder identifier(Identifier... identifier) {
            for (Identifier value : identifier) {
                this.identifier.add(value);
            }
            return this;
        }

        /**
         * <p>
         * Unique code or number identifying the location to its users.
         * </p>
         * <p>
         * Replaces existing list with a new one containing elements from the Collection
         * </p>
         * 
         * @param identifier
         *     Unique code or number identifying the location to its users
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder identifier(Collection<Identifier> identifier) {
            this.identifier = new ArrayList<>(identifier);
            return this;
        }

        /**
         * <p>
         * The status property covers the general availability of the resource, not the current value which may be covered by the 
         * operationStatus, or by a schedule/slots if they are configured for the location.
         * </p>
         * 
         * @param status
         *     active | suspended | inactive
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder status(LocationStatus status) {
            this.status = status;
            return this;
        }

        /**
         * <p>
         * The operational status covers operation values most relevant to beds (but can also apply to rooms/units/chairs/etc. 
         * such as an isolation unit/dialysis chair). This typically covers concepts such as contamination, housekeeping, and 
         * other activities like maintenance.
         * </p>
         * 
         * @param operationalStatus
         *     The operational status of the location (typically only for a bed/room)
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder operationalStatus(Coding operationalStatus) {
            this.operationalStatus = operationalStatus;
            return this;
        }

        /**
         * <p>
         * Name of the location as used by humans. Does not need to be unique.
         * </p>
         * 
         * @param name
         *     Name of the location as used by humans
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * <p>
         * A list of alternate names that the location is known as, or was known as, in the past.
         * </p>
         * <p>
         * Adds new element(s) to the existing list
         * </p>
         * 
         * @param alias
         *     A list of alternate names that the location is known as, or was known as, in the past
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder alias(String... alias) {
            for (String value : alias) {
                this.alias.add(value);
            }
            return this;
        }

        /**
         * <p>
         * A list of alternate names that the location is known as, or was known as, in the past.
         * </p>
         * <p>
         * Replaces existing list with a new one containing elements from the Collection
         * </p>
         * 
         * @param alias
         *     A list of alternate names that the location is known as, or was known as, in the past
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder alias(Collection<String> alias) {
            this.alias = new ArrayList<>(alias);
            return this;
        }

        /**
         * <p>
         * Description of the Location, which helps in finding or referencing the place.
         * </p>
         * 
         * @param description
         *     Additional details about the location that could be displayed as further information to identify the location beyond 
         *     its name
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder description(String description) {
            this.description = description;
            return this;
        }

        /**
         * <p>
         * Indicates whether a resource instance represents a specific location or a class of locations.
         * </p>
         * 
         * @param mode
         *     instance | kind
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder mode(LocationMode mode) {
            this.mode = mode;
            return this;
        }

        /**
         * <p>
         * Indicates the type of function performed at the location.
         * </p>
         * <p>
         * Adds new element(s) to the existing list
         * </p>
         * 
         * @param type
         *     Type of function performed
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder type(CodeableConcept... type) {
            for (CodeableConcept value : type) {
                this.type.add(value);
            }
            return this;
        }

        /**
         * <p>
         * Indicates the type of function performed at the location.
         * </p>
         * <p>
         * Replaces existing list with a new one containing elements from the Collection
         * </p>
         * 
         * @param type
         *     Type of function performed
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder type(Collection<CodeableConcept> type) {
            this.type = new ArrayList<>(type);
            return this;
        }

        /**
         * <p>
         * The contact details of communication devices available at the location. This can include phone numbers, fax numbers, 
         * mobile numbers, email addresses and web sites.
         * </p>
         * <p>
         * Adds new element(s) to the existing list
         * </p>
         * 
         * @param telecom
         *     Contact details of the location
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder telecom(ContactPoint... telecom) {
            for (ContactPoint value : telecom) {
                this.telecom.add(value);
            }
            return this;
        }

        /**
         * <p>
         * The contact details of communication devices available at the location. This can include phone numbers, fax numbers, 
         * mobile numbers, email addresses and web sites.
         * </p>
         * <p>
         * Replaces existing list with a new one containing elements from the Collection
         * </p>
         * 
         * @param telecom
         *     Contact details of the location
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder telecom(Collection<ContactPoint> telecom) {
            this.telecom = new ArrayList<>(telecom);
            return this;
        }

        /**
         * <p>
         * Physical location.
         * </p>
         * 
         * @param address
         *     Physical location
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder address(Address address) {
            this.address = address;
            return this;
        }

        /**
         * <p>
         * Physical form of the location, e.g. building, room, vehicle, road.
         * </p>
         * 
         * @param physicalType
         *     Physical form of the location
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder physicalType(CodeableConcept physicalType) {
            this.physicalType = physicalType;
            return this;
        }

        /**
         * <p>
         * The absolute geographic location of the Location, expressed using the WGS84 datum (This is the same co-ordinate system 
         * used in KML).
         * </p>
         * 
         * @param position
         *     The absolute geographic location
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder position(Position position) {
            this.position = position;
            return this;
        }

        /**
         * <p>
         * The organization responsible for the provisioning and upkeep of the location.
         * </p>
         * 
         * @param managingOrganization
         *     Organization responsible for provisioning and upkeep
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder managingOrganization(Reference managingOrganization) {
            this.managingOrganization = managingOrganization;
            return this;
        }

        /**
         * <p>
         * Another Location of which this Location is physically a part of.
         * </p>
         * 
         * @param partOf
         *     Another Location this one is physically a part of
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder partOf(Reference partOf) {
            this.partOf = partOf;
            return this;
        }

        /**
         * <p>
         * What days/times during a week is this location usually open.
         * </p>
         * <p>
         * Adds new element(s) to the existing list
         * </p>
         * 
         * @param hoursOfOperation
         *     What days/times during a week is this location usually open
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder hoursOfOperation(HoursOfOperation... hoursOfOperation) {
            for (HoursOfOperation value : hoursOfOperation) {
                this.hoursOfOperation.add(value);
            }
            return this;
        }

        /**
         * <p>
         * What days/times during a week is this location usually open.
         * </p>
         * <p>
         * Replaces existing list with a new one containing elements from the Collection
         * </p>
         * 
         * @param hoursOfOperation
         *     What days/times during a week is this location usually open
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder hoursOfOperation(Collection<HoursOfOperation> hoursOfOperation) {
            this.hoursOfOperation = new ArrayList<>(hoursOfOperation);
            return this;
        }

        /**
         * <p>
         * A description of when the locations opening ours are different to normal, e.g. public holiday availability. Succinctly 
         * describing all possible exceptions to normal site availability as detailed in the opening hours Times.
         * </p>
         * 
         * @param availabilityExceptions
         *     Description of availability exceptions
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder availabilityExceptions(String availabilityExceptions) {
            this.availabilityExceptions = availabilityExceptions;
            return this;
        }

        /**
         * <p>
         * Technical endpoints providing access to services operated for the location.
         * </p>
         * <p>
         * Adds new element(s) to the existing list
         * </p>
         * 
         * @param endpoint
         *     Technical endpoints providing access to services operated for the location
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder endpoint(Reference... endpoint) {
            for (Reference value : endpoint) {
                this.endpoint.add(value);
            }
            return this;
        }

        /**
         * <p>
         * Technical endpoints providing access to services operated for the location.
         * </p>
         * <p>
         * Replaces existing list with a new one containing elements from the Collection
         * </p>
         * 
         * @param endpoint
         *     Technical endpoints providing access to services operated for the location
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder endpoint(Collection<Reference> endpoint) {
            this.endpoint = new ArrayList<>(endpoint);
            return this;
        }

        @Override
        public Location build() {
            return new Location(this);
        }

        private Builder from(Location location) {
            id = location.id;
            meta = location.meta;
            implicitRules = location.implicitRules;
            language = location.language;
            text = location.text;
            contained.addAll(location.contained);
            extension.addAll(location.extension);
            modifierExtension.addAll(location.modifierExtension);
            identifier.addAll(location.identifier);
            status = location.status;
            operationalStatus = location.operationalStatus;
            name = location.name;
            alias.addAll(location.alias);
            description = location.description;
            mode = location.mode;
            type.addAll(location.type);
            telecom.addAll(location.telecom);
            address = location.address;
            physicalType = location.physicalType;
            position = location.position;
            managingOrganization = location.managingOrganization;
            partOf = location.partOf;
            hoursOfOperation.addAll(location.hoursOfOperation);
            availabilityExceptions = location.availabilityExceptions;
            endpoint.addAll(location.endpoint);
            return this;
        }
    }

    /**
     * <p>
     * The absolute geographic location of the Location, expressed using the WGS84 datum (This is the same co-ordinate system 
     * used in KML).
     * </p>
     */
    public static class Position extends BackboneElement {
        private final Decimal longitude;
        private final Decimal latitude;
        private final Decimal altitude;

        private volatile int hashCode;

        private Position(Builder builder) {
            super(builder);
            longitude = ValidationSupport.requireNonNull(builder.longitude, "longitude");
            latitude = ValidationSupport.requireNonNull(builder.latitude, "latitude");
            altitude = builder.altitude;
            if (!hasChildren()) {
                throw new IllegalStateException("ele-1: All FHIR elements must have a @value or children");
            }
        }

        /**
         * <p>
         * Longitude. The value domain and the interpretation are the same as for the text of the longitude element in KML (see 
         * notes below).
         * </p>
         * 
         * @return
         *     An immutable object of type {@link Decimal}.
         */
        public Decimal getLongitude() {
            return longitude;
        }

        /**
         * <p>
         * Latitude. The value domain and the interpretation are the same as for the text of the latitude element in KML (see 
         * notes below).
         * </p>
         * 
         * @return
         *     An immutable object of type {@link Decimal}.
         */
        public Decimal getLatitude() {
            return latitude;
        }

        /**
         * <p>
         * Altitude. The value domain and the interpretation are the same as for the text of the altitude element in KML (see 
         * notes below).
         * </p>
         * 
         * @return
         *     An immutable object of type {@link Decimal}.
         */
        public Decimal getAltitude() {
            return altitude;
        }

        @Override
        protected boolean hasChildren() {
            return super.hasChildren() || 
                (longitude != null) || 
                (latitude != null) || 
                (altitude != null);
        }

        @Override
        public void accept(java.lang.String elementName, Visitor visitor) {
            if (visitor.preVisit(this)) {
                visitor.visitStart(elementName, this);
                if (visitor.visit(elementName, this)) {
                    // visit children
                    accept(id, "id", visitor);
                    accept(extension, "extension", visitor, Extension.class);
                    accept(modifierExtension, "modifierExtension", visitor, Extension.class);
                    accept(longitude, "longitude", visitor);
                    accept(latitude, "latitude", visitor);
                    accept(altitude, "altitude", visitor);
                }
                visitor.visitEnd(elementName, this);
                visitor.postVisit(this);
            }
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            Position other = (Position) obj;
            return Objects.equals(id, other.id) && 
                Objects.equals(extension, other.extension) && 
                Objects.equals(modifierExtension, other.modifierExtension) && 
                Objects.equals(longitude, other.longitude) && 
                Objects.equals(latitude, other.latitude) && 
                Objects.equals(altitude, other.altitude);
        }

        @Override
        public int hashCode() {
            int result = hashCode;
            if (result == 0) {
                result = Objects.hash(id, 
                    extension, 
                    modifierExtension, 
                    longitude, 
                    latitude, 
                    altitude);
                hashCode = result;
            }
            return result;
        }

        @Override
        public Builder toBuilder() {
            return new Builder(longitude, latitude).from(this);
        }

        public Builder toBuilder(Decimal longitude, Decimal latitude) {
            return new Builder(longitude, latitude).from(this);
        }

        public static Builder builder(Decimal longitude, Decimal latitude) {
            return new Builder(longitude, latitude);
        }

        public static class Builder extends BackboneElement.Builder {
            // required
            private final Decimal longitude;
            private final Decimal latitude;

            // optional
            private Decimal altitude;

            private Builder(Decimal longitude, Decimal latitude) {
                super();
                this.longitude = longitude;
                this.latitude = latitude;
            }

            /**
             * <p>
             * Unique id for the element within a resource (for internal references). This may be any string value that does not 
             * contain spaces.
             * </p>
             * 
             * @param id
             *     Unique id for inter-element referencing
             * 
             * @return
             *     A reference to this Builder instance
             */
            @Override
            public Builder id(java.lang.String id) {
                return (Builder) super.id(id);
            }

            /**
             * <p>
             * May be used to represent additional information that is not part of the basic definition of the element. To make the 
             * use of extensions safe and manageable, there is a strict set of governance applied to the definition and use of 
             * extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part 
             * of the definition of the extension.
             * </p>
             * <p>
             * Adds new element(s) to the existing list
             * </p>
             * 
             * @param extension
             *     Additional content defined by implementations
             * 
             * @return
             *     A reference to this Builder instance
             */
            @Override
            public Builder extension(Extension... extension) {
                return (Builder) super.extension(extension);
            }

            /**
             * <p>
             * May be used to represent additional information that is not part of the basic definition of the element. To make the 
             * use of extensions safe and manageable, there is a strict set of governance applied to the definition and use of 
             * extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part 
             * of the definition of the extension.
             * </p>
             * <p>
             * Replaces existing list with a new one containing elements from the Collection
             * </p>
             * 
             * @param extension
             *     Additional content defined by implementations
             * 
             * @return
             *     A reference to this Builder instance
             */
            @Override
            public Builder extension(Collection<Extension> extension) {
                return (Builder) super.extension(extension);
            }

            /**
             * <p>
             * May be used to represent additional information that is not part of the basic definition of the element and that 
             * modifies the understanding of the element in which it is contained and/or the understanding of the containing 
             * element's descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe 
             * and manageable, there is a strict set of governance applied to the definition and use of extensions. Though any 
             * implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the 
             * extension. Applications processing a resource are required to check for modifier extensions.
             * </p>
             * <p>
             * Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot 
             * change the meaning of modifierExtension itself).
             * </p>
             * <p>
             * Adds new element(s) to the existing list
             * </p>
             * 
             * @param modifierExtension
             *     Extensions that cannot be ignored even if unrecognized
             * 
             * @return
             *     A reference to this Builder instance
             */
            @Override
            public Builder modifierExtension(Extension... modifierExtension) {
                return (Builder) super.modifierExtension(modifierExtension);
            }

            /**
             * <p>
             * May be used to represent additional information that is not part of the basic definition of the element and that 
             * modifies the understanding of the element in which it is contained and/or the understanding of the containing 
             * element's descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe 
             * and manageable, there is a strict set of governance applied to the definition and use of extensions. Though any 
             * implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the 
             * extension. Applications processing a resource are required to check for modifier extensions.
             * </p>
             * <p>
             * Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot 
             * change the meaning of modifierExtension itself).
             * </p>
             * <p>
             * Replaces existing list with a new one containing elements from the Collection
             * </p>
             * 
             * @param modifierExtension
             *     Extensions that cannot be ignored even if unrecognized
             * 
             * @return
             *     A reference to this Builder instance
             */
            @Override
            public Builder modifierExtension(Collection<Extension> modifierExtension) {
                return (Builder) super.modifierExtension(modifierExtension);
            }

            /**
             * <p>
             * Altitude. The value domain and the interpretation are the same as for the text of the altitude element in KML (see 
             * notes below).
             * </p>
             * 
             * @param altitude
             *     Altitude with WGS84 datum
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder altitude(Decimal altitude) {
                this.altitude = altitude;
                return this;
            }

            @Override
            public Position build() {
                return new Position(this);
            }

            private Builder from(Position position) {
                id = position.id;
                extension.addAll(position.extension);
                modifierExtension.addAll(position.modifierExtension);
                altitude = position.altitude;
                return this;
            }
        }
    }

    /**
     * <p>
     * What days/times during a week is this location usually open.
     * </p>
     */
    public static class HoursOfOperation extends BackboneElement {
        private final List<DaysOfWeek> daysOfWeek;
        private final Boolean allDay;
        private final Time openingTime;
        private final Time closingTime;

        private volatile int hashCode;

        private HoursOfOperation(Builder builder) {
            super(builder);
            daysOfWeek = Collections.unmodifiableList(builder.daysOfWeek);
            allDay = builder.allDay;
            openingTime = builder.openingTime;
            closingTime = builder.closingTime;
            if (!hasChildren()) {
                throw new IllegalStateException("ele-1: All FHIR elements must have a @value or children");
            }
        }

        /**
         * <p>
         * Indicates which days of the week are available between the start and end Times.
         * </p>
         * 
         * @return
         *     An unmodifiable list containing immutable objects of type {@link DaysOfWeek}.
         */
        public List<DaysOfWeek> getDaysOfWeek() {
            return daysOfWeek;
        }

        /**
         * <p>
         * The Location is open all day.
         * </p>
         * 
         * @return
         *     An immutable object of type {@link Boolean}.
         */
        public Boolean getAllDay() {
            return allDay;
        }

        /**
         * <p>
         * Time that the Location opens.
         * </p>
         * 
         * @return
         *     An immutable object of type {@link Time}.
         */
        public Time getOpeningTime() {
            return openingTime;
        }

        /**
         * <p>
         * Time that the Location closes.
         * </p>
         * 
         * @return
         *     An immutable object of type {@link Time}.
         */
        public Time getClosingTime() {
            return closingTime;
        }

        @Override
        protected boolean hasChildren() {
            return super.hasChildren() || 
                !daysOfWeek.isEmpty() || 
                (allDay != null) || 
                (openingTime != null) || 
                (closingTime != null);
        }

        @Override
        public void accept(java.lang.String elementName, Visitor visitor) {
            if (visitor.preVisit(this)) {
                visitor.visitStart(elementName, this);
                if (visitor.visit(elementName, this)) {
                    // visit children
                    accept(id, "id", visitor);
                    accept(extension, "extension", visitor, Extension.class);
                    accept(modifierExtension, "modifierExtension", visitor, Extension.class);
                    accept(daysOfWeek, "daysOfWeek", visitor, DaysOfWeek.class);
                    accept(allDay, "allDay", visitor);
                    accept(openingTime, "openingTime", visitor);
                    accept(closingTime, "closingTime", visitor);
                }
                visitor.visitEnd(elementName, this);
                visitor.postVisit(this);
            }
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            HoursOfOperation other = (HoursOfOperation) obj;
            return Objects.equals(id, other.id) && 
                Objects.equals(extension, other.extension) && 
                Objects.equals(modifierExtension, other.modifierExtension) && 
                Objects.equals(daysOfWeek, other.daysOfWeek) && 
                Objects.equals(allDay, other.allDay) && 
                Objects.equals(openingTime, other.openingTime) && 
                Objects.equals(closingTime, other.closingTime);
        }

        @Override
        public int hashCode() {
            int result = hashCode;
            if (result == 0) {
                result = Objects.hash(id, 
                    extension, 
                    modifierExtension, 
                    daysOfWeek, 
                    allDay, 
                    openingTime, 
                    closingTime);
                hashCode = result;
            }
            return result;
        }

        @Override
        public Builder toBuilder() {
            return new Builder().from(this);
        }

        public static Builder builder() {
            return new Builder();
        }

        public static class Builder extends BackboneElement.Builder {
            // optional
            private List<DaysOfWeek> daysOfWeek = new ArrayList<>();
            private Boolean allDay;
            private Time openingTime;
            private Time closingTime;

            private Builder() {
                super();
            }

            /**
             * <p>
             * Unique id for the element within a resource (for internal references). This may be any string value that does not 
             * contain spaces.
             * </p>
             * 
             * @param id
             *     Unique id for inter-element referencing
             * 
             * @return
             *     A reference to this Builder instance
             */
            @Override
            public Builder id(java.lang.String id) {
                return (Builder) super.id(id);
            }

            /**
             * <p>
             * May be used to represent additional information that is not part of the basic definition of the element. To make the 
             * use of extensions safe and manageable, there is a strict set of governance applied to the definition and use of 
             * extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part 
             * of the definition of the extension.
             * </p>
             * <p>
             * Adds new element(s) to the existing list
             * </p>
             * 
             * @param extension
             *     Additional content defined by implementations
             * 
             * @return
             *     A reference to this Builder instance
             */
            @Override
            public Builder extension(Extension... extension) {
                return (Builder) super.extension(extension);
            }

            /**
             * <p>
             * May be used to represent additional information that is not part of the basic definition of the element. To make the 
             * use of extensions safe and manageable, there is a strict set of governance applied to the definition and use of 
             * extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part 
             * of the definition of the extension.
             * </p>
             * <p>
             * Replaces existing list with a new one containing elements from the Collection
             * </p>
             * 
             * @param extension
             *     Additional content defined by implementations
             * 
             * @return
             *     A reference to this Builder instance
             */
            @Override
            public Builder extension(Collection<Extension> extension) {
                return (Builder) super.extension(extension);
            }

            /**
             * <p>
             * May be used to represent additional information that is not part of the basic definition of the element and that 
             * modifies the understanding of the element in which it is contained and/or the understanding of the containing 
             * element's descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe 
             * and manageable, there is a strict set of governance applied to the definition and use of extensions. Though any 
             * implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the 
             * extension. Applications processing a resource are required to check for modifier extensions.
             * </p>
             * <p>
             * Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot 
             * change the meaning of modifierExtension itself).
             * </p>
             * <p>
             * Adds new element(s) to the existing list
             * </p>
             * 
             * @param modifierExtension
             *     Extensions that cannot be ignored even if unrecognized
             * 
             * @return
             *     A reference to this Builder instance
             */
            @Override
            public Builder modifierExtension(Extension... modifierExtension) {
                return (Builder) super.modifierExtension(modifierExtension);
            }

            /**
             * <p>
             * May be used to represent additional information that is not part of the basic definition of the element and that 
             * modifies the understanding of the element in which it is contained and/or the understanding of the containing 
             * element's descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe 
             * and manageable, there is a strict set of governance applied to the definition and use of extensions. Though any 
             * implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the 
             * extension. Applications processing a resource are required to check for modifier extensions.
             * </p>
             * <p>
             * Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot 
             * change the meaning of modifierExtension itself).
             * </p>
             * <p>
             * Replaces existing list with a new one containing elements from the Collection
             * </p>
             * 
             * @param modifierExtension
             *     Extensions that cannot be ignored even if unrecognized
             * 
             * @return
             *     A reference to this Builder instance
             */
            @Override
            public Builder modifierExtension(Collection<Extension> modifierExtension) {
                return (Builder) super.modifierExtension(modifierExtension);
            }

            /**
             * <p>
             * Indicates which days of the week are available between the start and end Times.
             * </p>
             * <p>
             * Adds new element(s) to the existing list
             * </p>
             * 
             * @param daysOfWeek
             *     mon | tue | wed | thu | fri | sat | sun
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder daysOfWeek(DaysOfWeek... daysOfWeek) {
                for (DaysOfWeek value : daysOfWeek) {
                    this.daysOfWeek.add(value);
                }
                return this;
            }

            /**
             * <p>
             * Indicates which days of the week are available between the start and end Times.
             * </p>
             * <p>
             * Replaces existing list with a new one containing elements from the Collection
             * </p>
             * 
             * @param daysOfWeek
             *     mon | tue | wed | thu | fri | sat | sun
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder daysOfWeek(Collection<DaysOfWeek> daysOfWeek) {
                this.daysOfWeek = new ArrayList<>(daysOfWeek);
                return this;
            }

            /**
             * <p>
             * The Location is open all day.
             * </p>
             * 
             * @param allDay
             *     The Location is open all day
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder allDay(Boolean allDay) {
                this.allDay = allDay;
                return this;
            }

            /**
             * <p>
             * Time that the Location opens.
             * </p>
             * 
             * @param openingTime
             *     Time that the Location opens
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder openingTime(Time openingTime) {
                this.openingTime = openingTime;
                return this;
            }

            /**
             * <p>
             * Time that the Location closes.
             * </p>
             * 
             * @param closingTime
             *     Time that the Location closes
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder closingTime(Time closingTime) {
                this.closingTime = closingTime;
                return this;
            }

            @Override
            public HoursOfOperation build() {
                return new HoursOfOperation(this);
            }

            private Builder from(HoursOfOperation hoursOfOperation) {
                id = hoursOfOperation.id;
                extension.addAll(hoursOfOperation.extension);
                modifierExtension.addAll(hoursOfOperation.modifierExtension);
                daysOfWeek.addAll(hoursOfOperation.daysOfWeek);
                allDay = hoursOfOperation.allDay;
                openingTime = hoursOfOperation.openingTime;
                closingTime = hoursOfOperation.closingTime;
                return this;
            }
        }
    }
}
