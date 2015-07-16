package com.digiwes.common.catalog;

import com.digiwes.basetype.*;
import com.digiwes.product.offering.ProductOffering;
import org.apache.commons.lang.StringUtils;

public class Catalog {

    /**
     * A unique identifier for a catalog.
     */
    public String ID;
    /**
     * A word or phrase by which a catalog is known and distinguished from other catalogs.
     */
    public String name;
    /**
     * A categorization of an entry in the catalog such as web or book.
     */
    public String type;
    /**
     * The period of time during which the catalog is applicable.
     */
    public TimePeriod validFor;

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

    /**
     * @param id
     * @param name
     * @param type
     */
    public Catalog(String id, String name, String type) {
        assert StringUtils.isNotEmpty(id) : "Parameter [id] must be not null!";
        this.ID = id;
        this.name = name;
        this.type = type;
    }

    /**
     * @param id
     * @param name
     * @param type
     * @param validFor
     */
    public Catalog(String id, String name, String type, TimePeriod validFor) {
        assert StringUtils.isNotEmpty(id) : "Parameter [id] must be not null!";
        this.ID = id;
        this.name = name;
        this.type = type;
        this.validFor = validFor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductOffering that = (ProductOffering) o;

        return ID.equals(that.getId());

    }

    @Override
    public int hashCode() {
        return ID.hashCode();
    }

}