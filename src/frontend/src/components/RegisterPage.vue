<template>
  <div class="register-container">
    <h2>Register</h2>
    <form @submit.prevent="handleRegister">
      <div>
        <label for="firstName">First Name:</label>
        <input type="text" v-model="firstName" required />
      </div>
      <div>
        <label for="lastName">Last Name:</label>
        <input type="text" v-model="lastName" required />
      </div>
      <div>
        <label for="email">Email:</label>
        <input type="email" v-model="email" required />
      </div>
      <div>
        <label for="password">Password:</label>
        <input type="password" v-model="password" required />
      </div>
      <button type="submit">Register</button>
    </form>
    <p v-if="registerError">Registration failed, please try again.</p>
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
/* Add some basic styling */
.register-container {
  max-width: 400px;
  margin: 0 auto;
}
</style>
