<template>
  <div class="shipping-container">
    <h1>Shipping Address</h1>
<!--    <div class="shipping-details">-->
<!--      <p v-if="shippingInfo"><strong>Address Line 1:</strong> {{ shippingInfo.address }}</p>-->
<!--      <p v-if="shippingInfo"><strong>City:</strong> {{ shippingInfo.city }}</p>-->
<!--      <p v-if="shippingInfo"><strong>Province:</strong> {{ shippingInfo.state }}</p>-->
<!--      <p v-if="shippingInfo"><strong>Zip Code:</strong> {{ shippingInfo.zipCode }}</p>-->
<!--      <p v-if="shippingInfo"><strong>Country:</strong> {{ shippingInfo.country }}</p>-->
<!--&lt;!&ndash;      <p v-else>Your shipping information could not be retrieved.</p>&ndash;&gt;-->
<!--    </div>-->
    <table class="table table-striped">
      <thead>
      <tr>
        <th>ShippingId</th>
        <th>Address</th>
        <th>City</th>
        <th>Province</th>
        <th>Zip Code</th>
        <th>Country</th>
        <!--        <th>Address</th>-->
      </tr>
      </thead>
      <tbody>
      <tr v-for="shipping in shipping" :key="shipping.shippingId">
        <td>{{ shipping.shippingId }}</td>
        <td>{{ shipping.address }}</td>
        <td>{{ shipping.city }}</td>
        <td>{{ shipping.state }}</td>
        <td>{{ shipping.zipCode }}</td>
        <td>{{ shipping.country }}</td>
        <!--        <td>{{ customer.shipping.address }}</td>-->
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {
  name: 'ShippingAddress',
  data() {
    return {
      shipping: []
    }
  },
  mounted() {
    this.fetchData();
  },
  methods: {
    fetchData() {
      fetch("/api/shipping/getall")
          .then((response) => response.json())
          .then((data) => {
            this.shipping = data;
          })
          .catch((error) => {
            console.error('Error fetching data:', error);
          });
    }
  }
}
</script>

