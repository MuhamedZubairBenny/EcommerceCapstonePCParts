// src/router/index.js
import { createRouter, createWebHistory } from 'vue-router'; // Import the correct functions
import HomePage from '@/components/HomePage.vue';
import CpuCategory from '@/components/ProductCategories/CpuCategory.vue';
import GpuCategory from '@/components/ProductCategories/GpuCategory.vue';
import ShippingAddress from '@/components/Profile/ShippingAddress.vue';
import ProductDetails from "@/components/ProductDetails.vue";
import AccountInformation from "@/components/Profile/AccountInformation.vue";
import AddProducts from "@/components/AdminProfile/Product/AddProducts.vue";
import DeleteProducts from "@/components/AdminProfile/Product/DeleteProducts.vue";
import UpdateProducts from "@/components/AdminProfile/Product/UpdateProducts.vue";
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
import UpdateCustomer from "@/components/Profile/UpdateCustomer.vue";
import UpdateContact from "@/components/Profile/UpdateContact.vue";
import AddCategory from "@/components/AdminProfile/Category/AddCategory.vue";
import UpdateCategory from "@/components/AdminProfile/Category/UpdateCategory.vue";
import DeleteCategory from "@/components/AdminProfile/Category/DeleteCategory.vue";
import AddBrand from "@/components/AdminProfile/Brand/AddBrand.vue";
import UpdateBrand from "@/components/AdminProfile/Brand/UpdateBrand.vue";
import DeleteBrand from "@/components/AdminProfile/Brand/DeleteBrand.vue";
import AdminPage from "@/components/AdminPage.vue";
import LoginPage from "@/components/LoginPage.vue";
import RegisterPage from "@/components/RegisterPage.vue";
import store from "@/store";
import ProductPage from "@/components/ProductPage.vue";

//import Profile from '@/components/Profile/Profile.vue';
// import ProductPage from '@/components/ProductPage.vue';
// Create a router instance
const router = createRouter({
    history: createWebHistory(), // Use createWebHistory for Vue 3
    routes: [
        { path: '/', redirect: '/login' },
        {
            path: '/login',
            name: 'Login',
            component: LoginPage
        },
        {
            path: '/register',
            name: 'Register',
            component: RegisterPage
        },
        {
            path: '/search',
            name: 'SearchResults',
            component: () => import('@/components/SearchResults.vue')
        },
        {
            path: '/product/:id',
            name: 'ProductDetails',
            component: ProductDetails,
            props: true
        },
        {
            path: '/home',
            name: 'HomePage',
            component: HomePage
        },
        {
            path: '/product/:productId',
            name: 'ProductPage',
            component: ProductPage,
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
            path: '/UpdateCustomer',
            name:'UpdateCustomer',
            component: UpdateCustomer,
            meta: { hideNavbar: true},
        },
        {
            path: '/UpdateContact',
            name:'UpdateContact',
            component: UpdateContact,
            meta: { hideNavbar: true},
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
        {
            path: '/AddCategory',
            name: 'AddCategory',
            component: AddCategory
        },
        {
            path: '/UpdateCategory',
            name: 'UpdateCategory',
            component: UpdateCategory
        },
        {
            path: '/DeleteCategory',
            name: 'DeleteCategory',
            component: DeleteCategory
        },
        {
            path: '/AddBrand',
            name: 'AddBrand',
            component: AddBrand
        },
        {
            path: '/UpdateBrand',
            name: 'UpdateBrand',
            component: UpdateBrand
        },
        {
            path: '/DeleteBrand',
            name: 'DeleteBrand',
            component: DeleteBrand
        },
        {
            path: '/AdminPage',
            name: 'AdminPage',
            component: AdminPage
        },


    ],
});
router.beforeEach((to, from, next) => {
    const isAuthenticated = store.state.isAuthenticated;
    const publicPages = ['/login', '/register'];
    const authRequired = !publicPages.includes(to.path);

    if (authRequired && !isAuthenticated) {
        return next('/login');
    }

    next();
});


export default router;
