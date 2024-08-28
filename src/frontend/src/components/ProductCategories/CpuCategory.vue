<template>
  <h1 class="cpu-heading">CPU Category</h1>
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

// import { useRouter } from 'vue-router';

// const router = useRouter();

// Define the products ref
const products = ref([]);
// const searchQuery = ref(''); // Bind this to the search bar

// Fetch data when the component is mounted
onMounted(() => {
  fetch("/api/product/category/CPU")
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


// const goToBrand = (brand) => {
//   const brandRoutes = {
//     "AMD": "src/frontend/src/components/amd",
//     "Intel": "src/frontend/src/components/intel"
//   };

//   const route = brandRoutes[brand] || '/cpu-not-found';
//   router.push(route);
// };
// Function to handle the search input
// const handleSearch = () => {
//   const searchTerm = searchQuery.value.trim().toLowerCase();

  // Basic check for "CPU" and route to the CPU page
//   if (searchTerm === 'cpu') {
//     router.push('/cpu'); // Navigate to the CPU category page if the search term is "cpu"
//   } else {
//     console.log('Search term does not match CPU'); // Handle other cases as needed
//
// };
</script>




<style scoped>
/* Add styles for the AMD and Intel buttons */
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
  background-color: #e9f4fe; /* Light blue background */
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
  margin-bottom: 5px; /* Adjust margin to ensure proper spacing */
}

.category-name {
  font-size: 16px;
  font-weight: bold;
  color: #333;
  margin-top: 5px; /* Add margin-top if needed for better spacing */
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
  padding: 0; /* Remove padding */
  margin: 0; /* Remove margins */
  position: relative; /* Allows positioning adjustments */
  height: 120px; /* Set a fixed height to control spacing */
}

.logo {
  position: absolute; /* Position it absolutely within header */
  left: 10px; /* Align to the left */
  top: 50%; /* Center vertically */
  transform: translateY(-50%); /* Adjust for centering */
  padding: 0; /* Remove any padding */
}
.brand-logo {
  height: 115px; /* Set a reasonable height for the logo */
  width: auto; /* Maintain aspect ratio */
  transition: transform 0.3s;
}
.brand-logo:hover {
  transform: scale(1.05); /* Subtle hover effect */
}
.search-bar {
  flex: 2;
  display: flex;
  justify-content: center;
  align-items: center;
}

.search-input {
  width: 40%;
  padding: 6px;
  border-radius: 5px 0 0 5px;
  border: none;
}

.search-button {
  padding: 6px 10px;
  border-radius: 0 5px 5px 0;
  background-color: #febd69;
  border: none;
  cursor: pointer;
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
  width: 24px; /* Adjust size of the icons */
  height: 24px;
}

.icon-button:hover {
  background-color: #f0c14b; /* Adjust hover effect as needed */
}

.header-buttons {
  flex: 1;
  display: flex;
  justify-content: flex-end;
}



</style>