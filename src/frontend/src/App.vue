<template>
  <div id="app">
    <Navigation v-if="!isExcludedPage" @nav-toggle="handleNavToggle" />
    <div :class="{ 'content-shift': isNavExpanded && !isExcludedPage }">
      <router-view />
    </div>
  </div>
</template>

<script>
import Navigation from './components/NavigationTool.vue';
import { computed } from 'vue';
import { useRoute } from 'vue-router';

export default {
  name: 'App',
  components: {
    Navigation
  },
  setup() {
    const route = useRoute();
    const isExcludedPage = computed(() => ['/login', '/register'].includes(route.path));

    return {
      isExcludedPage
    };
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
  margin-top: 200px;
}
</style>
