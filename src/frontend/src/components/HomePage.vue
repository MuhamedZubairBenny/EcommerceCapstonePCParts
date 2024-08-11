<template>
  <div class="slideshow-container">
    <!-- Navbar for Categories -->
    <nav class="category-navbar">
      <ul>
        <router-link
            v-for="(category, index) in categories"
            :key="index"
            :to="`/${category.name.toLowerCase()}`"
        class="category-item"
        >
        <img :src="category.image.src" :alt="category.image.alt" class="category-image" />
        <span class="category-name">{{ category.name }}</span>
        </router-link>
      </ul>
    </nav>

    <!-- Slideshow -->
    <Swiper
        :slides-per-view="1"
        :space-between="10"
        :pagination="{ clickable: true }"
        :navigation="true"
        :loop="true"
        :autoplay="{ delay: 5000 }"
        class="mySwiper"
    >
      <SwiperSlide v-for="(image, index) in images" :key="index">
        <img :src="image.src" :alt="image.alt" class="slide-image" />
      </SwiperSlide>
    </Swiper>
  </div>
</template>

<script>
import { Swiper, SwiperSlide } from 'swiper/vue';
import 'swiper/swiper-bundle.css'; // Importing all Swiper styles in one go
import SwiperCore, { Autoplay, Pagination, Navigation } from 'swiper';

// Register Swiper modules globally
SwiperCore.use([Autoplay, Pagination, Navigation]);

export default {
  name: 'ImageSlideShow',
  components: {
    Swiper,
    SwiperSlide,
  },
  data() {
    return {
      images: [
        { src: require('@/assets/gamingchair.png'), alt: 'Chair' },
        { src: require('@/assets/gpu.png'), alt: 'GPU' },
        { src: require('@/assets/keyboard.png'), alt: 'Keyboard' },
      ],
      categories: [
        { name: 'CPU', image: { src: require('@/assets/cpuprocessor.png'), alt: 'CPU' } },
        { name: 'GPU', image: { src: require('@/assets/gpu.png'), alt: 'GPU' } },
        { name: 'Motherboard', image: { src: require('@/assets/motherboard.png'), alt: 'Motherboard' } },
        { name: 'RAM', image: { src: require('@/assets/ramstick.png'), alt: 'RAM' } },
        { name: 'Storage', image: { src: require('@/assets/storage.png'), alt: 'Storage' } },
        { name: 'PSU', image: { src: require('@/assets/psu.png'), alt: 'PSU' } },
        { name: 'Case', image: { src: require('@/assets/case.png'), alt: 'Case' } },
        { name: 'Peripherals', image: { src: require('@/assets/peripherals.png'), alt: 'Peripherals' } },
        { name: 'Monitors', image: { src: require('@/assets/monitor.png'), alt: 'Monitors' } },
        { name: 'Cooling', image: { src: require('@/assets/cooler.png'), alt: 'Cooling' } },
      ],
    };
  },
};
</script>

<style scoped>
.slideshow-container {
  width: 100%;
}

.category-navbar {
  display: flex;
  justify-content: center;
  margin-bottom: 15px;
}

.category-navbar ul {
  list-style: none;
  display: flex;
  padding: 0;
}

.category-item {
  margin: 0 10px;
  text-align: center;
  text-decoration: none; /* Remove underline from links */
}

.category-image {
  width: 50px; /* Adjust size as needed */
  height: 50px;
  object-fit: contain;
  margin-bottom: 5px;
}

.category-name {
  font-size: 14px;
  font-weight: bold;
  color: #333;
}

.mySwiper {
  width: 100%;
  height: 300px; /* Adjust height as needed */
}

.slide-image {
  width: 100%;
  height: 100%; /* Ensure the image covers the slide */
  object-fit: cover; /* Adjusts image fit */
}
</style>
