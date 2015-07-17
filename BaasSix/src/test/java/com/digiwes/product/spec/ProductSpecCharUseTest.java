package com.digiwes.product.spec;

import com.digiwes.basetype.TimePeriod;
import com.digiwes.common.enums.CommonErrorEnum;
import com.digiwes.common.enums.ProductSpecErrorEnum;
import com.digiwes.common.util.DateUtils;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by huangyq3 on 2015-07-16.
 */
public class ProductSpecCharUseTest {
    private ProductSpecCharUse pscu = null;
    private ProductSpecCharacteristic prodSpecCharOwn = null;
    private static TimePeriod validFor;

    @Before
    public void createProductSpecCharacteristic() {
        prodSpecCharOwn = new ProductSpecCharacteristic("1", "深度", "number", validFor, "false", 1, 1, true, "height",
                "");
        ProductSpecCharacteristicValue prodSpecCharValue = new ProductSpecCharacteristicValue("1", false, "cm",
                validFor, "12", "", "");
        prodSpecCharOwn.assignValue(prodSpecCharValue);
        ProductSpecCharacteristicValue prodSpecCharValue1 = new ProductSpecCharacteristicValue("1", false, "cm",
                validFor, "12.3", "", "");
        prodSpecCharOwn.assignValue(prodSpecCharValue1);
        pscu = new ProductSpecCharUse(prodSpecCharOwn, false, false, validFor, "深度");
    }

    @BeforeClass
    public static void initValidFor() {
        String startDate = "2015-06-01 12:01:01";
        String endDate = "2015-08-01 23:12:54";
        validFor = new TimePeriod(startDate, endDate);
    }

    @Test
    public void testSpecifyCardinality() throws Exception {

        int retCode = pscu.specifyCardinality(6, 5);
        assertEquals("maxCardinality is less than minCardinality", ProductSpecErrorEnum
                .MAX_CARDINALITY_LESS_THAN_MIN_CARDINALITY.getCode(), retCode);
        assertEquals("set characteristicUse cardinality,judet minCardinality", 0, pscu.getMinCardinality());
        assertEquals("set characteristicUse cardinality,judet maxCardinality", 0, pscu.getMaxCardinality());


        retCode = pscu.specifyCardinality(1, 5);
        assertEquals("maxCardinality is less than minCardinality", CommonErrorEnum.SUCCESS.getCode(), retCode);
        assertEquals("set characteristicUse cardinality,judet minCardinality", 1, pscu.getMinCardinality());
        assertEquals("set characteristicUse cardinality,judet maxCardinality", 5, pscu.getMaxCardinality());


        retCode = pscu.specifyCardinality(5, 5);
        assertEquals("maxCardinality is less than minCardinality", CommonErrorEnum.SUCCESS.getCode(), retCode);
        assertEquals("set characteristicUse cardinality,judet minCardinality", 5, pscu.getMinCardinality());
        assertEquals("set characteristicUse cardinality,judet maxCardinality", 5, pscu.getMaxCardinality());
    }

    @Test
    public void testAssignValue() throws Exception {

        int retCode = pscu.assignValue(null, false, validFor);
        assertEquals("Assign a null charValue.", ProductSpecErrorEnum.CHAR_VALUE_IS_NULL.getCode(), retCode);
        assertEquals("Assign a null charValue.", 0, pscu.getProdSpecCharValue().size());

        ProductSpecCharacteristicValue prodSpecCharValue = new ProductSpecCharacteristicValue("1", false, "cm",
                validFor, "12", "", "");
        ProductSpecCharacteristicValue prodSpecCharValue2 = new ProductSpecCharacteristicValue("1", false, "cm",
                validFor, "12", "", "");
        ProductSpecCharacteristicValue prodSpecCharValue3 = new ProductSpecCharacteristicValue("1", false, "cm",
                validFor, "13", "", "");

        retCode = pscu.assignValue(prodSpecCharValue, false, validFor);

        List<ProdSpecCharValueUse> expectedCharUseList = new ArrayList<ProdSpecCharValueUse>();
        ProdSpecCharValueUse expectedCharValueUse = new ProdSpecCharValueUse(prodSpecCharValue, false, validFor);
        expectedCharUseList.add(expectedCharValueUse);
        assertEquals("Assign a normal charValue.", CommonErrorEnum.SUCCESS.getCode(), retCode);
        assertEquals("Assign a normal charValue.", 1, pscu.getProdSpecCharValue().size());
        assertEquals("Assign a normal charValue.", expectedCharUseList, pscu.getProdSpecCharValue());

        retCode = pscu.assignValue(prodSpecCharValue2, true, validFor);
        assertEquals("Assign a normal charValue.", ProductSpecErrorEnum.SPEC_CHAR_ALREADY_USE_THE_VALUE.getCode(), retCode);
        assertEquals("Assign the same charValue again.", 1, pscu.getProdSpecCharValue().size());
        assertEquals("Assign the same charValue again.", expectedCharUseList, pscu.getProdSpecCharValue());

        retCode = pscu.assignValue(prodSpecCharValue3, false, validFor);
        assertEquals("add a charValue but the charValue isn't belong to the char.", ProductSpecErrorEnum
                .CHAR_NOT_EXISTS_THE_VALUE.getCode()
                , retCode);
        assertEquals("add a charValue but the charValue isn't belong to the char.", 1, pscu.getProdSpecCharValue()
                .size());
        assertEquals("add a charValue but the charValue isn't belong to the char.", expectedCharUseList, pscu
                .getProdSpecCharValue());


    }

    @Test
    public void testSpecifyDefaultCharacteristicValue() throws Exception {
        ProductSpecCharacteristicValue prodSpecCharValue = new ProductSpecCharacteristicValue("1", false, "cm", validFor, "12", "", "");
        ProductSpecCharacteristicValue prodSpecCharValue2 = new ProductSpecCharacteristicValue("1", false, "cm", validFor, "12.3", "", "");

        List<ProdSpecCharValueUse> expectCharValueUse = new ArrayList<ProdSpecCharValueUse>();

        int retCode = pscu.specifyDefaultCharacteristicValue(prodSpecCharValue);
        assertEquals("specify default characteristicValue but the characteristic haven't value", ProductSpecErrorEnum
                .SPEC_NO_CHAR_VALUE.getCode(), retCode);
        assertEquals("specify default characteristicValue but the characteristic haven't value", null, pscu.getProdSpecCharValue());

        retCode = pscu.specifyDefaultCharacteristicValue(null);
        assertEquals("specify default characteristicValue, but the parameter is null", ProductSpecErrorEnum
                .SPEC_NO_CHAR_VALUE.getCode(), retCode);
        assertNull("specify default characteristicValue, but the parameter is null", pscu.getProdSpecCharValue());

        pscu.assignValue(prodSpecCharValue, false, validFor);
        pscu.assignValue(prodSpecCharValue2, true, validFor);

        ProdSpecCharValueUse charValueUse = new ProdSpecCharValueUse(prodSpecCharValue, true, validFor);
        ProdSpecCharValueUse defCharValueUse = new ProdSpecCharValueUse(prodSpecCharValue2, true, validFor);
        expectCharValueUse.add(charValueUse);
        expectCharValueUse.add(defCharValueUse);

        retCode = pscu.specifyDefaultCharacteristicValue(prodSpecCharValue);
        assertEquals("specify characteristicValue to defaultValue", CommonErrorEnum.SUCCESS.getCode(), retCode);
        for (int i = 0; i < expectCharValueUse.size(); i++) {
            assertEquals("specify characteristicValue to defaultValue", expectCharValueUse.get(i)
                    .getProdSpecCharValue(), pscu.getProdSpecCharValue().get(i).getProdSpecCharValue());
            assertEquals("specify characteristicValue to defaultValue", expectCharValueUse.get(i).isIsDefault(), pscu
                    .getProdSpecCharValue().get(i).isIsDefault());
        }

        ProductSpecCharacteristicValue defaultValue2 = new ProductSpecCharacteristicValue("1", false, "cm", validFor, "15", "", "");
        retCode = pscu.specifyDefaultCharacteristicValue(defaultValue2);
        assertEquals("specify characteristicValue to defaultValue", ProductSpecErrorEnum.SPEC_CHAR_NOT_USE_THE_VALUE.getCode(), retCode);
        assertEquals("specify default characteristicValue, but the charValue isn't belong to the characteristic",
                expectCharValueUse, pscu.getProdSpecCharValue());
    }
}