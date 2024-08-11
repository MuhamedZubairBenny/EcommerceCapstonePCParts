<script setup>

</script>

<template>
  <div class="container">
    <h1>Account Information</h1>
    <table class="table table-striped">
      <thead>
      <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Mobile</th>
        <th>Address</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="customer in customers" :key="customer.customerId">
        <td>{{ customer.customerId }}</td>
        <td>{{ customer.firstName }}</td>
        <td>{{ customer.lastName }}</td>
        <td>{{ customer.contact.email }}</td>
        <td>{{ customer.contact.mobile }}</td>
        <td>{{ customer.contact.address }}</td>
        <!-- Add more data columns as needed -->
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {
  name: 'AccountInformation',
  data() {
    return {
      customers: [] // Array to store fetched data
    }
  },
  mounted() {
    this.fetchData();
  },
  methods: {
    fetchData() {
      fetch("/api/customer/getall")
          .then((response) => response.json()) // Assuming the response is JSON
          .then((data) => {
            this.customers = data; // Store fetched data
          })
          .catch((error) => {
            console.error('Error fetching data:', error);
          });
    }
  }
}
</script>
<style scoped>

</style>