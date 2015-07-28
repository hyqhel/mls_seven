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

/**
 * the money type price in SID model
 */
public class Rate {
  private Float taxIncludedAmount;

  public Float getTaxIncludedAmount() {
    return taxIncludedAmount;
  }

  public void setTaxIncludedAmount(Float value) {
    this.taxIncludedAmount = value;
  }

  private float dutyFreeAmount;

  public float getDutyFreeAmount() {
    return dutyFreeAmount;
  }

  public void setDutyFreeAmount(float value) {
    this.dutyFreeAmount = value;
  }

  private float taxRate;

  public float getTaxRate() {
    return taxRate;
  }

  public void setTaxRate(float value) {
    this.taxRate = value;
  }

  private String currencyCode;

  public String getCurrencyCode() {
    return currencyCode;
  }

  public void setCurrencyCode(String value) {
    this.currencyCode = value;
  }

  private float percentage;

  public float getPercentage() {
    return percentage;
  }

  public void setPercentage(float value) {
    this.percentage = value;
  }

  private String priceType;

  public String getPriceType() {
    return priceType;
  }

  public void setPriceType(String value) {
    this.priceType = value;
  }

  private ProductOfferPriceAlteration productOfferPriceAlteration;

  public ProductOfferPriceAlteration getProductOfferPriceAlteration() {
    return productOfferPriceAlteration;
  }

  public void setProductOfferPriceAlteration(ProductOfferPriceAlteration value) {
    this.productOfferPriceAlteration = value;
  }

}