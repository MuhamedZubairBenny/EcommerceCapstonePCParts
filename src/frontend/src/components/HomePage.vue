<!-- src/components/HomePage.vue -->
<template>
  <div class="container mt-5">
    <h1 class="text-center">Welcome to the Home Page!</h1>
    <p class="text-muted text-center">This is where your homepage content goes.</p>
    <ImageSlideShow />
  </div>

</template>

<script>
import ImageSlideShow from "./ImageSlideShow.vue";
export default {
  name: 'HomePage',
  components: {
    ImageSlideShow,

  }
}

</script>

<style scoped>

</style>
