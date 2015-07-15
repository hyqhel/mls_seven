package com.digiwes.common.catalog;

import com.digiwes.basetype.*;

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
     * 
     * @param id
     * @param name
     * @param type
     * @param validFor
     */
    public Catalog(String id, String name, String type, TimePeriod validFor) {
        // TODO - implement Catalog.Catalog
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param o
     */
    public boolean equals(Object o) {
        // TODO - implement Catalog.equals
        throw new UnsupportedOperationException();
    }

    public int hashCode() {
        // TODO - implement Catalog.hashCode
        throw new UnsupportedOperationException();
    }

}