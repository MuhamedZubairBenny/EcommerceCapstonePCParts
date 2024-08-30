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
      customers: []
    }
  },
  mounted() {
    this.fetchData();
  },
  methods: {
    fetchData() {
      fetch("/api/customer/getall")
          .then((response) => response.json())
          .then((data) => {
            this.customers = data;
          })
          .catch((error) => {
            console.error('Error fetching data:', error);
          });
    }
  }
}
</script>
<style scoped>
.account-info-container {
  max-width: 900px;
  margin: auto;
  padding: 30px;
  background-color: #f9f9f9;
  border-radius: 8px;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
}

h1 {
  font-size: 28px;
  text-align: center;
  margin-bottom: 20px;
  font-weight: bold;
}

.table-responsive {
  overflow-x: auto;
}

.table {
  width: 100%;
  margin-bottom: 1rem;
  border: 1px solid #dee2e6;
}

.table thead th {
  background-color: #007bff;
  color: white;
  border: none;
  text-align: center;
  padding: 10px;
}

.table tbody td {
  padding: 15px;
  text-align: center;
  vertical-align: middle;
}

.table tbody tr:nth-child(even) {
  background-color: #f2f2f2;
}

.table-striped tbody tr:nth-of-type(odd) {
  background-color: #e9ecef;
}

.table-bordered {
  border: 2px solid #dee2e6;
}

</style>