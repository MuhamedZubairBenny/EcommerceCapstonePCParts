<template>
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
</template>

<script>
import { Swiper, SwiperSlide } from 'swiper/vue';
import 'swiper/swiper-bundle.css';
import SwiperCore, { Autoplay, Pagination, Navigation } from 'swiper';

// Register Swiper modules
SwiperCore.use([Autoplay, Pagination, Navigation]);

export default {
  name: 'ImageSlideShow',
  components: {
    Swiper,
    SwiperSlide
  },
  data() {
    return {
      images: [
        { src: require('@/assets/gamingchair.png'), alt: 'Chair' },
        { src: require('@/assets/gpu.png'), alt: 'GPU' },
        { src: require('@/assets/keyboard.png'), alt: 'Keyboard' }
      ]
    };
  }
}
</script>

<style scoped>
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
