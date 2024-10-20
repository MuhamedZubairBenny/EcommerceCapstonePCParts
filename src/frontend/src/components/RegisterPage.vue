<template>
  <div class="container mt-5">
    <div class="row justify-content-center">
      <div class="col-md-6">
        <div class="logo">
          <img :src="require('@/assets/cybertech.png')" alt="Brand Logo" class="brand-logo" />
          <link href="https://fonts.googleapis.com/css2?family=Orbitron:wght@400;700&display=swap" rel="stylesheet">
          <span class="brand-name">CYBERTECH</span>
        </div>
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
              <button type="submit" class="auth-button" :disabled="isLoading">Register</button>
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
      errorMessage: '',
      isLoading: false
    };
  },
  methods: {
    registerUser() {
      this.isLoading = true;
      AuthService.register(this.user)
          .then(response => {
            this.successMessage = response.data;
            this.errorMessage = '';
            this.resetForm();
            alert("Successfully registered")
            this.$router.push('/login');
          })
          .catch(error => {
            this.successMessage = '';
            this.errorMessage = error.response?.data || 'Registration failed. Please try again.';
          })
          .finally(() => {
            this.isLoading = false;
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

<style scoped>
.brand-name {
  font-size: 36px;
  font-weight: bold;
  color: black;
  margin-left: 50px;
  margin-top: 30px;
  font-family: 'Orbitron', sans-serif;
  letter-spacing: 1px;
}
.logo {
  display: flex;
  justify-content: center;
  margin-bottom: 20px;
}

.brand-logo {
  max-width: 120px;
  width: 100%;
  height: auto;
}

h1 {
  margin-bottom: 20px;
}

input {
  padding: 10px;
  border: 1px solid grey;
  border-radius: 5px;
  width: 100%;
  outline: none;
  transition: border-color 0.3s;
}

input:focus {
  border-color: #57d6c2;
}

.auth-button {
  background-color: #131921;
  color: white;
  padding: 12px 15px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  font-size: 1rem;
  font-weight: bold;
  text-transform: uppercase;
  width: 100%;
  transition: background-color 0.3s ease, transform 0.2s ease;
  margin-top: 5px;
}

.auth-button:hover {
  background-color: #57d6c2;
  transform: translateY(-2px);
}

.auth-button:active {
  background-color: #3dbba9;
  transform: translateY(0);
}

.auth-button:disabled {
  background-color: #a3e7dc;
  color: #666;
  cursor: not-allowed;
}

.card {
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
  border-radius: 8px;
}

.card-header {
  background-color: #131921;
  color: white;
  text-align: center;
  font-weight: bold;
  font-size: 1.2rem;
}

.alert {
  font-size: 0.9rem;
}

.mt-3 {
  margin-top: 1rem;
}
label {
  font-weight: bold;
}
</style>
