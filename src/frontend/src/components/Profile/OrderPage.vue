<template>
  <div class="order-summary-container">
    <h2>Order Summary</h2>

    <div class="order-details">
      <h3>Order Details</h3>
      <p><strong>Order ID:</strong> {{ order.orderId }}</p>
      <p><strong>Total Price:</strong> {{ formatCurrency(order.overallPrice) }}</p>
      <h4>Items:</h4>
      <ul>
        <li v-for="(item, index) in order.cart.products" :key="index" class="product-item">
          <img :src="item.image" alt="Product Image" class="product-image" />
          <div class="product-details">
            <strong>{{ item.productName }}</strong> - {{ formatCurrency(item.price) }} (Quantity: {{ item.quantity }})
            <p><small>Brand: {{ item.brand }}</small></p>
            <p><small>Category: {{ item.category }}</small></p>
          </div>
        </li>
      </ul>
    </div>

    <div class="payment-details">
      <h3>Payment Details</h3>
      <p><strong>Payment ID:</strong> {{ payment.paymentId }}</p>
      <p><strong>Payment Type:</strong> {{ payment.paymentType }}</p>
      <p><strong>Payment Total:</strong> {{ formatCurrency(payment.paymentTotal) }}</p>
      <p><strong>Cardholder Name:</strong> {{ payment.user.firstName }} {{ payment.user.lastName }}</p>
    </div>

    <router-link to="/UserCart" class="back-button">Back to Cart</router-link>
  </div>
</template>

<script>
import { useRoute } from 'vue-router';

export default {
  name: 'OrderPage',
  setup() {
    const route = useRoute();

    const order = JSON.parse(route.query.order || '{}');
    const payment = JSON.parse(route.query.payment || '{}');

    const formatCurrency = (amount) => {
      return new Intl.NumberFormat('en-US', {
        style: 'currency',
        currency: 'ZAR',
      }).format(amount);
    };

    return {
      order,
      payment,
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
.payment-details {
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
