<script setup>
import { ref, onMounted } from 'vue';

// Define the products ref
const products = ref([]);

// Fetch data when the component is mounted
onMounted(() => {
  fetch("/api/product/category/PSU")
      .then((response) => response.json())
      .then((data) => {
        products.value = data; // Store fetched data
        console.log(products.value.map(p => p.productPicture));
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

// Define categories for navigation
const categories = [
  { name: 'CPU', image: { src: require('@/assets/cpuprocessor.png'), alt: 'CPU' } },
  { name: 'GPU', image: { src: require('@/assets/gpu.png'), alt: 'GPU' } },
  { name: 'Motherboard', image: { src: require('@/assets/motherboard.png'), alt: 'Motherboard' } },
  { name: 'RAM', image: { src: require('@/assets/ramstick.png'), alt: 'RAM' } },
  { name: 'Storage', image: { src: require('@/assets/storage.png'), alt: 'Storage' } },
  { name: 'PSU', image: { src: require('@/assets/psu.png'), alt: 'PSU' } },
  { name: 'Case', image: { src: require('@/assets/case.png'), alt: 'Case' } },
  { name: 'Peripherals', image: { src: require('@/assets/peripherals.png'), alt: 'Peripherals' } },
  { name: 'Monitors', image: { src: require('@/assets/monitor.png'), alt: 'Monitors' } },
  { name: 'Cooling', image: { src: require('@/assets/cooler.png'), alt: 'Cooling' } },
];
</script>

<template>
  <div class="slideshow-container">
    <!-- Navbar for Categories -->
    <nav class="category-navbar">
      <ul>
        <router-link
            v-for="(category, index) in categories"
            :key="index"
            :to="`/${category.name.toLowerCase()}`"
            class="category-item"
        >
          <img :src="category.image.src" :alt="category.image.alt" class="category-image" />
          <span class="category-name">{{ category.name }}</span>
        </router-link>
      </ul>
    </nav>
  </div>
  <h1>Power Supply Products</h1>

  <!-- Product List -->
  <div class="products-container">
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

b<style scoped>
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

.category-navbar {
  display: flex;
  justify-content: center;
  margin-bottom: 15px;
}

.category-navbar ul {
  list-style: none;
  display: flex;
  padding: 0;
}

.category-item {
  margin: 0 10px;
  text-align: center;
  text-decoration: none;
}

.category-image {
  width: 50px;
  height: 50px;
  object-fit: contain;
  margin-bottom: 5px;
}

.category-name {
  font-size: 14px;
  font-weight: bold;
  color: #333;
}
</style>