<template>
  <div class="update-product">
    <h2>Update Product</h2>
    <form @submit.prevent="updateProduct">

      <div class="mb-3">
        <label for="productId" class="form-label">Select Product to Update</label>
        <select v-model="selectedProductId" @change="fetchProductDetails" id="productId" class="form-control" required>
          <option value="">Select a product</option>
          <option v-for="product in productList" :key="product.productId" :value="product.productId">
            {{ product.productId }} - {{ product.productName }}
          </option>
        </select>
      </div>


      <div v-if="product">
        <div class="mb-3">
          <label for="productName" class="form-label">Product Name</label>
          <input type="text" v-model="product.productName" class="form-control" id="productName" required />
        </div>
        <div class="mb-3">
          <label for="categoryId" class="form-label">Category ID</label>
          <input type="text" v-model="product.categoryId" class="form-control" id="categoryId" readonly />
        </div>
        <div class="mb-3">
          <label for="brandId" class="form-label">Brand ID</label>
          <input type="text" v-model="product.brandId" class="form-control" id="brandId" readonly />
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
          <label for="productPicture" class="form-label">Product Picture URL</label>
          <input type="text" v-model="product.productPicture" class="form-control" id="productPicture" />
        </div>
        <button type="submit" class="btn btn-primary">Update Product</button>
        <button type="button" class="btn btn-primary" @click="goBack">Back to Admin Page</button>
      </div>
    </form>
    <p v-if="message" class="message">{{ message }}</p>
  </div>
</template>
<script setup>
import { ref, onMounted } from 'vue';
import axios from 'axios';
import { useRouter } from 'vue-router';

const router = useRouter();

const selectedProductId = ref('');
const productList = ref([]);
const product = ref(null);
const message = ref('');

onMounted(async () => {
  await fetchProducts();
});

const fetchProducts = async () => {
  try {
    const response = await axios.get('http://localhost:3000/api/product/getall');
    productList.value = response.data;
  } catch (error) {
    message.value = `Error fetching products: ${error.message}`;
  }
};

const fetchProductDetails = async () => {
  if (!selectedProductId.value) return;

  try {
    const response = await axios.get(`http://localhost:3000/api/product/read/${selectedProductId.value}`);
    product.value = response.data;
  } catch (error) {
    message.value = `Error fetching product details: ${error.message}`;
  }
};

const updateProduct = async () => {
  if (!product.value) return;

  try {
    const response = await axios.post('http://localhost:3000/api/product/update', product.value);
    message.value = `Product updated successfully: ${response.data.productName}`;
  } catch (error) {
    message.value = `Error updating product: ${error.message}`;
  }
};

const goBack = () => {
  router.push('/AdminPage');
};
</script>

<style scoped>
.update-product {
  max-width: 600px;
  margin: auto;
  padding: 20px;
  border-radius: 8px;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
  background-color: #f9f9f9;
}

.mb-3 {
  margin-bottom: 15px;
}

.form-label {
  display: block;
  margin-bottom: 5px;
}

.form-control {
  width: 100%;
  padding: 8px;
  border-radius: 4px;
  border: 1px solid #ced4da;
}

.btn-primary {
  padding: 10px 15px;
  background-color: #007bff;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  margin-right: 10px;
}

.btn-primary:hover {
  background-color: #0056b3;
}

.btn-secondary {
  padding: 10px 15px;
  background-color: #6c757d;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.btn-secondary:hover {
  background-color: #5a6268;
}

.message {
  margin-top: 20px;
  color: green;
}
</style>