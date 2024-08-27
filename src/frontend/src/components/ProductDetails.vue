<script setup>
import { ref, onMounted } from 'vue';
import { useRoute } from 'vue-router';

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
  return new Intl.NumberFormat('en-US', { style: 'currency', currency: 'ZAR' }).format(value);
};
</script>

<template>
  <div v-if="product" class="product-details-container">
    <h1>{{ product.productName }}</h1>
    <img :src="`/${product.productPicture}`" :alt="product.productName" class="product-image" />
    <p><strong>Price:</strong> {{ formatCurrency(product.price) }}</p>
    <p><strong>Description:</strong> {{ product.description }}</p>
    <p><strong>Category:</strong> {{ product.category }}</p>
    <p><strong>Brand:</strong> {{ product.brand }}</p>
    <p><strong>Stock Quantity:</strong> {{ product.stockQuantity }}</p>
  </div>
</template>

<style scoped>
.product-details-container {
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
  text-align: center;
}

.product-image {
  max-width: 100%;
  height: auto;
}

.product-details-container p {
  font-size: 1.2rem;
  margin: 10px 0;
}
</style>