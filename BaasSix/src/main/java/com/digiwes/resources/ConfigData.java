package com.digiwes.resources;

import com.digiwes.product.offering.ProductOffering;
import com.digiwes.product.offering.catalog.ProductCatalog;
import com.digiwes.product.spec.ProductSpecCharacteristic;
import com.digiwes.product.spec.ProductSpecification;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangyq3 on 2015-07-16.
 */
public class ConfigData {
    public static List<ProductCatalog> productCatalogList = new ArrayList<ProductCatalog>();
    public static List<ProductSpecCharacteristic> productSpecChars;
    public static ProductSpecification specification128 = null;
    public static ProductSpecification specification256 = null;
    public static ProductSpecification specification512 = null;
    public static List<ProductOffering> offerings = new ArrayList<ProductOffering>();
    public static ProductCatalog productCatalog  = null;
}
