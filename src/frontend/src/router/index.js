// src/router/index.js
import { createRouter, createWebHistory } from 'vue-router'; // Import the correct functions
import HomePage from '@/components/HomePage.vue';
import IntelCoreI9 from '@/components/IntelCoreI9.vue'
import CustomerTest from "@/components/CustomerTest.vue";


// Create a router instance
const router = createRouter({
    history: createWebHistory(), // Use createWebHistory for Vue 3
    routes: [
        {
            path: '/Home',
            name: 'HomePage',
            component: HomePage
        },
        {
            path: '/CPU',
            name: 'IntelCoreI9',
            component: IntelCoreI9
        },
        {
            path: '/CustomerTest',
            name: 'CustomerTest',
            component: CustomerTest
        }
        ]
});

export default router; // Export the router instance
