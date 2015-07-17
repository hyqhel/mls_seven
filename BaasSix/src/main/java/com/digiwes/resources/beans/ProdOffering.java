package com.digiwes.resources.beans;

import java.util.*;

public class ProdOffering {

    /**
     * A unique identifier for the ProductOffering.
     */
    private String id;
    /**
     * A word, term, or phrase by which the ProductOffeirng is known and distinguished from other ProductOfferings.
     */
    private String name;
    private boolean isBundle;
    /**
     * A narrative that explains what the offering is.
     */
    private String description;
    /**
     * The condition in which the offering exists, such as planned, obsolete, active
     */
    private String status;
    private ProductSpec productSpec;
    private List<BundledOffering> bundledOfferings;
    private List<RelatedOffering> relatedOfferings;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return this.status;
    }

    public ProductSpec getProductSpec() {
        return this.productSpec;
    }

    public void setProductSpec(ProductSpec productSpec) {
        this.productSpec = productSpec;
    }

    public List<BundledOffering> getBundledOfferings() {
        return this.bundledOfferings;
    }

    public void setBundledOfferings(List<BundledOffering> bundledOfferings) {
        this.bundledOfferings = bundledOfferings;
    }

    public List<RelatedOffering> getRelatedOfferings() {
        return this.relatedOfferings;
    }

    public void setRelatedOfferings(List<RelatedOffering> relatedOfferings) {
        this.relatedOfferings = relatedOfferings;
    }

}