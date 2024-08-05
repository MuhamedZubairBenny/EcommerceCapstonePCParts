// src/router/index.js
import { createRouter, createWebHistory } from 'vue-router'; // Import the correct functions
import HomePage from '@/components/HomePage.vue';
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
            path: '/Customer',
            name: 'CustomerTest',
            component: CustomerTest
        }
    ]
});

export default router; // Export the router instance
