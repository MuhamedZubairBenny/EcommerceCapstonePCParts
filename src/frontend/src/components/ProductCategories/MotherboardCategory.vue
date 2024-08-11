<template>
  <div>
    <h1>Motherboard Products</h1>
    <div class="product-list">
      <div v-for="product in MotherboardProducts" :key="product.id" class="product-item">
        <img :src="product.image" :alt="product.name" class="product-image" />
        <p>{{ product.name }}</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'MotherboardPage',
  data() {
    return {
      CpuProducts: [
        { id: 1, name: 'Aurus B450', image: require('@/assets/motherboard.png') },
        { id: 2, name: 'Aurus B550', image: require('@/assets/motherboard.png') },
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
