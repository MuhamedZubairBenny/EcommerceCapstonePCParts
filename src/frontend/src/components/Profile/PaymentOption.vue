<template>
  <div class="payment-container">
    <form @submit.prevent="handleSubmit" class="payment-form">
      <h2 class="payment-information">Payment Details</h2>

      <div class="form-group">
        <label for="card-number">Card Number</label>
        <input type="text" id="card-number" v-model="cardNumber" placeholder="1234 5678 9012 3456" />
      </div>

      <div class="form-group">
        <label for="card-expiry">Expiry Date</label>
        <input type="text" id="card-expiry" v-model="expiryDate" placeholder="MM/YY" />
      </div>

      <div class="form-group">
        <label for="card-cvv">CVV</label>
        <input type="text" id="card-cvv" v-model="cvv" placeholder="123" />
      </div>

      <div class="form-group">
        <label for="card-name">Cardholder's Name</label>
        <input type="text" id="card-name" v-model="cardName" placeholder="John Doe" />
      </div>

      <div class="price-details">
        <div class="price-item">
          <span>Subtotal:</span>
          <span>{{ formatCurrency(subtotal) }}</span>
        </div>
        <div class="price-item">
          <span>VAT (15%):</span>
          <span>{{ formatCurrency(vat) }}</span>
        </div>
        <div class="price-item total">
          <span>Total:</span>
          <span>{{ formatCurrency(total) }}</span>
        </div>
      </div>

      <button type="submit" class="confirm-button">Confirm Payment</button>
    </form>
  </div>
</template>

<script>
import { useRoute } from 'vue-router';
import { mapState } from 'vuex';
import axios from 'axios';

export default {
  name: 'PaymentPage',
  data() {
    return {
      cardNumber: '',
      expiryDate: '',
      cvv: '',
      cardName: '',
      vatRate: 0.15,
      cartTotal: 0,
      cart:[],
    };
  },
  computed: {
    ...mapState({
      user: (state) => state.user,
    }),
    subtotal() {
      return this.cartTotal;
    },
    vat() {
      return this.subtotal * this.vatRate;
    },
    total() {
      return this.subtotal + this.vat;
    },
  },
  mounted() {
    const route = useRoute();
    this.cartTotal = parseFloat(route.query.cartTotal) || 0;
    this.cart = JSON.parse(route.query.cart || '[]');
  },
  methods: {
    async handleSubmit() {
      try {
        const orderData = {
          orderId: null,
          overallPrice: this.total,
          cart: {
            cartId: this.user.cart.cartId,
            products: this.cart.map(item => ({
              productId: item.productId,
              productName: item.productName,
              price: item.price,
              quantity: item.quantity,
              brand: item.brand,
              category: item.category,
              image: item.image,
            })),
          },
        };
        const orderResponse = await axios.post('http://localhost:3000/api/order/create', orderData);
        const orderId = orderResponse.data.orderId;

        const user = this.user;
        const paymentData = {
          paymentId: null,
          order: {
            orderId: orderId,
          },
          paymentType: 'Credit Card',
          paymentTotal: this.total,
          user: user,
        };

        const paymentResponse = await axios.post('http://localhost:3000/api/payment/create', paymentData);

        console.log('Payment successful:', paymentResponse.data);
        this.$router.push({
          path: '/OrderPage',
          query: {
            order: JSON.stringify(orderData),
            payment: JSON.stringify(paymentResponse.data),
          },
        });

        alert('Payment confirmed!');
      } catch (error) {
        console.error('Payment error:', error);
        alert('Payment failed. Please try again.');
      }
    },
    formatCurrency(amount) {
      return new Intl.NumberFormat('en-US', {
        style: 'currency',
        currency: 'ZAR',
      }).format(amount);
    },
  },
};
</script>

<style scoped>
.payment-information{
  text-align: center;
  font-size: 2.5rem;
  color: #232f3e;
  margin: 30px 0;
  padding: 10px;
  background-color: #69feca;
  border-radius: 10px;
  text-transform: uppercase;
  box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
  letter-spacing: 1.5px;
  font-family: 'Orbitron', sans-serif;
}
.payment-container {
  width: 100%;
  max-width: 450px;
  margin: auto;
  padding: 30px;
  background-color: #f8f9fa;
  border-radius: 12px;
  box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
  font-family: 'Roboto', sans-serif;
}
h2 {
  text-align: center;
  font-size: 1.8rem;
  margin-bottom: 20px;
  color: #343a40;
}

.payment-form {
  display: flex;
  flex-direction: column;
}

.form-group {
  margin-bottom: 20px;
}

.form-group label {
  display: block;
  margin-bottom: 8px;
  font-weight: 600;
  color: #495057;
}

.form-group input {
  width: 100%;
  padding: 12px;
  border: 2px solid #ced4da;
  border-radius: 8px;
  font-size: 16px;
  outline: none;
  transition: border-color 0.3s ease;
}
.form-group input:focus {
  border-color: #007bff;
}

.price-details {
  margin: 30px 0;
  background-color: #e9ecef;
  padding: 15px;
  border-radius: 8px;
}


.price-item {
  display: flex;
  justify-content: space-between;
  margin-bottom: 12px;
  font-size: 16px;
  color: #495057;
}

.price-item.total {
  font-size: 18px;
  font-weight: bold;
}

.confirm-button {

  //padding: 10px 20px;
  //background-color: #059090FF;

  padding: 12px;
  background-color: #28a745;

  color: white;
  border: none;
  border-radius: 8px;
  cursor: pointer;
  font-size: 18px;
  font-weight: 600;
  text-align: center;
  transition: background-color 0.3s ease;
}

.confirm-button:hover {
  background-color: #059090FF;
}
</style>