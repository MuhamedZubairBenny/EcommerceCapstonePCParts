<template>
  <div class="delete-product">
    <h2>Delete Product</h2>
    <form @submit.prevent="deleteProduct">

      <div class="form-group">
        <label for="productId">Select Product to Delete:</label>
        <select v-model="selectedProductId" id="productId" required>
          <option value="">Select a product</option>
          <option v-for="product in productList" :key="product.productId" :value="product.productId">
            {{ product.productId }} - {{ product.productName }}
          </option>
        </select>
      </div>

      <button type="submit">Delete Product</button>
      <button type="button" @click="goBack">Back to Admin Page</button>
    </form>
    <p v-if="message" class="message">{{ message }}</p>
  </div>
</template>

<script setup>
import {ref, onMounted} from 'vue';
import axios from 'axios';
import {useRouter} from 'vue-router';

const selectedProductId = ref('');
const productList = ref([]);
const message = ref('');
const router = useRouter();


onMounted(async () => {
  await fetchProducts();
});


const deleteProduct = async () => {
  if (!selectedProductId.value) {
    message.value = 'Please select a product to delete.';
    return;
  }

  try {
    await axios.delete(`http://localhost:3000/api/product/delete/${selectedProductId.value}`);
    message.value = 'Product deleted successfully';
    selectedProductId.value = '';
    await fetchProducts();
  } catch (error) {
    message.value = `Error deleting product: ${error.message}`;
  }
};


const fetchProducts = async () => {
  try {
    const response = await axios.get('http://localhost:3000/api/product/getall');
    productList.value = response.data;
  } catch (error) {
    message.value = `Error fetching products: ${error.message}`;
  }
};


const goBack = () => {
  router.push('/AdminPage');
};
</script>

<style scoped>
.delete-product {
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

select {
  width: 100%;
  padding: 8px;
  box-sizing: border-box;
}

button {
  padding: 10px 15px;
  background-color: #dc3545;
  color: white;
  border: none;
  cursor: pointer;
  margin: 10px;
}

button:hover {
  background-color: #c82333;
}

.message {
  margin-top: 20px;
  color: green;
}
</style>