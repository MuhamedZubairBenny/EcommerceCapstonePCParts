<script setup>
import { ref, onMounted } from 'vue';
import axios from 'axios';
import { useRouter } from 'vue-router'; // Import the router

// Define reactive variables
const selectedBrandId = ref('');
const brandList = ref([]);
const message = ref('');
const router = useRouter(); // Initialize the router

// Fetch all brands on component mount
onMounted(async () => {
  try {
    const response = await axios.get('http://localhost:3000/api/brand/getAll');
    brandList.value = response.data;
  } catch (error) {
    message.value = `Error fetching brands: ${error.message}`;
  }
});

// Method to handle brand deletion
const deleteBrand = async () => {
  if (!selectedBrandId.value) {
    message.value = 'Please select a brand to delete.';
    return;
  }

  try {
    await axios.delete(`http://localhost:3000/api/brand/delete/${selectedBrandId.value}`);
    message.value = 'Brand deleted successfully';
    // Optionally, refresh the brand list
    await fetchBrands();
  } catch (error) {
    message.value = `Error deleting brand: ${error.message}`;
  }
};

// Method to refresh the brand list
const fetchBrands = async () => {
  try {
    const response = await axios.get('http://localhost:3000/api/brand/getAll');
    brandList.value = response.data;
  } catch (error) {
    message.value = `Error fetching brands: ${error.message}`;
  }
};

// Method to navigate back
const goBack = () => {
  router.push('/AdminPage');
};
</script>

<template>
  <div class="delete-brand">
    <h2>Delete Brand</h2>
    <form @submit.prevent="deleteBrand">
      <!-- Brand Dropdown -->
      <div class="form-group">
        <label for="brandId">Select Brand to Delete:</label>
        <select v-model="selectedBrandId" id="brandId" required>
          <option value="">Select a brand</option>
          <option v-for="b in brandList" :key="b.brandId" :value="b.brandId">
            {{ b.brandId }} - {{ b.brandName }}
          </option>
        </select>
      </div>

      <button type="submit">Delete Brand</button>
      <button type="button" @click="goBack">Back to Admin Page</button>
    </form>
    <p v-if="message" class="message">{{ message }}</p>
  </div>
</template>

<style scoped>
.delete-brand {
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

select {
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
  background-color: #dc3545;
}

button:first-of-type:hover {
  background-color: #c82333;
}

button:last-of-type {
  background-color: #007bff;
}
button:last-of-type:hover {
  background-color: #0056b3;
}

  .message {
    margin-top: 20px;
    color: green;
  }

</style>