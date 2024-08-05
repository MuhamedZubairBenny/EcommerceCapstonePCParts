<!-- src/App.vue -->
<template>
  <div id="app">
    <Navigation />
    <router-view/>
  </div>
</template>

<script>
import Navigation from './components/NavigationTool.vue';

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
