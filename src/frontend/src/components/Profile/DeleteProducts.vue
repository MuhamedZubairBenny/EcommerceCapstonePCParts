<template>
  <div class="container mt-5">
    <h2>Delete Product</h2>
    <form @submit.prevent="deleteProduct">
      <div class="mb-3">
        <label for="productId" class="form-label">Product ID</label>
        <input type="text" v-model="productId" class="form-control" id="productId" required />
      </div>
      <button type="submit" class="btn btn-danger">Delete Product</button>
    </form>
  </div>
</template>

<script>
export default {

  data() {
    return {
      productId: '',
    };
  },
  methods: {
    async deleteProduct() {
      if (!confirm("Are you sure you want to delete this product?")) {
        return;
      }

      try {
        const response = await fetch(`http://localhost:3000/api/product/delete/${this.productId}`, {
          method: 'DELETE',
        });

        if (response.ok) {
          alert('Product deleted successfully!');
          this.productId = '';
        } else {
          alert('Failed to delete product.');
        }
      } catch (error) {
        console.error('Error deleting product:', error);
        alert('An error occurred while deleting the product.');
      }
    }
  }
};
</script>

<style>
.container {
  max-width: 600px;
}
</style>