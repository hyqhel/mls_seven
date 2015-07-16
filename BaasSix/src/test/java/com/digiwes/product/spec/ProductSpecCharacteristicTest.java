package com.digiwes.product.spec;

import com.digiwes.basetype.TimePeriod;
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

/**
 * Created by huangyq3 on 2015-07-16.
 */
public class ProductSpecCharacteristicTest {
    private static final Logger logger = Logger.getLogger(ProductSpecCharacteristicTest.class);
    private ProductSpecCharacteristic prodSpecCharOwn=null;
    private ProductSpecCharacteristic exceptChar;
    private static TimePeriod validFor;
    @Before
    public void createProductSpecCharacteristic(){
        prodSpecCharOwn = new ConfigurableProductSpecCharacteristic("1", "high", "1", validFor, "false",  1,  1, true, "height","");
        exceptChar = prodSpecCharOwn;
    }
    @BeforeClass
    public static void initVliadFor(){
        String startDate = "2015-06-01";
        String endDate = "2015-08-01";
        validFor = new TimePeriod(startDate,endDate);
    }
    @Test
    public void testAssignValue()  {
        ProductSpecCharacteristicValue prodSpecCharValues = null;
        try {
            prodSpecCharOwn.assignValue(prodSpecCharValues);
            fail("param is not illegal");
        } catch (Exception e) {
        }
        ProductSpecCharacteristicValue prodSpecCharValue = new ProductSpecCharacteristicValue("1", false,"GHz", validFor, "8", "", "");
        //exceptChar.getProdSpecCharValue().add(prodSpecCharValue);

        Set<ProductSpecCharacteristicValue> expectProValueList = new HashSet<ProductSpecCharacteristicValue>();
        expectProValueList.add(prodSpecCharValue);
        prodSpecCharOwn.assignValue(prodSpecCharValue);

        assertEquals("check ProductSpecCharacteristic add value success", 1, prodSpecCharOwn.getProdSpecCharValue().size());
        assertEquals("check ProductSpecCharacteristic  other content", expectProValueList,prodSpecCharOwn.getProdSpecCharValue());

        prodSpecCharValues = new ProductSpecCharacteristicValue("1",false, "GHz", validFor, "8", "", "");
        prodSpecCharOwn.assignValue(prodSpecCharValues);
        assertEquals("check ProductSpecCharacteristic again  add value success", 1, prodSpecCharOwn.getProdSpecCharValue().size());
        assertEquals("check ProductSpecCharacteristic  other content", expectProValueList, prodSpecCharOwn.getProdSpecCharValue());

        prodSpecCharValues = new ProductSpecCharacteristicValue("1",false, "cm", validFor, "8", "", "");
        prodSpecCharOwn.assignValue(prodSpecCharValues);
        expectProValueList.add(prodSpecCharValues);
        assertEquals("add a different value", 2, prodSpecCharOwn.getProdSpecCharValue().size());
        assertEquals("add a different value  content", expectProValueList, prodSpecCharOwn.getProdSpecCharValue());

        prodSpecCharOwn.assignValue(prodSpecCharValues);
        assertEquals("add same project value agian", 2, prodSpecCharOwn.getProdSpecCharValue().size());
        assertEquals("add a different value  content", expectProValueList, prodSpecCharOwn.getProdSpecCharValue());
    }

    @Test
    public void testRemoveValue(){
        ProductSpecCharacteristicValue prodSpecCharValue = new ProductSpecCharacteristicValue("1", false,"GHz", validFor, "8", "", "");
        prodSpecCharOwn.removeValue(prodSpecCharValue);
        assertNull("remove one not exists value", prodSpecCharOwn.getProdSpecCharValue());
        prodSpecCharOwn.assignValue(prodSpecCharValue);
        prodSpecCharOwn.removeValue(prodSpecCharValue);
        assertEquals("remove one exists value",0,prodSpecCharOwn.getProdSpecCharValue().size());
    }

    @Test
    public void testSpecifyDefaultValue(){
        ProductSpecCharacteristicValue prodSpecCharValue = new ProductSpecCharacteristicValue("1",false, "GHz", validFor, "8");
        prodSpecCharOwn.specifyDefaultValue(prodSpecCharValue);
        assertNull("specify one defalut value to a empty value ProductSpecCharacteristic", prodSpecCharOwn.getProdSpecCharValue());

        prodSpecCharOwn.assignValue(prodSpecCharValue);
        prodSpecCharValue = null;
        try {
            prodSpecCharOwn.specifyDefaultValue(prodSpecCharValue);
            fail("param is not illegal");
        } catch (IllegalArgumentException e) {
        }

        prodSpecCharValue =  new ProductSpecCharacteristicValue("1",false, "cm", validFor, "9");
        prodSpecCharOwn.specifyDefaultValue(prodSpecCharValue);
        assertFalse("specify one defalut value but not exists ProductSpecCharacteristicValue", prodSpecCharOwn.getProdSpecCharValue().iterator().next().isIsDefault());
        assertFalse("specify one defalut value but not exists ProductSpecCharacteristicValue", prodSpecCharOwn.getProdSpecCharValue().contains(prodSpecCharValue));

        prodSpecCharValue =  new ProductSpecCharacteristicValue("1" ,false, "GHz", validFor, "8");
        prodSpecCharOwn.specifyDefaultValue(prodSpecCharValue);
        assertTrue("specify one defalut value from ProductSpecCharacteristicValue", prodSpecCharOwn.getProdSpecCharValue().iterator().next().isIsDefault());
        assertEquals("specify one defalut value from ProductSpecCharacteristicValue", 1, prodSpecCharOwn.getProdSpecCharValue().size());

    }

    @Test
    public void testAssociate() {
        ProductSpecCharacteristic prodSpecCharRelate = new ProductSpecCharacteristic("2", "Size and weight", "1", validFor, "true",  1,  1, true, "compistchar","");
        List<ProductSpecCharRelationship> exceptRelationship = new ArrayList<ProductSpecCharRelationship>();

        ProductSpecCharRelationship exceptShip = new ProductSpecCharRelationship(prodSpecCharOwn,prodSpecCharRelate,RelationshipType.AGGREGATION.getValue(), validFor);
        exceptRelationship.add(exceptShip);
        prodSpecCharOwn.associate(prodSpecCharRelate, RelationshipType.AGGREGATION.getValue(), validFor);
        assertEquals("check add realte", 1, prodSpecCharOwn.getProdSpecCharRelationship().size());
        assertEquals("check add the type value is right", exceptRelationship, prodSpecCharOwn.getProdSpecCharRelationship());

        prodSpecCharOwn.associate(prodSpecCharRelate, RelationshipType.AGGREGATION.getValue(), validFor);
        assertEquals("add a same relate characteristic and the validFor same too ", exceptRelationship, prodSpecCharOwn.getProdSpecCharRelationship());

        TimePeriod validFor2 = new TimePeriod("2015-07-15 00:00:00","2015-07-30 00:00:00");
        prodSpecCharOwn.associate(prodSpecCharRelate, RelationshipType.AGGREGATION.getValue(), validFor2);
        assertEquals("check add realte", 1, prodSpecCharOwn.getProdSpecCharRelationship().size());
        assertEquals("add a same relate characteristic but the validFor is in last one", exceptRelationship, prodSpecCharOwn.getProdSpecCharRelationship());

        TimePeriod validFor3 = new TimePeriod("2015-08-02  00:00:00","2015-09-01  00:00:00");
        ProductSpecCharRelationship exceptShip2 = new ProductSpecCharRelationship(prodSpecCharOwn,prodSpecCharRelate,RelationshipType.AGGREGATION.getValue(), validFor3);
        exceptRelationship.add(exceptShip2);
        prodSpecCharOwn.associate(prodSpecCharRelate, RelationshipType.AGGREGATION.getValue(), validFor3);
        assertEquals("check add realte", 2, prodSpecCharOwn.getProdSpecCharRelationship().size());
        assertEquals("add a same relate characteristic but the validFor is after last one", exceptRelationship, prodSpecCharOwn.getProdSpecCharRelationship());

        ProductSpecCharRelationship exceptShip3 = new ProductSpecCharRelationship(prodSpecCharOwn,prodSpecCharRelate,RelationshipType.DEPENDENCY.getValue(), validFor);
        exceptRelationship.add(exceptShip3);
        prodSpecCharOwn.associate(prodSpecCharRelate, RelationshipType.DEPENDENCY.getValue(), validFor);
        assertEquals("check add different realte", 3, prodSpecCharOwn.getProdSpecCharRelationship().size());
        assertEquals("in the same time add a same relate characteristic but the relationshipType is different ", exceptRelationship, prodSpecCharOwn.getProdSpecCharRelationship());

        try {
            prodSpecCharOwn.associate(null, RelationshipType.AGGREGATION.getValue(), validFor);
            fail("add a relate characteristic but the characteristic is null");
        }catch(IllegalArgumentException e){}
    }

    @Test
    public void testDissociate()  {
       /*ProductSpecCharacteristic prodSpecCharRelate = new ProductSpecCharacteristic("2", "Size and weight", "1", validFor, "true",  1,  1, true, "compistchar","");
		prodSpecCharOwn.removeRelatedCharacteristic(prodSpecCharRelate);
		assertNull("check remove relate",prodSpecCharOwn.getProdSpecCharRelationship());
		prodSpecCharOwn.addRelatedCharacteristic(prodSpecCharRelate, ProdSpecEnum.ProdSpecRelationship.AGGREGATION.getValue(), validFor);

		ProductSpecCharacteristic prodSpecCharRelatee = new ProductSpecCharacteristic("1", "color", "1", validFor, "true",  1,  1, false, "compistchar","");
		prodSpecCharOwn.removeRelatedCharacteristic(prodSpecCharRelatee);
		assertEquals("remove one not exists relate",1,prodSpecCharOwn.getProdSpecCharRelationship().size());

		prodSpecCharOwn.removeRelatedCharacteristic(prodSpecCharRelate);
		assertEquals("check remove relate",0,prodSpecCharOwn.getProdSpecCharRelationship().size());*/
    }
}