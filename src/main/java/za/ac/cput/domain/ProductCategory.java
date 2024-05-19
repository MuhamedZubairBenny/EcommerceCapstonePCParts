package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class ProductCategory {
    @Id
    private String categoryId;
    private String categoryName;

    protected ProductCategory() {
    }

    public ProductCategory(Builder builder) {
        this.categoryId = builder.categoryId;
        this.categoryName = builder.categoryName;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductCategory that)) return false;
        return Objects.equals(getCategoryId(), that.getCategoryId()) && Objects.equals(getCategoryName(), that.getCategoryName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCategoryId(), getCategoryName());
    }

    @Override
    public String toString() {
        return "ProductCategory{" +
                "categoryId='" + categoryId + '\'' +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }


    public static class Builder {
        private String categoryId;
        private String categoryName;

        public Builder setCategoryId(String categoryId) {
            this.categoryId = categoryId;
            return this;
        }

        public Builder setCategoryName(String categoryName) {
            this.categoryName = categoryName;
            return this;
        }

        public Builder copy(ProductCategory productCategory){
            this.categoryId = productCategory.categoryId;
            this.categoryName = productCategory.categoryName;
            return this;
        }

        public ProductCategory build(){
            return new ProductCategory(this);
        }
    }
}



