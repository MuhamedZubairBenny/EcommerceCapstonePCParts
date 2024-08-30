<script setup>
import { ref, onMounted } from 'vue';
import { useRouter } from 'vue-router';

const router = useRouter();
const products = ref([]);

const fetchData = () => {
  fetch("/api/product/search/3090")
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

const goToPage = (productId) => {
  router.push({ name: 'ProductDetails', params: { id: productId } });
};

const formatCurrency = (value) => {
  if (!value) return '';
  return new Intl.NumberFormat('en-US', { style: 'currency', currency: 'ZAR' }).format(value);
};
</script>

<template>
  <div class="products-container">
    <h1>Geforce RTX 3090 GPU</h1>
    <p>Check out the latest RTX 3090 products:</p>
    <div class="products-grid">
      <div
          class="product-card"
          v-for="(product, index) in products"
          :key="index"
          @click="goToPage(product.productId)">
        <img
            :src="`/${product.productPicture}`"
            :alt="product.productName"
            class="product-image" />
        <div class="product-details">
          <h3>{{ product.productName }}</h3>
          <p class="price">{{ formatCurrency(product.price) }}</p>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.products-container {
  max-width: 1200px;
  margin: 0 auto;
  padding: 20px;
}

.products-grid {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
  gap: 20px;
}

.product-card {
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
  cursor: pointer;
}

.product-card:hover {
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
  .product-card {
    flex: 0 1 48%;
  }
}

@media (max-width: 480px) {
  .product-card {
    flex: 0 1 100%;
  }
}
</style>
