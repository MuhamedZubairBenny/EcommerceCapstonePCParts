package za.ac.cput.domain;

import java.util.Objects;

public class Product{
    private String productId;
    private String product;
    private ProductCategory category;
    private Brand brand;
    private String description;
    private double price;
    private int stockQuantity;
    private String dimension;
    private String warranty;

    protected Product(){}

    public Product(Builder builder){
        this.productId = builder.productId;
        this.product = builder.product;
        this.category = builder.category;
        this.brand = builder.brand;
        this.description = builder.description;
        this.price = builder.price;
        this.stockQuantity = builder.stockQuantity;
        this.dimension = builder.dimension;
        this.warranty = builder.warranty;

    }

    public String getProductId() {
        return productId;
    }

    public String getProduct() {
        return product;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public Brand getBrand() {
        return brand;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public String getDimension() {
        return dimension;
    }

    public String getWarranty() {
        return warranty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product1)) return false;
        return Double.compare(getPrice(), product1.getPrice()) == 0 && getStockQuantity() == product1.getStockQuantity() && Objects.equals(getProductId(), product1.getProductId()) && Objects.equals(getProduct(), product1.getProduct()) && Objects.equals(getCategory(), product1.getCategory()) && Objects.equals(getBrand(), product1.getBrand()) && Objects.equals(getDescription(), product1.getDescription()) && Objects.equals(getDimension(), product1.getDimension()) && Objects.equals(getWarranty(), product1.getWarranty());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductId(), getProduct(), getCategory(), getBrand(), getDescription(), getPrice(), getStockQuantity(), getDimension(), getWarranty());
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", product='" + product + '\'' +
                ", category=" + category +
                ", brand=" + brand +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", stockQuantity=" + stockQuantity +
                ", dimension='" + dimension + '\'' +
                ", warranty='" + warranty + '\'' +
                '}';
    }

    public static class Builder{
        private String productId;
        private String product;
        private ProductCategory category;
        private Brand brand;
        private String description;
        private double price;
        private int stockQuantity;
        private String dimension;
        private String warranty;

        public Builder setProductId(String productId) {
            this.productId = productId;
            return this;
        }

        public Builder setProduct(String product) {
            this.product = product;
            return this;
        }

        public Builder setCategory(ProductCategory category) {
            this.category = category;
            return this;
        }

        public Builder setBrand(Brand brand) {
            this.brand = brand;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder setStockQuantity(int stockQuantity) {
            this.stockQuantity = stockQuantity;
            return this;
        }

        public Builder setDimension(String dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setWarranty(String warranty) {
            this.warranty = warranty;
            return this;
        }

        public Builder copy(Product product){
            this.productId = product.productId;
            this.product = product.product;
            this.category = product.category;
            this.brand = product.brand;
            this.description = product.description;
            this.price = product.price;
            this.stockQuantity = product.stockQuantity;
            this.dimension = product.dimension;
            this.warranty = product.warranty;
            return this;
        }

        public Product build(){
            return new Product(this);
        }
    }
    }



