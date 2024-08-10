<template>
  <div>
    <h1>CPU Products</h1>
    <div class="product-list">
      <div v-for="product in CpuProducts" :key="product.id" class="product-item">
        <img :src="product.image" :alt="product.name" class="product-image" />
        <p>{{ product.name }}</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'CpuPage',
  data() {
    return {
      CpuProducts: [
        { id: 1, name: 'Intel i5', image: require('@/assets/cpuprocessor.png') },
        { id: 2, name: 'Intel i7', image: require('@/assets/cpuprocessor.png') },
        // Add more CPU products here
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
