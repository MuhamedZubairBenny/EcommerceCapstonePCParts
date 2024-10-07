<template>
  <div class="container mt-5">
    <div class="row justify-content-center">
      <div class="col-md-6">
        <div class="card">
          <div class="card-header">Login Form</div>
          <div class="card-body">
            <form @submit.prevent="loginUser">
              <div class="form-group">
                <label>Email</label>
                <input v-model="user.email" class="form-control" type="email" placeholder="Email" />
              </div>
              <div class="form-group">
                <label>Password</label>
                <input v-model="user.password" class="form-control" type="password" placeholder="Password" />
              </div>
              <button type="submit" :disabled="isLoading">Login</button>
            </form>
            <div class="mt-3">
              <span>Not registered? <router-link to="/register">Register/SignUp Here</router-link></span>
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
        email: '',
        password: ''
      },
      isLoading: false, // Add this property to manage loading state
    };
  },
  methods: {
    async loginUser(event) {
      event.preventDefault(); // Prevent default form submission
      this.isLoading = true;  // Set loading state to true
      try {
        // Call the login method from AuthService
        const response = await AuthService.login(this.user);

        // Assuming the response contains the user data in response.data
        const userData = response.data; // Adjust if necessary based on your API response

        // Dispatch the Vuex login action to update the state
        await this.$store.dispatch('login', userData);

        // Navigate to the home page after successful login
        this.$router.push('/home');
      } catch (error) {
        console.error("Login failed:", error);
        // Optionally handle the error (e.g., show a notification or message to the user)
        // e.g., this.errorMessage = "Invalid credentials. Please try again.";
      } finally {
        this.isLoading = false; // Reset loading state
      }
    }
  }
};
</script>