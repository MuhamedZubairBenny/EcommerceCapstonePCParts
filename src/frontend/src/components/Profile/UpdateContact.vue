<script setup>
import { ref, onMounted } from 'vue';
import axios from 'axios';
import { useRouter } from 'vue-router';

// Define reactive variables
const shipping = ref({
  shippingId: '',
  address: '',
  city: '',
  state: '',
  zipCode: '',
  country: ''
});

const shippingList = ref([]);
const message = ref('');
const router = useRouter();

// Fetch all contacts when the component is mounted
onMounted(async () => {
  try {
    const response = await axios.get('http://localhost:3000/api/shipping/getall');
    shippingList.value = response.data;
  } catch (error) {
    message.value = `Error fetching contacts: ${error.message}`;
  }
});

const fetchContactDetails = async () => {
  if (shipping.value.shippingId) {
    try {
      const response = await axios.get(`http://localhost:3000/api/shipping/read/${shipping.value.shippingId}`);
      shipping.value = {...response.data};
    } catch (error) {
      message.value = `Error fetching shipping details: ${error.message}`;
    }
  } else {
    message.value = 'Please select an shipping ID.';
  }
};

const submitForm = async () => {
  try {
    const response = await axios.post('http://localhost:3000/api/shipping/update', shipping.value);
    message.value = `Shipping updated successfully: ${response.data.email}`;
    resetForm();
  } catch (error) {
    message.value = `Error updating shipping: ${error.message}`;
  }
};

// Reset the form fields
const resetForm = () => {
  shipping.value = {
    shippingId: '',
    address: '',
    city: '',
    state: '',
    zipCode: '',
    country: ''
  };
};

// Navigate back to Admin Page
const goBack = () => {
  router.push('/AdminPage');
};
</script>

<template>
  <div class="update-shipping">
    <h2>Update Shipping Information</h2>
    <form @submit.prevent="submitForm">
      <div class="form-group">
        <label for="shippingId">Shipping ID:</label>
        <select v-model="shipping.shippingId" @change="fetchContactDetails" id="shippingId" required>
          <option value="">Select Shipping Information</option>
          <option v-for="c in shippingList" :key="c.shippingId" :value="c.shippingId">
            {{ c.shippingId }}
          </option>
        </select>
      </div>

      <div class="form-group">
        <label for="address">Address:</label>
        <input v-model="shipping.address" type="text" id="address" required/>
      </div>

      <div class="form-group">
        <label for="city">City:</label>
        <input v-model="shipping.city" type="text" id="city" required/>
      </div>

      <div class="form-group">
        <label for="state">State:</label>
        <input v-model="shipping.state" type="text" id="state" required/>
      </div>

      <div class="form-group">
        <label for="zipCode">Zip Code:</label>
        <input v-model="shipping.zipCode" type="text" id="zipCode" required/>
      </div>

      <div class="form-group">
        <label for="country">Country:</label>
        <input v-model="shipping.country" type="text" id="country" required/>
      </div>

      <button type="submit">Update Shipping Information</button>
      <button type="button" @click="goBack">Home Page</button>
    </form>
    <p v-if="message" class="message">{{ message }}</p>
  </div>
</template>

<style scoped>
.update-shipping {
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
  border-radius: 8px;
  background-color: #f9f9f9;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

h2 {
  text-align: center;
  color: #333;
  margin-bottom: 20px;
}

.form-group {
  margin-bottom: 20px;
}

label {
  display: block;
  margin-bottom: 8px;
  font-weight: bold;
  color: #333;
}

input, select {
  width: 100%;
  padding: 12px;
  border: 1px solid #ddd;
  border-radius: 4px;
  box-sizing: border-box;
  font-size: 16px;
  color: #333;
}

input:focus, select:focus {
  border-color: #007bff;
  outline: none;
}

button {
  padding: 12px 20px;
  color: #fff;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size: 16px;
  margin-right: 10px;
  transition: background-color 0.3s ease;
}

button:first-of-type {
  background-color: #46c699;
}

button:first-of-type:hover {
  background-color: #059090;
}

button:last-of-type {
  background-color: #6c757d;
}

button:last-of-type:hover {
  background-color: #5a6268;
}

.message.success {
  margin-top: 20px;
  text-align: center;
  color: #5bc0de;
}

.message {
  margin-top: 20px;
  text-align: center;
  color: #5bc0de;
}
</style>
