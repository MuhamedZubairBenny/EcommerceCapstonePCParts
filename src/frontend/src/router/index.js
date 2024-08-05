// src/router/index.js
import { createRouter, createWebHistory } from 'vue-router'; // Import the correct functions
import HomePage from '@/components/HomePage.vue';
import HelloWorld from '@/components/HelloWorld.vue';
import IntelCoreI9 from '@/components/IntelCoreI9.vue'

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
        },


        {
            path: '/CPU',
            name: 'IntelCoreI9',
            component: IntelCoreI9
        }
        ]
});

export default router; // Export the router instance
