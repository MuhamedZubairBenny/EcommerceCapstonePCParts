<template>
  <div class="login-container">
    <h2>Login</h2>
    <form @submit.prevent="handleLogin">
      <div>
        <label for="email">Email:</label>
        <input type="email" v-model="email" required />
      </div>
      <div>
        <label for="password">Password:</label>
        <input type="password" v-model="password" required />
      </div>
      <button type="submit">Login</button>
    </form>
    <p v-if="loginError">Invalid credentials, please try again.</p>
  </div>
</template>

// Example for LoginPage.vue script
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


    return { email, password, handleLogin, loginError };
  }
};
</script>


<style scoped>
/* Add some basic styling */
.login-container {
  max-width: 300px;
  margin: 0 auto;
}
</style>
