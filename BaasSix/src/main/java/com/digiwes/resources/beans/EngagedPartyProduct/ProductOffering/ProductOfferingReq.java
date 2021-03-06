/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 *
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 *
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: nisx
 * License Type: Purchased
 */
package com.digiwes.resources.beans.EngagedPartyProduct.ProductOffering;

import com.digiwes.basetype.TimePeriod;
import com.digiwes.resources.beans.EngagedPartyProduct.Category.CategoryRef;
import com.digiwes.resources.beans.EngagedPartyProduct.ProductSpecification.ProductSpecificationRef;
import com.digiwes.resources.beans.Resource.ResourceCandidateRef;
import com.digiwes.resources.beans.Root.ChannelRef;
import com.digiwes.resources.beans.Root.PlaceRef;
import com.digiwes.resources.beans.Service.ServiceCandidateRef;
import com.digiwes.resources.beans.Service.ServiceLevelAgreementRef;

import java.util.List;

public class ProductOfferingReq {
  private String version;

  public String getVersion() {
    return version;
  }

  public void setVersion(String value) {
    this.version = value;
  }

  private String name;

  public String getName() {
    return name;
  }

  public void setName(String value) {
    this.name = value;
  }

  private String description;

  public String getDescription() {
    return description;
  }

  public void setDescription(String value) {
    this.description = value;
  }

  private boolean isBunlde;

  public boolean getIsBunlde() {
    return isBunlde;
  }

  public void setIsBunlde(boolean value) {
    this.isBunlde = value;
  }

  private String lifecycleStatus;

  public String getLifecycleStatus() {
    return lifecycleStatus;
  }

  public void setLifecycleStatus(String value) {
    this.lifecycleStatus = value;
  }

  private TimePeriod validFor;

  public TimePeriod getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriod value) {
    this.validFor = value;
  }

  private List<ChannelRef> channelRef;

  public List<ChannelRef> getChannelRef() {
    return channelRef;
  }

  public void setChannelRef(List<ChannelRef> value) {
    this.channelRef = value;
  }

  private List<PlaceRef> placeRef;

  public List<PlaceRef> getPlaceRef() {
    return placeRef;
  }

  public void setPlaceRef(List<PlaceRef> value) {
    this.placeRef = value;
  }

  private ProductSpecificationRef productSpecificationRef;

  public ProductSpecificationRef getProductSpecificationRef() {
    return productSpecificationRef;
  }

  public void setProductSpecificationRef(ProductSpecificationRef value) {
    this.productSpecificationRef = value;
  }

  private List<CategoryRef> categoryRef;

  public List<CategoryRef> getCategoryRef() {
    return categoryRef;
  }

  public void setCategoryRef(List<CategoryRef> value) {
    this.categoryRef = value;
  }

  private ServiceCandidateRef serviceCandidateRef;

  public ServiceCandidateRef getServiceCandidateRef() {
    return serviceCandidateRef;
  }

  public void setServiceCandidateRef(ServiceCandidateRef value) {
    this.serviceCandidateRef = value;
  }

  private ResourceCandidateRef resourceCandidateRef;

  public ResourceCandidateRef getResourceCandidateRef() {
    return resourceCandidateRef;
  }

  public void setResourceCandidateRef(ResourceCandidateRef value) {
    this.resourceCandidateRef = value;
  }

  private ServiceLevelAgreementRef serviceLevelAgreementRef;

  public ServiceLevelAgreementRef getServiceLevelAgreementRef() {
    return serviceLevelAgreementRef;
  }

  public void setServiceLevelAgreementRef(ServiceLevelAgreementRef value) {
    this.serviceLevelAgreementRef = value;
  }

  private List<ProductOfferingTerm> productOfferingTerm;

  public List<ProductOfferingTerm> getProductOfferingTerm() {
    return productOfferingTerm;
  }

  public void setProductOfferingTerm(List<ProductOfferingTerm> value) {
    this.productOfferingTerm = value;
  }

  private List<ProductOfferingPrice> productOfferingPrice;

  public List<ProductOfferingPrice> getProductOfferingPrice() {
    return productOfferingPrice;
  }

  public void setProductOfferingPrice(List<ProductOfferingPrice> value) {
    this.productOfferingPrice = value;
  }

  private List<BundledProductOffering> bundledProductOffering;

  public List<BundledProductOffering> getBundledProductOffering() {
    return bundledProductOffering;
  }

  public void setBundledProductOffering(List<BundledProductOffering> value) {
    this.bundledProductOffering = value;
  }

}