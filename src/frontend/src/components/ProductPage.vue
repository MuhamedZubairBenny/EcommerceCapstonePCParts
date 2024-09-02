<script setup>
import {ref, computed} from 'vue';
import axios from 'axios';

// Reactive data properties
const searchQuery = ref('');
const brands = ref([]);
const products = ref([]);


const fetchData = async () => {
  try {

    const brandsResponse = await axios.get('/api/brand/getAll');

    const productsResponse = await axios.get('/api/product/getAll');

    brands.value = brandsResponse.data;
    products.value = productsResponse.data;
  } catch (error) {
    console.error('Error fetching data:', error);
  }
};

fetchData();

const filteredProducts = computed(() => {
  const query = searchQuery.value.toLowerCase();
  return products.value.filter(product =>
      product.name.toLowerCase().includes(query)
  );
});
</script>

<template>
  <div>
    <h2>Search Products</h2>
    <input
        v-model="searchQuery"
        type="text"
        placeholder="Search for products..."
    />

    <h2>Brands</h2>
    <ul>
      <li v-for="brand in brands" :key="brand.brandId">
        {{ brand.brandName }}
      </li>
    </ul>

    <h2>Products</h2>
    <div v-for="product in filteredProducts" :key="product.id" class="product-card">
      <h3>{{ product.name }}</h3>
      <p>Brand ID: {{ product.brandId }}</p>
      <p>Price: ${{ product.price }}</p>
    </div>
  </div>
</template>

<style scoped>
.product-card {
  border: 1px solid #ccc;
  padding: 1rem;
  margin-bottom: 1rem;
}
</style>
