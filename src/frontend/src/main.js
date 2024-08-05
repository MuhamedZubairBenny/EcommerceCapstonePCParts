// src/main.js
import { createApp } from 'vue';
import App from './App.vue';
import router from './router';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'swiper/swiper-bundle.css';

createApp(App)
    .use(router) // Use the router
    .mount('#app');