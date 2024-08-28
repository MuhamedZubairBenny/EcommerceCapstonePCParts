<script setup>
import { ref, onMounted } from 'vue';

// Define AMD products ref
const amdProducts = ref([]);

// Fetch AMD products when the component is mounted
onMounted(() => {
  fetch("/api/product/category/CPU")
      .then((response) => response.json())
      .then((data) => {
        amdProducts.value = data.filter(product => product.brand === 'AMD');
      })
      .catch((error) => {
        console.error('Error fetching data:', error);
      });
});

// Method to format price as currency
const formatCurrency = (value) => {
  if (!value) return '';
  return new Intl.NumberFormat('en-US', { style: 'currency', currency: 'ZAR' }).format(value);
};
</script>

<template>

  <div class="products-container">
    <h1>AMD Products</h1>
    <ul class="products-list">
      <li v-for="product in amdProducts" :key="product.productId" class="product-item">
        <img :src="`/${product.productPicture}`" :alt="product.productName" class="product-image" />
        <div class="product-details">
          <h3>{{ product.productName }}</h3>
          <p class="price">{{ formatCurrency(product.price) }}</p>
        </div>
      </li>
    </ul>
  </div>
</template>
