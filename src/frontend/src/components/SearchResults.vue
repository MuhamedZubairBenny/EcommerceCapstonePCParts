<template>
  <div class="search-results">
    <!-- Removed the search results heading -->

    <!-- Display products -->
    <div v-if="products.length > 0">
      <router-link
          v-for="product in products"
          :key="product.productId"
          :to="'/product/' + product.productId"
          class="product-item"
      >
        <div class="product-item-content">
          <img :src="product.productPicture" :alt="product.productName" />
          <h3>{{ product.productName }}</h3>
          <p>{{ product.description }}</p>
        </div>
      </router-link>
    </div>
    <div v-else>
      <p>No products found matching your search criteria.</p>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      products: [],
      query: this.$route.query.q || '' // Initial query from the route
    };
  },
  watch: {
    // Watch for changes to query in case it changes without a full page refresh
    '$route.query.q': 'fetchSearchResults'
  },
  created() {
    if (this.query) {
      this.fetchSearchResults(this.query);
    }
  },
  methods: {
    fetchSearchResults(query) {
      if (query) {
        axios.get( `http://localhost:3000/api/product/search/${query}`)
      .then(response => {
          this.products = response.data;
        })
            .catch(error => {
              console.error('Error fetching search results:', error);
            });
      } else {
        this.products = []; // Clear products if there's no query
      }
    }
  }
};
</script>

<style scoped>
.search-results {
  padding: 20px;
}

.product-item {
  display: block;
  text-decoration: none;
  color: inherit;
  margin: 10px 0;
}

.product-item-content {
  border: 1px solid #ddd;
  border-radius: 8px;
  padding: 16px;
  text-align: center;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  transition: transform 0.2s;
  cursor: pointer;
  box-sizing: border-box;
}

.product-item-content:hover {
  transform: scale(1.05);
}

.product-item img {
  width: 200px;
  height: 200px;
  object-fit: cover;
  border-radius: 8px;
}

.product-item h3 {
  font-size: 1.2em;
  margin: 10px 0;
}

.product-item p {
  color: #555;
}
</style>




