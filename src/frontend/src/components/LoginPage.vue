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
                <input v-model="user.email" class="form-control" type="email" placeholder="Email" required />
              </div>
              <div class="form-group">
                <label>Password</label>
                <input v-model="user.password" class="form-control" type="password" placeholder="Password" required />
              </div>
              <button type="submit" :disabled="isLoading">Login</button>
            </form>

            <!-- Show error message if login fails -->
            <div v-if="errorMessage" class="text-danger mt-3">{{ errorMessage }}</div>

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
import { defineComponent } from 'vue';
import { useRouter } from 'vue-router'; // Import useRouter
import AuthService from '../AuthService';

export default defineComponent({
  setup() {
    const router = useRouter(); // Get the router instance

    return {
      router,
      user: {
        email: '',
        password: ''
      },
      isLoading: false,
      errorMessage: null
    };
  },
  methods: {
    async loginUser() {
      this.isLoading = true;
      this.errorMessage = null;
      try {
        const response = await AuthService.login(this.user);
        if (response && response.data) {
          const userData = response.data; // User details in response
          await this.$store.dispatch('login', userData); // Assuming your Vuex store can handle user data
          console.log("User data:", userData); // Log user data to see all details
          if (this.user.email === "admin@gmail.com") {
            this.router.push('/adminPage'); // Redirect to admin page
          } else {
            this.router.push('/home'); // Navigate to home for regular users
          }
          throw new Error("Invalid response from server.");
        }
      } catch (error) {
        console.error("Login failed:", error);
        this.errorMessage = "Invalid email or password.";
      } finally {
        this.isLoading = false;
      }
    }
  }
});

</script>
