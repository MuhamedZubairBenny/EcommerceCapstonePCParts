<script setup>
import { ref } from 'vue';
import axios from 'axios';
import { useRouter } from 'vue-router'; // Import the router

const brand = ref({
  brandId: '',
  brandName: ''
});

const message = ref('');
const router = useRouter();

const submitForm = async () => {
  try {
    const response = await axios.post('http://localhost:3000/api/brand/create', brand.value);
    message.value = `Brand created successfully: ${response.data.brandName}`;
    resetForm();
  } catch (error) {
    message.value = `Error creating brand: ${error.response?.data?.message || error.message}`;
  }
};

const resetForm = () => {
  brand.value = {
    brandId: '',
    brandName: ''
  };
};


const goBack = () => {
  router.push('/AdminPage');
};
</script>

<template>
  <div class="add-brand">
    <h2>Add New Brand</h2>
    <form @submit.prevent="submitForm">
      <div class="form-group">
        <label for="brandId">Brand ID:</label>
        <input v-model="brand.brandId" type="text" id="brandId" required />
      </div>
      <div class="form-group">
        <label for="brandName">Brand Name:</label>
        <input v-model="brand.brandName" type="text" id="brandName" required />
      </div>
      <button type="submit">Add Brand</button>
      <button type="button" @click="goBack">Back to Admin Page</button> <!-- Added back button -->
    </form>
    <p v-if="message" class="message">{{ message }}</p>
  </div>
</template>

<style scoped>
.add-brand {
  max-width: 600px;
  margin: 0 auto;
}

.form-group {
  margin-bottom: 15px;
}

label {
  display: block;
  margin-bottom: 5px;
}

input {
  width: 100%;
  padding: 8px;
  box-sizing: border-box;
}

button {
  padding: 10px 15px;
  background-color: #007bff;
  color: white;
  border: none;
  cursor: pointer;
  margin-right: 10px;
}

button:hover {
  background-color: #0056b3;
}

.message {
  margin-top: 20px;
  color: green;
}
</style>
