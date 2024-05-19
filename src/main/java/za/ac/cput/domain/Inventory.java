package za.ac.cput.domain;
/*
Author:
Imaan Sadien - 221752838
GitHub Repo:
https://github.com/Elentiya10/EcommercePCParts
 */

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.util.Objects;
@Entity
public class Inventory {
    @Id
    private String inventoryId;
    @OneToOne
    private Product product;
    private int stockQuantity;


    protected Inventory() {}

    public Inventory(Builder builder){
        this.inventoryId = builder.inventoryId;
        this.product = builder.product;
        this.stockQuantity = builder.stockQuantity;

    }

    public String getInventoryId() {
        return inventoryId;
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
        return stockQuantity == inventory.stockQuantity && Objects.equals(inventoryId, inventory.inventoryId) && Objects.equals(product, inventory.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inventoryId, product, stockQuantity);
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "inventoryId='" + inventoryId + '\'' +
                ", product=" + product +
                ", stockQuantity=" + stockQuantity +
                '}';
    }

    public static class Builder{
        private String inventoryId;
        private Product product;
        private int stockQuantity;

        public Builder setInventoryId(String inventoryId) {
            this.inventoryId = inventoryId;
            return this;
        }

        public Builder setProduct(Product product) {
            this.product = product;
            return this;
        }

        public Builder setStockQuantity(int stockQuantity) {
            this.stockQuantity = stockQuantity;
            return this;
        }

        public Builder copy(Inventory inventory){
            this.inventoryId = inventory.inventoryId;
            this.product = inventory.product;
            this.stockQuantity = inventory.stockQuantity;
            return this;

        }
        public Inventory build(){
            return new Inventory(this);
        }
    }
}
