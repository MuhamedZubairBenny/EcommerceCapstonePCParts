<script setup>
import {ref, onMounted} from 'vue';
import {useRoute} from 'vue-router';

const route = useRoute();
const product = ref(null);

// Fetch product data based on the product ID from the route
const fetchProductDetails = () => {
  const productId = route.params.id;
  fetch(`/api/product/read/${productId}`)
      .then(response => response.json())
      .then(data => {
        product.value = data;
      })
      .catch(error => {
        console.error('Error fetching product details:', error);
      });
};

onMounted(() => {
  fetchProductDetails();
});

// Method to format price as currency
const formatCurrency = (value) => {
  if (!value) return '';
  return new Intl.NumberFormat('en-US', {style: 'currency', currency: 'ZAR'}).format(value);
};
</script>

<template>
  <div v-if="product" class="product-details-container">
    <div class="product-header">
      <h1>{{ product.productName }}</h1>
      <p class="product-price">{{ formatCurrency(product.price) }}</p>
    </div>
    <div class="product-body">
      <img :src="`/${product.productPicture}`" :alt="product.productName" class="product-image"/>
      <div class="product-info">
        <p><strong>Description:</strong> {{ product.description }}</p>
        <p><strong>Category:</strong> {{ product.category }}</p>
        <p><strong>Brand:</strong> {{ product.brand }}</p>
        <p><strong>Stock Quantity:</strong> {{ product.stockQuantity }}</p>
      </div>
    </div>
    <div class="product-footer">
      <button @click="goBack">Back to Products</button>
    </div>
  </div>
</template>

<style scoped>
.product-details-container {
  max-width: 1200px;
  margin: 0 auto;
  padding: 20px;
  text-align: center;
  background-color: #f9f9f9;
  border-radius: 8px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.product-header {
  margin-bottom: 20px;
}

.product-price {
  font-size: 1.5rem;
  color: #28a745;
}

.product-body {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.product-image {
  max-width: 100%;
  height: auto;
  border-radius: 8px;
  margin-bottom: 20px;
}

.product-info {
  text-align: left;
  max-width: 600px;
  margin: 0 auto;
}

.product-info p {
  font-size: 1.1rem;
  margin: 10px 0;
}

.product-footer {
  margin-top: 20px;
}

.product-footer button {
  padding: 10px 20px;
  font-size: 1rem;
  color: #fff;
  background-color: #007bff;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  transition: background-color 0.3s;
}

.product-footer button:hover {
  background-color: #0056b3;
}
</style>
