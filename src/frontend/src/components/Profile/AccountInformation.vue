<script>
export default {
  name: 'AccountInformation',
  data() {
    return {
      user: null // Only the logged-in user
    }
  },
  mounted() {
    this.fetchData();
  },
  methods: {
    fetchData() {
      fetch("http://localhost:8080/auth/me", {
        method: 'GET',
        headers: {
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${localStorage.getItem('token')}` // Include auth token if using JWT
        }
      })
          .then((response) => response.json())
          .then((data) => {
            this.user = data;
          })
          .catch((error) => {
            console.error('Error fetching authenticated user:', error);
          });
    }
  }
}
</script>

<template>
  <div class="container">
    <h1>Account Information</h1>
    <div v-if="user">
      <table class="table table-striped">
        <thead>
        <tr>
          <th>ID</th>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Email</th>
          <th>Password</th>
          <th>Mobile</th>
          <th>Date of Birth</th>
        </tr>
        </thead>
        <tbody>
        <tr>
          <td>{{ user.id }}</td>
          <td>{{ user.firstName }}</td>
          <td>{{ user.lastName }}</td>
          <td>{{ user.email }}</td>
          <td>{{ user.password }}</td>
          <td>{{ user.mobileNumber }}</td>
          <td>{{ user.dateOfBirth }}</td>
        </tr>
        </tbody>
      </table>
    </div>
    <div v-else>
      <p>No user information available. Please log in.</p>
    </div>
  </div>
</template>

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