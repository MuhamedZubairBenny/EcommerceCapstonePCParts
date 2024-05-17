package za.ac.cput.domain;
/*
Author:
Imaan Sadien - 221752838
GitHub Repo:
https://github.com/Elentiya10/EcommercePCParts
 */

import java.util.Objects;

public class Inventory {
    private Product product;
        private int stockQuantity;


    protected Inventory() {}

    public Inventory(Builder builder){
        this.product = builder.product;
        this.stockQuantity = builder.stockQuantity;

    }

    public Product getProduct() {
        return product;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inventory inventory = (Inventory) o;
        return stockQuantity == inventory.stockQuantity && Objects.equals(product, inventory.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, stockQuantity);
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "product=" + product +
                ", stockQuantity=" + stockQuantity +
                '}';
    }

    public static class Builder{
        private Product product;
        private int stockQuantity;

        public Builder setProduct(Product product) {
            this.product = product;
            return this;
        }

        public Builder setStockQuantity(int stockQuantity) {
            this.stockQuantity = stockQuantity;
            return this;
        }

        public Builder copy(Inventory inventory){
            this.product = inventory.product;
            this.stockQuantity = inventory.stockQuantity;
            return this;

        }
        public Inventory build(){
            return new Inventory(this);
        }
    }
}
