<template>
  <div class="shipping-container">
    <h1>Shipping Address</h1>
    <div class="shipping-details">
      <p v-if="shippingInfo"><strong>Full Name:</strong> {{ shippingInfo.fullName }}</p>
      <p v-if="shippingInfo"><strong>Address Line 1:</strong> {{ shippingInfo.address }}</p>
      <p v-if="shippingInfo"><strong>Address Line 2:</strong> {{ shippingInfo.addressLine2 || 'N/A' }}</p>
      <p v-if="shippingInfo"><strong>City:</strong> {{ shippingInfo.city }}</p>
      <p v-if="shippingInfo"><strong>Province:</strong> {{ shippingInfo.state }}</p>
      <p v-if="shippingInfo"><strong>Zip Code:</strong> {{ shippingInfo.zipCode }}</p>
      <p v-if="shippingInfo"><strong>Country:</strong> {{ shippingInfo.country }}</p>
      <p v-if="shippingInfo"><strong>Phone Number:</strong> {{ shippingInfo.phone || 'N/A' }}</p>
      <p v-else>Your shipping information could not be retrieved.</p>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import { useStore } from 'vuex';

const store = useStore();
const shippingInfo = ref(null);
const userId = store.state.shippingId || ''; // Get the user's ID from the store

// Fetch shipping information from API
const fetchShippingInfo = async () => {
  if (!userId) {
    console.error('User ID is not available');
    return;
  }
  try {
    const response = await fetch(`/api/shipping/read/${userId}`);
    if (response.ok) {
      const data = await response.json();
      // Map backend attributes to frontend attributes if needed
      shippingInfo.value = {
        fullName: data.fullName || 'N/A',
        address: data.address || 'N/A',
        addressLine2: data.addressLine2 || 'N/A',
        city: data.city || 'N/A',
        state: data.state || 'N/A',
        zipCode: data.zipCode || 'N/A',
        country: data.country || 'N/A',
        phone: data.phone || 'N/A'
      };
    } else {
      console.error('Error fetching shipping information:', response.statusText);
    }
  } catch (error) {
    console.error('Error fetching shipping information:', error);
  }
};

// Fetch shipping information when component mounts
onMounted(() => {
  fetchShippingInfo();
});
</script>
