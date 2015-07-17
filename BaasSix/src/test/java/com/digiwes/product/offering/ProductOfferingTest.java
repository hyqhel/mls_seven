package com.digiwes.product.offering;

import com.digiwes.basetype.TimePeriod;
import com.digiwes.common.enums.ProductOfferingErrorEnum;
import com.digiwes.common.enums.RelationshipType;
import com.digiwes.product.spec.AtomicProductSpecification;
import com.digiwes.product.spec.ProductSpecification;
import org.junit.Before;
import org.junit.BeforeClass;
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
public class ProductOfferingTest {

    SimpleProductOffering offering = null;
    public static ProductSpecification specification = null;
    SimpleProductOffering srcOffering = null;

    @BeforeClass
    public static void initProductSpec() {
        specification = new AtomicProductSpecification("001SP", "11 英寸 MacBook Air SPEC", "Mac Air");
    }
    @Before
    public void initOffering() {
        String id = "S001";
        String name = "11 英寸 MacBook Air";
        TimePeriod validFor = new TimePeriod("2015-06-04 10:20:00", "2015-06-26 10:20:00");
        String description = "1.6GHz 双核 Intel Core i5 处理器，Turbo Boost 高达 2.7GHz";
        srcOffering = new SimpleProductOffering(id, name, description, validFor, specification);
    }

    @Test
    public void testAssociate()  {
// *********** Case1 **************
        TimePeriod targetProdOfferingValidFor = new TimePeriod("2015-06-04 10:20:00", "2015-06-26 10:20:00");
        SimpleProductOffering targetProdOffering = new SimpleProductOffering("T001", "AppleCare For Mac",
                "AppleCare", targetProdOfferingValidFor, specification);
        String type = RelationshipType.DEPENDENCY.getValue();
        TimePeriod validFor = new TimePeriod("2015-06-04 10:20:00", "2015-06-26 10:20:00");
        List<ProductOfferingRelationship> expectedRelatedOfferingList = new ArrayList<ProductOfferingRelationship>();
        ProductOfferingRelationship expectedRelatedOffering = new ProductOfferingRelationship(srcOffering,
                targetProdOffering, type, validFor);
        expectedRelatedOfferingList.add(expectedRelatedOffering);
        this.srcOffering.associate(targetProdOffering, type, validFor);
        assertEquals("add a normal SimpleProductOffering.", 1, this.srcOffering.getProdOfferingRelationship().size());
        assertEquals(expectedRelatedOfferingList, srcOffering.getProdOfferingRelationship());

        // *********** Case2 **************
        // add the same SimpleProductOffering 、 the same relationshipType and the same validTimePeriod again.
        SimpleProductOffering targetProdOffering2 = new SimpleProductOffering("T001", "AppleCare For Mac",
                "AppleCare", targetProdOfferingValidFor, specification);

        int returncode = this.srcOffering.associate(targetProdOffering2, type, validFor);
        assertEquals("the relationship already exist as the same timePeriod. Cannot associate relationship again.",
                ProductOfferingErrorEnum.OFFERING_RELATIONSHIP_EXISTING.getCode(), returncode);

        assertEquals("add same SimpleProductOffering and the same relationshipType again",
                1, this.srcOffering.getProdOfferingRelationship().size());
        assertEquals("add same SimpleProductOffering and the same relationshipType again",
                expectedRelatedOfferingList, this.srcOffering.getProdOfferingRelationship());

        // *********** Case3 **************
        SimpleProductOffering targetProdOffering3 = new SimpleProductOffering("T002", "AppleCare For Mac",
                "AppleCare", targetProdOfferingValidFor, specification);
        this.srcOffering.associate(targetProdOffering3, type, validFor);

        ProductOfferingRelationship expectedRelatedOffering3 = new ProductOfferingRelationship(srcOffering,
                targetProdOffering3, type, validFor);
        expectedRelatedOfferingList.add(expectedRelatedOffering3);
        assertEquals("add a different SimpleProductOffering and the same relationshipType again.", 2, this.srcOffering
                .getProdOfferingRelationship().size());
        assertEquals("add a different SimpleProductOffering and the same relationshipType again.",
                expectedRelatedOfferingList, this.srcOffering.getProdOfferingRelationship());

        // *********** Case4 **************
        // add the same SimpleProductOffering and different relationshipType again.
        String type4 = RelationshipType.AGGREGATION.getValue();
        SimpleProductOffering targetProdSpec4 = new SimpleProductOffering("T001", "AppleCare For Mac",
                "AppleCare", targetProdOfferingValidFor, specification);
        this.srcOffering.associate(targetProdSpec4, type4, validFor);

        SimpleProductOffering expectedTargetProdSpec4 = new SimpleProductOffering("T001", "AppleCare For Mac",
                "AppleCare", targetProdOfferingValidFor, specification);
        ProductOfferingRelationship expectedRelatedSpec4 = new ProductOfferingRelationship(srcOffering,
                expectedTargetProdSpec4, type4, validFor);
        expectedRelatedOfferingList.add(expectedRelatedSpec4);
        assertEquals("add the same AtomicProductSpecification and different relationshipType again.",
                3, this.srcOffering.getProdOfferingRelationship().size());
        assertEquals("add the same AtomicProductSpecification and different relationshipType again.",
                expectedRelatedOfferingList, srcOffering.getProdOfferingRelationship());

        // *********** Case5 **************
        // add relationship with srcProdSpec itSelf.
        returncode = this.srcOffering.associate(this.srcOffering, type4, validFor);
        assertEquals("add relationship with srcProdSpec itSelf.",ProductOfferingErrorEnum.OFFERING_ASSOCIATE_ITSELF.getCode(),
                returncode);
        assertEquals("add relationship with srcProdSpec itSelf.", 3, this.srcOffering.getProdOfferingRelationship().size());
        assertEquals("add relationship with srcProdSpec itSelf.", expectedRelatedOfferingList, srcOffering
                .getProdOfferingRelationship());

        // *********** Case6 **************
        // add the same SimpleProductOffering 、 the same relationshipType and the different validTimePeriod again.
        TimePeriod validFor6 = new TimePeriod("2015-07-04 10:20:00", "2015-07-26 10:20:00");
        SimpleProductOffering targetProdOffering6 = new SimpleProductOffering("T001", "AppleCare For Mac",
                "AppleCare", targetProdOfferingValidFor, specification);
        this.srcOffering.associate(targetProdOffering2, type, validFor6);

        SimpleProductOffering expectedTargetProdSpec6 = new SimpleProductOffering("T001", "AppleCare For Mac",
                "AppleCare", targetProdOfferingValidFor, specification);
        ProductOfferingRelationship expectedRelatedOffering6 = new ProductOfferingRelationship(srcOffering,
                expectedTargetProdSpec6, type, validFor6);
        expectedRelatedOfferingList.add(expectedRelatedOffering6);

        assertEquals("add same SimpleProductOffering and the same relationshipType again",
                4, this.srcOffering.getProdOfferingRelationship().size());
        assertEquals("add same SimpleProductOffering and the same relationshipType again",
                expectedRelatedOfferingList, this.srcOffering.getProdOfferingRelationship());

        System.out.println(this.srcOffering.toString());
    }

    @Test
    public void testDissociate(){

    }

    /**
     * by type
     */
    @Test
    public void testRetrieveRelatedOfferingByType()  {

        // *********** Case1 *************
        TimePeriod targetProdOfferingValidFor = new TimePeriod("2015-06-04 10:20:00", "2015-06-26 10:20:00");
        String dependencyType = RelationshipType.DEPENDENCY.getValue();
        String aggregationType = RelationshipType.AGGREGATION.getValue();
        SimpleProductOffering targetProdOfferingDependency1 = new SimpleProductOffering("T001", "AppleCare For Mac",
                "AppleCare", targetProdOfferingValidFor, specification);
        SimpleProductOffering targetProdOfferingAggregation1 = new SimpleProductOffering("T002", "AppleCare For Mac",
                "AppleCare", targetProdOfferingValidFor, specification);
        TimePeriod validFor = new TimePeriod();

        List<ProductOffering> expectedRelatedOfferingList = new ArrayList<ProductOffering>();
        SimpleProductOffering expectedTargetProdOffering = new SimpleProductOffering("T002", "AppleCare For Mac",
                "AppleCare", targetProdOfferingValidFor, specification);
        expectedRelatedOfferingList.add(expectedTargetProdOffering);

        this.srcOffering.associate(targetProdOfferingDependency1, dependencyType, validFor);
        this.srcOffering.associate(targetProdOfferingAggregation1, aggregationType, validFor);
        List<ProductOffering> productOfferingList = this.srcOffering.retrieveRelatedOffering(aggregationType);
        assertEquals("retrieve Offering of a relationshipType from more than 2 type.", 1, productOfferingList.size());
        assertEquals("retrieve Offering of a relationshipType from more than 2 type.", expectedRelatedOfferingList, productOfferingList);

        // *********** Case2 **************
        List<ProductOffering> productOfferingList2 = this.srcOffering
                .retrieveRelatedOffering(RelationshipType.EXCLUSIVITY.getValue());
        assertEquals("retrieve Offering from productOfferingRelationships by a no existent type.", 0,
                productOfferingList2.size());

        // *********** Case3 **************
        List<ProductOffering> productOfferingList3 = this.srcOffering.retrieveRelatedOffering(null);
        assertEquals("retrieve Offering by nyll offering", 0, productOfferingList3.size());

        // *********** Case4 **************
        this.srcOffering.getProdOfferingRelationship().clear();
        List<ProductOffering> productOfferingList4 = this.srcOffering
                .retrieveRelatedOffering(aggregationType);
        assertEquals("retrieve Offering from empty relationships", 0, productOfferingList4.size());
    }

    /**
     * by type and time
     */
    @Test
    public void testRetrieveRelatedOfferingByTypeAndTime()  {

        Date validDate = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        // *********** Case1 *************
        TimePeriod targetProdOfferingValidFor = new TimePeriod("2014-06-04 10:20:00", "2014-06-26 10:20:00");
        TimePeriod relationshipValidTime1 = new TimePeriod("2014-06-04 10:20:00", "2014-06-26 10:20:00");
        TimePeriod relationshipValidTime2 = new TimePeriod("2015-06-04 10:20:00", "2015-06-26 10:20:00");
        String dependencyType = RelationshipType.DEPENDENCY.getValue();
        String aggregationType = RelationshipType.AGGREGATION.getValue();
        SimpleProductOffering targetProdOfferingDependency1 = new SimpleProductOffering("T001", "AppleCare For Mac",
                "AppleCare", targetProdOfferingValidFor, specification);
        SimpleProductOffering targetProdOfferingAggregation1 = new SimpleProductOffering("T002", "AppleCare For Mac",
                "AppleCare", targetProdOfferingValidFor, specification);
        TimePeriod validFor = new TimePeriod();

        List<ProductOffering> expectedRelatedOfferingList = new ArrayList<ProductOffering>();

        this.srcOffering.associate(targetProdOfferingDependency1, dependencyType, relationshipValidTime1);
        this.srcOffering.associate(targetProdOfferingDependency1, dependencyType, relationshipValidTime2);
        this.srcOffering.associate(targetProdOfferingAggregation1, aggregationType, relationshipValidTime1);
        this.srcOffering.associate(targetProdOfferingAggregation1, aggregationType, relationshipValidTime2);

        try {
            validDate = format.parse("2015-06-05 10:21:10");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<ProductOffering> productOfferingList = this.srcOffering.retrieveRelatedOffering(aggregationType, validDate);
        SimpleProductOffering expectedTargetProdOffering = new SimpleProductOffering("T002", "AppleCare For Mac",
                "AppleCare", targetProdOfferingValidFor, specification);
        expectedRelatedOfferingList.add(expectedTargetProdOffering);
        assertEquals("retrieve specification of a relationshipType from more than 2 type.", 1, productOfferingList.size());
        assertEquals("retrieve specification of a relationshipType from more than 2 type.", expectedRelatedOfferingList, productOfferingList);

        // *********** Case2 **************
        List<ProductOffering> productOfferingList2 = this.srcOffering
                .retrieveRelatedOffering(RelationshipType.EXCLUSIVITY.getValue(), validDate);
        assertEquals("retrieve ProductSpecification from productSpecRelationships by a no existent type.", 0, productOfferingList2.size());

        // *********** Case3 **************
        List<ProductOffering> productOfferingList3 = this.srcOffering.retrieveRelatedOffering(null, validDate);
        assertEquals("Case 3 ： fail when relationType is null", 0, productOfferingList3.size());


        // *********** Case4 **************
        try {
            validDate = format.parse("2011-06-05 10:21:10");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<ProductOffering> productOfferingList4 = this.srcOffering.retrieveRelatedOffering(dependencyType, validDate);
        assertEquals("retrieve ProductSpecification from productSpecRelationships by a no existent validDate.", 0,
                productOfferingList2.size());

        // *********** Case5 **************
        this.srcOffering.getProdOfferingRelationship().clear();
        List<ProductOffering> productOfferingList5 = this.srcOffering
                .retrieveRelatedOffering(aggregationType);
        assertEquals("retrieve ProductSpecification from empty relationships", 0, productOfferingList4.size());
    }
}