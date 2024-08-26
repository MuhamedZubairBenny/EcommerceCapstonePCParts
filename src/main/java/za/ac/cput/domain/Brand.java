package za.ac.cput.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;
import java.util.Objects;

@Entity
public class Brand{
    @Id
    @Column(name = "brand_id", nullable = false, unique = true)
    private String brandId;
    private String brandName;
    @OneToMany(mappedBy = "brand")
    private List<Product> products;

    protected Brand(){}

    public Brand(Builder builder){
        this.brandId = builder.brandId;
        this.brandName = builder.brandName;
    }

    public String getBrandId() {
        return brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Brand brand)) return false;
        return Objects.equals(getBrandId(), brand.getBrandId()) && Objects.equals(getBrandName(), brand.getBrandName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBrandId(), getBrandName());
    }

    @Override
    public String toString() {
        return "Brand{" +
                "brandId='" + brandId + '\'' +
                ", brandName='" + brandName + '\'' +
                '}';
    }

    public static class Builder{
        private String brandId;
        private String brandName;

        public Builder setBrandId(String brandId) {
            this.brandId = brandId;
            return this;
        }

        public Builder setBrandName(String brandName) {
            this.brandName = brandName;
            return this;
        }

        public Builder copy(Brand brand){
            this.brandId = brand.brandId;
            this.brandName = brand.brandName;
            return this;
        }

        public Brand build(){
            return new Brand(this);
        }
    }
}
