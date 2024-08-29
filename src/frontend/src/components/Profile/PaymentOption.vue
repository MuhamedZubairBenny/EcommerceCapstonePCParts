<template>
  <div class="payment-container">
    <!-- Payment Form -->
    <form @submit.prevent="handleSubmit" class="payment-form">
      <h2>Payment Details</h2>

      <div class="form-group">
        <label for="card-number">Card Number</label>
        <input type="text" id="card-number" v-model="cardNumber" placeholder="1234 5678 9012 3456" required />
      </div>

      <div class="form-group">
        <label for="card-expiry">Expiry Date</label>
        <input type="text" id="card-expiry" v-model="expiryDate" placeholder="MM/YY" required />
      </div>

      <div class="form-group">
        <label for="card-cvv">CVV</label>
        <input type="text" id="card-cvv" v-model="cvv" placeholder="123" required />
      </div>

      <div class="form-group">
        <label for="card-name">Cardholder's Name</label>
        <input type="text" id="card-name" v-model="cardName" placeholder="John Doe" required />
      </div>

      <!-- Price Details -->
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
import axios from 'axios';

export default {
  name: 'PaymentPage',
  props: {
    orderId: {
      type: String,
      default: '001',
    },
  },
  data() {
    return {
      cardNumber: '',
      expiryDate: '',
      cvv: '',
      cardName: '',
      subtotal: 0,
      vatRate: 0.15,
      customer: null,  // Add customer data
    };
  },
  computed: {
    vat() {
      return this.subtotal * this.vatRate;
    },
    total() {
      return this.subtotal + this.vat;
    },
  },
  async mounted() {
    if (this.orderId) {
      try {
        // Fetch order data
        const orderResponse = await axios.get(`http://localhost:3000/api/order/read/${this.orderId}`);
        this.subtotal = orderResponse.data.overallPrice;

        // Fetch customer data
        const customerResponse = await axios.get(`http://localhost:3000/api/order/read/${this.orderId}/customer`);
        this.customer = customerResponse.data;
      } catch (error) {
        console.error('Failed to fetch order or customer data:', error);
      }
    }
  },
  methods: {
    async handleSubmit() {
      try {
        // Construct payment data object
        const paymentData = {
          paymentId: '', // You might want to generate or obtain this ID
          order: {
            orderId: this.orderId, // Assuming you might need to include the order ID
          },
          customer: this.customer, // Include customer details here
          paymentType: 'Credit Card', // Replace with actual payment type if necessary
          paymentTotal: this.total,
        };

        // Make POST request to backend
        const response = await axios.post('http://localhost:3000/api/payment/create', paymentData);

        // Handle successful response
        console.log('Payment successful:', response.data);
        alert('Payment confirmed!');
      } catch (error) {
        // Handle error
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
.payment-container {
  width: 100%;
  max-width: 500px;
  margin: auto;
  padding: 20px;
  border: 1px solid #ddd;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.payment-form {
  display: flex;
  flex-direction: column;
}

.form-group {
  margin-bottom: 15px;
}

.form-group label {
  display: block;
  margin-bottom: 5px;
  font-weight: bold;
}

.form-group input {
  width: 100%;
  padding: 10px;
  border: 1px solid #ddd;
  border-radius: 4px;
}

.price-details {
  margin-top: 20px;
  margin-bottom: 20px;
}

.price-item {
  display: flex;
  justify-content: space-between;
  margin-bottom: 10px;
}

.total {
  font-weight: bold;
}

.confirm-button {
  padding: 10px 20px;
  background-color: #28a745;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size: 16px;
}

.confirm-button:hover {
  background-color: #218838;
}
</style>
