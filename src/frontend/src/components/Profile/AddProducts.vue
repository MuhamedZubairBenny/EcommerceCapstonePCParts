<template>
  <div class="container mt-5">
    <h2>Add New Product</h2>
    <form @submit.prevent="addProduct">
      <div class="mb-3">
        <label for="productId" class="form-label">Product ID</label>
        <input type="text" v-model="product.productId" class="form-control" id="productId" required />
      </div>
      <div class="mb-3">
        <label for="productName" class="form-label">Product Name</label>
        <input type="text" v-model="product.productName" class="form-control" id="productName" required />
      </div>
      <div class="mb-3">
        <label for="category" class="form-label">Category ID</label>
        <input type="text" v-model="product.categoryId" class="form-control" id="category" required />
      </div>
      <div class="mb-3">
        <label for="brand" class="form-label">Brand ID</label>
        <input type="text" v-model="product.brandId" class="form-control" id="brand" required />
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
      <button type="submit" class="btn btn-primary">Add Product</button>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      product: {
        productId: '',
        productName: '',
        categoryId: '',
        brandId: '',
        description: '',
        price: 0,
        stockQuantity: 0,
        dimension: '',
        warranty: '',
        productPicture: ''
      }
    };
  },
  methods: {
    async addProduct() {
      try {
        // Structure data according to backend expectations
        const productData = {
          productId: this.product.productId,
          productName: this.product.productName,
          category: { categoryId: this.product.categoryId },
          brand: { brandId: this.product.brandId },
          description: this.product.description,
          price: this.product.price,
          stockQuantity: this.product.stockQuantity,
          dimension: this.product.dimension,
          warranty: this.product.warranty,
          productPicture: this.product.productPicture
        };

        const response = await fetch('http://localhost:3000/api/product/create', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify(productData)
        });

        if (response.ok) {
          alert('Product added successfully!');
          this.$router.push('/');
        } else {
          const errorData = await response.json();
          console.error('Server Error:', errorData);
          alert('Failed to add product. Please check the console for more details.');
        }
      } catch (error) {
        console.error('Error adding product:', error);
        alert('An error occurred while adding the product.');
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