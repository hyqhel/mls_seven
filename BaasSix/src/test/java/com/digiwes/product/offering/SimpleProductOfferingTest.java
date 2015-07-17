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

        String id = "0001OF";
        String name = "11 Ó¢´ç MacBook Air";
        TimePeriod validFor = new TimePeriod("2015-06-04 10:20:00", "2015-06-26 10:20:00");
        String description = "1.6GHz Ë«ºË Intel Core i5 ´¦ÀíÆ÷£¬Turbo Boost ¸ß´ï 2.7GHz";
        ProductSpecification prodSpec = null;
        try {
            SimpleProductOffering offering = new SimpleProductOffering(id, name, description, validFor, prodSpec);
            fail("fail when the prodSpec is null¡£");
        } catch (AssertionError ex) {
        }

        prodSpec = new AtomicProductSpecification("001SP", "11 Ó¢´ç MacBook Air SPEC", "Mac Air");
        SimpleProductOffering offering = new SimpleProductOffering(id, name, description, validFor, prodSpec);
        assertEquals("0001OF", offering.getId());
        assertEquals("11 Ó¢´ç MacBook Air", offering.getName());
        assertEquals("1.6GHz Ë«ºË Intel Core i5 ´¦ÀíÆ÷£¬Turbo Boost ¸ß´ï 2.7GHz", offering.getDescription());
        assertEquals(ProductOfferingStatus.PLANNED.getValue(), offering.getStatus());
        assertEquals(new TimePeriod("2015-06-04 10:20:00", "2015-06-26 10:20:00"), offering.getValidFor());
        assertEquals(new AtomicProductSpecification("001SP", "11 Ó¢´ç MacBook Air SPEC", "Mac Air"), offering.getProductSpecification());
    }
}