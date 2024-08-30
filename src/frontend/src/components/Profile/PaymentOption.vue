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

        const paymentData = {
          paymentId: '',
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
  background-color: #218838;
}
</style>
