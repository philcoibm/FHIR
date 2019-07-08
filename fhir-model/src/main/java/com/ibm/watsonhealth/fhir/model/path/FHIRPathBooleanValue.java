/**
 * (C) Copyright IBM Corp. 2019
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package com.ibm.watsonhealth.fhir.model.path;

import java.util.Collection;
import java.util.Objects;

public class FHIRPathBooleanValue extends FHIRPathAbstractNode implements FHIRPathPrimitiveValue {
    private final Boolean _boolean;
    
    protected FHIRPathBooleanValue(Builder builder) {
        super(builder);
        _boolean = builder._boolean;
    }
    
    @Override
    public boolean isBooleanValue() {
        return true;
    }
    
    public Boolean _boolean() {
        return _boolean;
    }
    
    public static FHIRPathBooleanValue booleanValue(Boolean _boolean) {
        return FHIRPathBooleanValue.builder(_boolean).build();
    }
    
    public static FHIRPathBooleanValue booleanValue(String name, Boolean _boolean) {
        return FHIRPathBooleanValue.builder(_boolean).name(name).build();
    }

    @Override
    public Builder toBuilder() {
        return new Builder(type, _boolean);
    }
    
    public static Builder builder(Boolean _boolean) {
        return new Builder(FHIRPathType.SYSTEM_BOOLEAN, _boolean);
    }
    
    public static class Builder extends FHIRPathAbstractNode.Builder {
        private final Boolean _boolean;
        
        private Builder(FHIRPathType type, Boolean _boolean) {
            super(type);
            this._boolean = _boolean;
        }
        
        @Override
        public Builder name(String name) {
            return (Builder) super.name(name);
        }
        
        @Override
        public Builder value(FHIRPathPrimitiveValue value) {
            return this;
        }
        
        @Override
        public Builder children(FHIRPathNode... children) {
            return this;
        }
        
        @Override
        public Builder children(Collection<FHIRPathNode> children) {
            return this;
        }
        
        @Override
        public Builder children(FHIRPathNode.Builder builder) {
            return this;
        }

        @Override
        public FHIRPathBooleanValue build() {
            return new FHIRPathBooleanValue(this);
        }
    }
    
    public FHIRPathBooleanValue or(FHIRPathBooleanValue value) {
        return booleanValue(_boolean || value._boolean());
    }
    
    public FHIRPathBooleanValue xor(FHIRPathBooleanValue value) {
        return booleanValue((_boolean || value._boolean()) && !(_boolean && value._boolean()));
    }
    
    public FHIRPathBooleanValue and(FHIRPathBooleanValue value) {
        return booleanValue(_boolean && value._boolean());
    }
    
    public FHIRPathBooleanValue implies(FHIRPathBooleanValue value) {
        return booleanValue(!_boolean || value._boolean());
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
        FHIRPathBooleanValue other = (FHIRPathBooleanValue) obj;
        return Objects.equals(_boolean, other._boolean());
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(_boolean);
    }
    
    @Override
    public String toString() {
        return _boolean.toString();
    }
}