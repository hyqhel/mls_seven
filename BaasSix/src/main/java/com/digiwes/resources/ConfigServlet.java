package com.digiwes.resources;

import com.digiwes.basetype.TimePeriod;
import com.digiwes.common.enums.ProdSpecType;
import com.digiwes.common.enums.ProductCatalogType;
import com.digiwes.product.offering.ProductOffering;
import com.digiwes.product.offering.SimpleProductOffering;
import com.digiwes.product.offering.catalog.ProductCatalog;
import com.digiwes.product.spec.*;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServlet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by huangyq3 on 2015-07-16.
 */
public class ConfigServlet extends HttpServlet {
    /*private Logger logger = Logger.getLogger(ConfigServlet.class);

    private ProductCatalog pcata = null;
    private List<ProductSpecCharacteristic> productSpecChars;
    private ProductSpecification specification128 = null;
    private ProductSpecification specification256 = null;
    private ProductSpecification specification512 = null;
    private ProductOffering offering128 = null;
    private ProductOffering offering256 = null;
    private ProductOffering offering512 = null;*/
    public void init(){
        //create Char
        createProductSpecChar();
        //create spec
        createProductSpec();
        //create offering
        createProductOffering();

        TimePeriod validFor = new TimePeriod("2015-06-04 10:20:00", "2015-08-26 10:20:00");
        ConfigData.pcata = new ProductCatalog("1", "13 英寸配备 Retina 显示屏的 MacBook Pro",
                ProductCatalogType.WEB.getValue(), validFor);
    }


    public void createProductSpecChar() {

        ConfigData.productSpecChars = new ArrayList<ProductSpecCharacteristic>();
        for (int i = 0; i < TestProductSpecificationData.specChar.length; i++) {
            String ID = TestProductSpecificationData.specChar[i][0].toString();
            ProductSpecCharacteristic productSpecCharProcessor1 = null;
            if (Boolean.parseBoolean(TestProductSpecificationData.specChar[i][7].toString())) {
                productSpecCharProcessor1 = new ConfigurableProductSpecCharacteristic(ID,
                        TestProductSpecificationData.specChar[i][1].toString(),
                        TestProductSpecificationData.specChar[i][2].toString(),
                        (TimePeriod) TestProductSpecificationData.specChar[i][3],
                        TestProductSpecificationData.specChar[i][4].toString(),
                        Integer.parseInt(TestProductSpecificationData.specChar[i][5].toString()),
                        Integer.parseInt(TestProductSpecificationData.specChar[i][6].toString()),
                        false,
                        "",
                        "");
            } else {
                productSpecCharProcessor1 = new ProductSpecCharacteristic(ID,
                        TestProductSpecificationData.specChar[i][1].toString(),
                        TestProductSpecificationData.specChar[i][2].toString(),
                        (TimePeriod) TestProductSpecificationData.specChar[i][3],
                        TestProductSpecificationData.specChar[i][4].toString(),
                        Integer.parseInt(TestProductSpecificationData.specChar[i][5].toString()),
                        Integer.parseInt(TestProductSpecificationData.specChar[i][6].toString()),
                        false,
                        "",
                        "");
            }

            for (int j = 0; j < TestProductSpecificationData.specCharValue.length; j++) {
                if (ID.equals(TestProductSpecificationData.specCharValue[j][0].toString())) {
                    ProductSpecCharacteristicValue oneprocessorValue1 = new ProductSpecCharacteristicValue(
                            TestProductSpecificationData.specCharValue[j][1].toString(),
                            Boolean.parseBoolean(TestProductSpecificationData.specCharValue[j][2].toString()),
                            TestProductSpecificationData.specCharValue[j][3].toString(),
                            (TimePeriod) TestProductSpecificationData.specCharValue[j][4],
                            TestProductSpecificationData.specCharValue[j][5].toString());
                    productSpecCharProcessor1.assignValue(oneprocessorValue1);
                }
            }
            ConfigData.productSpecChars.add(productSpecCharProcessor1);
        }
        for (int i = 0; i < TestProductSpecificationData.relateSpecChar.length; i++) {
            String srcId = TestProductSpecificationData.relateSpecChar[i][0].toString();
            String targetId = TestProductSpecificationData.relateSpecChar[i][1].toString();
            ProductSpecCharacteristic srcChar = this.getProdSpecCharById(srcId);
            ProductSpecCharacteristic targetChar = this.getProdSpecCharById(targetId);

            srcChar.associate(targetChar, TestProductSpecificationData.relateSpecChar[i][2].toString(),
                    (TimePeriod) TestProductSpecificationData.relateSpecChar[i][4], Integer.parseInt
                            (TestProductSpecificationData.relateSpecChar[i][3].toString()));
        }
    }

    public void createProductSpec() {

        // create product specification（2.7GHz 处理器 128 GB 存储容量）
        ConfigData.specification128 = createProductSpecification(
                TestProductSpecificationData.specParameter1, TestProductSpecificationData.one_charData);
        // create product specification（2.7GHz 处理器 256 GB 存储容量）
        ConfigData.specification256 = createProductSpecification(
                TestProductSpecificationData.specParameter2, TestProductSpecificationData.two_charData);
        // create product specification（2.9GHz 处理器 512GB 存储容量）
        ConfigData.specification512 = createProductSpecification(
                TestProductSpecificationData.specParameter3, TestProductSpecificationData.three_charData);
    }

    /**
     * 创建规格
     *
     * @return
     * @throws Exception
     */
    public ProductSpecification createProductSpecification(Object[] specParameter, Object[][] charData) {
        ProductSpecification productSpec = null;
        if (specParameter != null) {
            if ("AtomicProductSpecification".equals(specParameter[10].toString())) {
                productSpec = new AtomicProductSpecification(specParameter[0].toString(), specParameter[1].toString(),
                        specParameter[2].toString());
            } else {
                productSpec = new CompositeProductSpecification(specParameter[0].toString(),
                        specParameter[1].toString(), specParameter[2].toString());
            }
            for (int i = 0; i < charData.length; i++) {
                ProductSpecCharacteristic prodSpecChar = null;
                prodSpecChar = this.getCharByCharId(charData[i][0].toString());
                productSpec.attachCharacteristic(charData[i][4].toString(), prodSpecChar, Boolean.parseBoolean(charData[i][1].toString()),
                        Boolean.parseBoolean(charData[i][2].toString()),
                        (TimePeriod) charData[i][3], charData[i][5].toString(),
                        Integer.parseInt(charData[i][6].toString()), Integer.parseInt(charData[i][7].toString()),
                        Boolean.parseBoolean(charData[i][8].toString()),
                        charData[i][9].toString());
                if (Boolean.parseBoolean(charData[i][10].toString())) {
                    List<ProductSpecCharacteristicValue> values = this.getCharValue(prodSpecChar,
                            (String[]) charData[i][11]);
                    if (values != null) {
                        for (int j = 0; j < values.size(); j++) {
                            productSpec.assignCharacteristicValue(charData[i][4].toString(), prodSpecChar, values
                                            .get(j),
                                    ((boolean[]) charData[i][12])[j], (TimePeriod) specParameter[4]);
                        }
                    }
                }
            }
            return productSpec;
        }
        return null;
    }

    public ProductSpecCharacteristic getCharByCharId(String id) {
        ProductSpecCharacteristic prodSpecChar = null;
        for (int i = 0; i <ConfigData.productSpecChars.size(); i++) {
            prodSpecChar = ConfigData.productSpecChars.get(i);
            if (id.equals(prodSpecChar.getID())) {
                return prodSpecChar;
            }
        }
        return null;

    }

    public List<ProductSpecCharacteristicValue> getCharValue(ProductSpecCharacteristic characteristic, String[]
            values) {
        if (values != null) {
            Set<ProductSpecCharacteristicValue> productValues = characteristic.getProdSpecCharValue();
            List<ProductSpecCharacteristicValue> prodSpecChars = new ArrayList<ProductSpecCharacteristicValue>();

            for (String value : values) {
                for (ProductSpecCharacteristicValue productValue : productValues) {
                    if (value.equals(productValue.getValue())) {
                        prodSpecChars.add(productValue);
                        break;
                    }
                }
            }
            return prodSpecChars;
        }
        return null;

    }

    public ProductSpecCharacteristic getProdSpecCharById(String id) {
        if (ConfigData.productSpecChars != null) {
            for (ProductSpecCharacteristic productSpecCharacteristic : ConfigData.productSpecChars) {
                if (id.equals(productSpecCharacteristic.getID())) {
                    return productSpecCharacteristic;
                }
            }
        }
        return null;
    }

    private SimpleProductOffering createSimpleProductOffering(Object[] obj, ProductSpecification prodSpec) {
        return new SimpleProductOffering((String) obj[0], (String) obj[1], (String) obj[2], (TimePeriod) obj[3], prodSpec);
    }

    public void createProductOffering() {
        ConfigData.offering128 = createSimpleProductOffering(TestProductOfferingData.offering[0], ConfigData.specification128);
        ConfigData.offering256 = createSimpleProductOffering(TestProductOfferingData.offering[1], ConfigData.specification256);
        ConfigData.offering512 = createSimpleProductOffering(TestProductOfferingData.offering[2], ConfigData.specification512);
    }

}
