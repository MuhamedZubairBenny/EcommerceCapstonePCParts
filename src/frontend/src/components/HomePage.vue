
<template>
  <div class="homepage-container">
<!--    &lt;!&ndash; Navigation Tool &ndash;&gt;-->
    <NavigationTool />
<!--    &lt;!&ndash; Header Section &ndash;&gt;-->
<!--    <header class="header">-->
<!--      <div class="logo">-->
<!--        <img :src="require('@/assets/cybertech.png')" alt="Brand Logo" class="brand-logo" />-->
<!--      </div>-->
<!--      &lt;!&ndash; Centered Search Bar &ndash;&gt;-->
<!--      <div class="search-bar">-->
<!--        <input-->
<!--            type="text"-->
<!--            placeholder="Search for products, brands, and more..."-->
<!--            class="search-input"-->
<!--            v-model="searchQuery"-->
<!--            @keyup.enter="handleSearch"-->
<!--        />-->
<!--        <button class="search-button" @click="handleSearch">Search</button>-->
<!--      </div>-->
<!--      &lt;!&ndash; Search Results &ndash;&gt;-->
<!--      <div class="product-results" v-if="products.length > 0">-->
<!--        <div v-for="product in products" :key="product.id" class="product-card">-->
<!--          <h3>{{ product.name }}</h3>-->
<!--          <p>{{ product.description }}</p>-->
<!--          <span>\${{ product.price }}</span>-->
<!--        </div>-->
<!--      </div>-->
<!--      &lt;!&ndash; Cart and Account Icons &ndash;&gt;-->
<!--      <div class="header-buttons">-->
<!--        <button class="icon-button">-->
<!--          &lt;!&ndash; Updated Cart Icon SVG &ndash;&gt;-->
<!--          <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" class="icon cart-icon">-->
<!--            <path d="M7 4h-2l-3 7v11h18V11l-3-7h-2l-2 4H9l-2-4zm-2 7h14l2 8H5l2-8zm0 2h8v2H5v-2z"/>-->
<!--          </svg>-->
<!--        </button>-->
<!--        <button class="icon-button">-->
<!--          &lt;!&ndash; Account Icon SVG &ndash;&gt;-->
<!--          <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" class="icon account-icon">-->
<!--            <path d="M12 12c2.21 0 4-1.79 4-4s-1.79-4-4-4-4 1.79-4 4 1.79 4 4 4zm0 2c-3.31 0-6 2.69-6 6v2h12v-2c0-3.31-2.69-6-6-6z"/>-->
<!--          </svg>-->
<!--        </button>-->
<!--      </div>-->
<!--    </header>-->

<!--    &lt;!&ndash; Navbar for Categories &ndash;&gt;-->
<!--    <nav class="category-navbar">-->
<!--      <ul>-->
<!--        <router-link-->
<!--            v-for="(category, index) in categories"-->
<!--            :key="index"-->
<!--            :to="'/' + category.name.toLowerCase()"-->
<!--            class="category-item"-->
<!--        >-->
<!--          <img :src="category.image.src" :alt="category.image.alt" class="category-image" />-->
<!--          <span class="category-name">{{ category.name }}</span>-->
<!--        </router-link>-->
<!--      </ul>-->
<!--    </nav>-->

    <!-- Slideshow -->

  <Swiper
        :slides-per-view="1"
        :space-between="10"
        :pagination="{ clickable: true }"
        :navigation="true"
        :loop="true"
        :autoplay="{ delay: 5000 }"
        class="mySwiper"
    >
      <SwiperSlide v-for="(image, index) in images" :key="index">
        <img :src="image.src" :alt="image.alt" class="slide-image" />
      </SwiperSlide>
    </Swiper>

    <!-- About Us Section -->
    <section class="About-us">
      <h2>About Us</h2>
      <p>Welcome to CyberTech! We are passionate about bringing the best in PC components and technology to enthusiasts worldwide...</p>
    </section>
  </div>
</template>

<script>
import axios from 'axios';
// Ensure correct path

import { Swiper, SwiperSlide } from 'swiper/vue';
import 'swiper/swiper-bundle.css';
import SwiperCore, { Autoplay, Pagination, Navigation } from 'swiper';

SwiperCore.use([Autoplay, Pagination, Navigation]);

export default {
  name: 'HomePage',
  components: {
    Swiper,
    SwiperSlide,
  },
  data() {
    return {
      searchQuery: '',
      products: [],
      images: [
        { src: require('@/assets/pcparts.png'), alt: 'Parts' },
        { src: require('@/assets/chassis.png'), alt: 'GPU' },
        { src: require('@/assets/gaming.png'), alt: 'Gaming' },
        { src: require('@/assets/pc.png'), alt: 'PC' }
      ],
    };
  },
  methods: {
    handleSearch() {
      console.log('Search button clicked!');
      const query = this.searchQuery.trim().toLowerCase();
      const matchingCategory = this.categories.find(category => category.name.toLowerCase() === query);
      if (matchingCategory) {
        this.$router.push('/' + matchingCategory.name.toLowerCase());
      } else if (query !== '') {
        axios.get(`api/product/category/${this.searchQuery}`)
            .then(response => {
              this.products = response.data;
            })
            .catch(error => {
              console.error('Error fetching products:', error);
            });
      }
    }
  }
};
</script>

<style scoped>
/* Enhanced About Us Section */
.about-us {
  background: linear-gradient(135deg, #5f7b8a, #131921); /* Subtle gradient background */
  color: white; /* Change text color for contrast */
  padding: 60px 30px; /* Add more padding for spacious feel */
  text-align: center;
  border-radius: 10px; /* Add rounded corners */
  margin: 40px auto; /* Center section with margin */
  max-width: 1200px; /* Limit the width to avoid excessive stretching */
  box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1); /* Add box shadow for depth */
}

.about-us h2 {
  font-size: 40px; /* Make heading larger */
  margin-bottom: 25px; /* Adjust bottom margin */
  color: #febd69; /* Use the theme color for emphasis */
  font-family: 'Roboto', sans-serif; /* Custom font for a modern look */
  text-transform: uppercase; /* Make heading uppercase */
  letter-spacing: 1.5px; /* Add letter spacing for style */
}

.about-us p {
  font-size: 20px; /* Increase text size for readability */
  line-height: 1.8; /* Add line height for spacing */
  margin-bottom: 20px; /* Adjust bottom margin for spacing between paragraphs */
  color: #e0e0e0; /* Softer white for less eye strain */
  font-family: 'Open Sans', sans-serif; /* Use a clean font for body text */
}

.about-us p:last-child {
  margin-bottom: 0; /* Remove margin from the last paragraph */
}

.about-us p:first-child {
  font-style: italic; /* Emphasize the first paragraph */
  font-weight: 300; /* Lighter font weight */
}

.about-us h2::after {
  content: ''; /* Add a decorative line below heading */
  display: block;
  width: 100px;
  height: 4px;
  background-color: #febd69;
  margin: 10px auto; /* Center the line */
  border-radius: 2px; /* Rounded edges */
}

@media (max-width: 768px) {
  .about-us {
    padding: 40px 20px; /* Reduce padding on smaller screens */
  }

  .about-us h2 {
    font-size: 30px; /* Adjust font size for smaller screens */
  }

  .about-us p {
    font-size: 18px; /* Adjust text size for better readability */
  }
}
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