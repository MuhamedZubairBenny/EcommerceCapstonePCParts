<template>
  <h1 class="gpu-heading">Cooling Category</h1>
  <div class="products-container">
    <ul class="products-list">
      <li
          v-for="product in products"
          :key="product.productId"
          class="product-item"
          @click="goToPage(product.productId)"
      >
        <img :src="`/${product.productPicture}`" :alt="product.productName" class="product-image" />
        <div class="product-details">
          <h3>{{ product.productName }}</h3>
          <p class="price">{{ formatCurrency(product.price) }}</p>
        </div>
      </li>
    </ul>
  </div>
</template>

<script setup>
import {ref, onMounted} from 'vue';
import {useRouter} from "vue-router";

const router = useRouter();

const products = ref([]);

onMounted(() => {
  fetch("/api/product/category/Cooling")
      .then((response) => response.json())
      .then((data) => {
        products.value = data; // Store fetched data
        console.log(products.value.map(p => p.productPicture));
      })
      .catch((error) => {
        console.error('Error fetching data:', error);
      });
});
const goToPage = (productId) => {
  router.push({name: 'ProductDetails', params: {id: productId}});
};
const formatCurrency = (value) => {
  if (!value) return '';
  return new Intl.NumberFormat('en-US', {style: 'currency', currency: 'ZAR'}).format(value);
};
</script>

<style scoped>

.gpu-heading {
  text-align: center;
  font-size: 2.5rem;
  color: #007bff;
  margin: 30px 0;
  padding: 10px;
  background-color: #e9f4fe;
  text-transform: uppercase;
  box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
  letter-spacing: 1.5px;
}

.category-navbar ul {
  list-style: none;
  display: flex;
  padding: 0;
}

html, body {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

.products-container {
  max-width: 1200px;
  margin: 0 auto;
  padding: 20px;
}

.products-list {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
  list-style: none;
  padding: 0;
}

.product-item {
  background-color: #f8f9fa;
  border: 3px solid #007bff;
  border-radius: 10px;
  overflow: hidden;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  transition: transform 0.3s ease, border-color 0.3s ease;
  flex: 0 1 22%;
  margin: 20px 0;
  padding: 15px;
  text-align: center;
}

.product-item:hover {
  transform: translateY(-10px);
  border-color: #28a745;
}

.product-image {
  width: 150px;
  height: auto;
  margin-bottom: 15px;
}

.product-details {
  padding: 15px;
}

.product-details h3 {
  font-size: 1.3rem;
  margin-bottom: 10px;
  color: #333;
}

.product-details .price {
  font-size: 1.2rem;
  color: #ff5722;
}

@media (max-width: 768px) {
  .product-item {
    flex: 0 1 48%;
  }
}

@media (max-width: 480px) {
  .product-item {
    flex: 0 1 100%;
  }
}

.icon-button .icon {
  width: 24px;
  height: 24px;
}

</style>