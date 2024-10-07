<script setup>
import { ref, onMounted } from 'vue';
import axios from 'axios';
import { useRouter } from 'vue-router';

// Define reactive variables
const brand = ref({
  brandId: '',
  brandName: '',
});

const brandList = ref([]);
const message = ref('');
const router = useRouter();


onMounted(async () => {
  try {
    const response = await axios.get('http://localhost:3000/api/brand/getAll');
    brandList.value = response.data;
  } catch (error) {
    message.value = `Error fetching brands: ${error.message}`;
  }
});


const fetchBrandDetails = () => {
  const selectedBrand = brandList.value.find(b => b.brandId === brand.value.brandId);
  if (selectedBrand) {
    brand.value.brandName = selectedBrand.brandName;
  } else {
    message.value = 'Brand not found';
  }
};


const submitForm = async () => {
  try {
    const response = await axios.post('http://localhost:3000/api/brand/update', brand.value);
    message.value = `Brand updated successfully: ${response.data.brandName}`;
    resetForm();
  } catch (error) {
    message.value = `Error updating brand: ${error.message}`;
  }
};


const resetForm = () => {
  brand.value = {
    brandId: '',
    brandName: '',
  };
};


const goBack = () => {
  router.push('/AdminPage'); // Ensure this route is correct
};
</script>

<template>
  <div class="update-brand">
    <h2>Update Brand</h2>
    <form @submit.prevent="submitForm">
      <!-- Brand Dropdown -->
      <div class="form-group">
        <label for="brandId">Brand ID:</label>
        <select v-model="brand.brandId" @change="fetchBrandDetails" id="brandId" required>
          <option value="">Select a brand</option>
          <option v-for="b in brandList" :key="b.brandId" :value="b.brandId">
            {{ b.brandId }}
          </option>
        </select>
      </div>

      <!-- Editable Brand Name -->
      <div class="form-group">
        <label for="brandName">Brand Name:</label>
        <input v-model="brand.brandName" type="text" id="brandName" required />
      </div>

      <button type="submit">Update Brand</button>
      <button type="button" @click="goBack">Back to Admin Page</button> <!-- Added back button -->
    </form>
    <p v-if="message" class="message">{{ message }}</p>
  </div>
</template>

<style scoped>
.update-brand {
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

input, select {
  width: 100%;
  padding: 8px;
  box-sizing: border-box;
}

button {
  padding: 10px 15px;
  color: white;
  border: none;
  cursor: pointer;
  margin-right: 10px;
}

button:first-of-type {
  background-color: #007bff;
}

button:first-of-type:hover {
  background-color: #0056b3;
}

button:last-of-type {
  background-color: #007bff;
}

button:last-of-type:hover {
  background-color: #5a6268;
}

.message {
  margin-top: 20px;
  color: green;
}
</style>