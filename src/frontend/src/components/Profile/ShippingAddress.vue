<script setup>
import { ref } from 'vue';

// Sample data for shipping information
const shippingInfo = ref({
  fullName: "Hanz Homey",
  addressLine1: "123 Main Street",
  addressLine2: "Apt 4B",
  city: "Cape Town",
  province: "Western Cape",
  zipCode: "7510",
  country: "South Africa",
  phone: "(+27) 78-814-233"
});
</script>

<template>
  <div class="shipping-container">
    <h1>Shipping Address</h1>

    <!-- Shipping Details Section -->
    <div class="shipping-details">
      <p><strong>Full Name:</strong> {{ shippingInfo.fullName }}</p>
      <p><strong>Address Line 1:</strong> {{ shippingInfo.addressLine1 }}</p>
      <p><strong>Address Line 2:</strong> {{ shippingInfo.addressLine2 }}</p>
      <p><strong>City:</strong> {{ shippingInfo.city }}</p>
      <p><strong>Province:</strong> {{ shippingInfo.province }}</p>
      <p><strong>Zip Code:</strong> {{ shippingInfo.zipCode }}</p>
      <p><strong>Country:</strong> {{ shippingInfo.country }}</p>
      <p><strong>Phone Number:</strong> {{ shippingInfo.phone }}</p>
    </div>
  </div>
</template>

<style scoped>
.shipping-container {
  max-width: 650px;
  margin: 0 auto;
  padding: 35px;
  background: linear-gradient(145deg, #fe8c00, #f83600);
  border-radius: 20px;
  box-shadow: 0 12px 24px rgba(0, 0, 0, 0.25);
  color: #f4f4f4;
}

h1 {
  text-align: center;
  font-size: 2.4rem;
  color: #f4f4f4;
  margin-bottom: 25px;
  letter-spacing: 1.2px;
  text-transform: capitalize;
}

.shipping-details p {
  font-size: 18px;
  line-height: 1.7;
  margin: 12px 0;
  color: #f4f4f4;
  text-shadow: 0 1px 2px rgba(0, 0, 0, 0.3);
}

.shipping-details p strong {
  display: inline-block;
  min-width: 160px;
  font-weight: 700;
  color: #ffcc00;
  text-transform: capitalize;
}
</style>