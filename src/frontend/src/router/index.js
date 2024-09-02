// src/router/index.js
import { createRouter, createWebHistory } from 'vue-router'; // Import the correct functions
import HomePage from '@/components/HomePage.vue';
import CpuCategory from '@/components/ProductCategories/CpuCategory.vue';
import GpuCategory from '@/components/ProductCategories/GpuCategory.vue';
import ShippingAddress from '@/components/Profile/ShippingAddress.vue';
import ProductDetails from "@/components/ProductDetails.vue";
import AccountInformation from "@/components/Profile/AccountInformation.vue";
import AddProducts from "@/components/Profile/AddProducts.vue";
import DeleteProducts from "@/components/Profile/DeleteProducts.vue";
import UpdateProducts from "@/components/Profile/UpdateProducts.vue";
import PaymentOption from "@/components/Profile/PaymentOption.vue";
import UserCart from "@/components/Profile/UserCart.vue";
import CoolingCategory from "@/components/ProductCategories/CoolingCategory.vue";
import CaseCategory from "@/components/ProductCategories/CaseCategory.vue";
import MonitorCategory from "@/components/ProductCategories/MonitorCategory.vue";
import MotherboardCategory from "@/components/ProductCategories/MotherboardCategory.vue";
import StorageCategory from "@/components/ProductCategories/StorageCategory.vue";
import RAMCategory from "@/components/ProductCategories/RAMCategory.vue";
import PSUCategory from "@/components/ProductCategories/PSUCategory.vue";
import PeripheralCategory from "@/components/ProductCategories/PeripheralCategory.vue";

const router = createRouter({
    history: createWebHistory(),
    routes: [
        {
            path: '/product/:id',
            name: 'ProductDetails',
            component: ProductDetails,
            props: true
        },
        {
            path: '/search',
            name: 'SearchResults',
            component: () => import('@/components/SearchResults.vue')
        },
        {
            path: '/',
            name: 'HomePage',
            component: HomePage
        },
        {
            path: '/cpu',
            name: 'CpuCategory',
            component: CpuCategory
        },
        {
            path: '/gpu',
            name: 'GpuCategory',
            component: GpuCategory
        },
        {
            path: '/cpu',
            name: 'CpuCategory',
            component: CpuCategory
        },
        {
            path: '/ShippingAddress',
            name: 'ShippingAddress',
            component: ShippingAddress,
            meta: { hideNavbar: true },
        },
        {
            path: '/AccountInformation',
            name: 'AccountInformation',
            component: AccountInformation,
            meta: { hideNavbar: true },
        },
        {
            path: '/AddProducts',
            name: 'AddProducts',
            component: AddProducts,
            meta: { hideNavbar: true },
        },
        {
            path: '/DeleteProducts',
            name: 'DeleteProducts',
            component: DeleteProducts,
            meta: { hideNavbar: true },
        },
        {
            path: '/PaymentOption',
            name: 'PaymentOption',
            component: PaymentOption,
            meta: { hideNavbar: true },
        },
        {
            path: '/cart',
            name: 'UserCart',
            component: UserCart,
            meta: { hideNavbar: true },
        },
        {
            path: '/UpdateProducts',
            name: 'UpdateProducts',
            component: UpdateProducts,
            meta: { hideNavbar: true },
        },
    {
        path: '/Peripherals',
        name: 'PeripheralCategory',
        component: PeripheralCategory
    },
    {
        path: '/PSU',
        name: 'PSUCategory',
        component: PSUCategory
    },
    {
        path: '/RAM',
        name: 'RAMCategory',
        component: RAMCategory
    },
    {
        path: '/Storage',
        name: 'StorageCategory',
        component: StorageCategory
    },
    {
        path: '/Motherboard',
        name: 'MotherboardCategory',
        component: MotherboardCategory
    },
    {
        path: '/Monitor',
        name: 'MonitorCategory',
        component: MonitorCategory
    },
    {
        path: '/Case',
        name: 'CaseCategory',
        component: CaseCategory
    },
    {
        path: '/Cooling',
        name: 'CoolingCategory',
        component: CoolingCategory
    },



    ],
});


export default router;
