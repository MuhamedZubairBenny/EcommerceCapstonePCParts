<script setup>
import { ref } from 'vue';
import { useRouter } from 'vue-router';


const selectedSection = ref('');


const router = useRouter();


const navigateTo = (section) => {
  selectedSection.value = section;
  router.push({name: section});
};
</script>

<template>
  <div class="admin-container">
    <h1>Admin</h1>
    <div class="navigation">
      <div class="card">
        <h3>Manage Products</h3>
        <button @click="navigateTo('AddProducts')">Add Product</button>
        <button @click="navigateTo('DeleteProducts')">Delete Product</button>
        <button @click="navigateTo('UpdateProducts')">Update Product</button>
      </div>
      <div class="card">
        <h3>Manage Categories</h3>
        <button @click="navigateTo('AddCategory')">Add Product Category</button>
        <button @click="navigateTo('DeleteCategory')">Delete Product Category</button>
        <button @click="navigateTo('UpdateCategory')">Update Product Category</button>
      </div>
      <div class="card">
        <h3>Manage Brands</h3>
        <button @click="navigateTo('AddBrand')">Add Brand</button>
        <button @click="navigateTo('DeleteBrand')">Delete Brand</button>
        <button @click="navigateTo('UpdateBrand')">Update Brand</button>
      </div>
    </div>
    <router-view/>
  </div>
</template>

<style scoped>
.admin-container {
  padding: 30px;
  background: #f4f7f6;
  min-height: 100vh;
}

h1 {
  text-align: center;
  font-size: 2.5rem;
  color: #232f3e;
  margin: 30px 0;
  padding: 10px;
  background-color: #69feca;
  border-radius: 10px;
  text-transform: uppercase;
  box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
  letter-spacing: 1.5px;
  font-family: 'Orbitron', sans-serif;
}

.navigation {
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 20px;
}

.card {
  background: #fff;
  border-radius: 10px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  padding: 20px;
  width: 100%;
  max-width: 500px;
  text-align: center;
}

.card h3 {
  margin-bottom: 20px;
  font-size: 1.5em;
  color: #007bff;
}

button {
  display: block;
  width: 100%;
  padding: 12px;
  font-size: 16px;
  border: none;
  border-radius: 8px;
  cursor: pointer;
  background-color: #007bff;
  color: white;
  margin-bottom: 10px;
  transition: background-color 0.3s, transform 0.2s;
}

button:hover {
  background-color: #0056b3;
  transform: translateY(-2px);
}

button:active {
  background-color: #004494;
  transform: translateY(0);
}

@media (max-width: 600px) {
  .card {
    width: 100%;
    padding: 15px;
  }

  button {
    font-size: 14px;
  }
}
</style>