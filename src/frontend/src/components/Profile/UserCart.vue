<template>
  <div class="cart-container">
    <h2 class="cart-heading">Your Cart</h2>
    <div v-if="cartItems.length > 0">
      <div class="cart-item" v-for="item in cartItems" :key="item.productId">
        <img :src="item.productPicture" alt="Product Image" />
        <div class="cart-item-details">
          <h3>{{ item.productName }}</h3>
          <p>Price: {{ formatCurrency(item.price) }}</p>
          <p>Quantity: {{ item.quantity }}</p>
          <button @click="removeFromCart(item.productId)" class="remove-button">Remove</button>
        </div>
      </div>
      <div class="cart-summary">
        <p>Total Items: {{ totalItems }}</p>
        <p>Total Price: {{ formatCurrency(totalPrice) }}</p>
        <button @click="proceedToCheckout" class="checkout-button">Proceed to Checkout</button>
      </div>
    </div>
    <div v-else class="empty-cart">
      <p>Your cart is currently empty.</p>
    </div>
  </div>
</template>

<script>
import { computed, ref, onMounted } from 'vue';
import { useStore } from 'vuex';
import { useRouter } from 'vue-router';

export default {
  name: 'UserCart',
  setup() {
    const router = useRouter();
    const store = useStore();
    const cartItems = ref([]);

    const cartTotal = computed(() => {
      return cartItems.value.reduce((total, item) => total + item.price * item.quantity, 0);
    });

    const fetchCartItems = async () => {
      const user = store.state.user; // Fetch the logged-in user from Vuex
      if (user && user.cart) {
        const cartId = user.cart.cartId; // Get the cartId from the user object
        try {
          const response = await fetch(`/api/cart/read/${cartId}`);
          if (response.ok) {
            const data = await response.json();
            cartItems.value = data.products.map(product => ({
              productId: product.productId,
              productName: product.productName,
              productPicture: product.productPicture,
              price: product.price,
              quantity: 1
            })) || [];
          } else {
            console.error('Error fetching cart items:', response.statusText);
            cartItems.value = [];
          }
        } catch (error) {
          console.error('Error fetching cart items:', error);
          cartItems.value = [];
        }
      }
    };

    const removeFromCart = async (productId) => {
      const user = store.state.user;
      if (user && user.cart) {
        const cartId = user.cart.cartId;
        try {
          const response = await fetch(`/api/cart/${cartId}/removeProduct/${productId}`, {
            method: 'DELETE',
            headers: {
              'Content-Type': 'application/json',
            },
          });

          if (response.ok) {
            cartItems.value = cartItems.value.filter(item => item.productId !== productId);
            alert('Product removed from cart');
          } else {
            console.error('Error removing product from cart:', response.statusText);
          }
        } catch (error) {
          console.error('Error removing product from cart:', error);
        }
      }
    };

    const proceedToCheckout = () => {
      alert('Proceeding to checkout!');
      router.push({
        path: '/PaymentOption',
        query: {
          cartTotal: cartTotal.value,
          cart: JSON.stringify(cartItems.value) }
      });
    };

    const totalItems = computed(() => {
      return cartItems.value.reduce((total, item) => total + item.quantity, 0);
    });

    const totalPrice = computed(() => {
      return cartItems.value.reduce((total, item) => total + item.price * item.quantity, 0);
    });

    onMounted(() => {
      fetchCartItems();
    });

    return {
      cartItems,
      removeFromCart,
      proceedToCheckout,
      totalItems,
      totalPrice,
      formatCurrency: (amount) => new Intl.NumberFormat('en-US', {
        style: 'currency',
        currency: 'ZAR',
      }).format(amount),
    };
  }
}
</script>

<style scoped>
.cart-container {
  padding: 20px;
}

.cart-heading {
  text-align: center;
  font-size: 2.5rem;
  color: #007bff;
  margin: 30px 0;
  padding: 10px;
  background-color: #e9f4fe;
  border-radius: 10px;
  text-transform: uppercase;
  box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
  letter-spacing: 1.5px;
}

.cart-item {
  display: flex;
  align-items: center;
  border: 1px solid #ddd;
  padding: 10px;
  border-radius: 4px;
  background-color: #fff;
  margin-bottom: 10px;
}

.cart-item img {
  width: 100px;
  height: 100px;
  object-fit: cover;
  margin-right: 15px;
}

.cart-item-details {
  flex: 1;
}

.cart-item h3 {
  font-size: 18px;
  margin: 0;
}

.cart-item p {
  margin: 5px 0;
}

.remove-button {
  background-color: red;
  color: white;
  border: none;
  padding: 5px 10px;
  border-radius: 4px;
  cursor: pointer;
}

.remove-button:hover {
  background-color: #ff4d4d;
}

.cart-summary {
  margin-top: 20px;
  text-align: center;
}

.checkout-button {
  background-color: green;
  color: white;
  border: none;
  padding: 10px 20px;
  border-radius: 4px;
  cursor: pointer;
}

.checkout-button:hover {
  background-color: #005600;
}

.empty-cart {
  text-align: center;
  margin-top: 20px;
}
</style>



