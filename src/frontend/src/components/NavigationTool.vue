<template>
  <div class="homepage-container">
    <!-- Header Section -->
    <header class="header">
      <div class="logo">
        <img :src="require('@/assets/cybertech.png')" alt="Brand Logo" class="brand-logo" />
      </div>

      <!-- Centered Search Bar -->
      <div class="search-bar">
        <input
            type="text"
            placeholder="Search for products, brands, and more..."
            class="search-input"
            v-model="searchQuery"
            @keyup.enter="handleSearch"
        />
        <button class="search-button" @click="handleSearch">Search</button>
      </div>

      <!-- Search Results -->
      <div class="product-results" v-if="products.length > 0">
        <div v-for="product in products" :key="product.id" class="product-card">
          <h3>{{ product.name }}</h3>
          <p>{{ product.description }}</p>
          <span>\${{ product.price }}</span>
        </div>
      </div>

      <!-- Cart and Account Icons -->
      <div class="header-buttons">
        <button class="icon-button">
          <!-- Updated Cart Icon SVG -->
          <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" class="icon cart-icon">
            <path d="M7 4h-2l-3 7v11h18V11l-3-7h-2l-2 4H9l-2-4zm-2 7h14l2 8H5l2-8zm0 2h8v2H5v-2z"/>
          </svg>
        </button>
        <button class="icon-button">
          <!-- Account Icon SVG -->
          <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" class="icon account-icon">
            <path d="M12 12c2.21 0 4-1.79 4-4s-1.79-4-4-4-4 1.79-4 4 1.79 4 4 4zm0 2c-3.31 0-6 2.69-6 6v2h12v-2c0-3.31-2.69-6-6-6z"/>
          </svg>
        </button>
      </div>
    </header>

    <!-- Navbar for Categories -->
    <nav class="category-navbar">
      <ul>
        <router-link
            v-for="(category, index) in categories"
            :key="index"
            :to="'/' + category.name.toLowerCase()"
            class="category-item"
        >
          <img :src="category.image.src" :alt="category.image.alt" class="category-image" />
          <span class="category-name">{{ category.name }}</span>
        </router-link>
      </ul>
    </nav>
  </div>
</template>

<script>
import axios from 'axios';


export default {
  name: 'NavbarTool',
  data() {
    return {
      searchQuery: '',
      products: [],
      categories: [
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
      ],
    };
  },
  methods: {
        handleSearch() {
          console.log('Search button clicked!');
          const query = this.searchQuery.trim().toLowerCase();
          // Check if the search query matches a category name
          const matchingCategory = this.categories.find(category => category.name.toLowerCase() === query);
          if (matchingCategory) {
            // Redirect to the category page
            this.$router.push('/' + matchingCategory.name.toLowerCase());
          } else if (query !== '') {
            // Otherwise, perform a product search
            axios.get(`api/product/category/${this.searchQuery}`)
                .then(response => {
                  this.products = response.data;  // Update products with search results
                })
                .catch(error => {
                  console.error('Error fetching products:', error);
                });
          }
        }
      }
}

</script>

<style scoped>
.homepage-container {
  width: 100%;
}

.header-buttons {
  flex: 1;
  display: flex;
  justify-content: flex-end;
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


/* Header Section */
.header {
  display: flex;
  align-items: center;
  background-color: #131921;
  color: white;
  padding: 15px 30px;
}

.logo {
  position: absolute; /* Position it absolutely within header */
  left: 10px; /* Adjust the left margin to position */
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

/* Category Navbar */
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

/* Slideshow */
.mySwiper {
  width: 100%;
  height: 300px;
}

.slide-image {
  width: 100%;
  height: 100%;
  object-fit: cover;
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

html, body {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

</style>
