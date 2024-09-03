<template>
  <div class="register-container">
    <h2>Register</h2>
    <form @submit.prevent="handleRegister">
      <div class="form-group">
        <label for="firstName">First Name:</label>
        <input type="text" id="firstName" v-model="firstName" required />
      </div>
      <div class="form-group">
        <label for="lastName">Last Name:</label>
        <input type="text" id="lastName" v-model="lastName" required />
      </div>
      <div class="form-group">
        <label for="email">Email:</label>
        <input type="email" id="email" v-model="email" required />
      </div>
      <div class="form-group">
        <label for="password">Password:</label>
        <input type="password" id="password" v-model="password" required />
      </div>
      <button type="submit" class="register-button">Register</button>
    </form>
    <p v-if="registerError" class="error-message">Registration failed, please try again.</p>
    <p class="register-link">Want to login? <router-link to="/login">Login here</router-link></p>

  </div>
</template>

<script>
import { ref } from 'vue'; // Import ref from Vue
import { useStore } from 'vuex'; // Import useStore
import { useRouter } from 'vue-router'; // Import useRouter

export default {
  setup() {
    const store = useStore(); // Use the store
    const router = useRouter(); // Use the router

    const firstName = ref('');
    const lastName = ref('');
    const email = ref('');
    const password = ref('');
    const registerError = ref(false);

    const handleRegister = async () => {
      try {
        const success = await store.dispatch('register', {
          email: email.value,
          password: password.value,
          firstName: firstName.value,
          lastName: lastName.value
        });

        if (success) {
          router.push('/home'); // Redirect to home page on successful registration
        } else {
          registerError.value = true; // Display error if registration fails
        }
      } catch (error) {
        console.error("Registration failed:", error);
        registerError.value = true; // Display error if an exception occurs
      }
    };

    return {firstName, lastName, email, password, handleRegister, registerError};
  }
};
</script>

<style scoped>
/* Styling for the registration page */
.register-container {
  max-width: 400px;
  margin: 5% auto;
  padding: 2rem;
  border-radius: 8px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  background-color: #ffffff;
}

h2 {
  text-align: center;
  margin-bottom: 1.5rem;
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

input[type="text"], input[type="email"], input[type="password"] {
  width: 100%;
  padding: 0.75rem;
  border: 1px solid #ddd;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type="text"]:focus, input[type="email"]:focus, input[type="password"]:focus {
  border-color: #007bff;
  outline: none;
}

button.register-button {
  width: 100%;
  padding: 0.75rem;
  border: none;
  border-radius: 4px;
  background-color: #28a745;
  color: #fff;
  font-size: 1rem;
  cursor: pointer;
}

button.register-button:hover {
  background-color: #218838;
}

.error-message {
  color: #e74c3c;
  text-align: center;
  margin-top: 1rem;
}
</style>
