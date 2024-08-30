<script setup>
import { ref, onMounted } from 'vue';

const intelProducts = ref([]);

onMounted(() => {
  fetch("/api/product/category/CPU")
      .then((response) => response.json())
      .then((data) => {
        intelProducts.value = data.filter(product => product.brand === 'Intel');
      })
      .catch((error) => {
        console.error('Error fetching data:', error);
      });
});

const formatCurrency = (value) => {
  if (!value) return '';
  return new Intl.NumberFormat('en-US', { style: 'currency', currency: 'ZAR' }).format(value);
};
</script>

<template>
  <div class="products-container">
    <h1>Intel Products</h1>
    <ul class="products-list">
      <li v-for="product in intelProducts" :key="product.productId" class="product-item">
        <img :src="`/${product.productPicture}`" :alt="product.productName" class="product-image" />
        <div class="product-details">
          <h3>{{ product.productName }}</h3>
          <p class="price">{{ formatCurrency(product.price) }}</p>
        </div>
      </li>
    </ul>
  </div>
</template>
