package com.digiwes.product.spec;

import com.digiwes.basetype.*;
import com.digiwes.common.enums.RelationshipType;

import java.util.HashMap;
import java.util.Map;

/**
 * A migration, substitution, dependency, or exclusivity relationship between/among ProductSpecifications.
 */
public class ProductSpecificationRelationship {

    ProductSpecification targetProdSpec;
    ProductSpecification sourceSpec;
    /**
     * A categorization of the relationship, such as migration, substitution, dependency, exclusivity.
     */
    private String type;
    /**
     * The period for which the relationship is applicable.
     */
    private TimePeriod validFor;

    public ProductSpecification getTargetProdSpec() {
        return targetProdSpec;
    }

    public void setTargetProdSpec(ProductSpecification targetProdSpec) {
        this.targetProdSpec = targetProdSpec;
    }

    public ProductSpecification getSourceSpec() {
        return sourceSpec;
    }

    public void setSourceSpec(ProductSpecification sourceSpec) {
        this.sourceSpec = sourceSpec;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public TimePeriod getValidFor() {
        return validFor;
    }

    public void setValidFor(TimePeriod validFor) {
        this.validFor = validFor;
    }

    /**
     * @param sourceSpec
     * @param targetSpec
     * @param type
     * @param validFor
     */
    public ProductSpecificationRelationship(ProductSpecification sourceSpec, ProductSpecification targetSpec, String type, TimePeriod validFor) {
        this.sourceSpec = sourceSpec;
        this.targetProdSpec = targetSpec;
        this.type = type;
        this.validFor = validFor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductSpecificationRelationship that = (ProductSpecificationRelationship) o;

        if (!targetProdSpec.equals(that.targetProdSpec)) return false;
        if (!type.equals(that.type)) return false;
        return !(validFor != null ? !validFor.equals(that.validFor) : that.validFor != null);

    }

    @Override
    public int hashCode() {
        int result = targetProdSpec.hashCode();
        result = 31 * result + type.hashCode();
        result = 31 * result + (validFor != null ? validFor.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        Map<String, Object> relationshipMap = new HashMap<String, Object>();
        relationshipMap.put("targetProdSpec", this.targetProdSpec);
        relationshipMap.put("type", RelationshipType.getName(this.type));
        relationshipMap.put("validFor", this.validFor);

        return relationshipMap.toString();
    }
}