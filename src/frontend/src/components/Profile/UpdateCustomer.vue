<script setup>
import { ref, onMounted } from 'vue';
import axios from 'axios';
import { useRouter } from 'vue-router';

const customer = ref({
  customer_id: '',
  firstName: '',
  lastName: '',
  mobileNumber: '',
  email: '',
  dateOfBirth: '',
  password: '',
});

const customerList = ref([]);
const message = ref('');
const router = useRouter();

onMounted(async () => {
  try {
    const response = await axios.get('http://localhost:3000/api/customer/getall');
    customerList.value = response.data;
  } catch (error) {
    message.value = `Error fetching customers: ${error.message}`;
  }
});

const fetchCustomerDetails = async () => {
  if (customer.value.customer_id) {
    try {
      const response = await axios.get(`http://localhost:3000/api/customer/read/${customer.value.customer_id}`);
      customer.value = {...response.data};
    } catch (error) {
      message.value = `Error fetching customer details: ${error.message}`;
    }
  } else {
    message.value = 'Please select a customer ID.';
  }
};

const submitForm = async () => {
  try {
    const response = await axios.put('http://localhost:3000/api/customer/update', customer.value);
    message.value = `Customer updated successfully: ${response.data.firstName} ${response.data.lastName}`;
    resetForm();
  } catch (error) {
    message.value = `Error updating customer: ${error.message}`;
  }
};

const resetForm = () => {
  customer.value = {
    customer_id: '',
    firstName: '',
    lastName: '',
    mobileNumber: '',
    email: '',
    dateOfBirth: '',
    password: '',
  };
};

const goBack = () => {
  router.push('/AdminPage');
};
</script>

<template>
  <div class="update-customer">
    <h2>Update Customer</h2>
    <form @submit.prevent="submitForm">
      <div class="form-group">
        <label for="customerId">Customer ID:</label>
        <select v-model="customer.customer_id" @change="fetchCustomerDetails" id="customerId" required>
          <option value="">Select a customer</option>
          <option v-for="c in customerList" :key="c.customer_id" :value="c.customer_id">
            {{ c.customer_id }}
          </option>
        </select>
      </div>

      <div class="form-group">
        <label for="firstName">First Name:</label>
        <input v-model="customer.firstName" type="text" id="firstName" required/>
      </div>

      <div class="form-group">
        <label for="lastName">Last Name:</label>
        <input v-model="customer.lastName" type="text" id="lastName" required/>
      </div>

      <div class="form-group">
        <label for="mobileNumber">Mobile Number:</label>
        <input v-model="customer.mobileNumber" type="text" id="mobileNumber" required/>
      </div>
      <div class="form-group">
        <label for="email">Email:</label>
        <input v-model="customer.email" type="text" id="email" required/>
      </div>
      <div class="form-group">
        <label for="dateOfBirth">Date Of Birth:</label>
        <input v-model="customer.dateOfBirth" type="text" id="dateOfBirth" required/>
      </div>

      <div class="form-group">
        <label for="password">Password:</label>
        <input v-model="customer.password" type="password" id="password" required/>
      </div>

      <button type="submit">Update Customer</button>
      <button type="button" @click="goBack">Home Page</button>
    </form>
    <p v-if="message" class="message">{{ message }}</p>
  </div>
</template>

<style scoped>
.update-customer {
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