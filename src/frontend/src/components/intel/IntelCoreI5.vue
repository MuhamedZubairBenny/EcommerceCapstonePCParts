<script setup>
import { useRouter } from 'vue-router';

const router = useRouter();

function goToPage(pagePath) {
  router.push(pagePath);
}


</script>

<template>
  <div class="products-container">
    <h1>Intel Core i5 Processors</h1>
    <div class="products-grid">
      <div class="product-card" v-for="(product, index) in products" :key="index" @click="goToPage(product.pagePath)">
        <img :src="product.image" :alt="product.name" class="product-image" />
        <div class="product-info">
          <h2>{{ product.name }}</h2>
          <p>{{ product.price }}</p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'IntelCoreI5',
  data() {
    return {
      products: [
        { name: 'Intel Core i5-14600KF', image: require('@/assets/IntelCoreI5Products/i5-14600KF.png'), price: '$299',pagePath: '/intel/i5processors/i5-14600kf' },
        { name: 'Intel Core i5-14600K', image: require('@/assets/IntelCoreI5Products/i5-14600k.png'), price: '$299',pagePath: '/intel/i5processors/i5-14600k' },
        { name: 'Intel Core i5-14500', image: require('@/assets/IntelCoreI5Products/i5-14500.png'), price: '$299',pagePath: '/intel/i5processors/i5-14500' },
        { name: 'Intel Core i5-14400f', image: require('@/assets/IntelCoreI5Products/i5-14400f.png'), price: '$299',pagePath: '/intel/i5processors/i5-14400f' },
        { name: 'Intel Core i5-14400', image: require('@/assets/IntelCoreI5Products/i5-14400.png'), price: '$299',pagePath: '/intel/i5processors/i5-14400' },
        { name: 'Intel Core i5-12400f', image: require('@/assets/IntelCoreI5Products/i5-12400f.png'), price: '$299',pagePath: '/intel/i5processors/i5-12400f' },

      ],
    };
  },
};
</script>

<style scoped>
.products-container {
  padding: 20px;
  max-width: 1200px;
  margin: 0 auto;
}

.products-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
  gap: 20px;
}

.product-card {
  border: 1px solid #ddd;
  border-radius: 8px;
  overflow: hidden;
  text-align: center;
  transition: transform 0.2s ease;
}

.product-card:hover {
  transform: translateY(-5px);
}

.product-image {
  width: 80%;
  height: auto;
}

.product-info {
  padding: 10px;
}

.product-info h2 {
  font-size: 1.2rem;
  margin: 10px 0;
}

.product-info p {
  font-size: 1rem;
  color: #333;
}
</style>