package com.digiwes.product.offering;

import com.digiwes.basetype.TimePeriod;
import com.digiwes.common.enums.ProductOfferingStatus;
import com.digiwes.product.spec.AtomicProductSpecification;
import com.digiwes.product.spec.ProductSpecification;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by huangyq3 on 2015-07-17.
 */
public class SimpleProductOfferingTest {

    @Test
    public void createSimpleProductOffering() {

        //create a simple by null spec
        String id = "0001OF";
        String name = "11 英寸 MacBook Air";
        TimePeriod validFor = new TimePeriod("2015-06-04 10:20:00", "2015-06-26 10:20:00");
        String description = "1.6GHz 双核 Intel Core i5 处理器，Turbo Boost 高达 2.7GHz";
        ProductSpecification prodSpec = null;
        try {
            SimpleProductOffering offering = new SimpleProductOffering(id, name, description, validFor, prodSpec);
            fail("fail when the prodSpec is null。");
        } catch (AssertionError ex) {
        }

        //create a simple by right spec
        prodSpec = new AtomicProductSpecification("001SP", "11 英寸 MacBook Air SPEC", "Mac Air");
        SimpleProductOffering offering = new SimpleProductOffering(id, name, description, validFor, prodSpec);
        assertEquals("0001OF", offering.getId());
        assertEquals("11 英寸 MacBook Air", offering.getName());
        assertEquals("1.6GHz 双核 Intel Core i5 处理器，Turbo Boost 高达 2.7GHz", offering.getDescription());
        assertEquals(ProductOfferingStatus.PLANNED.getValue(), offering.getStatus());
        assertEquals(new TimePeriod("2015-06-04 10:20:00", "2015-06-26 10:20:00"), offering.getValidFor());
        assertEquals(new AtomicProductSpecification("001SP", "11 英寸 MacBook Air SPEC", "Mac Air"), offering.getProductSpecification());
    }
}