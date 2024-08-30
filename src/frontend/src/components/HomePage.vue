
<template xmlns:th="http://www.w3.org/1999/xhtml">
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

    <section id="about-us" class="about-us-section">
    </section>

    <section class="about-us">
      <h2>About Us</h2>
      <p>Welcome to CyberTech! We are a group of like-minded individuals who have a deep passion for the world of pcs.</p>
      <p>We are passionate about bringing the best in PC components and technology to enthusiasts nationwide.
        We are committed to delivering quality products and service to our customers and wanting to make their dreams possible.  </p>
      <div class="about-icons">
        </div>
    </section>
  </div>
</template>

<script>
import axios from 'axios';


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
        {src: require('@/assets/ryzenslideshow.png'), alt: 'ryzen'},
        {src: require('@/assets/laptopslideshow.png'), alt: 'laptop'},
        {src: require('@/assets/alienware.png'), alt: 'alienware'},
        {src: require('@/assets/computerslideshow.png'), alt: 'computer'}
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

.about-us {
  background: linear-gradient(135deg, #5f7b8a, #131921);
  color: white;
  padding: 60px 30px;
  text-align: center;
  border-radius: 10px;
  margin: 40px auto;
  max-width: 1200px;
  box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
}

.about-us h2 {
  font-size: 40px;
  margin-bottom: 25px;
  color: #febd69; /
  font-family: 'Roboto', sans-serif;
  text-transform: uppercase;
  letter-spacing: 1.5px;
}

.about-us p {
  font-size: 20px;
  line-height: 1.8;
  margin-bottom: 20px;
  color: #e0e0e0;
  font-family: 'Open Sans', sans-serif;
}

.about-us p:last-child {
  margin-bottom: 0;
}

.about-us p:first-child {
  font-style: italic;
  font-weight: 300;
}

.about-us h2::after {
  content: '';
  display: block;
  width: 100px;
  height: 4px;
  background-color: #febd69;
  margin: 10px auto;
  border-radius: 2px;
}

@media (max-width: 768px) {
  .about-us {
    padding: 40px 20px;
  }

  .about-us h2 {
    font-size: 30px;
  }

  .about-us p {
    font-size: 18px;
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
  width: 24px; /
  height: 24px;
}

.icon-button:hover {
  background-color: #f0c14b;
}



.header {
  display: flex;
  align-items: center;
  background-color: #131921;
  color: white;
  padding: 15px 30px;
}

.logo {
  position: absolute;
  left: 10px;
  top: 50%;
  transform: translateY(-50%);
  padding: 0;
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
  margin-bottom: 5px;
}

.category-name {
  font-size: 16px;
  font-weight: bold;
  color: #333;
  margin-top: 5px;
}

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
  padding: 0;
  margin: 0;
  position: relative;
  height: 120px;

.logo {
  position: absolute;
  left: 10px;
  top: 50%;
  transform: translateY(-50%);
  padding: 0;
}

html, body {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}
.about-us {
  background: linear-gradient(135deg, #1e3b70, #2a5298);
  color: white;
  padding: 70px 40px;
  text-align: center;
  border-radius: 15px;
  margin: 50px auto;
  max-width: 1000px;
  box-shadow: 0 12px 35px rgba(0, 0, 0, 0.15);
  position: relative;
  overflow: hidden;
}

.about-us::before {
  content: '';
  position: absolute;
  top: -100px;
  left: -100px;
  width: 300px;
  height: 300px;
  background: rgba(255, 255, 255, 0.1);
  border-radius: 50%;
  animation: float 6s ease-in-out infinite;
}

.about-us h2 {
  font-size: 42px;
  margin-bottom: 30px;
  color: #febd69;
  font-family: 'Roboto', sans-serif;
  text-transform: uppercase;
  letter-spacing: 2px;
}

.about-us p {
  font-size: 22px;
  line-height: 1.7;
  margin-bottom: 30px;
  color: #e0e0e0;
  font-family: 'Open Sans', sans-serif;
}

.about-us p:first-child {
  font-style: italic;
  font-weight: 300;
}

.about-us h2::after {
  content: '';
  display: block;
  width: 110px;
  height: 5px;
  background-color: #febd69;
  margin: 12px auto;
  border-radius: 2px;
}

.about-icons {
  display: flex;
  justify-content: center;
  gap: 40px;
}

.icon-box {
  text-align: center;
}

.icon-box img {
  width: 70px;
  height: 70px;
  margin-bottom: 15px;
}

.icon-box h3 {
  font-size: 20px;
  color: #febd69;
  font-family: 'Roboto', sans-serif;
}

@keyframes float {
  0% {
    transform: translateY(0);
  }
  50% {
    transform: translateY(20px);
  }
  100% {
    transform: translateY(0);
  }
}

@media (max-width: 768px) {
  .about-us {
    padding: 50px 20px;
  }

  .about-us h2 {
    font-size: 34px;
  }

  .about-us p {
    font-size: 18px;
  }

  .about-icons {
    flex-direction: column;
    gap: 30px;
  }

  .icon-box img {
    width: 60px;
    height: 60px;
  }
}}


</style>