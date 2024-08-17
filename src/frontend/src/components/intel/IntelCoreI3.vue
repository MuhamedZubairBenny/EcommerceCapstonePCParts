<script setup>
import {ref, onMounted} from 'vue';

// Define the products ref
const products = ref([]);

// Fetch data when the component is mounted
const fetchData = () => {
  fetch("/api/product/search/i3")
      .then(response => response.json())
      .then(data => {
        products.value = data; // Store fetched data
        console.log(products.value.map(p => p.productPicture));
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
    <h1>Intel Core I3 Processors</h1>
    <p>List of Intel Products:</p>
    <ul>
      <li v-for="product in products" :key="product.productId">
        <img :src="`/${product.productPicture}`" :alt="product.productName" style="width: 100px; height: auto;"/>
        <div>
          <h3>{{ product.productName }}</h3>
          <p>{{ formatCurrency(product.price) }}</p>
        </div>
      </li>
    </ul>
  </div>
</template>

<style scoped>
/* Add your styles here */
</style>
