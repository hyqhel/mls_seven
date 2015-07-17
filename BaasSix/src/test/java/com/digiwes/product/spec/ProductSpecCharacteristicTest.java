package com.digiwes.product.spec;

import com.digiwes.basetype.TimePeriod;
import com.digiwes.common.enums.CommonErrorEnum;
import com.digiwes.common.enums.ProductSpecErrorEnum;
import com.digiwes.common.enums.RelationshipType;
import com.digiwes.common.util.DateUtils;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by huangyq3 on 2015-07-16.
 */
public class ProductSpecCharacteristicTest {
    private static final Logger logger = Logger.getLogger(ProductSpecCharacteristicTest.class);
    private ProductSpecCharacteristic prodSpecCharOwn = null;
    private ProductSpecCharacteristic exceptChar;
    private static TimePeriod validFor;

    @Before
    public void createProductSpecCharacteristic() {
        prodSpecCharOwn = new ConfigurableProductSpecCharacteristic("1", "high", "1", validFor, "false", 1, 1, true, "height", "");
        exceptChar = prodSpecCharOwn;
    }

    @BeforeClass
    public static void initValidFor() {
        String startDate = "2015-06-01 12:01:01";
        String endDate = "2015-08-01 23:12:54";
        validFor = new TimePeriod(startDate, endDate);
    }

    @Test
    public void testAssignValue() {
        ProductSpecCharacteristicValue prodSpecCharValue = null;
        int returnCode = prodSpecCharOwn.assignValue(prodSpecCharValue);
        assertEquals("param is not illegal", ProductSpecErrorEnum.CHAR_VALUE_IS_NULL.getCode(), returnCode);

        prodSpecCharValue = new ProductSpecCharacteristicValue("1", false, "GHz", validFor, "8", "", "");

        Set<ProductSpecCharacteristicValue> expectedProValueList = new HashSet<ProductSpecCharacteristicValue>();
        ProductSpecCharacteristicValue expectedProdSpecCharValue = new ProductSpecCharacteristicValue("1", false,
                "GHz", validFor, "8", "", "");
        expectedProValueList.add(expectedProdSpecCharValue);
        returnCode = prodSpecCharOwn.assignValue(prodSpecCharValue);

        assertEquals("check ProductSpecCharacteristic add value success", CommonErrorEnum.SUCCESS.getCode(), returnCode);
        assertEquals("check ProductSpecCharacteristic add value success", 1, prodSpecCharOwn.getProdSpecCharValue().size());
        assertEquals("check ProductSpecCharacteristic  other content", expectedProValueList, prodSpecCharOwn.getProdSpecCharValue());

        ProductSpecCharacteristicValue prodSpecCharValue2 = new ProductSpecCharacteristicValue("1", false, "GHz",
                validFor, "8", "", "");
        returnCode = prodSpecCharOwn.assignValue(prodSpecCharValue2);
        assertEquals("check ProductSpecCharacteristic add value success", ProductSpecErrorEnum
                .CHAR_ALREADY_USE_THE_VALUE.getCode(), returnCode);
        assertEquals("check ProductSpecCharacteristic again  add value success", 1, prodSpecCharOwn.getProdSpecCharValue().size());
        assertEquals("check ProductSpecCharacteristic  other content", expectedProValueList, prodSpecCharOwn.getProdSpecCharValue());

        ProductSpecCharacteristicValue prodSpecCharValue3 = new ProductSpecCharacteristicValue("1", false, "cm",
                validFor, "8", "", "");
        returnCode = prodSpecCharOwn.assignValue(prodSpecCharValue3);

        ProductSpecCharacteristicValue expectedProdSpecCharValue3 = new ProductSpecCharacteristicValue("1", false, "cm",
                validFor, "8", "", "");
        expectedProValueList.add(expectedProdSpecCharValue3);
        assertEquals("check ProductSpecCharacteristic add value success", CommonErrorEnum.SUCCESS.getCode(), returnCode);
        assertEquals("add a different value", 2, prodSpecCharOwn.getProdSpecCharValue().size());
        assertEquals("add a different value  content", expectedProValueList, prodSpecCharOwn.getProdSpecCharValue());

    }

    @Test
    public void testRemoveValue() {
        ProductSpecCharacteristicValue prodSpecCharValue = new ProductSpecCharacteristicValue("1", false, "GHz", validFor, "8", "", "");
        int retCode = prodSpecCharOwn.removeValue(prodSpecCharValue);

        assertEquals("remove a value from empty valueList", CommonErrorEnum.SUCCESS.getCode(), retCode);
        assertNull("remove a value from empty valueList", prodSpecCharOwn.getProdSpecCharValue());

        prodSpecCharOwn.assignValue(prodSpecCharValue);

        retCode = prodSpecCharOwn.removeValue(null);
        assertEquals("remove null value from valueList", ProductSpecErrorEnum.CHAR_VALUE_IS_NULL.getCode(), retCode);
        assertEquals("remove null value from valueList", 1, prodSpecCharOwn.getProdSpecCharValue().size());

        ProductSpecCharacteristicValue removeProdSpecCharValue = new ProductSpecCharacteristicValue("1", false, "GHz",
                validFor, "8", "", "");
        retCode = prodSpecCharOwn.removeValue(removeProdSpecCharValue);
        assertEquals("remove one exists value", CommonErrorEnum.SUCCESS.getCode(), retCode);
        assertEquals("remove one exists value", 0, prodSpecCharOwn.getProdSpecCharValue().size());
    }

    @Test
    public void testSpecifyDefaultValue() {

        ProductSpecCharacteristicValue prodSpecCharValue = new ProductSpecCharacteristicValue("1", false, "GHz", validFor, "8");
        int retCode = prodSpecCharOwn.specifyDefaultValue(prodSpecCharValue);
        assertEquals("specify one default value to a empty value ProductSpecCharacteristic", retCode,
                ProductSpecErrorEnum.CHAR_NO_VALUE.getCode());
        assertNull("specify one default value to a empty value ProductSpecCharacteristic", prodSpecCharOwn
                .getProdSpecCharValue());

        prodSpecCharOwn.assignValue(prodSpecCharValue);
        retCode = prodSpecCharOwn.specifyDefaultValue(null);

        Set<ProductSpecCharacteristicValue> expectedProValueList = new HashSet<ProductSpecCharacteristicValue>();
        ProductSpecCharacteristicValue expectedProdSpecCharValue = new ProductSpecCharacteristicValue("1", false,
                "GHz", validFor, "8");
        expectedProValueList.add(expectedProdSpecCharValue);
        assertEquals("specify a null value to default", retCode, ProductSpecErrorEnum.CHAR_VALUE_IS_NULL.getCode());
        assertEquals("specify a null value to default", expectedProValueList, prodSpecCharOwn.getProdSpecCharValue());

        ProductSpecCharacteristicValue prodSpecCharValue2 = new ProductSpecCharacteristicValue("1", false, "cm",
                validFor, "9");
        retCode = prodSpecCharOwn.specifyDefaultValue(prodSpecCharValue2);
        assertEquals("specify one default value but not exists ProductSpecCharacteristicValue", ProductSpecErrorEnum
                .CHAR_NOT_EXISTS_THE_VALUE.getCode(), retCode);
        assertEquals("specify one default value but not exists ProductSpecCharacteristicValue",
                expectedProValueList, prodSpecCharOwn.getProdSpecCharValue());

        prodSpecCharValue = new ProductSpecCharacteristicValue("1", false, "GHz", validFor, "8");
        retCode = prodSpecCharOwn.specifyDefaultValue(prodSpecCharValue);

        expectedProValueList.iterator().next().setIsDefault(true);
        assertEquals("specify one default value from ProductSpecCharacteristicValue", CommonErrorEnum.SUCCESS.getCode
                (), retCode);
        assertEquals("specify one default value from ProductSpecCharacteristicValue", expectedProValueList,
                prodSpecCharOwn.getProdSpecCharValue());

    }

    @Test
    public void testAssociate() {

        int retCode = prodSpecCharOwn.associate(null, RelationshipType.AGGREGATION.getValue(), validFor);
        assertEquals("Associate a null Characteristic.", ProductSpecErrorEnum.CHAR_IS_NULL.getCode(), retCode);
        assertEquals("Associate a null Characteristic.", 0, prodSpecCharOwn.getProdSpecCharRelationship().size());

        ProductSpecCharacteristic relatedProdSpecChar = new ProductSpecCharacteristic("2", "Size and weight", "1",
                validFor, "true", 1, 1, true, "compositeChar", "");

        retCode = prodSpecCharOwn.associate(relatedProdSpecChar, null, validFor);
        assertEquals("Associate a Characteristic with the null type.", ProductSpecErrorEnum
                .CHAR_RELATIONSHIP_TYPE_IS_NULL.getCode(), retCode);
        assertEquals("Associate a null Characteristic with the null type.", 0, prodSpecCharOwn.getProdSpecCharRelationship
                ().size());

        List<ProductSpecCharRelationship> expectedRelationship = new ArrayList<ProductSpecCharRelationship>();
        ProductSpecCharacteristic expectedRelatedProdSpecChar = new ProductSpecCharacteristic("2", "Size and weight",
                "1", validFor, "true", 1, 1, true, "compositeChar", "");
        ProductSpecCharRelationship expectedShip = new ProductSpecCharRelationship(prodSpecCharOwn,
                expectedRelatedProdSpecChar, RelationshipType.AGGREGATION.getValue(), validFor);
        expectedRelationship.add(expectedShip);

        retCode = prodSpecCharOwn.associate(relatedProdSpecChar, RelationshipType.AGGREGATION.getValue(), validFor);
        assertEquals("check add the type value is right", CommonErrorEnum.SUCCESS.getCode(), retCode);
        assertEquals("check add the type value is right", 1, prodSpecCharOwn.getProdSpecCharRelationship().size());
        assertEquals("check add the type value is right", expectedRelationship, prodSpecCharOwn
                .getProdSpecCharRelationship());


        retCode = prodSpecCharOwn.associate(relatedProdSpecChar, RelationshipType.AGGREGATION.getValue(), validFor);

        assertEquals("Associate a same characteristic and the same type again.", ProductSpecErrorEnum
                        .ASSOCIATE_REPETITIVE_CHAR.getCode(),
                retCode);
        assertEquals("Associate a same characteristic and the same type again.", 1, prodSpecCharOwn
                .getProdSpecCharRelationship().size());
        assertEquals("Associate a same characteristic and the same type again.", expectedRelationship, prodSpecCharOwn
                .getProdSpecCharRelationship());

        TimePeriod validFor2 = new TimePeriod("2015-07-15 00:00:00", "2015-07-30 00:00:00");
        retCode = prodSpecCharOwn.associate(relatedProdSpecChar, RelationshipType.AGGREGATION.getValue(), validFor2);
        assertEquals("add a same relate characteristic but the validFor is in last one", ProductSpecErrorEnum
                .ASSOCIATE_REPETITIVE_CHAR.getCode(), retCode);
        assertEquals("add a same relate characteristic but the validFor is in last one", 1, prodSpecCharOwn
                .getProdSpecCharRelationship().size());
        assertEquals("add a same relate characteristic but the validFor is in last one", expectedRelationship,
                prodSpecCharOwn.getProdSpecCharRelationship());

        TimePeriod validFor3 = new TimePeriod("2015-08-02  00:00:00", "2015-09-01  00:00:00");
        ProductSpecCharRelationship exceptShip2 = new ProductSpecCharRelationship(prodSpecCharOwn,
                relatedProdSpecChar, RelationshipType.AGGREGATION.getValue(), validFor3);
        expectedRelationship.add(exceptShip2);
        prodSpecCharOwn.associate(relatedProdSpecChar, RelationshipType.AGGREGATION.getValue(), validFor3);
        assertEquals("add a same relate characteristic but the validFor is after last one", ProductSpecErrorEnum
                .ASSOCIATE_REPETITIVE_CHAR.getCode(), retCode);
        assertEquals("add a same relate characteristic but the validFor is after last one", 2, prodSpecCharOwn
                .getProdSpecCharRelationship().size());
        assertEquals("add a same relate characteristic but the validFor is after last one", expectedRelationship,
                prodSpecCharOwn.getProdSpecCharRelationship());
    }
}