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
import com.digiwes.common.util.DateAdapter;
import com.digiwes.product.offering.catalog.ProdCatalogProdOffer;
import com.digiwes.resources.beans.EngagedPartyProduct.Category.CategoryRef;
import com.digiwes.resources.beans.EngagedPartyProduct.ProductSpecification.ProductSpecificationRef;
import com.digiwes.resources.beans.Resource.ResourceCandidateRef;
import com.digiwes.resources.beans.Root.ChannelRef;
import com.digiwes.resources.beans.Root.PlaceRef;
import com.digiwes.resources.beans.Service.ServiceCandidateRef;
import com.digiwes.resources.beans.Service.ServiceLevelAgreementRef;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;

@XmlRootElement
public class ProductOfferingResp{
  private String id;
  private String href;
  private Date lastUpdate;
  private String version;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }
  @XmlJavaTypeAdapter(DateAdapter.class)
  @XmlElement
  public Date getLastUpdate() {
    return lastUpdate;
  }

  public void setLastUpdate(Date lastUpdate) {
    this.lastUpdate = lastUpdate;
  }

  public boolean isBunlde() {
    return isBunlde;
  }

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
  @XmlElement
  public List<ChannelRef> getChannelRef() {
    return channelRef;
  }

  public void setChannelRef(List<ChannelRef> value) {
    this.channelRef = value;
  }

  private List<PlaceRef> placeRef;
  @XmlElement
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
  @XmlElement
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
  @XmlElement
  public List<ProductOfferingTerm> getProductOfferingTerm() {
    return productOfferingTerm;
  }

  public void setProductOfferingTerm(List<ProductOfferingTerm> value) {
    this.productOfferingTerm = value;
  }

  private List<ProductOfferingPrice> productOfferingPrice;
  @XmlElement
  public List<ProductOfferingPrice> getProductOfferingPrice() {
    return productOfferingPrice;
  }

  public void setProductOfferingPrice(List<ProductOfferingPrice> value) {
    this.productOfferingPrice = value;
  }

  private List<BundledProductOffering> bundledProductOffering;
  @XmlElement
  public List<BundledProductOffering> getBundledProductOffering() {
    return bundledProductOffering;
  }

  public void setBundledProductOffering(List<BundledProductOffering> value) {
    this.bundledProductOffering = value;
  }

  public void convertFromProdCatalogProdOffeing(ProdCatalogProdOffer prodCatalogProdOffer){
    this.id = prodCatalogProdOffer.getProdOffering().getId();
    this.name = prodCatalogProdOffer.getProdOffering().getName();
    this.description = prodCatalogProdOffer.getProdOffering().getDescription();
    this.lifecycleStatus = prodCatalogProdOffer.getProdOffering().getStatus();
  }
}