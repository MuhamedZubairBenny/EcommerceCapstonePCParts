<template>
  <div class="container mt-5">
    <div class="row justify-content-center">
      <div class="col-md-6">
        <div class="card">
          <div class="card-header">Registration</div>
          <div class="card-body">
            <form @submit.prevent="registerUser">
              <div class="form-group">
                <label>First Name</label>
                <input v-model="user.firstName" class="form-control" type="text" placeholder="Enter first name" required />
              </div>
              <div class="form-group">
                <label>Last Name</label>
                <input v-model="user.lastName" class="form-control" type="text" placeholder="Enter last name" required />
              </div>
              <div class="form-group">
                <label>Email</label>
                <input v-model="user.email" class="form-control" type="email" placeholder="Enter email address" required />
              </div>
              <div class="form-group">
                <label>Password</label>
                <input v-model="user.password" class="form-control" type="password" placeholder="Enter password" required />
              </div>
              <button type="submit" class="btn btn-primary">Register</button>
            </form>
            <div v-if="successMessage" class="alert alert-success mt-3">
              {{ successMessage }}
            </div>
            <div v-if="errorMessage" class="alert alert-danger mt-3">
              {{ errorMessage }}
            </div>
            <div class="mt-3">
              <span>Already registered? <router-link to="/login">Login here</router-link></span>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import AuthService from '../AuthService';

export default {
  data() {
    return {
      user: {
        firstName: '',
        lastName: '',
        email: '',
        password: ''
      },
      successMessage: '',
      errorMessage: ''
    };
  },
  methods: {
    registerUser() {
      AuthService.register(this.user)
          .then(response => {
            this.successMessage = response.data;
            this.errorMessage = '';
            this.resetForm();
          })
          .catch(error => {
            this.successMessage = '';
            if (error.response && error.response.data) {
              this.errorMessage = error.response.data; // Show error message if the email is already registered
            } else {
              this.errorMessage = 'Registration failed. Please try again.'; // General error message
            }
          });
    },
    resetForm() {
      this.user.firstName = '';
      this.user.lastName = '';
      this.user.email = '';
      this.user.password = '';
    }
  }
};
</script>
