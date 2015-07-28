package com.digiwes.product.offering;

import com.digiwes.basetype.TimePeriod;
import com.digiwes.common.enums.CommonErrorEnum;
import com.digiwes.common.enums.ProductOfferingErrorEnum;
import com.digiwes.product.spec.AtomicProductSpecification;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by huangyq3 on 2015-07-17.
 */
public class BundledProductOfferingTest {
    private BundledProductOffering parentOffering = null;
    private AtomicProductSpecification prodSpec = null;
    @Before
    public void initOffering() {
        String id = "0001OF";
        String name = "11 英寸 MacBook Air";
        TimePeriod validFor = new TimePeriod("2015-06-04 10:20:00", "2015-06-26 10:20:00");
        String description = "13 英寸配备 Retina 显示屏的 MacBook Pro";
        parentOffering = new BundledProductOffering(id, name, description, validFor);
        prodSpec = new AtomicProductSpecification("SP001", "Mac Book Pro", "Apple Mac Pro");
    }

    /**
     * test param ProductOffering
     */
    @Test
    public void testComposedOf()  {
        TimePeriod validFor = new TimePeriod("2015-06-04 10:20:00", "2015-06-26 10:20:00");
        List<BundledProdOfferOption> expectedSubOfferingOptionList = new ArrayList<BundledProdOfferOption>();

        //bundle a right simpleOffering
        SimpleProductOffering subOffering1 = new SimpleProductOffering("SO001", "11 英寸 MacBook Air 2.7GHz",
                "2.7GHz 双核 Intel Core i5 处理器 Turbo Boost 高达 3.1GHz", validFor, prodSpec);
        parentOffering.composedOf(subOffering1);
        SimpleProductOffering expectedSubOffering1 = new SimpleProductOffering("SO001", "11 英寸 MacBook Air 2.7GHz",
                "2.7GHz 双核 Intel Core i5 处理器 Turbo Boost 高达 3.1GHz", validFor, prodSpec);
        BundledProdOfferOption expectedBundledOfferingOption1 = new BundledProdOfferOption(expectedSubOffering1, -1,
                -1);
        expectedSubOfferingOptionList.add(expectedBundledOfferingOption1);
        assertEquals("Add a normal sub offering.", 1, parentOffering.getBundledProdOfferOption().size());
        assertEquals("Add a normal sub offering.", expectedSubOfferingOptionList, parentOffering.getBundledProdOfferOption());

        //bundle a same simpleOffering
        int returnCode = parentOffering.composedOf(subOffering1);
        assertEquals("Add the same sub offering again.", ProductOfferingErrorEnum.COMPOSE_REPETITIVE_OFFERING.getCode(), returnCode);
        assertEquals("Add the same sub offering again.", 1, parentOffering.getBundledProdOfferOption().size());
        assertEquals("Add the same sub offering again.", expectedSubOfferingOptionList, parentOffering.getBundledProdOfferOption());

        //bundle a null simpleOffering
        returnCode = parentOffering.composedOf(null);
        assertEquals("Add a null sub offering", ProductOfferingErrorEnum.OFFERING_IS_NULL.getCode(), returnCode);
        assertEquals("Add the same sub offering again.", 1, parentOffering.getBundledProdOfferOption().size());
        assertEquals("Add the same sub offering again.", expectedSubOfferingOptionList, parentOffering.getBundledProdOfferOption());

    }
    /**
     * test param ProductOffering,lowerLimit and upperLimit
     */
    @Test
    public void testComposedOf1() {
        TimePeriod validFor = new TimePeriod("2015-06-04 10:20:00", "2015-06-26 10:20:00");
        List<BundledProdOfferOption> expectedSubOfferingOptionList = new ArrayList<BundledProdOfferOption>();

        //bundle a right offering but  lowerLimit <= upperLimit
        SimpleProductOffering subOffering1 = new SimpleProductOffering("SO002", "11 英寸 MacBook Air 2.9GHz",
                "2.9GHz 双核 Intel Core i5 处理器 Turbo Boost 高达 3.3GHz", validFor, prodSpec);
        SimpleProductOffering expectedSubOffering2 = new SimpleProductOffering("SO002", "11 英寸 MacBook Air 2.9GHz",
                "2.9GHz 双核 Intel Core i5 处理器 Turbo Boost 高达 3.1GHz", validFor, prodSpec);
        BundledProdOfferOption expectedBundledOfferingOption2 = new BundledProdOfferOption(expectedSubOffering2, -1, -1);
        expectedSubOfferingOptionList.add(expectedBundledOfferingOption2);
        int returnCode = parentOffering.composeOf(subOffering1,-1,1);
        assertEquals("bundle sub offering again.", CommonErrorEnum.SUCCESS.getCode(), returnCode);
        assertEquals("bundle sub offering again.", 1, parentOffering.getBundledProdOfferOption().size());
        assertEquals("bundle sub offering again.", expectedSubOfferingOptionList, parentOffering.getBundledProdOfferOption());

        //bundle a right offering but  lowerLimit > upperLimit
        returnCode = parentOffering.composeOf(subOffering1,2,1);
        assertEquals("check code", ProductOfferingErrorEnum.LOWERLIMIT_GREATER_UPPERLIMIT.getCode(), returnCode);
        assertEquals("check content", expectedSubOfferingOptionList, parentOffering.getBundledProdOfferOption());

        //bundle a null offering but  lowerLimit <= upperLimit
        returnCode = parentOffering.composeOf(null,1,2);
        assertEquals("check code", ProductOfferingErrorEnum.OFFERING_IS_NULL.getCode(), returnCode);
        assertEquals("check content", expectedSubOfferingOptionList, parentOffering.getBundledProdOfferOption());

        //bundle a null offering but  lowerLimit > upperLimit
        returnCode = parentOffering.composeOf(null,2,1);
        assertEquals("check code", ProductOfferingErrorEnum.LOWERLIMIT_GREATER_UPPERLIMIT.getCode(), returnCode);
        assertEquals("check content", expectedSubOfferingOptionList, parentOffering.getBundledProdOfferOption());

        //bundle a exists  offering but  lowerLimit <= upperLimit
        returnCode = parentOffering.composeOf(subOffering1,1,3);
        assertEquals("check code", ProductOfferingErrorEnum.COMPOSE_REPETITIVE_OFFERING.getCode(), returnCode);
        assertEquals("check content", expectedSubOfferingOptionList, parentOffering.getBundledProdOfferOption());

        //bundle a exists  offering but  lowerLimit > upperLimit
        returnCode = parentOffering.composeOf(subOffering1,3,1);
        assertEquals("check code", ProductOfferingErrorEnum.LOWERLIMIT_GREATER_UPPERLIMIT.getCode(), returnCode);
        assertEquals("check content", expectedSubOfferingOptionList, parentOffering.getBundledProdOfferOption());

        //bundle myself offering but  lowerLimit <= upperLimit
        returnCode = parentOffering.composeOf(parentOffering,1,3);
        assertEquals("check code", ProductOfferingErrorEnum.OFFERING_ASSOCIATE_ITSELF.getCode(), returnCode);
        assertEquals("check content", expectedSubOfferingOptionList, parentOffering.getBundledProdOfferOption());

        //bundle myself offering but  lowerLimit > upperLimit
        returnCode = parentOffering.composeOf(parentOffering,3,1);
        assertEquals("check code", ProductOfferingErrorEnum.LOWERLIMIT_GREATER_UPPERLIMIT.getCode(), returnCode);
        assertEquals("check content", expectedSubOfferingOptionList, parentOffering.getBundledProdOfferOption());

       //bundle a different right offering but  lowerLimit > upperLimit
        SimpleProductOffering subOffering3 = new SimpleProductOffering("SO003", "11 英寸 MacBook Air 2.7GHz",
                "2.7GHz 双核 Intel Core i5 处理器 Turbo Boost 高达 3.1GHz", validFor, prodSpec);
        SimpleProductOffering expectedSubOffering3 = new SimpleProductOffering("SO003", "11 英寸 MacBook Air 2.7GHz",
                "2.7GHz 双核 Intel Core i5 处理器 Turbo Boost 高达 3.1GHz", validFor, prodSpec);
        BundledProdOfferOption expectedBundledOfferingOption3 = new BundledProdOfferOption(expectedSubOffering3, 1, 3);
        expectedSubOfferingOptionList.add(expectedBundledOfferingOption3);
        returnCode = parentOffering.composeOf(subOffering3,1,3);
        assertEquals("check code", CommonErrorEnum.SUCCESS.getCode(), returnCode);
        assertEquals("check content", expectedSubOfferingOptionList, parentOffering.getBundledProdOfferOption());
    }

}