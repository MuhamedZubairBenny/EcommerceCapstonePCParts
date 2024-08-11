<template>
  <div class="header-container">
    <div class="header-content">
      <a class="navbar-brand" href="#" @click="toggleMainNav">
        <img src="@/assets/icon.png" alt="Home" class="navbar-image" />
      </a>
      <h1 class="website-heading">Computer Components</h1>
      <input
          type="text"
          placeholder="Search..."
          class="search-bar"
          v-model="searchQuery"
          @keyup.enter="handleSearch"
      />
    </div>

    <div v-if="showMainNav" class="main-navbar">
      <ul class="navbar-nav">
        <li class="nav-item">
          <router-link class="nav-link" to="/cart">Cart</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/account">Account Information</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/payment">Payment Options</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/address">Address</router-link>
        </li>
      </ul>
    </div>

    <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <a class="navbar-brand" href="/">
        <img src="@/assets/home.png" alt="Home" class="navbar-image" />
      </a>
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
            <router-link class="nav-link" to="/i9">Intel Core i9 Processors</router-link>
          </li>
          <li class="nav-item">
            <router-link class="nav-link" to="/i7">Intel Core i7 Processors</router-link>
          </li>
          <li class="nav-item">
            <router-link class="nav-link" to="/i5">Intel Core i5 Processors</router-link>
          </li>
          <li class="nav-item">
            <router-link class="nav-link" to="/i3">Intel Core i3 Processors</router-link>
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
            <router-link class="nav-link" to="/RTX3090">RTX 3090</router-link>
          </li>
          <li class="nav-item">
            <router-link class="nav-link" to="/RTX3080">RTX 3080</router-link>
          </li>
          <li class="nav-item">
            <router-link class="nav-link" to="/RTX3070">RTX 3070</router-link>
          </li>
          <li class="nav-item">
            <router-link class="nav-link" to="/RTX3060">RTX 3060</router-link>
          </li>
        </ul>
      </div>
      <div v-if="show4000SeriesNav" class="quaternary-navbar">
        <ul class="navbar-nav">
          <li class="nav-item">
            <router-link class="nav-link" to="/RTX4090">RTX 4090</router-link>
          </li>
          <li class="nav-item">
            <router-link class="nav-link" to="/RTX4080">RTX 4080</router-link>
          </li>
          <li class="nav-item">
            <router-link class="nav-link" to="/RTX4070">RTX 4070</router-link>
          </li>
          <li class="nav-item">
            <router-link class="nav-link" to="/RTX4060">RTX 4060</router-link>
          </li>
        </ul>
      </div>
      <div v-if="showAMDNav" class="AMD-navbar">
        <ul class="navbar-nav">
          <li class="nav-item">
            <router-link class="nav-link" to="/AmdRyzen9">AMD Ryzen 9 Processors</router-link>
          </li>
          <li class="nav-item">
            <router-link class="nav-link" to="/AmdRyzen7">AMD Ryzen 7 Processors</router-link>
          </li>
          <li class="nav-item">
            <router-link class="nav-link" to="/AmdRyzen5">AMD Ryzen 5 Processors</router-link>
          </li>
        </ul>
      </div>
      <div v-if="showRyzenNav" class="Ryzen-navbar">
        <ul class="navbar-nav">
          <li class="nav-item">
            <router-link class="nav-link" to="/RX7900XTX">RX 7900 XTX</router-link>
          </li>
          <li class="nav-item">
            <router-link class="nav-link" to="/RX7900XT">RX 7900 XT</router-link>
          </li>
          <li class="nav-item">
            <router-link class="nav-link" to="/RX7800XT">RX 7800 XT</router-link>
          </li>
          <li class="nav-item">
            <router-link class="nav-link" to="/RX7700XT">RX 7700 XT</router-link>
          </li>
          <li class="nav-item">
            <router-link class="nav-link" to="/RX7600XT">RX 7600 XT</router-link>
          </li>
          <li class="nav-item">
            <router-link class="nav-link" to="/RX7600">RX 7600</router-link>
          </li>
        </ul>
      </div>
    </nav>
  </div>
</template>

<script>
export default {
  name: 'NavbarTool',
  data() {
    return {
      showMainNav: false,
      showIntelNav: false,
      showNvidiaNav: false,
      show3000SeriesNav: false,
      show4000SeriesNav: false,
      showAMDNav: false,
      showRyzenNav: false,
      searchQuery: '',
    };
  },
  methods: {
    toggleMainNav() {
      this.showMainNav = !this.showMainNav;
      if (this.showMainNav) {
        this.showIntelNav = false;
        this.showNvidiaNav = false;
        this.show3000SeriesNav = false;
        this.show4000SeriesNav = false;
        this.showAMDNav = false;
        this.showRyzenNav = false;
      }
    },
    toggleIntelNav() {
      this.showIntelNav = !this.showIntelNav;
      if (this.showIntelNav) {
        this.showMainNav = false;
        this.showNvidiaNav = false;
        this.show3000SeriesNav = false;
        this.show4000SeriesNav = false;
        this.showAMDNav = false;
        this.showRyzenNav = false;
      }
    },
    toggleNvidiaNav() {
      this.showNvidiaNav = !this.showNvidiaNav;
      if (this.showNvidiaNav) {
        this.showMainNav = false;
        this.showIntelNav = false;
        this.show3000SeriesNav = false;
        this.show4000SeriesNav = false;
        this.showAMDNav = false;
        this.showRyzenNav = false;
      }
    },
    toggleAMDNav() {
      this.showAMDNav = !this.showAMDNav;
      if (this.showAMDNav) {
        this.showMainNav = false;
        this.showIntelNav = false;
        this.showNvidiaNav = false;
        this.show3000SeriesNav = false;
        this.show4000SeriesNav = false;
        this.showRyzenNav = false;
      }
    },
    toggleRyzenNav() {
      this.showRyzenNav = !this.showRyzenNav;
      if (this.showRyzenNav) {
        this.showMainNav = false;
        this.showIntelNav = false;
        this.showNvidiaNav = false;
        this.show3000SeriesNav = false;
        this.show4000SeriesNav = false;
        this.showAMDNav = false;
      }
    },
    toggle3000SeriesNav() {
      this.show3000SeriesNav = !this.show3000SeriesNav;
      if (this.show3000SeriesNav) {
        this.show4000SeriesNav = false;
      }
    },
    toggle4000SeriesNav() {
      this.show4000SeriesNav = !this.show4000SeriesNav;
      if (this.show4000SeriesNav) {
        this.show3000SeriesNav = false;
      }
    },
    handleSearch() {
      const query = this.searchQuery.trim().toLowerCase();

      //// Nvidia 3000s series searchbar
      if (query.includes('3060') || query.includes('rtx3060')) {
        this.$router.push('/RTX3060');
      } else if (query.includes('3070') || query.includes('rtx3070')) {
        this.$router.push('/RTX3070');
      } else if (query.includes('3080') || query.includes('rtx3080')) {
        this.$router.push('/RTX3080');
      } else if (query.includes('3090') || query.includes('rtx3090')) {
        this.$router.push('/RTX3090');

        //// Nvidia 4000s series searchbar
      } else if (query.includes('4060') || query.includes('rtx4060')) {
        this.$router.push('/RTX4060');
      } else if (query.includes('4070') || query.includes('rtx4070')) {
        this.$router.push('/RTX4070');
      } else if (query.includes('4080') || query.includes('rtx4080')) {
        this.$router.push('/RTX4080');
      } else if (query.includes('4090') || query.includes('rtx4090')) {
        this.$router.push('/RTX4090');

        // Intel CPU searchbar
      } else if (query.includes('i3') || query.includes('intel core i3')) {
        this.$router.push('/i3');
      } else if (query.includes('i5') || query.includes('intel core i5')) {
        this.$router.push('/i5');
      } else if (query.includes('i7') || query.includes('intel core i7')) {
        this.$router.push('/i7');
      } else if (query.includes('i9') || query.includes('intel core i9')) {
        this.$router.push('/i9');

        // AMD searchbar
      } else if (query.includes('AmdRyzen5') || query.includes('ryzen5')) {
        this.$router.push('/AmdRyzen5');
      } else if (query.includes('AmdRyzen7') || query.includes('ryzen7')) {
        this.$router.push('/AmdRyzen7');
      } else if (query.includes('AmdRyzen9') || query.includes('ryzen9')) {
        this.$router.push('/AmdRyzen9');

        //Ryzen searchbar
        // AMD RX searchbar
        // AMD RX searchbar
      } else if (query.includes('rx7900xtx') || query.includes('7900xtx')) {
        this.$router.push('/RX7900XTX');
      } else if (query.includes('rx7900xt') || query.includes('7900xt')) {
        this.$router.push('/RX7900XT');
      } else if (query.includes('rx7800xt') || query.includes('7800xt')) {
        this.$router.push('/RX7800XT');
      } else if (query.includes('rx7700xt') || query.includes('7700xt')) {
        this.$router.push('/RX7700XT');
      } else if (query.includes('rx7600xt') || query.includes('7600xt')) {
        this.$router.push('/RX7600XT');
      } else if (query.includes('rx7600') || query.includes('7600')) {
        this.$router.push('/RX7600');
      }else{
        this.$router.push(`/search?query=${query}`);
      }
    }
    }
  }
</script>

<style scoped>
.header-content {
  display: flex;
  justify-content: center;
  align-items: center;
  margin-bottom: 10px;
  position: relative; /* Allow absolute positioning for the search bar */
}

.website-heading {
  margin: 0;
  font-size: 2rem;
  font-weight: bold;
  color: #333;
  text-align: center;
  flex-grow: 1; /* Ensures the heading takes up as much space as possible */
}


.website-heading {
  margin: 0;
  font-size: 2rem;
  font-weight: bold;
  color: #333;
  align: center;
}

.search-bar {
  padding: 5px;
  font-size: 1rem;
  border-radius: 4px;
  border: 1px solid #ccc;
  width: 300px;
}

.navbar {
  position: relative;
  padding: 0;
}

.navbar-image {
  width: 100px;
  cursor: pointer;
  margin-right: 10px;
}

.secondary-navbar, .tertiary-navbar, .quaternary-navbar, .AMD-navbar, .Ryzen-navbar {
  position: absolute;
  top: 100%;
  left: 0;
  background-color: #f8f9fa;
  width: 100%;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  z-index: 1000;
}

.secondary-navbar .nav-link, .tertiary-navbar .nav-link, .quaternary-navbar .nav-link, .AMD-navbar .nav-link, .Ryzen-navbar .nav-link {
  padding: 10px 20px;
}

.secondary-navbar .nav-item, .tertiary-navbar .nav-item, .quaternary-navbar .nav-item, .AMD-navbar .nav-link, .Ryzen-navbar .nav-link {
  border-bottom: 1px solid #dee2e6;
}

</style>
