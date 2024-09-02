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

      <!-- Header Buttons -->
      <div class="header-buttons">
        <!-- Home Button -->
        <router-link to="/" class="icon-button">
          <!-- Home Icon SVG -->
          <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" class="icon home-icon">
            <path d="M12 3l1.45 1.32 7.55 6.68v10.2h-5v-6h-4v6H5V11.2l7.55-6.68L12 3z"/>
          </svg>
        </router-link>

        <!-- Cart Button -->
        <router-link to="/cart" class="icon-button">
          <!-- Updated Cart Icon SVG -->
          <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" class="icon cart-icon">
            <path d="M7 4h-2l-3 7v11h18V11l-3-7h-2l-2 4H9l-2-4zm-2 7h14l2 8H5l2-8zm0 2h8v2H5v-2z"/>
          </svg>
        </router-link>

        <!-- Account Button with Dropdown -->
        <div class="account-dropdown">
          <button @click="toggleDropdown" class="icon-button">
            <!-- Account Icon SVG -->
            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" class="icon account-icon">
              <path d="M12 12c2.21 0 4-1.79 4-4s-1.79-4-4-4-4 1.79-4 4 1.79 4 4 4zm0 2c-3.31 0-6 2.69-6 6v2h12v-2c0-3.31-2.69-6-6-6z"/>
            </svg>
          </button>

          <div v-if="isDropdownVisible" class="dropdown-content">
            <router-link to="/AccountInformation">Account Information</router-link>
            <router-link to="/PaymentOption">Payment Option</router-link>
            <router-link to="/ShippingAddress">Shipping Address</router-link>
            <router-link to="/PaymentOption">Payment Option</router-link>
            <router-link to="/AdminPage">Admin Page</router-link>
          </div>
        </div>
      </div>
    </header>

    <!-- Navbar for Categories -->
    <nav v-if="!$route.meta.hideNavbar" class="category-navbar">

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
      isDropdownVisible: false, // Dropdown visibility state
      categories: [
        {name: 'CPU', image: {src: require('@/assets/cpuprocessor.png'), alt: 'CPU'}},
        {name: 'GPU', image: {src: require('@/assets/gpu.png'), alt: 'GPU'}},
        {name: 'Motherboard', image: {src: require('@/assets/motherboard.png'), alt: 'Motherboard'}},
        {name: 'RAM', image: {src: require('@/assets/ramstick.png'), alt: 'RAM'}},
        {name: 'Storage', image: {src: require('@/assets/storage.png'), alt: 'Storage'}},
        {name: 'PSU', image: {src: require('@/assets/psu.png'), alt: 'PSU'}},
        {name: 'Case', image: {src: require('@/assets/case.png'), alt: 'Case'}},
        {name: 'Peripherals',image: {src: require('@/assets/peripherals.png'), alt: 'Peripherals'}},
        {name: 'Monitors', image: {src: require('@/assets/monitor.png'), alt: 'Monitors'}},
        {name: 'Cooling', image: {src: require('@/assets/cooler.png'), alt: 'Cooling'}},
      ],
    };
  },
  methods: {
    handleSearch() {
      const query = this.searchQuery.trim().toLowerCase();

      // Check if the query matches a category
      const matchingCategory = this.categories.find(category => category.name.toLowerCase() === query);
      if (matchingCategory) {
        this.$router.push('/' + matchingCategory.name.toLowerCase());
        return;
      }

      // Search for products by name or brand
      if (query !== '') {
        axios.get(`http://localhost:3000/api/product/search/${query}`)
            .then(response => {
              this.products = response.data;
              if (this.products.length > 0) {
                this.$router.push({ name: 'SearchResults', query: { q: this.searchQuery } });
              } else {
                alert('No products found.');
              }
            })
            .catch(error => {
              console.error('Error fetching products:', error);
              alert('An error occurred while searching. Please try again.');
            });
      }
    },
    toggleDropdown() {
      this.isDropdownVisible = !this.isDropdownVisible;
    }
  }
}
</script>

<style scoped>
.homepage-container {
  width: 100%;
}

/* Header Section */
.header {
  display: flex;
  align-items: center;
  justify-content: space-between;
  background-color: #131921;
  padding: 15px 30px;
  color: white;
}

.logo {
  flex: 1;
}

.brand-logo {
  height: 100px;
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
  width: 35%;
  margin: 0 auto;
}

.search-input {
  width: 100%;
  padding: 10px 15px;
  border: 2px solid #69feca;
  border-right: none;
  border-radius: 25px 0 0 25px;
  font-size: 16px;
  outline: none;
  transition: all 0.3s ease;
  height: 44px;
}

.search-input:focus {
  border-color: #69feca;
}

.search-button {
  padding: 10px 15px;
  background-color: #69feca;
  border: 2px solid #69feca;
  border-radius: 0 25px 25px 0;
  cursor: pointer;
  font-size: 16px;
  height: 44px;
}

.search-button:hover {
  background-color: #69feca;
}

/* Header Buttons */
.header-buttons {
  display: flex;
  align-items: center;
}

.icon-button {
  background-color: #69feca;
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
  background-color: #57d6c2;
}

.home-icon {
  fill: currentColor;
}

/* Account Dropdown */
.account-dropdown {
  position: relative;
  z-index: 1010;
}

.dropdown-content {
  display: flex;
  flex-direction: column;
  position: absolute;
  top: 40px;
  right: 0;
  background-color: #131921;
  border: 1px solid #69feca;
  border-radius: 5px;
  padding: 10px;
  z-index: 1010;
}

.dropdown-content a {
  color: white;
  text-decoration: none;
  padding: 8px;
  border-radius: 5px;
  margin-bottom: 5px;
  transition: background-color 0.3s;
}

.dropdown-content a:hover {
  background-color: #57d6c2;
}

/* Navbar for Categories */
.category-navbar {
  display: flex;
  justify-content: center;
  background-color: #232f3e; /* Dark background for contrast */
  padding: 15px 0; /* Add padding for better spacing */
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1); /* Soft shadow for depth */
  border-bottom: 2px solid #69feca; /* Stylish bottom border */
  position: sticky; /* Stick to the top of the page */
  top: 0;
  z-index: 1000; /* Ensure navbar stays above other elements */
}

.category-navbar ul {
  list-style: none;
  padding: 0;
  margin: 0;
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  gap: 40px; /* Add more space between categories */
}

.category-item {
  text-align: center;
  text-decoration: none;
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 120px; /* Fix width for consistent sizing */
  color: white;
  position: relative;
  transition: color 0.3s ease;
}
.category-item::before {
  content: '';
  position: absolute;
  top: 50%;
  left: 50%;
  width: 0;
  height: 0;
  background-color: rgba(255, 255, 255, 0.1); /* Add semi-transparent white background */
  border: 2px solid #69feca; /* Border color */
  border-radius: 8px; /* Rounded corners for smooth effect */
  transform: translate(-50%, -50%); /* Center the pseudo-element */
  transition: all 0.3s ease;
  z-index: -1; /* Place the background behind the content */
}

.category-item:hover::before {
  width: 140px; /* Expand width on hover */
  height: 140px; /* Expand height on hover */
  opacity: 1; /* Ensure it's visible */
}

.category-image {
  height: 80px; /* Adjust image height for uniformity */
  width: auto;
  display: block;
  margin: 0 auto;
  transition: transform 0.3s ease, box-shadow 0.3s ease;
}

.category-item:hover {
  color: #69feca; /* Change color on hover */
}
.category-image:hover {
  transform: scale(1.2); /* Enlarge image on hover */
  box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2); /* Add shadow on hover */
}

.category-name {
  font-size: 16px; /* Increase font size for readability */
  margin-top: 8px;
  color: white;
  text-transform: uppercase; /* Make category names uppercase for style */
  font-weight: bold;
}

@media (max-width: 768px) {
  .category-navbar ul {
    gap: 20px; /* Reduce gap for smaller screens */
  }

  .category-item {
    width: 100px; /* Reduce width on smaller screens */
  }

  .category-image {
    height: 60px; /* Smaller images on mobile */
  }

  .category-name {
    font-size: 14px; /* Adjust font size for mobile */
  }
}

@media (max-width: 480px) {
  .category-navbar ul {
    gap: 10px; /* Further reduce gap for very small screens */
  }

  .category-item {
    width: 80px; /* Adjust width further for small devices */
  }

  .category-image {
    height: 50px; /* Adjust image size for small devices */
  }

  .category-name {
    font-size: 12px; /* Smaller font size for small screens */
  }
} /* Closing brace was missing previously */
</style>