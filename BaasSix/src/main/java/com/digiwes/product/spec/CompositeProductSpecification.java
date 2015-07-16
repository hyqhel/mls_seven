package com.digiwes.product.spec;

import java.util.*;

import com.digiwes.basetype.*;
import com.digiwes.common.util.CommonUtils;
import org.apache.log4j.Logger;

/**
 * A type of ProductSpecification that is formed by aggregating other ProductSpecifications, which may be Composite or Atomic ProductSpecifications.
 */
public class CompositeProductSpecification extends ProductSpecification {

    private static Logger logger = Logger.getLogger(CompositeProductSpecification.class);

    public List<ProductSpecification> prodSpec;

    /**
     * @param productNumber
     * @param name
     * @param brand
     */
    public CompositeProductSpecification(String productNumber, String name, String brand) {
        super(productNumber, name, brand);
    }

    /**
     * @param productNumber
     * @param name
     * @param brand
     * @param description
     * @param validFor
     */
    public CompositeProductSpecification(String productNumber, String name, String brand, String description, TimePeriod validFor) {
        super(productNumber, name, brand, validFor, description);
    }

    /**
     * @param prodSpec
     */
    public int composedOf(ProductSpecification prodSpec) {

        if (null == this.prodSpec) {
            this.prodSpec = new ArrayList<ProductSpecification>();
        }
        if (CommonUtils.checkParamIsNull(prodSpec)) {
            return 0;
        }

        if (this.prodSpec.contains(prodSpec)) {
            logger.error("the subProdSpec already exist, Cannot repeatedly create subProdSpec. ProductNumber="
                    + prodSpec.getProductNumber());
            return 0;
        }
        if (this.equals(prodSpec)) {
            logger.error("Cannot add subProdSpec with it self!");
            return 0;
        }
        this.prodSpec.add(prodSpec);
        return 0;
    }

    /**
     * @param status
     */
    public List<ProductSpecification> retrieveProductSpec(String status) {
        // TODO - implement CompositeProductSpecification.retrieveProductSpec
        return null;
    }

    /**
     * @param time
     */
    public List<ProductSpecification> retrieveProductSpec(Date time) {
        // TODO - implement CompositeProductSpecification.retrieveProductSpec
        return null;
    }

    public String toString() {
        // TODO - implement CompositeProductSpecification.toString
        return null;
    }

}