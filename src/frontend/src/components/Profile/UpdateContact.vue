<script setup>
import { ref, onMounted } from 'vue';
import axios from 'axios';
import { useRouter } from 'vue-router';

// Define reactive variables
const contact = ref({
  email: '',
  mobile: '',
  address: '',
  city: '',
  state: '',
  zipCode: '',
  country: ''
});

const contactList = ref([]);
const message = ref('');
const router = useRouter();

// Fetch all contacts when the component is mounted
onMounted(async () => {
  try {
    const response = await axios.get('http://localhost:3000/api/contact/getall');
    contactList.value = response.data;
  } catch (error) {
    message.value = `Error fetching contacts: ${error.message}`;
  }
});

// Fetch contact details based on selected email
const fetchContactDetails = async () => {
  if (contact.value.email) {
    try {
      const response = await axios.get(`http://localhost:3000/api/contact/read/${contact.value.email}`);
      contact.value = {...response.data}; // Update reactive contact object
    } catch (error) {
      message.value = `Error fetching contact details: ${error.message}`;
    }
  } else {
    message.value = 'Please select an email.';
  }
};

// Submit the form to update the contact
const submitForm = async () => {
  try {
    const response = await axios.post('http://localhost:3000/api/contact/update', contact.value);
    message.value = `Contact updated successfully: ${response.data.email}`;
    resetForm();
  } catch (error) {
    message.value = `Error updating contact: ${error.message}`;
  }
};

// Reset the form fields
const resetForm = () => {
  contact.value = {
    email: '',
    mobile: '',
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
  <div class="update-contact">
    <h2>Update Contact</h2>
    <form @submit.prevent="submitForm">
      <!-- Contact Dropdown -->
      <div class="form-group">
        <label for="email">Email:</label>
        <select v-model="contact.email" @change="fetchContactDetails" id="email" required>
          <option value="">Select a contact</option>
          <option v-for="c in contactList" :key="c.email" :value="c.email">
            {{ c.email }}
          </option>
        </select>
      </div>

      <!-- Editable Contact Details -->
      <div class="form-group">
        <label for="mobile">Mobile:</label>
        <input v-model="contact.mobile" type="text" id="mobile" required/>
      </div>

      <div class="form-group">
        <label for="address">Address:</label>
        <input v-model="contact.address" type="text" id="address" required/>
      </div>

      <div class="form-group">
        <label for="city">City:</label>
        <input v-model="contact.city" type="text" id="city" required/>
      </div>

      <div class="form-group">
        <label for="state">State:</label>
        <input v-model="contact.state" type="text" id="state" required/>
      </div>

      <div class="form-group">
        <label for="zipCode">Zip Code:</label>
        <input v-model="contact.zipCode" type="text" id="zipCode" required/>
      </div>

      <div class="form-group">
        <label for="country">Country:</label>
        <input v-model="contact.country" type="text" id="country" required/>
      </div>

      <button type="submit">Update Contact</button>
      <button type="button" @click="goBack">Home Page</button>
    </form>
    <p v-if="message" class="message">{{ message }}</p>
  </div>
</template>

<style scoped>
.update-contact {
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
