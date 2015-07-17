package com.digiwes.product.offering.catalog;

import com.digiwes.basetype.TimePeriod;
import com.digiwes.common.enums.ProductCatalogType;
import com.digiwes.common.util.DateUtils;
import com.digiwes.product.offering.ProductOffering;
import com.digiwes.product.offering.SimpleProductOffering;
import com.digiwes.product.spec.AtomicProductSpecification;
import com.digiwes.product.spec.ProductSpecification;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by huangyq3 on 2015-07-17.
 */
public class ProductCatalogTest {
    private ProductOffering poff = null;
    private ProductCatalog pcata = null;
    @Before
    public void initCatalog(){
        TimePeriod validFor = new TimePeriod("2015-06-04 10:20:00", "2015-09-26 10:20:00");
        pcata = new ProductCatalog("1","13 ´ç", ProductCatalogType.BOOK.getValue(),validFor);

        String id = "0001OF";
        String name = "11 Ó¢´ç MacBook Air";
        String description = "1.6GHz Ë«ºË Intel Core i5 ´¦ÀíÆ÷£¬Turbo Boost ¸ß´ï 2.7GHz";


        ProductSpecification prodSpec = new AtomicProductSpecification("001SP", "11 Ó¢´ç MacBook Air SPEC", "Mac Air");
        poff = new SimpleProductOffering(id, name, description, validFor, prodSpec);
    }
    @Test
    public void testPublish(){
        ProductOffering offering = null ;
        TimePeriod validFor = new TimePeriod("2015-06-04 10:20:00", "2015-07-26 10:20:00");

        try {
            pcata.publish(offering, validFor);
            fail("publish one null offering to catalog.");
        } catch (IllegalArgumentException ex) {
        }
        List<ProdCatalogProdOffer> expectedProdCatalogProdList = new ArrayList<ProdCatalogProdOffer>();
        ProdCatalogProdOffer expectedSubOffering1 = new ProdCatalogProdOffer(poff,validFor);
        expectedProdCatalogProdList.add(expectedSubOffering1);

        pcata.publish(poff, validFor);
        assertEquals("publish one  offering to catalog,check size ", 1, pcata.getProdCatalogProdOffer().size());
        assertEquals("publish one  offering to catalog,check content", pcata.getProdCatalogProdOffer(), expectedProdCatalogProdList);


        TimePeriod validFor1 = new TimePeriod("2015-06-05 10:20:00", "2015-08-26 10:20:00");
        pcata.publish(poff, validFor1);
        assertEquals("publish one  offering to catalog,check size ", 1, pcata.getProdCatalogProdOffer().size());
        assertEquals("publish one  offering to catalog,check content", expectedProdCatalogProdList, pcata.getProdCatalogProdOffer());
    }

    @Test
    public void testRetired(){
        ProductOffering offering = null ;
        try {
            pcata.retired(offering);
            fail("retired  one null offering");
        } catch (IllegalArgumentException ex) {
        }

        TimePeriod validFor1 = new TimePeriod("2015-06-04 10:20:00", "2015-07-26 10:20:00");
        pcata.publish(poff, validFor1);
        pcata.retired(poff);
        assertEquals("retired  one  offering", 1, pcata.getProdCatalogProdOffer().size());
        for(ProdCatalogProdOffer pcpo:pcata.getProdCatalogProdOffer()){
            assertTrue("retired  one  offering", 0 >= pcpo.getValidFor().getEndDateTime().compareTo(new Date()));
        }
        TimePeriod validFor2 = new TimePeriod("2015-06-04 10:20:00", "2015-07-26 10:20:00");
        pcata.publish(poff, validFor2);
        ProductSpecification  prodSpec = new AtomicProductSpecification("001SP", "11 Ó¢´ç MacBook Air SPEC", "Mac Air");
        SimpleProductOffering offering1 = new SimpleProductOffering("00011F", "13 Ó¢´ç MacBook Air",  "1.6GHz Ë«ºË Intel Core i5 ´¦ÀíÆ÷£¬Turbo Boost ¸ß´ï 2.7GHz", validFor1, prodSpec);
        pcata.retired(offering1);

        assertEquals("retired  one  offering ,check size ",2, pcata.getProdCatalogProdOffer().size());
    }

    @Test
    public void testRetrieveOffering() {
        TimePeriod validFor1 = new TimePeriod("2015-06-04 10:20:00", "2015-07-26 10:20:00");
        pcata.publish(poff, validFor1);

        TimePeriod validFor2 = new TimePeriod("2015-04-04 10:20:00", "2015-08-26 10:20:00");
        ProductSpecification  prodSpec = new AtomicProductSpecification("001SP", "11 Ó¢´ç MacBook Air SPEC", "Mac Air");
        SimpleProductOffering offering1 = new SimpleProductOffering("00011F", "13 Ó¢´ç MacBook Air",  "1.6GHz Ë«ºË Intel Core i5 ´¦ÀíÆ÷£¬Turbo Boost ¸ß´ï 2.7GHz", validFor1, prodSpec);
        pcata.publish(offering1, validFor2);

        List<ProdCatalogProdOffer> expectedProdCatalogProdList = new ArrayList<ProdCatalogProdOffer>();
        ProdCatalogProdOffer expectedSubOffering1 = new ProdCatalogProdOffer(poff,validFor1);
        expectedProdCatalogProdList.add(expectedSubOffering1);

        ProdCatalogProdOffer expectedSubOffering2 = new ProdCatalogProdOffer(offering1,validFor2);
        expectedProdCatalogProdList.add(expectedSubOffering2);

        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        pcata.retrieveOffering(DateUtils.str2Date("2015-07-03 10:20:00", sim));
        assertEquals("retrieve all  offering", 2, pcata.getProdCatalogProdOffer().size());
        assertEquals("retrieve   offering", expectedProdCatalogProdList,pcata.getProdCatalogProdOffer());

        List<ProdCatalogProdOffer>  retrlist = pcata.retrieveOffering(DateUtils.str2Date("2015-04-03 10:20:00", sim));
        assertEquals("retrieve   offering all offering out of validfor",0, retrlist.size());

        List<ProdCatalogProdOffer>  retrlists = pcata.retrieveOffering(DateUtils.str2Date("2015-04-05 10:20:00", sim));
        assertEquals("retrieve   offering have one not out of  validfor,check size",1, retrlists.size());
        List<ProdCatalogProdOffer> expectedRtProdCatalogProdList = new ArrayList<ProdCatalogProdOffer>();
        ProdCatalogProdOffer expectedSubOffering4 = new ProdCatalogProdOffer(offering1,validFor2);
        expectedRtProdCatalogProdList.add(expectedSubOffering4);
        assertEquals("retrieve   offering have one not out of  validfor,check content", expectedRtProdCatalogProdList, retrlists);
    }
}