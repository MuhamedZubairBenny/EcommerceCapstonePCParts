<template>
  <h1 class="cart-heading">Your Cart</h1>
  <div class="cart-container">
    <!-- Cart Header -->
    <header class="cart-header">
    </header>

    <!-- Cart Items -->
    <div v-if="cartItems.length > 0" class="cart-items">
      <div class="cart-item" v-for="item in cartItems" :key="item.id">
        <img :src="item.image" alt="Product Image" class="cart-item-image" />
        <div class="cart-item-details">
          <h2 class="cart-item-title">{{ item.name }}</h2>
          <p class="cart-item-price">${{ item.price.toFixed(2) }}</p>
          <p class="cart-item-quantity">Quantity: {{ item.quantity }}</p>
          <p class="cart-item-total">Total: ${{ (item.price * item.quantity).toFixed(2) }}</p>
          <button @click="removeFromCart(item.id)" class="remove-button">Remove</button>
        </div>
      </div>

      <!-- Cart Summary -->
      <div class="cart-summary">
        <h3>Cart Summary</h3>
        <p>Total Items: {{ totalItems }}</p>
        <p>Total Price: ${{ totalPrice.toFixed(2) }}</p>
        <button @click="proceedToCheckout" class="checkout-button">Proceed to Checkout</button>
      </div>
    </div>

    <!-- Empty Cart Message -->
    <div v-else class="empty-cart">
      <p>Your cart is currently empty.</p>
    </div>
  </div>
</template>

<script>
import { computed, ref } from 'vue';

export default {
  name: 'UserCart',
  setup() {
    const cartItems = ref([
      {
        id: 1,
        name: 'Product 1',
        price: 29.99,
        quantity: 2,
        image: 'https://via.placeholder.com/100'
      },
      {
        id: 2,
        name: 'Product 2',
        price: 49.99,
        quantity: 1,
        image: 'https://via.placeholder.com/100'
      },
      {
        id: 3,
        name: 'Product 3',
        price: 15.99,
        quantity: 3,
        image: 'https://via.placeholder.com/100'
      }
    ]);

    const removeFromCart = (productId) => {
      cartItems.value = cartItems.value.filter(item => item.id !== productId);
    };

    const proceedToCheckout = () => {
      alert('Proceeding to checkout');
    };

    const totalItems = computed(() => {
      return cartItems.value.reduce((total, item) => total + item.quantity, 0);
    });

    const totalPrice = computed(() => {
      return cartItems.value.reduce((total, item) => total + item.price * item.quantity, 0);
    });

    return {
      cartItems,
      removeFromCart,
      proceedToCheckout,
      totalItems,
      totalPrice
    };
  }
}
</script>


<style scoped>
.cart-heading {
  text-align: center;
  font-size: 2.5rem;
  color: #007bff;
  margin: 30px 0;
  padding: 10px;
  background-color: #e9f4fe; /* Light blue background */
  border-radius: 10px;
  text-transform: uppercase;
  box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
  letter-spacing: 1.5px;
}

.cart-container {
  padding: 20px;
}

.cart-header {
  text-align: center;
  margin-bottom: 20px;
}

.cart-items {
  display: flex;
  flex-direction: column;
  gap: 10px;
}

.cart-item {
  display: flex;
  align-items: center;
  border: 1px solid #ddd;
  padding: 10px;
  border-radius: 4px;
}

.cart-item-image {
  width: 100px;
  height: 100px;
  object-fit: cover;
  margin-right: 15px;
}

.cart-item-details {
  flex: 1;
}

.cart-item-title {
  font-size: 18px;
  margin: 0;
}

.cart-item-price,
.cart-item-quantity,
.cart-item-total {
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

.empty-cart {
  text-align: center;
  margin-top: 20px;
}
</style>