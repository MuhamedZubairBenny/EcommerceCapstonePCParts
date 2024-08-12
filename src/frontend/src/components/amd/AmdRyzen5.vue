<script setup>

</script>

<template>
  <div>
    <h1>AMD Ryzen 5 Processors</h1>
    <p>List of Ryzen Products</p>
  </div>
</template>

<script>
export default {
  name: 'AmdRyzen5',
  data(){
    return{
      products: []
    }
  },
  mounted() {
    this.fetchData();
  },
  methods: {
    fetchData() {
      fetch("/api/product/getall")
          .then((response) => response.json()) // Assuming the response is JSON
          .then((data) => {
            this.products = data; // Store fetched data
          })
          .catch((error) => {
            console.error('Error fetching data:', error);
          });
    }
  }
}
</script>

<style scoped>
/* Add your styles here */
</style>
