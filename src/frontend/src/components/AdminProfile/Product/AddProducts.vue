<template>
  <div class="container mt-5">
    <h2>Add New Product</h2>
    <form @submit.prevent="addProduct">

      <div class="mb-3">
        <label for="productId" class="form-label">Product ID</label>
        <input type="text" v-model="product.productId" class="form-control" id="productId" required />
      </div>

      <div class="mb-3">
        <label for="productName" class="form-label">Product Name</label>
        <input type="text" v-model="product.productName" class="form-control" id="productName" required />
      </div>

      <div class="mb-3">
        <label for="category" class="form-label">Category</label>
        <select v-model="product.categoryId" class="form-control" id="categoryId" required>
          <option v-for="category in categories" :key="category.categoryId" :value="category.categoryId">
            {{ category.categoryName }}
          </option>
        </select>
      </div>

      <div class="mb-3">
        <label for="brand" class="form-label">Brand</label>
        <select v-model="product.brandId" class="form-control" id="brandId" required>
          <option v-for="brand in brands" :key="brand.brandId" :value="brand.brandId">
            {{ brand.brandName }}
          </option>
        </select>
      </div>

      <div class="mb-3">
        <label for="description" class="form-label">Description</label>
        <textarea v-model="product.description" class="form-control" id="description"></textarea>
      </div>

      <div class="mb-3">
        <label for="price" class="form-label">Price</label>
        <input type="number" v-model="product.price" class="form-control" id="price" required />
      </div>

      <div class="mb-3">
        <label for="stockQuantity" class="form-label">Stock Quantity</label>
        <input type="number" v-model="product.stockQuantity" class="form-control" id="stockQuantity" required />
      </div>

      <div class="mb-3">
        <label for="dimension" class="form-label">Dimension</label>
        <input type="text" v-model="product.dimension" class="form-control" id="dimension" />
      </div>

      <div class="mb-3">
        <label for="warranty" class="form-label">Warranty</label>
        <input type="text" v-model="product.warranty" class="form-control" id="warranty" />
      </div>

      <div class="mb-3">
        <label for="productPicture" class="form-label">Product Picture (File Path or URL)</label>
        <input type="text" v-model="product.productPicture" class="form-control" id="productPicture" @input="updateImagePreview" />
        <img v-if="imagePreview" :src="imagePreview" alt="Product Image Preview" class="product-image mt-3" />
      </div>

      <button type="submit" class="btn btn-primary">Add Product</button>
      <button type="button" class="btn btn-primary" @click="goBack">Back to Admin Page</button>
    </form>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      product: {
        productId: '',
        productName: '',
        categoryId: '',
        brandId: '',
        description: '',
        price: 0,
        stockQuantity: 0,
        dimension: '',
        warranty: '',
        productPicture: ''
      },
      categories: [],
      brands: [],
      imagePreview: ''
    };
  },
  created() {
    this.fetchCategories();
    this.fetchBrands();
  },
  methods: {
    async fetchCategories() {
      try {
        const response = await axios.get('http://localhost:3000/api/productCategory/getAll');
        this.categories = response.data;
      } catch (error) {
        console.error('Error fetching categories:', error);
      }
    },
    async fetchBrands() {
      try {
        const response = await axios.get('http://localhost:3000/api/brand/getAll');
        this.brands = response.data;
      } catch (error) {
        console.error('Error fetching brands:', error);
      }
    },
    updateImagePreview() {
      this.imagePreview = this.product.productPicture ? this.product.productPicture : '';
    },
    async addProduct() {
      try {
        const productData = {
          productId: this.product.productId,
          productName: this.product.productName,
          category: { categoryId: this.product.categoryId },
          brand: { brandId: this.product.brandId },
          description: this.product.description,
          price: this.product.price,
          stockQuantity: this.product.stockQuantity,
          dimension: this.product.dimension,
          warranty: this.product.warranty,
          productPicture: this.product.productPicture
        };

        const response = await axios.post('http://localhost:3000/api/product/create', productData);

        if (response.status === 200 || response.status === 201) {
          alert('Product added successfully!');
        } else {
          alert('Failed to add product. Please check the console for more details.');
        }
      } catch (error) {
        console.error('Error adding product:', error);
        alert('An error occurred while adding the product.');
      }
    },
    goBack() {
      this.$router.push('/AdminPage');
    },
  },
  watch: {
    'product.productPicture': function () {
      this.updateImagePreview();
    }
  }
};
</script>

<style scoped>
.container {
  max-width: 600px;
}

.product-image {
  width: 100%;
  max-width: 600px;
  height: auto;
}
button {
  padding: 10px 15px;
  background-color: #007bff;
  color: white;
  border: none;
  cursor: pointer;
  margin-right: 10px;
}

button:hover {
  background-color: #0056b3;
}
</style>