package com.digiwes.resources.beans;

import com.digiwes.basetype.*;

import java.util.List;

public class ProductCatalogResponse {

    private List<ProdCatalogOffering> prodCatalogOfferings;
    /**
     * A unique identifier for a catalog.
     */
    private String ID;
    /**
     * A word or phrase by which a catalog is known and distinguished from other catalogs.
     */
    private String name;
    /**
     * A categorization of an entry in the catalog such as web or book.
     */
    private String type;
    /**
     * The period of time during which the catalog is applicable.
     */
    private TimePeriod validFor;

    public List<ProdCatalogOffering> getProdCatalogOfferings() {
        return prodCatalogOfferings;
    }

    public void setProdCatalogOfferings(List<ProdCatalogOffering> prodCatalogOfferings) {
        this.prodCatalogOfferings = prodCatalogOfferings;
    }

    public String getID() {
        return this.ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public TimePeriod getValidFor() {
        return this.validFor;
    }

    public void setValidFor(TimePeriod validFor) {
        this.validFor = validFor;
    }

}