<template>
  <div>
    <h1>GPU Products</h1>
    <div class="product-list">
      <div v-for="product in gpuProducts" :key="product.id" class="product-item">
        <img :src="product.image" :alt="product.name" class="product-image" />
        <p>{{ product.name }}</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'GpuPage',
  data() {
    return {
      gpuProducts: [
        { id: 1, name: 'RTX 3080', image: require('@/assets/gpu.png') },
        { id: 2, name: 'RTX 3070', image: require('@/assets/gpu.png') },
        // Add more GPU products here
      ],
    };
  },
};
</script>

<style scoped>
.product-list {
  display: flex;
  flex-wrap: wrap;
}

.product-item {
  width: 200px;
  margin: 10px;
  text-align: center;
}

.product-image {
  width: 100%;
  height: auto;
}
</style>
