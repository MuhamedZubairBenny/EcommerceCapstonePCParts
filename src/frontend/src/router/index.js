// src/router/index.js
import { createRouter, createWebHistory } from 'vue-router'; // Import the correct functions
import HomePage from '@/components/HomePage.vue';
import HelloWorld from '@/components/CustomerTest.vue';
import GpuPage from '@/components/ProductCategories/GpuCategory.vue';
import CpuPage from '@/components/ProductCategories/CpuCategory.vue';
import IntelCoreI9 from '@/components/intel/IntelCoreI9.vue'
import IntelCoreI7 from '@/components/intel/IntelCoreI7.vue'
import IntelCoreI5 from '@/components/intel/IntelCoreI5.vue'
import IntelCoreI3 from '@/components/intel/IntelCoreI3.vue'
import RTX3060 from "@/components/nvidia/series3000/RTX3060.vue";
import RTX3070 from "@/components/nvidia/series3000/RTX3070.vue";
import RTX3080 from "@/components/nvidia/series3000/RTX3080.vue";
import RTX3090 from "@/components/nvidia/series3000/RTX3090.vue";
import RTX4060 from "@/components/nvidia/series4000/RTX4060.vue";
import RTX4070 from "@/components/nvidia/series4000/RTX4070.vue";
import RTX4080 from "@/components/nvidia/series4000/RTX4080.vue";
import RTX4090 from "@/components/nvidia/series4000/RTX4090.vue";
import AmdRyzen9 from "@/components/amd/AmdRyzen9.vue";
import AmdRyzen5 from "@/components/amd/AmdRyzen5.vue";
import AmdRyzen7 from "@/components/amd/AmdRyzen7.vue";
import RX7900XTX from "@/components/ryzen/RX7900XTX.vue";
import RX7900XT from "@/components/ryzen/RX7900XT.vue";
import RX7800XT from "@/components/ryzen/RX7800XT.vue";
import RX7700XT from "@/components/ryzen/RX7700XT.vue";
import RX7600XT from "@/components/ryzen/RX7600XT.vue";
import RX7600 from "@/components/ryzen/RX7600.vue";
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

//*****************************************************
//Intel CPU Pages
//*****************************************************

        {
            path: '/i9',
            name: 'IntelCoreI9',
            component: IntelCoreI9
        },
        {
            path: '/i7',
            name: 'IntelCoreI7',
            component: IntelCoreI7
        },
        {
            path: '/i5',
            name: 'IntelCoreI5',
            component: IntelCoreI5
        },
        {
            path: '/i3',
            name: 'IntelCoreI3',
            component: IntelCoreI3
        },

//*****************************************************
//Nvidia GPU
//*****************************************************


//*****************************************************
//3000 series
//*****************************************************

        {
            path: '/RTX3090',
            name: 'RTX3090',
            component: RTX3090
        },
        {
            path: '/RTX3080',
            name: 'RTX3080',
            component: RTX3080
        },
        {
            path: '/RTX3070',
            name: 'RTX3070',
            component: RTX3070
        },
        {
            path: '/RTX3060',
            name: 'RTX3060',
            component: RTX3060
        },

//*****************************************************
//4000 series
//*****************************************************

        {
            path: '/RTX4090',
            name: 'RTX4090',
            component: RTX4090
        },
        {
            path: '/RTX4080',
            name: 'RTX4080',
            component: RTX4080
        },
        {
            path: '/RTX4070',
            name: 'RTX4070',
            component: RTX4070
        },
        {
            path: '/RTX4060',
            name: 'RTX4060',
            component: RTX4060
        },

//*****************************************************
//AMD CPU Pages
//*****************************************************

        {
            path: '/AmdRyzen9',
            name: 'AmdRyzen9',
            component: AmdRyzen9
        },
        {
            path: '/AmdRyzen7',
            name: 'AmdRyzen7',
            component: AmdRyzen7
        },
        {
            path: '/AmdRyzen5',
            name: 'AmdRyzen5',
            component: AmdRyzen5
        },

//*****************************************************
//Ryzen GPU
//*****************************************************

        {
            path: '/RX7900XTX',
            name: 'RX7900XTX',
            component: RX7900XTX
        },
        {
            path: '/RX7900XT',
            name: 'RX7900XT',
            component: RX7900XT
        },
        {
            path: '/RX7800XT',
            name: 'RX7800XT',
            component: RX7800XT
        },
        {
            path: '/RX7700XT',
            name: 'RX7700XT',
            component: RX7700XT
        },
        {
            path: '/RX7600XT',
            name: 'RX7600XT',
            component: RX7600XT
        },
        {
            path: '/RX7600',
            name: 'RX7600',
            component: RX7600
        },
        //*****************************************************
// GPU Page
//*****************************************************
        {
            path: '/gpu',
            name: 'GpuPage',
            component: GpuPage
        },
        //*****************************************************
// CPU Page
//*****************************************************
        {
            path: '/cpu',
            name: 'CpuPage',
            component: CpuPage
        }
    ]
});

export default router; // Export the router instance
