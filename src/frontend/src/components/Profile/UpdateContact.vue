<script setup>
import {ref} from 'vue';
import {useStore} from 'vuex';

const shipping = ref({
  shippingId: '',
  address: '',
  city: '',
  state: '',
  zipCode: '',
  country: ''
});

const message = ref('');
const store = useStore();


const user = store.state.user;
shipping.value = user ? user.shipping : {};


const submitForm = async () => {
  try {
    const updatedShipping = await store.dispatch('updateShipping', shipping.value);
    shipping.value = updatedShipping;
    message.value = 'Shipping information updated successfully!';
    resetForm();
  } catch (error) {
    message.value = `Error updating shipping: ${error.message}`;
  }
};

const resetForm = () => {
  shipping.value = user.shipping;
};
</script>

<template>
  <div class="update-shipping-container">
    <h2>Update Your Shipping Information</h2>
    <form @submit.prevent="submitForm" class="shipping-form">
      <div class="form-group">
        <label for="shippingId">Shipping ID:</label>
        <input v-model="shipping.shippingId" type="text" id="shippingId" readonly/>
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

      <button type="submit" class="submit-btn">Update Shipping Information</button>
    </form>

    <p v-if="message" class="message">{{ message }}</p>
  </div>
</template>

<style scoped>
.update-shipping-container {
  max-width: 600px;
  margin: 50px auto;
  padding: 30px;
  background-color: #f4f4f4;
  border-radius: 10px;
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
}

h2 {
  text-align: center;
  margin-bottom: 20px;
  color: #333;
}

.shipping-form {
  display: flex;
  flex-direction: column;
}

.form-group {
  margin-bottom: 15px;
}

.form-group label {
  font-size: 16px;
  font-weight: bold;
  margin-bottom: 5px;
  display: block;
  color: #555;
}

.form-group input {
  width: 100%;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
  font-size: 14px;
}

.form-group input:focus {
  border-color: #007bff;
  outline: none;
}

.submit-btn {
  width: 100%;
  padding: 12px;
  background-color: #007bff;
  color: white;
  border: none;
  border-radius: 5px;
  font-size: 16px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.submit-btn:hover {
  background-color: #0056b3;
}

.message {
  text-align: center;
  margin-top: 20px;
  font-size: 16px;
  color: #28a745;
}
</style>
