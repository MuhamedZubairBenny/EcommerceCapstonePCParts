<template xmlns:th="http://www.w3.org/1999/xhtml">
  <NavigationTool />
  <div class="homepage-container">

    <section id="about-us" class="about-us-section">
    </section>

    <section class="about-us">
      <h2>About Us</h2>
      <p>Welcome to CyberTech! We are a group of like-minded individuals who have a deep passion for the world of PCs.</p>
      <p>We are passionate about bringing the best in PC components and technology to enthusiasts nationwide. We are committed to delivering quality products and service to our customers and wanting to make their dreams possible.</p>
      <div class="about-icons">
      </div>
    </section>
  </div>

  <div>
    <h1 v-if="isAuthenticated">Welcome Back, {{ user.id }}!</h1>
    <h1 v-else>Please Log In</h1>
  </div>

</template>

<script>
import { mapState } from 'vuex';
import {axios} from 'axios';
import AuthService from "@/AuthService";

export default {
  computed: {
    ...mapState({
      isAuthenticated: state => state.isAuthenticated,
      userId: state => state.user.id // Assuming 'user' is the property where user details are stored
    })
  },

  name: 'HomePage',
  components: {
    // Your other components
  },
  data() {
    return {
      searchQuery: '',
      products: [],
      user: {}
    };
  },
  methods: {
    handleSearch() {
      console.log('Search button clicked!');
      const query = this.searchQuery.trim().toLowerCase();
      // Assuming you have a 'categories' property in your data or computed
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
    fetchUserDetails() {
      AuthService.getUserById(this.userId)
          .then(response => {
            this.user = response.data; // Assuming the response contains user details
          })
          .catch(error => {
            console.error('Error fetching user details:', error);
          });
    }
  },
  mounted() {
    if (this.isAuthenticated) {
      this.fetchUserDetails(); // Fetch user details if authenticated
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