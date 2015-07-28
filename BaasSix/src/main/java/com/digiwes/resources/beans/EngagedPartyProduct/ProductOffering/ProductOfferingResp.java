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


  private boolean isBundle;

  public boolean isBundle() {
    return isBundle;
  }

  public void setIsBundle(boolean isBundle) {
    this.isBundle = isBundle;
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

  private List<ChannelRef> channel;
  @XmlElement
  public List<ChannelRef> getChannel() {
    return channel;
  }

  public void setChannelRef(List<ChannelRef> value) {
    this.channel = value;
  }

  private List<PlaceRef> place;
  @XmlElement
  public List<PlaceRef> getPlace() {
    return place;
  }

  public void setPlace(List<PlaceRef> value) {
    this.place = value;
  }

  private ProductSpecificationRef productSpecification;

  public ProductSpecificationRef getProductSpecification() {
    return productSpecification;
  }

  public void setProductSpecification(ProductSpecificationRef value) {
    this.productSpecification = value;
  }

  private List<CategoryRef> category;
  @XmlElement
  public List<CategoryRef> getCategory() {
    return category;
  }

  public void setCategory(List<CategoryRef> category) {
    this.category = category;
  }




  private ServiceCandidateRef serviceCandidate;

  public ServiceCandidateRef getServiceCandidate() {
    return serviceCandidate;
  }

  public void setServiceCandidate(ServiceCandidateRef serviceCandidate) {
    this.serviceCandidate = serviceCandidate;
  }

  private ResourceCandidateRef resourceCandidate;

  public ResourceCandidateRef getResourceCandidate() {
    return resourceCandidate;
  }

  public void setResourceCandidate(ResourceCandidateRef value) {
    this.resourceCandidate = value;
  }

  private ServiceLevelAgreementRef serviceLevelAgreement;

  public ServiceLevelAgreementRef getServiceLevelAgreement() {
    return serviceLevelAgreement;
  }

  public void setServiceLevelAgreement(ServiceLevelAgreementRef value) {
    this.serviceLevelAgreement = value;
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