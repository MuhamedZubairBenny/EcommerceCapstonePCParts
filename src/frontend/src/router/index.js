// src/router/index.js
import { createRouter, createWebHistory } from 'vue-router'; // Import the correct functions
import HomePage from '@/components/HomePage.vue';
import HelloWorld from '@/components/HelloWorld.vue';

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
            path: '/hello',
            name: 'HelloWorld',
            component: HelloWorld
        }
    ]
});

export default router; // Export the router instance
