<!-- src/App.vue -->
<template>
  <div id="app">
    <Navigation @nav-toggle="handleNavToggle"/>
    <div :class="{ 'content-shift': isNavExpanded }">
      <router-view/>
    </div>
  </div>
</template>

<script>

import Navigation from './components/NavigationTool.vue';
import 'swiper/swiper-bundle.css';

export default {
  name: 'App',
  components: {
    Navigation
  },
  data() {
    return {
      isNavExpanded: false
    };
  },
  methods: {
    handleNavToggle(isExpanded) {
      this.isNavExpanded = isExpanded;
    }
  }
}
</script>

<style>
.content-shift {
  margin-top: 200px; /* Adjust this value based on the height of your expanded navbar */
}
</style>