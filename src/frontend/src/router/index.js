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
import Cart from "@/components/Profile/Cart.vue";
import UpdateProducts from "@/components/Profile/UpdateProducts.vue";
import PaymentOption from "@/components/Profile/PaymentOption.vue";

//import Profile from '@/components/Profile/Profile.vue';
// import ProductPage from '@/components/ProductPage.vue';
// Create a router instance
const router = createRouter({
    history: createWebHistory(), // Use createWebHistory for Vue 3
    routes: [
        {
            path: '/product/:id',
            name: 'ProductDetails',
            component: ProductDetails,
            props: true
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
            component: ShippingAddress
        },
        {
            path: '/AccountInformation',
            name: 'AccountInformation',
            component: AccountInformation
        },
        {
            path: '/AddProducts',
            name: 'AddProducts',
            component: AddProducts
        },
        {
            path: '/DeleteProducts',
            name: 'DeleteProducts',
            component: DeleteProducts
        },
        {
            path: '/PaymentOption',
            name: 'PaymentOption',
            component: PaymentOption
        },
        {
            path: '/Cart',
            name: 'Cart',
            component: Cart
        },
        {
            path: '/UpdateProducts',
            name: 'UpdateProducts',
            component: UpdateProducts
        }

        // {
        //     path: '/profile',
        //     name: 'Profile',
        //     component: Profile,
        //     children: [
        //         {
        //             path: 'account',
        //             name: 'AccountInformation',
        //             component: () => import('@/components/Profile/AccountInformation.vue')
        //         },
        //         {
        //             path: 'cart',
        //             name: 'ProductCart',
        //             component: () => import('@/components/Profile/Cart.vue')
        //         },
        //         {
        //             path: 'payment',
        //             name: 'PaymentOption',
        //             component: () => import('@/components/Profile/Payment.vue')
        //         },
        //         {
        //             path: 'address',
        //             name: 'ShippingAddress',
        //             component: () => import('@/components/Profile/ShippingAddress.vue')
        //         }
            //]
       // },
        // Dynamic route for product categories
        // {
        //     path: '/:category',
        //     name: 'ProductPage',
        //     component: ProductPage,
        //     props: route => ({ category: route.params.category })
        // },
        // // Dynamic route for product variants (e.g., processors, GPUs)
        // {
        //     path: '/category/product',
        //     name: 'ProductDetailPage',
        //     component: ProductPage,
        //     props: route => ({
        //         category: route.params.category,
        //         product: route.params.product
        //     })
        //}

    ]
});


export default router;
