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
              <button type="submit" class= "auth-button" :disabled="isLoading">Login</button>
            </form>
            <div v-if="errorMessage" class="text-danger mt-3">{{ errorMessage }}</div>

            <div class="mt-3">
              <span>Not registered? <router-link to="/register">Register Here</router-link></span>
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
    const router = useRouter();

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
          const userData = response.data;
          await this.$store.dispatch('login', userData);
          console.log("User data:", userData);
          if (this.user.email === "admin@gmail.com") {
            alert("Successfully logged in")
            this.router.push('/adminPage');
          } else {
            alert("Successfully logged in")
            this.router.push('/home');
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
.card-header {
  background-color: #131921;
  color: white;
  text-align: center;
  font-weight: bold;
  font-size: 1.2rem;
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
label {
  font-weight: bold;
}
</style>