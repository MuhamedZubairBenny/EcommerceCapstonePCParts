<template>
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <nav class="navbar-nav">
        <li class="nav-item active">
          <a class="nav-link" href="/Home">Home</a>
        </li>
        <li class="nav-item active">
          <a class="nav-link" href="/Customer">Customer</a>
        </li>
      </nav>
    </div>
  </nav>
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#" @click="toggleIntelNav">
      <img src="@/assets/Intel.png" alt="Intel Components" class="navbar-image" />
    </a>
    <a class="navbar-brand" href="#" @click="toggleNvidiaNav">
      <img src="@/assets/Nvidia.png" alt="Nvidia Components" class="navbar-image" />
    </a>
    <div v-if="showIntelNav" class="secondary-navbar">
      <ul class="navbar-nav">
        <li class="nav-item">
          <router-link class="nav-link" to="/CPU">Intel Core i9 Processors</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/CPU">Intel Core i7 Processors</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/CPU">Intel Core i5 Processors</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/CPU">Intel Core i3 Processors</router-link>
        </li>
      </ul>
    </div>
    <div v-if="showNvidiaNav" class="tertiary-navbar">
      <ul class="navbar-nav">
        <li class="nav-item">
          <router-link class="nav-link" to="/GPU">3000 series</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/GPU">4000 series</router-link>
        </li>
      </ul>
    </div>
  </nav>
</template>

<script>
export default {
  name: 'NavbarTool',
  data() {
    return {
      showIntelNav: false,
      showNvidiaNav: false
    };
  },
  methods: {
    toggleIntelNav() {
      this.showIntelNav = !this.showIntelNav;
      this.showNvidiaNav = false; // Hide Nvidia nav when Intel nav is shown
    },
    toggleNvidiaNav() {
      this.showNvidiaNav = !this.showNvidiaNav;
      this.showIntelNav = false; // Hide Intel nav when Nvidia nav is shown
    }
  }
}
</script>

<style scoped>
.navbar {
  position: relative;
  padding: 0;
}

.navbar-image {
  width: 100px; /* Adjust width as needed */
  cursor: pointer;
  margin-right: 10px; /* Add space between images */
}

.secondary-navbar, .tertiary-navbar {
  position: absolute;
  top: 100%;
  left: 0;
  background-color: #f8f9fa; /* Match the bg-light color */
  width: 100%;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.secondary-navbar .nav-link, .tertiary-navbar .nav-link {
  padding: 10px 20px;
}

.secondary-navbar .nav-item, .tertiary-navbar .nav-item {
  border-bottom: 1px solid #dee2e6;
}
</style>