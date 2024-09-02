<script setup>
import {ref, onMounted} from 'vue';
import axios from 'axios';
import {useRouter} from 'vue-router';


const productCategory = ref({
  categoryId: '',
  categoryName: '',
});

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

const fetchCategoryDetails = () => {
  const selectedCategory = categoryList.value.find(category => category.categoryId === productCategory.value.categoryId);
  if (selectedCategory) {
    productCategory.value.categoryName = selectedCategory.categoryName;
  } else {
    message.value = 'Category not found';
  }
};

const submitForm = async () => {
  try {
    const response = await axios.post('http://localhost:3000/api/productCategory/update', productCategory.value);
    message.value = `Category updated successfully: ${response.data.categoryName}`;
    resetForm();
  } catch (error) {
    message.value = `Error updating category: ${error.message}`;
  }
};

const resetForm = () => {
  productCategory.value = {
    categoryId: '',
    categoryName: '',
  };
};


const goBack = () => {
  router.push('/AdminPage');
};
</script>

<template>
  <div class="update-category">
    <h2>Update Product Category</h2>
    <form @submit.prevent="submitForm">
      <div class="form-group">
        <label for="categoryId">Category ID:</label>
        <select v-model="productCategory.categoryId" @change="fetchCategoryDetails" id="categoryId" required>
          <option v-for="category in categoryList" :key="category.categoryId" :value="category.categoryId">
            {{ category.categoryId }}
          </option>
        </select>
      </div>

      <!-- Editable Category Name -->
      <div class="form-group">
        <label for="categoryName">Category Name:</label>
        <input v-model="productCategory.categoryName" type="text" id="categoryName" required/>
      </div>

      <button type="submit">Update Category</button>
      <button type="button" @click="goBack">Back to Admin Page</button>
    </form>
    <p v-if="message" class="message">{{ message }}</p>
  </div>
</template>

<style scoped>
.update-category {
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

input, select, textarea {
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