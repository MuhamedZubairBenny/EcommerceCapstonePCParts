<template>
  <div class="container mt-5">
    <h2>Add New Product Category</h2>
    <form @submit.prevent="addCategory">

      <div class="mb-3">
        <label for="categoryId" class="form-label">Category ID</label>
        <input type="text" v-model="category.categoryId" class="form-control" id="categoryId" required/>
      </div>


      <div class="mb-3">
        <label for="categoryName" class="form-label">Category Name</label>
        <input type="text" v-model="category.categoryName" class="form-control" id="categoryName" required/>
      </div>


      <div class="button-group">
        <button type="submit" class="btn btn-primary">Add Category</button>
        <button type="button" class="btn btn-secondary" @click="goBack">Back to Admin Page</button>
      </div>
    </form>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      category: {
        categoryId: '',
        categoryName: ''
      }
    };
  },
  methods: {
    async addCategory() {
      try {
        const response = await axios.post('http://localhost:3000/api/productCategory/create', this.category);

        if (response.status === 200 || response.status === 201) {
          alert('Category added successfully!');
        } else {
          alert('Failed to add category. Please check the console for more details.');
        }
      } catch (error) {
        console.error('Error adding category:', error);
        alert('An error occurred while adding the category.');
      }
    },
    goBack() {
      this.$router.push('/AdminPage');
  }
  },
};
</script>

<style scoped>
.container {
  max-width: 600px;
}

.button-group {
  margin-top: 20px;
}

button {
  padding: 10px 15px;
  border: none;
  cursor: pointer;
}

button.btn-primary {
  background-color: #007bff;
  color: white;
}

button.btn-primary:hover {
  background-color: #0056b3;
}

button.btn-secondary {
  background-color: #6c757d;
  color: white;
  margin-left: 10px;
}

button.btn-secondary:hover {
  background-color: #5a6268;
}
</style>