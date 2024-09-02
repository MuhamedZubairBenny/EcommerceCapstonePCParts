<template>
  <h1 class="cpu-heading">CPU Category</h1>
  <div class="category-info">
    <img src="@/assets/cputester.png" alt="CPU Category Image" class="category-image"/>
    <p class="category-description">
      Explore our wide range of CPUs from top brands like AMD and Intel. Whether you're building a gaming rig or need powerful processors for work, we have the right option for you.
    </p>
  </div>

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
import { ref, onMounted } from 'vue';
import {useRouter} from "vue-router";

 const router = useRouter();

const products = ref([]);
onMounted(() => {
  fetch("/api/product/category/CPU")
      .then((response) => response.json())
      .then((data) => {
        products.value = data;
        console.log(products.value.map(p => p.productPicture));
      })
      .catch((error) => {
        console.error('Error fetching data:', error);
      });
});
const goToPage = (productId) => {
  router.push({ name: 'ProductDetails', params: { id: productId } });
};

const formatCurrency = (value) => {
  if (!value) return '';
  return new Intl.NumberFormat('en-US', { style: 'currency', currency: 'ZAR' }).format(value);
};

</script>

<style scoped>
.cpu-heading {
  text-align: center;
  font-size: 2.5rem;
  color: #007bff;
  margin: 30px 0;
  padding: 10px;
  background-color: #e9f4fe;
  border-radius: 10px;
  text-transform: uppercase;
  box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
  letter-spacing: 1.5px;
}
.category-image {
  width: 100%;
  height: 400px;
  margin-bottom: 15px;
  border-radius: 10px;
  box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
  object-fit: contain;
}
.category-info {
  width: 100%;
  max-width: 1200px;
  margin: 0 auto;
  text-align: center;
}

.category-description {
  font-size: 1.4rem;
  color: #333;
  max-width: 800px;
  text-align: center;
  margin-bottom: 20px;
}

.cpu-buttons {
  display: flex;
  justify-content: center;
  margin: 30px 0;
}
.brand-button {
  background-color: #007bff;
  color: white;
  padding: 15px 30px;
  margin: 0 15px;
  font-size: 18px;
  font-weight: bold;
  border: none;
  border-radius: 8px;
  cursor: pointer;
  transition: all 0.3s ease;
}

.amd-button {
  background-color: #ff5722;
}

.intel-button {
  background-color: #007bff;
}

.brand-button:hover {
  transform: scale(1.1);
  background-color: #0056b3;
}

.amd-button:hover {
  background-color: #e64a19;
}

.cpu-heading {
  text-align: center;
  font-size: 2.5rem;
  color: #007bff;
  margin: 30px 0;
  padding: 10px;
  background-color: #e9f4fe;
  border-radius: 10px;
  text-transform: uppercase;
  box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
  letter-spacing: 1.5px;
}
.homepage-container {
  width: 100%;
}
.cart-button,
.account-button {
  background-color: #febd69;
  color: black;
  padding: 10px 20px;
  margin-left: 10px;
  border-radius: 5px;
  border: none;
  cursor: pointer;
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
  margin: 0 20px;
  text-align: center;
  text-decoration: none;
  display: flex;
  flex-direction: column;
  align-items: center;
}

.category-image {
  width: 100px;
  height: 100px;
  object-fit: contain;
  margin-bottom: 5px;
}

.category-name {
  font-size: 16px;
  font-weight: bold;
  color: #333;
  margin-top: 5px;
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
.header {
  display: flex;
  align-items: center;
  background-color: #5f7b8a;
  color: white;
  padding: 0;
  margin: 0;
  position: relative;
  height: 120px;
}
  .brand-logo {
    height: 115px;
    width: auto;
    transition: transform 0.3s;
  }

  .brand-logo:hover {
    transform: scale(1.05);
  }

  .search-bar {
    flex: 2;
    display: flex;
    justify-content: center;
    align-items: center;
  }
  
  .icon-button {
    background-color: #febd69;
    color: black;
    padding: 10px;
    margin-left: 10px;
    border-radius: 50%;
    border: none;
    cursor: pointer;
    display: flex;
    align-items: center;
    justify-content: center;
  }

  .icon-button .icon {
    width: 24px;
    height: 24px;
  }

  .icon-button:hover {
    background-color: #f0c14b;
  }

  .header-buttons {
    flex: 1;
    display: flex;
    justify-content: flex-end;
  }

</style>