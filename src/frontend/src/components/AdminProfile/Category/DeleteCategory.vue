<script setup>
import { ref, onMounted } from 'vue';
import axios from 'axios';
import { useRouter } from 'vue-router';


const selectedCategoryId = ref('');
const categoryList = ref([]);
const message = ref('');
const router = useRouter();


onMounted(async () => {
  try {
    const response = await axios.get('http://localhost:3000/api/productCategory/getAll');
    categoryList.value = response.data;
  } catch (error) {
    message.value = `Error fetching categories: ${error.message}`;
  }
});


const deleteCategory = async () => {
  if (!selectedCategoryId.value) {
    message.value = 'Please select a category to delete.';
    return;
  }

  try {
    await axios.delete(`http://localhost:3000/api/productCategory/delete/${selectedCategoryId.value}`);
    message.value = 'Category deleted successfully';

    await fetchCategories();
  } catch (error) {
    message.value = `Error deleting category: ${error.message}`;
  }
};


const fetchCategories = async () => {
  try {
    const response = await axios.get('http://localhost:3000/api/productCategory/getAll');
    categoryList.value = response.data;
  } catch (error) {
    message.value = `Error fetching categories: ${error.message}`;
  }
};


const goBack = () => {
  router.push('/AdminPage');
};
</script>

<template>
  <div class="delete-category">
    <h2>Delete Product Category</h2>
    <form @submit.prevent="deleteCategory">

      <div class="form-group">
        <label for="categoryId">Select Category to Delete:</label>
        <select v-model="selectedCategoryId" id="categoryId" required>
          <option value="">Select a category</option>
          <option v-for="category in categoryList" :key="category.categoryId" :value="category.categoryId">
            {{ category.categoryId }} - {{ category.categoryName }}
          </option>
        </select>
      </div>

      <button type="submit">Delete Category</button>
      <button type="button" @click="goBack">Back to Admin Page</button>
    </form>
    <p v-if="message" class="message">{{ message }}</p>
  </div>
</template>

<style scoped>
.delete-category {
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
  background-color: #dc3545;
  color: white;
  border: none;
  cursor: pointer;
  margin: 10px;
}

button:hover {
  background-color: #c82333;
}

.message {
  margin-top: 20px;
  color: green;
}
</style>