<script setup>
import {ref, onMounted} from 'vue';

// Define the products ref
const products = ref([]);

// Fetch data when the component is mounted
const fetchData = () => {
  fetch("/api/product/search/Ryzen 7")
      .then(response => response.json())
      .then(data => {
        products.value = data; // Store fetched data
      })
      .catch(error => {
        console.error('Error fetching data:', error);
      });
};

onMounted(() => {
  fetchData();
});

// Method to format price as currency
const formatCurrency = (value) => {
  if (!value) return '';
  return new Intl.NumberFormat('en-US', {style: 'currency', currency: 'ZAR'}).format(value);
};
</script>

<template>
  <div>
    <h1>AMD Ryzen 5 Processors</h1>
    <p>List of Ryzen Products:</p>
    <ul>
      <li v-for="product in products" :key="product.productId">
        {{ product.productName }} - {{ formatCurrency(product.price) }}
      </li>
    </ul>
  </div>
</template>

<style scoped>
/* Add your styles here */
</style>
