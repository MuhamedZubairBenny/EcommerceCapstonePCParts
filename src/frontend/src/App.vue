<!-- src/App.vue -->
<template>
  <div id="app">
    <Navigation />
    <router-view/>
  </div>
</template>

<script>
import Navigation from './components/NavigationTool.vue';
import 'swiper/swiper-bundle.css';

export default {
  name: 'App',
  components: {
    Navigation
  }
}
</script>

<style>
/* Global styles here */
</style>
