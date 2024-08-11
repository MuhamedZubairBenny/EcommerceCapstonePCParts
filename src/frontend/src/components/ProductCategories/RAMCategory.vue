<template>
  <div>
    <h1>Memory/RAM Products</h1>
    <div class="product-list">
      <div v-for="product in RAMProducts" :key="product.id" class="product-item">
        <img :src="product.image" :alt="product.name" class="product-image" />
        <p>{{ product.name }}</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'RAMPage',
  data() {
    return {
      CpuProducts: [
        { id: 1, name: '16GB 3200Mhz Kit', image: require('@/assets/ramstick.png') },
        { id: 2, name: '32GB 3200Mhz Kit', image: require('@/assets/ramstick.png') },
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
