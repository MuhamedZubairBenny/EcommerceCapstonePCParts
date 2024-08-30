<script setup>
import { ref, onMounted } from 'vue';

const products = ref([]);

const fetchData = () => {
  fetch("/api/product/search/Ryzen 9")
      .then(response => response.json())
      .then(data => {
        products.value = data;
        console.log(products.value.map(p => p.productPicture));
      })
      .catch(error => {
        console.error('Error fetching data:', error);
      });
};

onMounted(() => {
  fetchData();
});

const formatCurrency = (value) => {
  if (!value) return '';
  return new Intl.NumberFormat('en-US', { style: 'currency', currency: 'ZAR' }).format(value);
};
</script>

<template>
  <div class="products-container">
    <h1>AMD Ryzen 9 Processors</h1>
    <p>Check out the latest Ryzen 9 products:</p>
    <ul class="products-list">
      <li v-for="product in products" :key="product.productId" class="product-item">
        <img :src="`/${product.productPicture}`" :alt="product.productName" class="product-image" />
        <div class="product-details">
          <h3>{{ product.productName }}</h3>
          <p class="price">{{ formatCurrency(product.price) }}</p>
        </div>
      </li>
    </ul>
  </div>
</template>

<style scoped>
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
  margin: 0;
}

.product-item {
  background-color: #f8f9fa;
  border: 3px solid #007bff;
  border-radius: 10px;
  overflow: hidden;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  transition: transform 0.3s ease, border-color 0.3s ease;
  flex: 0 1 calc(25% - 20px);
  margin: 10px;
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
    flex: 0 1 calc(50% - 20px);
  }
}

@media (max-width: 480px) {
  .product-item {
    flex: 0 1 calc(100% - 20px);
  }
}
</style>
