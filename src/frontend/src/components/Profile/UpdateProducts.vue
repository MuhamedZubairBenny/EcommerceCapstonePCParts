<template>
  <div class="container mt-5">
    <h2>Update Product</h2>
    <form @submit.prevent="updateProduct">
      <div class="mb-3">
        <label for="searchProductName" class="form-label">Search Product Name</label>
        <input type="text" v-model="searchQuery" class="form-control" id="searchProductName" @input="fetchProduct" placeholder="Enter product name" />
      </div>
      <div v-if="product">
        <div class="mb-3">
          <label for="productId" class="form-label">Product ID</label>
          <input type="text" v-model="product.productId" class="form-control" id="productId" readonly />
        </div>
        <div class="mb-3">
          <label for="productName" class="form-label">Product Name</label>
          <input type="text" v-model="product.productName" class="form-control" id="productName" required />
        </div>
        <div class="mb-3">
          <label for="category" class="form-label">Category ID</label>
          <input type="text" v-model="product.categoryId" class="form-control" id="category" readonly />
        </div>
        <div class="mb-3">
          <label for="brand" class="form-label">Brand ID</label>
          <input type="text" v-model="product.brandId" class="form-control" id="brand" readonly />
        </div>
        <div class="mb-3">
          <label for="description" class="form-label">Description</label>
          <textarea v-model="product.description" class="form-control" id="description"></textarea>
        </div>
        <div class="mb-3">
          <label for="price" class="form-label">Price</label>
          <input type="number" v-model="product.price" class="form-control" id="price" required />
        </div>
        <div class="mb-3">
          <label for="stockQuantity" class="form-label">Stock Quantity</label>
          <input type="number" v-model="product.stockQuantity" class="form-control" id="stockQuantity" required />
        </div>
        <div class="mb-3">
          <label for="dimension" class="form-label">Dimension</label>
          <input type="text" v-model="product.dimension" class="form-control" id="dimension" />
        </div>
        <div class="mb-3">
          <label for="warranty" class="form-label">Warranty</label>
          <input type="text" v-model="product.warranty" class="form-control" id="warranty" />
        </div>
        <div class="mb-3">
          <label for="productPicture" class="form-label">Product Picture URL</label>
          <input type="text" v-model="product.productPicture" class="form-control" id="productPicture" />
        </div>
        <button type="submit" class="btn btn-primary">Update Product</button>
      </div>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      searchQuery: '',
      product: null,
    };
  },
  methods: {
    async fetchProduct() {
      if (this.searchQuery.trim() === '') {
        this.product = null;
        return;
      }

      try {
        const response = await fetch(`http://localhost:3000/api/product/search/${this.searchQuery}`);
        const products = await response.json();

        if (products.length > 0) {
          this.product = products[0];
        } else {
          this.product = null;
        }
      } catch (error) {
        console.error('Error fetching product:', error);
      }
    },
    async updateProduct() {
      try {
        const response = await fetch('http://localhost:3000/api/product/update', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify(this.product),
        });

        if (response.ok) {
          alert('Product updated successfully!');
        } else {
          alert('Failed to update product.');
        }
      } catch (error) {
        console.error('Error updating product:', error);
        alert('An error occurred while updating the product.');
      }
    },
  },
};
</script>

<style>
.container {
  max-width: 600px;
}
</style>