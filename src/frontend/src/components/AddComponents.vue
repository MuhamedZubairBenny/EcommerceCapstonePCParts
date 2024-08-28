<template>
  <div class="add-product">
    <h2>Add Product</h2>
    <form @submit.prevent="submitForm">
      <div class="form-group">
        <label for="productId">Product ID:</label>
        <input v-model="product.productId" type="text" id="productId" required />
      </div>
      <div class="form-group">
        <label for="productName">Product Name:</label>
        <input v-model="product.productName" type="text" id="productName" required />
      </div>
      <div class="form-group">
        <label for="category">Category ID:</label>
        <input v-model="product.category" type="text" id="category" required />
      </div>
      <div class="form-group">
        <label for="brand">Brand ID:</label>
        <input v-model="product.brand" type="text" id="brand" required />
      </div>
      <div class="form-group">
        <label for="description">Description:</label>
        <textarea v-model="product.description" id="description" required></textarea>
      </div>
      <div class="form-group">
        <label for="price">Price:</label>
        <input v-model="product.price" type="number" id="price" required />
      </div>
      <div class="form-group">
        <label for="stockQuantity">Stock Quantity:</label>
        <input v-model="product.stockQuantity" type="number" id="stockQuantity" required />
      </div>
      <div class="form-group">
        <label for="dimension">Dimension:</label>
        <input v-model="product.dimension" type="text" id="dimension" />
      </div>
      <div class="form-group">
        <label for="warranty">Warranty:</label>
        <input v-model="product.warranty" type="text" id="warranty" />
      </div>
      <div class="form-group">
        <label for="productPicture">Product Picture URL:</label>
        <input v-model="product.productPicture" type="text" id="productPicture" />
      </div>
      <button type="submit">Add Product</button>
    </form>
    <p v-if="message" class="message">{{ message }}</p>
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
        category: '',
        brand: '',
        description: '',
        price: 0,
        stockQuantity: 0,
        dimension: '',
        warranty: '',
        productPicture: ''
      },
      message: ''
    };
  },
  methods: {
    async submitForm() {
      try {
        const response = await axios.post('http://localhost:8080/api/products/create', this.product);
        this.message = `Product added successfully: ${response.data.productId}`;
        this.resetForm();
      } catch (error) {
        this.message = `Error adding product: ${error.message}`;
      }
    },
    resetForm() {
      this.product = {
        productId: '',
        productName: '',
        category: '',
        brand: '',
        description: '',
        price: 0,
        stockQuantity: 0,
        dimension: '',
        warranty: '',
        productPicture: ''
      };
    }
  }
};
</script>

<style scoped>
.add-product {
  max-width: 600px;
  margin: 0 auto;
}

.form-group {
  margin-bottom: 15px;
}

label {
  display: block;
  margin-bottom: 5px;
}

input, textarea {
  width: 100%;
  padding: 8px;
  box-sizing: border-box;
}

button {
  padding: 10px 15px;
  background-color: #007bff;
  color: white;
  border: none;
  cursor: pointer;
}

button:hover {
  background-color: #0056b3;
}

.message {
  margin-top: 20px;
  color: green;
}
</style>
