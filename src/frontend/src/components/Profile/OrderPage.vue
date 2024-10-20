<template>
  <div class="order-summary-container">
    <h2>Order Summary</h2>

    <div class="order-details">
      <h3>Order Details</h3>
      <p v-if="order.cart.cartTotal"><strong>Total Price:</strong> {{ formatCurrency(order.cart.cartTotal) }}</p>
      <h4>Items:</h4>
      <ul>
        <li v-for="(item, index) in order.cart.products" :key="index" class="product-item">
          <img :src="item.productPicture" alt="Product Image" class="product-image" />
          <div class="product-details">
            <strong>{{ item.productName }}</strong> - {{ formatCurrency(item.price) }}
            <p><small>Brand: {{ item.brand.brandName }}</small></p>
            <p><small>Category: {{ item.category.categoryName }}</small></p>
          </div>
        </li>
      </ul>
    </div>

    <div class="shipping-details">
      <h3>Shipping Details</h3>
      <p v-if="order.shipping.address"><strong>Address:</strong> {{ order.shipping.address }}</p>
      <p v-if="order.shipping.city"><strong>City:</strong> {{ order.shipping.city }}</p>
      <p v-if="order.shipping.state"><strong>State:</strong> {{ order.shipping.state }}</p>
      <p v-if="order.shipping.zipCode"><strong>Zip Code:</strong> {{ order.shipping.zipCode }}</p>
      <p v-if="order.shipping.country"><strong>Country:</strong> {{ order.shipping.country }}</p>
    </div>

    <router-link to="/UserCart" class="back-button">Back to Cart</router-link>
  </div>
</template>

<script>
import { computed } from 'vue';
import { useStore } from 'vuex';

export default {
  name: 'OrderPage',
  setup() {
    const store = useStore();
    const order = computed(() => store.state.user || {});
    const user = computed(() =>  store.state.user || {})

    const formatCurrency = (amount) => {
      return new Intl.NumberFormat('en-US', {
        style: 'currency',
        currency: 'ZAR',
      }).format(amount);
    };

    return {
      order,
      user,
      formatCurrency,
    };
  },
};
</script>

<style scoped>
.order-summary-container {
  padding: 20px;
  max-width: 600px;
  margin: auto;
}

h2 {
  text-align: center;
}

.order-details,
.shipping-details {
  margin-bottom: 30px;
  padding: 15px;
  border: 1px solid #ccc;
  border-radius: 8px;
  background-color: #f9f9f9;
}

.product-item {
  display: flex;
  align-items: center;
  margin-bottom: 10px;
}

.product-image {
  width: 100px; /* Adjust size as needed */
  height: 100px; /* Adjust size as needed */
  object-fit: cover;
  margin-right: 10px;
}

.product-details {
  flex: 1;
}

.product-details strong {
  font-size: 1.2rem;
}

.back-button {
  display: inline-block;
  margin-top: 20px;
  padding: 10px 15px;
  background-color: #007bff;
  color: white;
  border-radius: 5px;
  text-decoration: none;
}

.back-button:hover {
  background-color: #0056b3;
}
</style>
