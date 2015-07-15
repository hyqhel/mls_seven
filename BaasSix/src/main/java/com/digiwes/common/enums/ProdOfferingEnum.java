package com.digiwes.common.enums;

public class ProdOfferingEnum {/**
     * OfferingStatus
     */
    public enum ProductOfferingStatus {
        PLANNED("PLANNED", "PLANNED"),
        OBSOLETE("OBSOLETE", "OBSOLETE"),
        ACTIVE("ACTIVE", "ACTIVE");

        private String value;
        private String name;

        /**
         * 
         * @param value
         * @param name
         */
        ProductOfferingStatus(String value, String name) {
            // TODO - implement ProductOfferingStatus.ProductOfferingStatus
            throw new UnsupportedOperationException();
        }

        public String getValue() {
            return this.value;
        }

        public String getName() {
            return this.name;
        }



    }/**
     * OfferingStatus
     */
    public enum OfferingRelationshipType {
        AGGREGATION("1", "AGGREGATION"),
        DEPENDENCY("2", "DEPENDENCY"),
        MIGRATION("3", "MIGRATION"),
        SUBSTITUTION("4", "SUBSTITUTION"),
        EXCLUSIVITY("5", "EXCLUSIVITY");

        private String value;
        private String name;

        /**
         * 
         * @param value
         * @param name
         */
        OfferingRelationshipType(String value, String name) {
            // TODO - implement OfferingRelationshipType.OfferingRelationshipType
            throw new UnsupportedOperationException();
        }

        public String getValue() {
            return this.value;
        }

        public String getName() {
            return this.name;
        }



    }/**
     * OfferingStatus
     */
    public enum ProductCatalogType {
        WEB("1", "web"),
        BOOK("2", "book");

        private static String value;
        private static String name;

        /**
         * 
         * @param value
         * @param name
         */
        ProductCatalogType(String value, String name) {
            // TODO - implement ProductCatalogType.ProductCatalogType
            throw new UnsupportedOperationException();
        }

        public String getValue() {
            return this.value;
        }

        public String getName() {
            return this.name;
        }



    }

}