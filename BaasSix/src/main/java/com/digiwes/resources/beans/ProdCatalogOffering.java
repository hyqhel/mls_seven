package com.digiwes.resources.beans;

import com.digiwes.basetype.*;

public class ProdCatalogOffering {

    private TimePeriod validFor;
    private ProdOffering prodOffering;

    public ProdOffering getProdOffering() {
        return this.prodOffering;
    }

    public void setProdOffering(ProdOffering prodOffering) {
        this.prodOffering = prodOffering;
    }


    public TimePeriod getValidFor() {
        return validFor;
    }

    public void setValidFor(TimePeriod validFor) {
        this.validFor = validFor;
    }
}