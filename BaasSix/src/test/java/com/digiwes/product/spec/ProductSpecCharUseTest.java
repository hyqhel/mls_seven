package com.digiwes.product.spec;

import com.digiwes.basetype.TimePeriod;
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
    private	ProductSpecCharUse pscu =null;
    private ProductSpecCharacteristic prodSpecCharOwn=null;
    private static TimePeriod validFor;
    @Before
    public void createProductSpecCharacteristic(){
        prodSpecCharOwn = new ProductSpecCharacteristic("1", "深度", "number", validFor, "false",  1,  1, true, "height","");
        ProductSpecCharacteristicValue prodSpecCharValue = new ProductSpecCharacteristicValue("1",false, "cm", validFor, "12", "", "");
        prodSpecCharOwn.assignValue(prodSpecCharValue);
        ProductSpecCharacteristicValue prodSpecCharValuee = new ProductSpecCharacteristicValue("1",false, "cm", validFor, "12.3", "", "");
        prodSpecCharOwn.assignValue(prodSpecCharValuee);
        pscu = new ProductSpecCharUse(prodSpecCharOwn, false, false, validFor,"深度");
    }
    @BeforeClass
    public static void initVliadFor(){
        String startDate = "2015-06-01";
        String endDate = "2015-08-01";
        validFor = new TimePeriod(startDate,endDate);
    }
    @Test
    public void testSpecifyCardinality() throws Exception {
        pscu.specifyCardinality(1, 5);
        assertEquals("set characteristicUse cardinality,judet minCardinality", 1, pscu.getMinCardinality());
        assertEquals("set characteristicUse cardinality,judet maxCardinality",5,pscu.getMaxCardinality());

        try{
            pscu.specifyCardinality(6, 5);
            fail("set characteristicUse cardinality , but minCardinality is greater than maxCardinality");
        }catch(IllegalArgumentException e){}

        pscu.specifyCardinality(5, 5);
        assertEquals("set characteristicUse cardinality,judet minCardinality", 5, pscu.getMinCardinality());
        assertEquals("set characteristicUse cardinality,judet maxCardinality",5,pscu.getMaxCardinality());
    }

    @Test
    public void testAssignValue() throws Exception {
        ProductSpecCharacteristicValue prodSpecCharValue = new ProductSpecCharacteristicValue("1", false,"cm", validFor, "12", "", "");
        ProductSpecCharacteristicValue prodSpecCharValue2 = new ProductSpecCharacteristicValue("1",false, "cm", validFor, "12", "", "");
        ProductSpecCharacteristicValue prodSpecCharValue3 = new ProductSpecCharacteristicValue("1", false,"cm", validFor, "13", "", "");

        ProdSpecCharValueUse charValueUse = new ProdSpecCharValueUse(prodSpecCharValue, false, validFor);

        pscu.assignValue(prodSpecCharValue, false, validFor);
        assertEquals("add a charValue ,compare charValues's size", 1, pscu.getProdSpecCharValue().size());
        assertTrue("add a charValue, check whether the charValue contained in the charValues", pscu.getProdSpecCharValue().contains(charValueUse));

        pscu.assignValue(prodSpecCharValue2, false, validFor);
        assertEquals("add a same charValue ,compare charValues's size", 1, pscu.getProdSpecCharValue().size());
        assertTrue("add a same charValue, check whether the charValue contained in the charValues", pscu.getProdSpecCharValue().contains(charValueUse));

        pscu.assignValue(prodSpecCharValue3, false, validFor);
        assertEquals("add a charValue but the charValue isn't belong to the char ,compare charValues's size", 1, pscu.getProdSpecCharValue().size());
        assertTrue("add a charValue but the charValue isn't belong to the char, check whether the charValue contained in the charValues", pscu.getProdSpecCharValue().contains(charValueUse));

        try{
            pscu.assignValue(null, false, validFor);
            fail("add a null");
        }catch(IllegalArgumentException e){}
    }

    @Test
    public void testSpecifyDefaultCharacteristicValue() throws Exception {
        ProductSpecCharacteristicValue prodSpecCharValue = new ProductSpecCharacteristicValue("1", false,"cm", validFor, "12", "", "");
        ProductSpecCharacteristicValue prodSpecCharValue2 = new ProductSpecCharacteristicValue("1",false, "cm", validFor, "12.3", "", "");

        List<ProdSpecCharValueUse> expectCharValueUse = new ArrayList<ProdSpecCharValueUse>();

        pscu.specifyDefaultCharacteristicValue(prodSpecCharValue);
        assertEquals("specify default characteristicValue but the characteristic haven't value", null, pscu.getProdSpecCharValue());

        pscu.assignValue(prodSpecCharValue, false, validFor);
        pscu.assignValue(prodSpecCharValue2, true, validFor);

        ProdSpecCharValueUse charValueUse = new ProdSpecCharValueUse(prodSpecCharValue,true,validFor);
        ProdSpecCharValueUse defcharValueUse = new ProdSpecCharValueUse(prodSpecCharValue2,false,validFor);
        expectCharValueUse.add(charValueUse);
        expectCharValueUse.add(defcharValueUse);

        pscu.specifyDefaultCharacteristicValue(prodSpecCharValue);
        assertEquals("specify default characteristicValue", expectCharValueUse, pscu.getProdSpecCharValue());

        try{
            pscu.specifyDefaultCharacteristicValue(null);
            fail("specify default characteristicValue，but the parameter is null");
        }catch(IllegalArgumentException e){
        }

        ProductSpecCharacteristicValue defaultValue2 = new ProductSpecCharacteristicValue("1",false, "cm", validFor, "15", "", "");
        pscu.specifyDefaultCharacteristicValue(defaultValue2);
        assertEquals("specify default characteristicValue，but the charValue isn't belong to the characteristic", expectCharValueUse, pscu.getProdSpecCharValue());
    }
}