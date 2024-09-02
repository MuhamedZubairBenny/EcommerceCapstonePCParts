<template>
  <div class="login-container">
    <h2>Login</h2>
    <form @submit.prevent="handleLogin">
      <div class="form-group">
        <label for="email">Email:</label>
        <input type="email" id="email" v-model="email" required />
      </div>
      <div class="form-group">
        <label for="password">Password:</label>
        <input type="password" id="password" v-model="password" required />
      </div>
      <button type="submit" class="login-button">Login</button>
    </form>
    <p v-if="loginError" class="error-message">Invalid credentials, please try again.</p>
    <p class="register-link">Don't have an account? <router-link to="/register">Register here</router-link></p>
  </div>
</template>

<script>
import { ref } from 'vue';
import { useStore } from 'vuex';
import { useRouter } from 'vue-router';

export default {
  setup() {
    const store = useStore();
    const router = useRouter();
    const email = ref('');
    const password = ref('');
    const loginError = ref(false);

    const handleLogin = () => {
      const url = new URL('/api/customer/login', window.location.origin);
      url.searchParams.append('email', email.value);
      url.searchParams.append('password', password.value);

      fetch(url, {
        method: 'GET',
        headers: {
          'Accept': 'application/json',
        },
      })
          .then(response => response.json())
          .then(data => {
            if (data) {  // Adjust based on your backend's response
              store.commit('setAuthentication', true);
              router.push('/home');
            } else {
              loginError.value = true;
            }
          })
          .catch(error => {
            console.error("Login failed:", error);
            loginError.value = true;
          });
    };

    return {email, password, handleLogin, loginError};
  }
};
</script>

<style scoped>
.login-container {
  max-width: 360px;
  margin: 5% auto;
  padding: 2rem;
  border-radius: 8px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  background-color: #ffffff;
}

h2 {
  text-align: center;
  margin-bottom: 1rem;
  color: #333;
}

.form-group {
  margin-bottom: 1rem;
}

label {
  display: block;
  margin-bottom: 0.5rem;
  color: #555;
}

input[type="email"], input[type="password"] {
  width: 100%;
  padding: 0.75rem;
  border: 1px solid #ddd;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type="email"]:focus, input[type="password"]:focus {
  border-color: #007bff;
  outline: none;
}

button.login-button {
  width: 100%;
  padding: 0.75rem;
  border: none;
  border-radius: 4px;
  background-color: #007bff;
  color: #fff;
  font-size: 1rem;
  cursor: pointer;
}

button.login-button:hover {
  background-color: #0056b3;
}

.error-message {
  color: #e74c3c;
  text-align: center;
  margin-top: 1rem;
}
</style>
