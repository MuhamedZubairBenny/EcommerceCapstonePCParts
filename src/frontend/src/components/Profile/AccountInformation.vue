<script>
import { mapState } from 'vuex';

export default {
  name: 'AboutPage',
  computed: {
    ...mapState({
      isAuthenticated: state => state.isAuthenticated,
      user: state => state.user,
    }),
    isUserLoaded() {
      return !!this.user && !!this.user.email;
    }
  },
  methods: {
    fetchUserDetailsByEmail() {
      if (this.user.email) {
        this.$store.dispatch('fetchUserByEmail', this.user.email)
            .then(() => {
              // Optional: Additional logic after fetching the user
            })
            .catch(error => {
              console.error('Error fetching user details:', error);
            });
      } else {
        console.error('User email is not available');
      }
    },
    editUser() {
      this.$router.push('/UpdateCustomer');
    }
  },

  created() {
    this.$store.dispatch('initializeStore');
    if (this.isAuthenticated) {
      this.fetchUserDetailsByEmail();
    }
  },
  watch: {
    isAuthenticated(newVal) {
      if (newVal) {
        this.fetchUserDetailsByEmail();
      }
    }
  }
};
</script>


<template>
  <div class="account-info-container">
    <h1>Account Information</h1>
    <div v-if="user">
      <table class="table table-striped">
        <thead>
        <tr>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Email</th>
          <th>Mobile</th>
          <th>Date of Birth</th>
        </tr>
        </thead>
        <tbody>
        <tr>
          <td>{{ user.firstName }}</td>
          <td>{{ user.lastName }}</td>
          <td>{{ user.email }}</td>
          <td>{{ user.mobileNumber }}</td>
          <td>{{ user.dateOfBirth }}</td>
        </tr>
        </tbody>
      </table>
      <button @click="editUser" class="update-user-button">Edit Details</button>
    </div>
    <div v-else>
      <p class="no-user-message">No user information available. Please log in.</p>
    </div>
  </div>
</template>

<style scoped>
.account-info-container {
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
  background-color: #f9f9f9;
  border-radius: 8px;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
}

h1 {
  text-align: center;
  color: #333;
  margin-bottom: 20px;
}

.table {
  width: 100%;
  border-collapse: collapse;
  margin-bottom: 20px;
}

.table th, .table td {
  padding: 12px;
  text-align: left;
  border-bottom: 1px solid #ddd;
}

.table th {
  background-color: #007bff;
  color: white;
}

.table-striped tbody tr:nth-of-type(odd) {
  background-color: #f2f2f2;
}

.no-user-message {
  text-align: center;
  color: #666;
  font-size: 18px;
}

.update-user-button {
  display: block;
  margin: 20px auto;
  padding: 10px 20px;
  background-color: #007bff;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size: 16px;
}

.update-user-button:hover {
  background-color: #0056b3;
}
</style>