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
    <a class="navbar-brand" href="#" @click="toggleAMDNav">
      <img src="@/assets/AMD.png" alt="AMD Components" class="navbar-image" />
    </a>
    <a class="navbar-brand" href="#" @click="toggleRyzenNav">
      <img src="@/assets/Ryzen.png" alt="Ryzen Components" class="navbar-image" />
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
          <a class="nav-link" href="#" @click="toggle3000SeriesNav">3000 series</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#" @click="toggle4000SeriesNav">4000 series</a>
        </li>
      </ul>
    </div>
    <div v-if="show3000SeriesNav" class="quaternary-navbar">
      <ul class="navbar-nav">
        <li class="nav-item">
          <router-link class="nav-link" to="/GPU">RTX 3090</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/GPU">RTX 3080</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/GPU">RTX 3070</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/GPU">RTX 3060</router-link>
        </li>
      </ul>
    </div>
    <div v-if="show4000SeriesNav" class="quaternary-navbar">
      <ul class="navbar-nav">
        <li class="nav-item">
          <router-link class="nav-link" to="/GPU">RTX 4090</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/GPU">RTX 4080</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/GPU">RTX 4070</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/GPU">RTX 4060</router-link>
        </li>
      </ul>
    </div>
    <div v-if="showAMDNav" class="AMD-navbar">
      <ul class="navbar-nav">
        <li class="nav-item">
          <router-link class="nav-link" to="/CPU">AMD Ryzen 9 Processors</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/CPU">AMD Ryzen 7 Processors</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/CPU">AMD Ryzen 5 Processors</router-link>
        </li>
      </ul>
    </div>
    <div v-if="showRyzenNav" class="Ryzen-navbar">
      <ul class="navbar-nav">
        <li class="nav-item">
          <router-link class="nav-link" to="/GPU">RX 7900 XTX </router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/GPU">RX 7900 XT </router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/GPU"> RX 7800 XT</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/GPU"> RX 7700 XT</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/GPU"> RX 7600 XT</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/GPU"> RX 7600 </router-link>
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
      showNvidiaNav: false,
      show3000SeriesNav: false,
      show4000SeriesNav: false,
      showAMDNav : false,
      showRyzenNav : false
    };
  },
  methods: {
    toggleIntelNav() {
      this.showIntelNav = !this.showIntelNav;
      this.showNvidiaNav = false;
      this.show3000SeriesNav = false;
      this.show4000SeriesNav = false;
      this.showAMDNav = false;
      this.showRyzenNav = false;
    },
    toggleNvidiaNav() {
      this.showNvidiaNav = !this.showNvidiaNav;
      this.showIntelNav = false;
      this.show3000SeriesNav = false;
      this.show4000SeriesNav = false;
      this.showAMDNav = false;
      this.showRyzenNav = false;
    },
    toggleAMDNav() {
      this.showAMDNav = !this.showAMDNav;
      this.showIntelNav = false;
      this.showNvidiaNav = false;
      this.show3000SeriesNav = false;
      this.show4000SeriesNav = false;
      this.showRyzenNav = false;
    },
    toggleRyzenNav() {
      this.showRyzenNav = !this.showRyzenNav;
      this.showIntelNav = false;
      this.showNvidiaNav = false;
      this.show3000SeriesNav = false;
      this.show4000SeriesNav = false;
      this.showAMDNav = false;
    },
    toggle3000SeriesNav() {
      this.show3000SeriesNav = !this.show3000SeriesNav;
    },
    toggle4000SeriesNav() {
      this.show4000SeriesNav = !this.show4000SeriesNav;
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

.secondary-navbar, .tertiary-navbar, .quaternary-navbar ,.AMD-navbar ,.Ryzen-navbar {
  position: absolute;
  top: 100%;
  left: 0;
  background-color: #f8f9fa; /* Match the bg-light color */
  width: 100%;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.secondary-navbar .nav-link, .tertiary-navbar .nav-link, .quaternary-navbar .nav-link , .AMD-navbar .nav-link, .Ryzen-navbar .nav-link {
  padding: 10px 20px;
}

.secondary-navbar .nav-item, .tertiary-navbar .nav-item, .quaternary-navbar .nav-item , .AMD-navbar .nav-link, .Ryzen-navbar .nav-link{
  border-bottom: 1px solid #dee2e6;
}
</style>