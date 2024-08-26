package za.ac.cput.domain;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "product_id", nullable = false, unique = true)
    private String productId;
    private String productName;
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private ProductCategory category;
    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;
    private String description;
    private double price;
    private int stockQuantity;
    private String dimension;
    private String warranty;
    private String productPicture; // Add this field

    protected Product() {}

    public Product(Builder builder) {
        this.productId = builder.productId;
        this.productName = builder.productName;
        this.category = builder.category;
        this.brand = builder.brand;
        this.description = builder.description;
        this.price = builder.price;
        this.stockQuantity = builder.stockQuantity;
        this.dimension = builder.dimension;
        this.warranty = builder.warranty;
        this.productPicture = builder.productPicture;
    }

    // Getters
    public String getProductId() { return productId; }
    public String getProductName() { return productName; }
    public ProductCategory getCategory() { return category; }
    public Brand getBrand() { return brand; }
    public String getDescription() { return description; }
    public double getPrice() { return price; }
    public int getStockQuantity() { return stockQuantity; }
    public String getDimension() { return dimension; }
    public String getWarranty() { return warranty; }
    public String getProductPicture() { return productPicture; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product1)) return false;
        return Double.compare(getPrice(), product1.getPrice()) == 0 && getStockQuantity() == product1.getStockQuantity() && Objects.equals(getProductId(), product1.getProductId()) && Objects.equals(getProductName(), product1.getProductName()) && Objects.equals(getCategory(), product1.getCategory()) && Objects.equals(getBrand(), product1.getBrand()) && Objects.equals(getDescription(), product1.getDescription()) && Objects.equals(getDimension(), product1.getDimension()) && Objects.equals(getWarranty(), product1.getWarranty()) && Objects.equals(getProductPicture(), product1.getProductPicture());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductId(), getProductName(), getCategory(), getBrand(), getDescription(), getPrice(), getStockQuantity(), getDimension(), getWarranty(), getProductPicture()); // Add getPicture()
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", category=" + category +
                ", brand=" + brand +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", stockQuantity=" + stockQuantity +
                ", dimension='" + dimension + '\'' +
                ", warranty='" + warranty + '\'' +
                ", productPicture='" + productPicture + '\'' +
                '}';
    }

    public static class Builder {
        private String productId;
        private String productName;
        private ProductCategory category;
        private Brand brand;
        private String description;
        private double price;
        private int stockQuantity;
        private String dimension;
        private String warranty;
        private String productPicture; // Add this field

        public Builder setProductId(String productId) {
            this.productId = productId;
            return this;
        }

        public Builder setProductName(String productName) {
            this.productName = productName;
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

        public Builder setProductPicture(String productPicture) {
            this.productPicture = productPicture;
            return this;
        }

        public Builder copy(Product product) {
            this.productId = product.productId;
            this.productName = product.productName;
            this.category = product.category;
            this.brand = product.brand;
            this.description = product.description;
            this.price = product.price;
            this.stockQuantity = product.stockQuantity;
            this.dimension = product.dimension;
            this.warranty = product.warranty;
            this.productPicture = product.productPicture;
            return this;
        }

        public Product build(){
            return new Product(this);
        }
    }
}