<script setup>
import { useRouter } from 'vue-router';

const router = useRouter();

function goToPage(pagePath) {
  router.push(pagePath);
}
</script>

<template>
  <div class="products-container">
    <h1>Intel Core i9 Processors</h1>
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
        { name: 'Intel Core i9-14900', image: require('@/assets/IntelCoreI9Products/i9-14900.png'), price: '$299', pagePath: '/intel/i9processors/i9-14900' },
        { name: 'Intel Core i9-14900F', image: require('@/assets/IntelCoreI9Products/i9-14900f.png'), price: '$299', pagePath: '/intel/i9processors/i9-14900f'  },
        { name: 'Intel Core i9-14900K', image: require('@/assets/IntelCoreI9Products/i9-14900k.png'), price: '$299', pagePath: '/intel/i9processors/i9-14900k'  },
        { name: 'Intel Core i9-14900KF', image: require('@/assets/IntelCoreI9Products/i9-14900kf.png'), price: '$299', pagePath: '/intel/i9processors/i9-14900kf'  },
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