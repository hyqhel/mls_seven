package com.digiwes.product.offering.catalog;

import com.digiwes.basetype.TimePeriod;
import com.digiwes.common.enums.CommonErrorEnum;
import com.digiwes.common.enums.ProductCatalogErrorEnum;
import com.digiwes.common.enums.ProductCatalogType;
import com.digiwes.common.enums.ProductOfferingErrorEnum;
import com.digiwes.common.util.DateUtils;
import com.digiwes.product.offering.ProductOffering;
import com.digiwes.product.offering.SimpleProductOffering;
import com.digiwes.product.spec.AtomicProductSpecification;
import com.digiwes.product.spec.ProductSpecification;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
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
    private  TimePeriod validFor = null;
    private ProductSpecification prodSpec = null;
    @Before
    public void initCatalog(){
       validFor = new TimePeriod("2015-07-08 10:20:00", "2017-12-08 10:20:00");
        pcata = new ProductCatalog("1","13 inch", ProductCatalogType.BOOK.getValue(),validFor);

        String id = "0001OF";
        String name = "13-inch MacBook Pro";
        String description = "13-inch MacBook Pro";

        prodSpec = new AtomicProductSpecification("001SP", "MacBook Pro SPEC", "Mac Pro");
        poff = new SimpleProductOffering(id, name, description, validFor, prodSpec);
    }
    @Test
    public void testPublish(){
        List<ProdCatalogProdOffer> expectProdCatalogProdOffer = new ArrayList<ProdCatalogProdOffer>();

        //publish a offering but it's null
        int errorCode =  pcata.publish(null,validFor);
        assertEquals("compare to return errorCode.", ProductOfferingErrorEnum.OFFERING_IS_NULL.getCode(),errorCode);
        assertEquals("expectProdCatalogProdOffer compare to catalog's prodCatalogProdOffer.", expectProdCatalogProdOffer, pcata.getProdCatalogProdOffer());

        //publish a offering but it's validFor is null
        errorCode =  pcata.publish(poff,null);
        assertEquals("compare to return errorCode.", CommonErrorEnum.VALIDFOR_IS_NULL.getCode(),errorCode);
        assertEquals("expectProdCatalogProdOffer compare to catalog's prodCatalogProdOffer.", expectProdCatalogProdOffer, pcata.getProdCatalogProdOffer());

        //publish a offering
        TimePeriod validFor1 = new TimePeriod("2015-07-31 11:59:59","2016-08-08 23:59:59");
        ProdCatalogProdOffer catalogProdOffer = new ProdCatalogProdOffer(poff,validFor1);
        expectProdCatalogProdOffer.add(catalogProdOffer);
        errorCode =  pcata.publish(poff,validFor1);
        assertEquals("compare to return errorCode.", CommonErrorEnum.SUCCESS.getCode(), errorCode);
        assertEquals("expectProdCatalogProdOffer compare to catalog's prodCatalogProdOffer.", expectProdCatalogProdOffer, pcata.getProdCatalogProdOffer());

        //publish a exists offering but the validFor is different
        TimePeriod validFor11 = new TimePeriod("2016-09-08 23:59:59","2017-08-08 23:59:59");
        SimpleProductOffering sameProductOffering =new SimpleProductOffering("1","13-inch MacBook Pro","13-inch MacBook Pro", validFor,prodSpec) ;
        ProdCatalogProdOffer catalogProdOffer2 = new ProdCatalogProdOffer(sameProductOffering,validFor11);
        expectProdCatalogProdOffer.add(catalogProdOffer2);
        errorCode =  pcata.publish(sameProductOffering,validFor11);
        assertEquals("compare to return errorCode.", CommonErrorEnum.SUCCESS.getCode(), errorCode);
        assertEquals("expectProdCatalogProdOffer compare to catalog's prodCatalogProdOffer.", expectProdCatalogProdOffer, pcata.getProdCatalogProdOffer());

        //publish a different offering but the validFor is same
        SimpleProductOffering diffProductOffering =new SimpleProductOffering("5","15-inch MacBook Pro","15-inch MacBook Pro", validFor,prodSpec) ;
        ProdCatalogProdOffer diffcatalogProdOffer = new ProdCatalogProdOffer(diffProductOffering,validFor1);
        expectProdCatalogProdOffer.add(diffcatalogProdOffer);
        errorCode =  pcata.publish(diffProductOffering,validFor1);
        assertEquals("compare to return errorCode.", CommonErrorEnum.SUCCESS.getCode(), errorCode);
        assertEquals("expectProdCatalogProdOffer compare to catalog's prodCatalogProdOffer.", expectProdCatalogProdOffer, pcata.getProdCatalogProdOffer());

        //publish a exists offering but the validFor within the last published time
        TimePeriod validFor13 = new TimePeriod("2015-09-08 23:59:59","2016-07-08");
        errorCode =  pcata.publish(sameProductOffering,validFor13);
        assertEquals("compare to return errorCode.", ProductCatalogErrorEnum.PUBLISH_REPETITIVE_OFFERING.getCode(), errorCode);
        assertEquals("expectProdCatalogProdOffer compare to catalog's prodCatalogProdOffer.",expectProdCatalogProdOffer,pcata.getProdCatalogProdOffer());

        //publish a exists offering
        errorCode =  pcata.publish(sameProductOffering,validFor1);
        assertEquals("compare to return errorCode.", ProductCatalogErrorEnum.PUBLISH_REPETITIVE_OFFERING.getCode(), errorCode);
        assertEquals("expectProdCatalogProdOffer compare to catalog's prodCatalogProdOffer.",expectProdCatalogProdOffer,pcata.getProdCatalogProdOffer());

        //publish a exists offering but the validFor's endTime within the last published time
        TimePeriod validFor12 = new TimePeriod("2015-07-28 23:59:59","2015-12-08 23:59:59");
        errorCode =  pcata.publish(sameProductOffering,validFor12);
        assertEquals("compare to return errorCode.", ProductCatalogErrorEnum.PUBLISH_REPETITIVE_OFFERING.getCode(), errorCode);
        assertEquals("expectProdCatalogProdOffer compare to catalog's prodCatalogProdOffer.",expectProdCatalogProdOffer,pcata.getProdCatalogProdOffer());

        //publish a exists offering but the validFor's startTime within the last published time
        TimePeriod validFor14 = new TimePeriod("2015-09-08 23:59:59","2016-12-08 23:59:59");
        errorCode =  pcata.publish(sameProductOffering,validFor14);
        assertEquals("compare to return errorCode.", ProductCatalogErrorEnum.PUBLISH_REPETITIVE_OFFERING.getCode(), errorCode);
        assertEquals("expectProdCatalogProdOffer compare to catalog's prodCatalogProdOffer.",expectProdCatalogProdOffer,pcata.getProdCatalogProdOffer());

        //publish a exists offering but the validFor include the last published time
        TimePeriod validFor15 = new TimePeriod("2015-07-28 11:59:59","2016-12-08 23:59:59");
        errorCode =  pcata.publish(sameProductOffering,validFor15);
        assertEquals("compare to return errorCode.", ProductCatalogErrorEnum.PUBLISH_REPETITIVE_OFFERING.getCode(), errorCode);
        assertEquals("expectProdCatalogProdOffer compare to catalog's prodCatalogProdOffer.",expectProdCatalogProdOffer,pcata.getProdCatalogProdOffer());

        //publish a invalid offering
        TimePeriod validFor2 = new TimePeriod("2015-02-10 23:59:59","2015-07-15 23:59:59");
        SimpleProductOffering invalidProductOffering =new SimpleProductOffering("2","11-inch MacBook","11-inch MacBook", validFor2,prodSpec) ;
        errorCode =  pcata.publish(invalidProductOffering,validFor1);
        assertEquals("compare to return errorCode.", ProductCatalogErrorEnum.PUBLISH_INVALID_OFFERING.getCode(), errorCode);
        assertEquals("expectProdCatalogProdOffer compare to catalog's prodCatalogProdOffer.",expectProdCatalogProdOffer,pcata.getProdCatalogProdOffer());

        //publish a offering but the publish time is greater than offering's endDateTime
        TimePeriod validFor3 = new TimePeriod("2015-07-28 11:59:59","2016-10-08 23:59:59");
        SimpleProductOffering productOffering3 =new SimpleProductOffering("3","17-inch MacBook Pro","17-inch MacBook Pro", validFor3,prodSpec) ;
        errorCode =  pcata.publish(productOffering3,new TimePeriod("2015-07-28 11:59:59","2016-12-08 23:59:59"));
        assertEquals("compare to return errorCode.", ProductCatalogErrorEnum.PUBLISH_INVALID_OFFERING.getCode(), errorCode);
        assertEquals("expectProdCatalogProdOffer compare to catalog's prodCatalogProdOffer.",expectProdCatalogProdOffer,pcata.getProdCatalogProdOffer());

        //publish a offering but the publish time is greater than offering's validFor
        TimePeriod validFor4 = new TimePeriod("2015-07-28 11:59:59","2016-10-08 23:59:59");
        SimpleProductOffering productOffering4 =new SimpleProductOffering("3","17-inch MacBook Pro","17-inch MacBook Pro", validFor4,prodSpec) ;
        errorCode =  pcata.publish(productOffering4,new TimePeriod("2016-12-08 11:59:59","2017-12-08 23:59:59"));
        assertEquals("compare to return errorCode.", ProductCatalogErrorEnum.PUBLISH_INVALID_OFFERING.getCode(), errorCode);
        assertEquals("expectProdCatalogProdOffer compare to catalog's prodCatalogProdOffer.",expectProdCatalogProdOffer,pcata.getProdCatalogProdOffer());

        //publish an ineffective offering
        TimePeriod validFor5 = new TimePeriod("2015-09-08 11:59:59","2017-08-08 23:59:59");
        SimpleProductOffering productOffering5 =new SimpleProductOffering("3","18-inch MacBook Pro","18-inch MacBook Pro", validFor5,prodSpec) ;
        errorCode =  pcata.publish(productOffering4,new TimePeriod("2015-07-28 11:59:59","2016-08-08 23:59:59"));
        assertEquals("compare to return errorCode.", ProductCatalogErrorEnum.PUBLISH_VALIDFOR_INVALID.getCode(), errorCode);
        assertEquals("expectProdCatalogProdOffer compare to catalog's prodCatalogProdOffer.",expectProdCatalogProdOffer,pcata.getProdCatalogProdOffer());

    }

    @Test
    public void testRetired(){
        ProductOffering offering = null ;
        int returnCode =  pcata.retired(offering);
        assertEquals("retired  one null offering ", ProductOfferingErrorEnum.OFFERING_IS_NULL.getCode(), returnCode);

        TimePeriod validFor1 = new TimePeriod("2015-06-04 10:20:00", "2015-07-26 10:20:00");
        pcata.publish(poff, validFor1);
        pcata.retired(poff);
        assertEquals("retired  one  offering check size", 1, pcata.getProdCatalogProdOffer().size());
        for(ProdCatalogProdOffer pcpo:pcata.getProdCatalogProdOffer()){
            assertTrue("retired  one  offering", 0 >= pcpo.getValidFor().getEndDateTime().compareTo(new Date()));
        }
        TimePeriod validFor2 = new TimePeriod("2015-06-04 10:20:00", "2015-07-26 10:20:00");
        pcata.publish(poff, validFor2);
        ProductSpecification  prodSpec = new AtomicProductSpecification("001SP", "11 英寸 MacBook Air SPEC", "Mac Air");
        SimpleProductOffering offering1 = new SimpleProductOffering("00011F", "13 英寸 MacBook Air",  "1.6GHz 双核 Intel Core i5 处理器，Turbo Boost 高达 2.7GHz", validFor1, prodSpec);
        pcata.retired(offering1);
        assertEquals("retired  one  not exists offering ,check size ", 1, pcata.getProdCatalogProdOffer().size());

        TimePeriod validFor3 = new TimePeriod("2015-06-04 10:20:00", "2015-07-26 10:20:00");
        pcata.publish(offering1, validFor3);
        assertEquals("publish different offering ,check size ", 2, pcata.getProdCatalogProdOffer().size());

        List<ProdCatalogProdOffer> lisretiredOffer = new ArrayList<ProdCatalogProdOffer>();
        ProdCatalogProdOffer expectedRetiredOffering1 = new ProdCatalogProdOffer(poff,validFor1);
        lisretiredOffer.add(expectedRetiredOffering1);

        List<ProdCatalogProdOffer> listpublishOffer = new ArrayList<ProdCatalogProdOffer>();
        ProdCatalogProdOffer expectedPublishOffering1 = new ProdCatalogProdOffer(offering1,validFor3);
        listpublishOffer.add(expectedPublishOffering1);

        List<ProdCatalogProdOffer> listResultRetiredOffer = new ArrayList<ProdCatalogProdOffer>();
        List<ProdCatalogProdOffer> listResultPublishOffer = new ArrayList<ProdCatalogProdOffer>();

        for(ProdCatalogProdOffer pcpo:pcata.getProdCatalogProdOffer()){
            if(0 >= pcpo.getValidFor().getEndDateTime().compareTo(new Date())){
                listResultRetiredOffer.add(pcpo);
            }else{
                listResultPublishOffer.add(pcpo);
            }
        }
        assertEquals("publish different offering and have one retired check retired count", 1, listResultRetiredOffer.size());
        assertEquals("publish different offering and have one retired check retired count", lisretiredOffer, listResultRetiredOffer);

        assertEquals("publish different offering and have one retired check publish count", 1, listResultPublishOffer.size());
        assertEquals("publish different offering and have one retired check content",listpublishOffer, listResultPublishOffer);

    }

    @Test
    public void testRetrieveOffering() throws ParseException {
        //publish a offering
        TimePeriod validFor1 = new TimePeriod("2015-07-31 11:59:59","2016-08-08 23:59:59");
        ProdCatalogProdOffer catalogProdOffer = new ProdCatalogProdOffer(poff,validFor1);
        pcata.publish(poff, validFor1);
        TimePeriod validFor11 = new TimePeriod("2016-09-08 23:59:59","2017-08-08 23:59:59");
        SimpleProductOffering sameProductOffering =new SimpleProductOffering("1","13-inch MacBook Pro","13-inch MacBook Pro", validFor,prodSpec) ;
        ProdCatalogProdOffer catalogProdOffer2 = new ProdCatalogProdOffer(sameProductOffering,validFor11);
        pcata.publish(sameProductOffering, validFor11);
        SimpleProductOffering diffProductOffering =new SimpleProductOffering("5","15-inch MacBook Pro","15-inch MacBook Pro", validFor,prodSpec) ;
        ProdCatalogProdOffer diffcatalogProdOffer = new ProdCatalogProdOffer(diffProductOffering,validFor1);
       pcata.publish(diffProductOffering, validFor1);
        List<ProdCatalogProdOffer> prodCatalogProdOffer = null;

        try{
            Date time = null;
            prodCatalogProdOffer = pcata.retrieveOffering(time);
            fail("retrieve offerings by time but the parameter time is null.");
        }catch(IllegalArgumentException E){}

        List<ProdCatalogProdOffer> expectProdCatalogProdOffer = new ArrayList<ProdCatalogProdOffer>();
        expectProdCatalogProdOffer.add(catalogProdOffer);
        expectProdCatalogProdOffer.add(diffcatalogProdOffer);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //retrieve sometime  offerings
        prodCatalogProdOffer = pcata.retrieveOffering(dateFormat.parse("2015-07-31 11:59:59"));
        assertEquals("compare to size.", 2, prodCatalogProdOffer.size());
        assertEquals("expectProdCatalogProdOffer compare to catalog's prodCatalogProdOffer.", expectProdCatalogProdOffer, prodCatalogProdOffer);

        //retrieve sometime  offerings
        prodCatalogProdOffer = pcata.retrieveOffering(dateFormat.parse("2018-10-08 11:59:59"));
        assertEquals("compare to size.", 0, prodCatalogProdOffer.size());

        //retrieve sometime  offerings
        prodCatalogProdOffer = pcata.retrieveOffering(dateFormat.parse("2015-06-08 11:59:59"));
        assertEquals("compare to size.", 0, prodCatalogProdOffer.size());
    }
    @Test
    public void testRetrieveOffering1() throws ParseException {
        //publish a offering
        TimePeriod validFor1 = new TimePeriod("2015-07-31 11:59:59","2016-08-08 23:59:59");
        ProdCatalogProdOffer catalogProdOffer = new ProdCatalogProdOffer(poff,validFor1);
        pcata.publish(poff, validFor1);
        TimePeriod validFor11 = new TimePeriod("2016-09-08 23:59:59","2017-08-08 23:59:59");
        SimpleProductOffering sameProductOffering =new SimpleProductOffering("1","13-inch MacBook Pro","13-inch MacBook Pro", validFor,prodSpec) ;
        ProdCatalogProdOffer catalogProdOffer2 = new ProdCatalogProdOffer(sameProductOffering,validFor11);
        pcata.publish(sameProductOffering, validFor11);
        SimpleProductOffering diffProductOffering =new SimpleProductOffering("5","15-inch MacBook Pro","15-inch MacBook Pro", validFor,prodSpec) ;
        ProdCatalogProdOffer diffcatalogProdOffer = new ProdCatalogProdOffer(diffProductOffering,validFor1);
        pcata.publish(diffProductOffering,validFor1);
        List<ProdCatalogProdOffer> prodCatalogProdOffer = null;

        try{
            String offeringName = null;
            prodCatalogProdOffer = pcata.retrieveOffering(offeringName);
            fail("retrieve offerings by offeringName but the parameter offeringName is null.");
        }catch(IllegalArgumentException E){}

        List<ProdCatalogProdOffer> expectProdCatalogProdOffer = new ArrayList<ProdCatalogProdOffer>();
        expectProdCatalogProdOffer.add(catalogProdOffer);
        expectProdCatalogProdOffer.add(catalogProdOffer2);
        //retrieve offeringName is '13-inch MacBook Pro'  offerings
        prodCatalogProdOffer = pcata.retrieveOffering("13-inch MacBook Pro");
        assertEquals("compare to size.", 2, prodCatalogProdOffer.size());
        assertEquals("expectProdCatalogProdOffer compare to catalog's prodCatalogProdOffer.", expectProdCatalogProdOffer, prodCatalogProdOffer);

        //retrieve offeringName is '11-inch MacBook Pro'  offerings
        prodCatalogProdOffer = pcata.retrieveOffering("11-inch MacBook Pro");
        assertEquals("compare to size.", 0, prodCatalogProdOffer.size());

    }
    @Test
    public void testRetrieveOffering2() throws ParseException {
        //publish a offering
        TimePeriod validFor1 = new TimePeriod("2015-07-31 11:59:59","2016-08-08 23:59:59");
        ProdCatalogProdOffer catalogProdOffer = new ProdCatalogProdOffer(poff,validFor1);
        pcata.publish(poff, validFor1);
        TimePeriod validFor11 = new TimePeriod("2016-09-08 23:59:59","2017-08-08 23:59:59");
        SimpleProductOffering sameProductOffering =new SimpleProductOffering("1","13-inch MacBook Pro","13-inch MacBook Pro", validFor,prodSpec) ;
        ProdCatalogProdOffer catalogProdOffer2 = new ProdCatalogProdOffer(sameProductOffering,validFor11);
        pcata.publish(sameProductOffering, validFor11);
        SimpleProductOffering diffProductOffering =new SimpleProductOffering("5","15-inch MacBook Pro","15-inch MacBook Pro", validFor,prodSpec) ;
        ProdCatalogProdOffer diffcatalogProdOffer = new ProdCatalogProdOffer(diffProductOffering,validFor1);
        pcata.publish(diffProductOffering,validFor1);
        List<ProdCatalogProdOffer> prodCatalogProdOffer = null;

        try{
            Date time = null;
            prodCatalogProdOffer = pcata.retrieveOffering(time);
            fail("retrieve offerings by time and offering but the parameter time is null.");
        }catch(IllegalArgumentException E){}
        try{
            String offeringName = null;
            prodCatalogProdOffer = pcata.retrieveOffering(offeringName);
            fail("retrieve offerings by time and offering but the parameter offeringName is null.");
        }catch(IllegalArgumentException E){}

        List<ProdCatalogProdOffer> expectProdCatalogProdOffer = new ArrayList<ProdCatalogProdOffer>();
        expectProdCatalogProdOffer.add(catalogProdOffer);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //retrieve offeringName is '13-inch MacBook Pro' and validTime is 2015-07-31  offerings
        prodCatalogProdOffer = pcata.retrieveOffering("13-inch MacBook Pro",dateFormat.parse("2015-07-31 11:59:59"));
        assertEquals("compare to size.", 1, prodCatalogProdOffer.size());
        assertEquals("expectProdCatalogProdOffer compare to catalog's prodCatalogProdOffer.", expectProdCatalogProdOffer, prodCatalogProdOffer);

        //retrieve offeringName is '13-inch MacBook Pro' and validTime is 2018-07-31  offerings
        prodCatalogProdOffer = pcata.retrieveOffering("13-inch MacBook Pro",dateFormat.parse("2018-07-31 11:59:59"));
        assertEquals("compare to size.", 0, prodCatalogProdOffer.size());

        //retrieve offeringName is '15-inch MacBook Pro' and validTime is 2015-07-31  offerings
        prodCatalogProdOffer = pcata.retrieveOffering("15-inch MacBook Pro",dateFormat.parse("2015-07-31 11:59:59"));
        assertEquals("compare to size.", 0, prodCatalogProdOffer.size());

    }
}