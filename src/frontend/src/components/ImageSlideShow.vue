<template>
  <Swiper
      :slides-per-view="1"
      :space-between="10"
      :pagination="{ clickable: true, el: '.swiper-pagination' }"
      :navigation="true"
      :loop="true"
      :autoplay="{ delay: 3000 }"
      class="mySwiper"
  >
    <SwiperSlide v-for="(image, index) in images" :key="index">
      <img :src="image.src" :alt="image.alt" class="slide-image" />
    </SwiperSlide>
    <!-- Add Swiper pagination and navigation elements -->
    <div class="swiper-pagination"></div>
    <div class="swiper-button-next"></div>
    <div class="swiper-button-prev"></div>
  </Swiper>
</template>

<script>
import { Swiper, SwiperSlide } from 'swiper/vue';
import 'swiper/swiper-bundle.css';
import SwiperCore, { Autoplay, Pagination, Navigation } from 'swiper';

SwiperCore.use([Autoplay, Pagination, Navigation]);

export default {
  name: 'ImageSlideShow',
  components: {
    Swiper,
    SwiperSlide,
  },
  data() {
    return {
      searchQuery: '',
      products: [],
      images: [
        {src: require('@/assets/ryzenslideshow.png'), alt: 'ryzen'},
        {src: require('@/assets/laptopslideshow.png'), alt: 'laptop'},
        {src: require('@/assets/alienware.png'), alt: 'alienware'},
        {src: require('@/assets/computerslideshow.png'), alt: 'computer'}
      ]
    };
  }
}
</script>

<style scoped>
.mySwiper {
  width: 100%;
  height: 800px; /* Adjust height as needed */
  position: relative;
}

.slide-image {
  width: 100%;
  height: 100%;
  object-fit: cover;
  transition: transform 0.5s ease-in-out; /* Smooth transition */
}

/* Customize Swiper navigation and pagination */
.swiper-button-next,
.swiper-button-prev {
  color: #fff; /* Change navigation button color */
  width: 50px;
  height: 50px;
  background: rgba(0, 0, 0, 0.5); /* Semi-transparent background */
  border-radius: 50%;
}

.swiper-button-next:hover,
.swiper-button-prev:hover {
  background: rgba(0, 0, 0, 0.8); /* Darker background on hover */
}

.swiper-pagination-bullet {
  background: #fff; /* Bullet color */
  opacity: 0.7; /* Bullet opacity */
}

.swiper-pagination-bullet-active {
  background: #febd69; /* Active bullet color */
  opacity: 1; /* Full opacity for active bullet */
}
</style>
