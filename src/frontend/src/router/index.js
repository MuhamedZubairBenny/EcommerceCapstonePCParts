// src/router/index.js
import { createRouter, createWebHistory } from 'vue-router'; // Import the correct functions
import HomePage from '@/components/HomePage.vue';
import HelloWorld from '@/components/CustomerTest.vue';
import GpuPage from '@/components/ProductCategories/GpuCategory.vue';
import CpuPage from '@/components/ProductCategories/CpuCategory.vue';
import MotherboardPage from '@/components/ProductCategories/MotherboardCategory.vue';
import RAMPage from '@/components/ProductCategories/RAMCategory.vue'
import StoragePage from '@/components/ProductCategories/StorageCategory.vue'
import MonitorPage from '@/components/ProductCategories/MonitorCategory.vue'
import PSUPage from '@/components/ProductCategories/PSUCategory.vue'
import CoolingPage from '@/components/ProductCategories/CoolingCategory.vue'
import PeripheralPage from '@/components/ProductCategories/PeripheralCategory.vue'
import CasePage from '@/components/ProductCategories/CaseCategory.vue'
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
import AccountInformation from "@/components/Profile/AccountInformation.vue";
import Cart from "@/components/Profile/Cart.vue";
import ShippingAddress from "@/components/Profile/ShippingAddress.vue";
import Payment from "@/components/Profile/Payment.vue";
import I312100F from '@/components/intel/I3Processors/i3-12100F.vue';
import I314100 from "@/components/intel/I3Processors/i3-14100.vue";
import I314100F from "@/components/intel/I3Processors/i3-14100F.vue";
import I514600KF from "@/components/intel/I5Processors/i5-14600KF.vue";
import I514600K from "@/components/intel/I5Processors/i5-14600K.vue";
import I514500 from "@/components/intel/I5Processors/i5-14500.vue";
import I514400F from "@/components/intel/I5Processors/i5-14400F.vue";
import I514400 from "@/components/intel/I5Processors/i5-14400.vue";
import I512400F from "@/components/intel/I5Processors/i5-12400F.vue";
import I712700F from "@/components/intel/I7Processors/i7-12700F.vue";
import I714700 from "@/components/intel/I7Processors/i7-14700.vue";
import I714700F from "@/components/intel/I7Processors/i7-14700F.vue";
import I714700K from "@/components/intel/I7Processors/i7-14700K.vue";
import I714700KF from "@/components/intel/I7Processors/i7-14700KF.vue";
import I914900 from "@/components/intel/I9Processors/i9-14900.vue";
import I914900F from "@/components/intel/I9Processors/i9-14900F.vue";
import I914900K from "@/components/intel/I9Processors/i9-14900K.vue";
import I914900KF from "@/components/intel/I9Processors/i9-14900KF.vue";
import Ryzen5600X from "@/components/amd/Ryzen5Processors/5600X.vue";
import Ryzen8400F from "@/components/amd/Ryzen5Processors/8400F.vue";
import Ryzen5500GT from "@/components/amd/Ryzen5Processors/5500GT.vue";
import Ryzen8600G from "@/components/amd/Ryzen5Processors/8600G.vue";
import Ryzen9600X from "@/components/amd/Ryzen5Processors/9600X.vue";
import Ryzen5700 from "@/components/amd/Ryzen7Processors/5700.vue";
import Ryzen8700F from "@/components/amd/Ryzen7Processors/8700F.vue";
import Ryzen5800XT from "@/components/amd/Ryzen7Processors/5800XT.vue";
import Ryzen8700G from "@/components/amd/Ryzen7Processors/8700G.vue";
import Ryzen9700X from "@/components/amd/Ryzen7Processors/9700X.vue";

// Create a router instance
const router = createRouter({
    history: createWebHistory(), // Use createWebHistory for Vue 3
    routes: [
        {
            path: '/',
            name: 'HomePage',
            component: HomePage
        },
        {
            path: '/hello',
            name: 'HelloWorld',
            component: HelloWorld
        },
//*****************************************************
//Profile Information
//*****************************************************
        {
            path: '/account',
            name: 'AccountInformation',
            component: AccountInformation
        },
        {
            path: '/cart',
            name: 'ProductCart',
            component: Cart
        },

        {
            path: '/payment',
            name: 'PaymentOption',
            component: Payment
        },
        {
            path: '/address',
            name: 'ShippingAddress',
            component: ShippingAddress
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
        // Product Categories
        //*****************************************************

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
        },
        //*****************************************************
        // MotherBoard Page
        //*****************************************************
        {
            path: '/motherboard',
            name: 'MotherboardPage',
            component: MotherboardPage
        },
        //*****************************************************
        // RAM Page
        //*****************************************************
        {
            path: '/ram',
            name: 'RAMPage',
            component: RAMPage
        },

        //*****************************************************
        // Storage Page
        //*****************************************************
        {
            path: '/storage',
            name: 'StoragePage',
            component: StoragePage
        },

        //*****************************************************
        // Monitor Page
        //*****************************************************
        {
            path: '/monitors',
            name: 'MonitorPage',
            component: MonitorPage
        },

        //*****************************************************
        // PSU Page
        //*****************************************************
        {
            path: '/psu',
            name: 'PSUPage',
            component: PSUPage
        },

        //*****************************************************
        // Peripheral Page
        //*****************************************************
        {
            path: '/peripherals',
            name: 'PeripheralPage',
            component: PeripheralPage
        },

        //*****************************************************
        // Cooling Page
        //*****************************************************
        {
            path: '/cooling',
            name: 'CoolingPage',
            component: CoolingPage
        },

        //*****************************************************
        // Case Page
        //*****************************************************
        {
            path: '/case',
            name: 'CasePage',
            component: CasePage
        },

        //*****************************************************
        // I3Processors Page
        //*****************************************************

        {
            path: '/intel/i3processors/i3-12100f',
            name: 'I312100F',
            component: I312100F,
        },
        {
            path: '/intel/i3processors/i3-14100',
            name: 'I314100',
            component: I314100,
        },
        {
            path: '/intel/i3processors/i3-14100f',
            name: 'I314100F',
            component: I314100F,
        },

        //*****************************************************
        // I5Processors Page
        //*****************************************************
        {
            path: '/intel/i5processors/i5-14600kf',
            name: 'I514600KF',
            component: I514600KF,
        },
        {
            path: '/intel/i5processors/i5-14600k',
            name: 'I514600K',
            component: I514600K,
        },
        {
            path: '/intel/i5processors/i5-14500',
            name: 'I514500',
            component: I514500,
        },
        {
            path: '/intel/i5processors/i5-14400f',
            name: 'I514400F',
            component: I514400F,
        },
        {
            path: '/intel/i5processors/i5-14400',
            name: 'I514400',
            component: I514400,
        },
        {
            path: '/intel/i5processors/i5-12400f',
            name: 'I512400F',
            component: I512400F,
        },

        //*****************************************************
        // I7Processors Page
        //*****************************************************
        {
            path: '/intel/i7processors/i7-12700f',
            name: 'I712700F',
            component: I712700F,
        },
        {
            path: '/intel/i7processors/i7-14700',
            name: 'I714700',
            component: I714700,
        },
        {
            path: '/intel/i7processors/i7-14700f',
            name: 'I714700F',
            component: I714700F,
        },
        {
            path: '/intel/i7processors/i7-14700k',
            name: 'I714700K',
            component: I714700K,
        },
        {
            path: '/intel/i7processors/i7-14700kf',
            name: 'I714700KF',
            component: I714700KF,
        },

        //*****************************************************
        // I9Processors Page
        //*****************************************************
        {
            path: '/intel/i9processors/i9-14900',
            name: 'I914900',
            component: I914900,
        },
        {
            path: '/intel/i9processors/i9-14900f',
            name: 'I914900F',
            component: I914900F,
        },
        {
            path: '/intel/i9processors/i9-14900k' ,
            name: 'I914900K',
            component: I914900K,
        },
        {
            path: '/intel/i9processors/i9-14900kf',
            name: 'I914900KF',
            component: I914900KF,
        },

        //*****************************************************
        // Ryzen5Processors Page
        //*****************************************************
        {
            path: '/amd/Ryzen5Processors/5600X',
            name: '5600X',
            component: Ryzen5600X,
        },
        {
            path: '/amd/Ryzen5Processors/8400F',
            name: '8400F',
            component: Ryzen8400F,
        },
        {
            path: '/amd/Ryzen5Processors/5500GT',
            name: '5500GT',
            component: Ryzen5500GT,
        },
        {
            path: '/amd/Ryzen5Processors/8600G',
            name: '8600G',
            component: Ryzen8600G,
        },
        {
            path: '/amd/Ryzen5Processors/9600X',
            name: '9600X',
            component: Ryzen9600X,
        },

        //*****************************************************
        // Ryzen7Processors Page
        //*****************************************************
        {
            path: '/amd/Ryzen7Processors/5700',
            name: '5700',
            component: Ryzen5700,
        },
        {
            path: '/amd/Ryzen7Processors/8700F',
            name: '8700F',
            component: Ryzen8700F,
        },
        {
            path: '/amd/Ryzen7Processors/5800XT',
            name: '5800XT',
            component: Ryzen5800XT,
        },
        {
            path: '/amd/Ryzen7Processors/8700G',
            name: '8700G',
            component: Ryzen8700G,
        },
        {
            path: '/amd/Ryzen7Processors/9700X',
            name: '9700X',
            component: Ryzen9700X,
        },


    ]
});


export default router;
