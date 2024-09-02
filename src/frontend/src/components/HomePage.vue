<template xmlns:th="http://www.w3.org/1999/xhtml">
  <div class="homepage-container">
    <NavigationTool />

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

    <section class="product-list" style="background-color: white">
      <h2>Our Products</h2>
      <div class="products-container">
        <ul>
          <li v-if="products.length === 0">
            <p>No products available. Please check back later.</p>
          </li>
          <li v-for="product in products" :key="product.productId" class="product-item">
            <img :src="`/${product.productPicture}`" :alt="product.productName" class="product-image" />
            <div class="product-details">
              <h3>{{ product.productName }}</h3>
              <p class="price">{{ formatCurrency(product.price) }}</p>
            </div>
          </li>
        </ul>
      </div>
    </section>

    <!-- About Us Section -->
    <section id="about-us" class="about-us-section"></section>
    <section class="about-us">
      <h2>About Us</h2>
      <p>Welcome to CyberTech! We are a group of like-minded individuals who have a deep passion for the world of pcs.</p>
      <p>We are passionate about bringing the best in PC components and technology to enthusiasts nationwide.
        We are committed to delivering quality products and service to our customers and wanting to make their dreams possible.</p>
      <div class="about-icons"></div>
    </section>

    <!-- Product List Section -->

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
    },
    fetchProducts() {
      axios.get('/api/product/category/cooling')
          .then((response) => {
            this.products = response.data; // Store fetched data
            console.log(this.products);
          })
          .catch((error) => {
            console.error('Error fetching products:', error);
          });
    },
    formatCurrency(value) {
      if (!value) return '';
      return new Intl.NumberFormat('en-US', { style: 'currency', currency: 'ZAR' }).format(value);
    }
  },
  mounted() {
    this.fetchProducts(); // Fetch products when component is mounted
  }
};
</script>


<style scoped>
/* Existing styles */

/* Swiper Section */
.mySwiper {
  width: 100%;
  height: 200px; /* Reduce the height of the swiper */
}

.slide-image {
  width: 100%; /* Allow the image width to adjust based on height */
  height: auto; /* Adjust the image height to fit within the swiper */
  max-height: 300px; /* Limit the max height to reduce image size */
  object-fit: contain; /* Ensure the images scale proportionally */
}

/* Existing styles */

/* Product List Section */
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
  max-width: 180px; /* Control the size of the items */
  text-align: center;
  transition: color 0.3s ease, box-shadow 0.3s ease;
  position: relative;
}

/* Hover effect for product items */
.products-container li:hover {
  color: #232f3e; /* Change text color on hover */
  box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2); /* Add shadow effect */
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

</style>