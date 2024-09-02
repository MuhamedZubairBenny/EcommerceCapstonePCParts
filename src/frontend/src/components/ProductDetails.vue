<script setup>
import { ref, onMounted } from 'vue';
import { useRoute } from 'vue-router';

const route = useRoute();
const product = ref(null);

// Fetch product data based on the product ID from the route
const fetchProductDetails = () => {
  const productId = route.params.id;
  fetch(`/api/product/read/${productId}`)
.then(response => response.json())
      .then(data => {
        product.value = data;
      })
      .catch(error => {
        console.error('Error fetching product details:', error);
      });
};

onMounted(() => {
  fetchProductDetails();
});

// Method to format price as currency
const formatCurrency = (value) => {
  if (!value) return '';
  return new Intl.NumberFormat('en-US', { style: 'currency', currency: 'ZAR' }).format(value);
};

// Navigate back to the product list
const goBack = () => {
  window.history.back();
};
</script>

<template>
  <div v-if="product" class="product-details-container">
    <div class="product-header">
      <h1 class="product-title">{{ product.productName }}</h1>
      <p class="product-price">{{ formatCurrency(product.price) }}</p>
    </div>
    <div class="product-body">
      <div class="product-image-container">
        <img :src="`/${product.productPicture}`" :alt="product.productName" class="product-image"/>
      </div>
      <div class="product-info">
        <div class="info-item">
          <span class="info-label">Description:</span>
          <p class="info-value">{{ product.description }}</p>
        </div>
        <div class="info-item">
          <span class="info-label">Category:</span>
          <p class="info-value">{{ product.category.categoryName }}</p>
        </div>
        <div class="info-item">
          <span class="info-label">Brand:</span>
          <p class="info-value">{{ product.brand.brandName }}</p>
        </div>
        <div class="info-item">
          <span class="info-label">Stock Quantity:</span>
          <p class="info-value">{{ product.stockQuantity }}</p>
        </div>
      </div>
    </div>
    <div class="product-footer">
      <button @click="goBack" class="back-button">Back to Products</button>
      <button @click="addToCart" class="cart-button">Add to Cart</button>
    </div>
  </div>
</template>

<style scoped>
.product-details-container {
  max-width: 1200px;
  margin: 20px auto;
  padding: 30px;
  background-color: #ffffff;
  border-radius: 12px;
  box-shadow: 0 6px 12px rgba(0, 0, 0, 0.1);
  overflow: hidden;
}

.product-header {
  margin-bottom: 20px;
  text-align: center;
}

.product-title {
  font-size: 2.5rem;
  color: #333;
  margin-bottom: 10px;
  font-weight: 600;
}

.product-price {
  font-size: 1.75rem;
  color: #28a745;
  font-weight: 700;
}

.product-body {
  display: flex;
  flex-direction: column;
  align-items: center;
  text-align: center;
}

.product-image-container {
  width: 100%;
  max-width: 500px;
  margin-bottom: 20px;
  display: flex;
  justify-content: center;
}

.product-image {
  width: 100%;
  height: auto;
  border-radius: 12px;
  border: 2px solid #ddd;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  object-fit: cover;
}

.product-info {
  font-size: 1.2rem;
  color: #555;
  text-align: left;
  max-width: 800px;
  margin: 0 auto;
}

.info-item {
  margin: 15px 0;
  display: flex;
  justify-content: space-between;
  padding: 10px 0;
  border-bottom: 1px solid #ddd;
}

.info-label {
  font-weight: bold;
  color: #333;
  width: 40%;
}

.info-value {
  color: #666;
  width: 60%;
}

.product-footer {
  text-align: center;
  margin-top: 30px;
}

.back-button, .cart-button {
  padding: 12px 25px;
  font-size: 1.1rem;
  color: #fff;
  background-color: #007bff;
  border: none;
  border-radius: 8px;
  cursor: pointer;
  transition: background-color 0.3s, transform 0.2s;
  margin: 0 10px;
}

.back-button:hover, .cart-button:hover {
  background-color: #0056b3;
  transform: scale(1.05);
}
</style>