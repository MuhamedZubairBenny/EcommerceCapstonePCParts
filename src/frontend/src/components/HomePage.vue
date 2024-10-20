<template xmlns:th="http://www.w3.org/1999/xhtml">
  <NavigationTool />

  <section class="product-list" style="background-color: white">
    <h1 class="products-heading">Our Products</h1>
    <div class="products-container">
      <ul>
        <li v-if="products.length === 0">
          <p>No products available. Please check back later.</p>
        </li>
        <li v-for="product in products" :key="product.productId" class="product-item" @click="goToProductPage(product.productId)">
          <img :src="`/${product.productPicture}`" :alt="product.productName" class="product-image" />
          <div class="product-details">
            <h3>{{ product.productName }}</h3>
            <p class="price">{{ formatCurrency(product.price) }}</p>
          </div>
        </li>
      </ul>
    </div>
  </section>

  <div class="homepage-container">

    <section id="about-us" class="about-us-section"></section>
    <section class="about-us">
      <h2>About Us</h2>
      <p>Welcome to CyberTech! We are a group of like-minded individuals who have a deep passion for the world of PCs.</p>
      <p>We are passionate about bringing the best in PC components and technology to enthusiasts nationwide. We are committed to delivering quality products and service to our customers and wanting to make their dreams possible.</p>
      <div class="about-icons"></div>
    </section>
  </div>
</template>

<script>
import { mapState } from 'vuex';
import axios from 'axios';

export default {
  name: 'HomePage',
  computed: {
    ...mapState({
      isAuthenticated: state => state.isAuthenticated,
      user: state => state.user,
    }),
    isUserLoaded() {
      return !!this.user && !!this.user.email;
    }
  },
  data() {
    return {
      searchQuery: '',
      products: [],
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
    },
    selectRandomProducts() {
      const shuffled = this.products.sort(() => 0.5 - Math.random());
      this.randomProducts = shuffled.slice(0, 10);
    },

    fetchProducts() {
      axios.get('/api/product/getall')
          .then((response) => {
            this.products = response.data;
            this.selectRandomProducts();
            console.log(this.products);
            console.log(this.randomProducts);
          })
          .catch((error) => {
            console.error('Error fetching products:', error);
          });
    },
    formatCurrency(value) {
      if (!value) return '';
      return new Intl.NumberFormat('en-US', { style: 'currency', currency: 'ZAR' }).format(value);
    },
    goToProductPage(productId) {
      this.$router.push(`/product/${productId}`);
    },
    fetchUserDetailsByEmail() {
      if (this.user.email) {
        this.$store.dispatch('fetchUserByEmail', this.user.email)
            .then(() => {
              // Optional: Additional logic after fetching the user
            })
            .catch(error => {
              console.error('Error fetching user details:', error);
            });
      } else {
        console.error('User email is not available');
      }
    }
  },
  mounted() {
    this.fetchProducts();
  },
  created() {
    this.$store.dispatch('initializeStore');
    if (this.isAuthenticated) {
      this.fetchUserDetailsByEmail();
    }
  },
  watch: {
    isAuthenticated(newVal) {
      if (newVal) {
        this.fetchUserDetailsByEmail();
      }
    }
  }
};
</script>



<style scoped>
.products-heading{
  text-align: center;
  font-size: 2.5rem;
  color: #232f3e;
  margin: 30px 0;
  padding: 10px;
  background-color: #69feca;
  border-radius: 10px;
  text-transform: uppercase;
  box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
  letter-spacing: 1.5px;
  font-family: 'Orbitron', sans-serif;
}
.product-list {
  padding: 40px;
  background-color: #f8f9fa;
  text-align: center;
}

.product-list h2 {
  font-size: 36px;
  margin-bottom: 20px;
  color: #333;
}

.products-container ul {
  list-style-type: none;
  padding: 0;
  margin: 0;
  display: flex;
  flex-wrap: wrap;
  gap: 20px;
  justify-content: center;
}

.products-container li {
  background-color: white;
  border: 1px solid #ddd;
  border-radius: 8px;
  padding: 20px;
  max-width: 180px;
  text-align: center;
  transition: color 0.3s ease, box-shadow 0.3s ease;
  position: relative;
}

.products-container li:hover {
  color: #232f3e;
  box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
}

.products-container li::before {
  content: '';
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(255, 255, 255, 0.1);
  border: 2px solid #232f3e;
  border-radius: 8px;
  transition: all 0.3s ease;
  z-index: -1;
  opacity: 0;
}

.products-container li:hover::before {
  opacity: 1;
}

.product-item {
  background-color: white;
  border: 1px solid #ddd;
  border-radius: 8px;
  padding: 20px;
  margin: 10px;
  max-width: 180px;
  text-align: center;
  transition: box-shadow 0.3s ease;
}

.product-item:hover {
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  border: 2px solid #232f3e;
}

.product-image {
  width: 100%;
  height: auto;
  max-height: 100px;
  border-radius: 4px;
  margin-bottom: 10px;
}

.products-container li:hover .product-image {
  transform: scale(1.1);
  box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
}

.product-details h3 {
  font-size: 16px;
  margin-bottom: 10px;
}

.product-details .price {
  font-size: 14px;
  color: #007bff;
}

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
  color: #febd69;
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
  width: 24px;
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