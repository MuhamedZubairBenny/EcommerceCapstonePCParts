import { createStore } from 'vuex';
import AuthService from "@/AuthService";
import axios from "axios";

export const store = createStore({
    state: {
        isAuthenticated: false,
        user: {},
        error: null, // To store error messages
        loading: false // To manage loading state
    },
    mutations: {
        SET_AUTHENTICATION(state, status) {
            state.isAuthenticated = status;
            localStorage.setItem('user', JSON.stringify(status));
        },
        SET_USER(state, user) {
            state.user = user;
        },
        SET_ERROR(state, error) {
            state.error = error; // Set error message
        },
        SET_ADMIN_STATUS(state, isAdmin) {
            state.isAdmin = isAdmin; // or however you manage admin status in your state
        },
        SET_LOADING(state, loading) {
            state.loading = loading; // Set loading state
        },
        SET_SHIPPING(state, shipping) {
            if (state.user) {
                state.user.shipping = shipping;
            }
        }
    },
    actions: {
        initializeStore({ commit }) {
            const user = JSON.parse(localStorage.getItem('user'));
            if (user) {
                commit('SET_AUTHENTICATION', user);
            }
        },
        fetchUserByEmail({ commit }, email) {
            return AuthService.getUserByEmail(email)
                .then(userFetched => {
                    commit('SET_USER', userFetched); // Commit the mutation to update user state
                });
        },
        async login({ commit }, user) {
            commit('SET_LOADING', true);
            commit('SET_ERROR', null);
            try {
                const response = await AuthService.login(user);
                commit('SET_AUTHENTICATION', true);
                commit('SET_USER', response.data);

                if (user.email === 'admin@gmail.com') {
                    commit('SET_ADMIN_STATUS', true);
                } else {
                    commit('SET_ADMIN_STATUS', false);
                }

                // Redirect to the homepage after successful login
                this.$router.push('/home'); // Adjust the route as needed

            } catch (error) {
                console.error("Login failed:", error);
                commit('SET_ERROR', "Invalid email or password.");
            } finally {
                commit('SET_LOADING', false);
            }
        },
        async register({ commit }, user) {
            commit('SET_LOADING', true); // Start loading
            commit('SET_ERROR', null); // Clear any previous errors
            try {
                const response = await AuthService.register(user); // Call the API
                commit('SET_AUTHENTICATION', true); // Update authentication state
                commit('SET_USER', response.data); // Store user info

                // Optionally, set admin status based on email
                if (user.email === 'admin@gmail.com') {
                    commit('SET_ADMIN_STATUS', true);
                } else {
                    commit('SET_ADMIN_STATUS', false);
                }
            } catch (error) {
                console.error("Registration failed:", error);
                commit('SET_ERROR', "Registration failed. Please try again."); // Set error message
            } finally {
                commit('SET_LOADING', false); // End loading
            }
        },
        async logout({ commit }, user) {
            try {
                await AuthService.logout(user);
                commit('SET_AUTHENTICATION', false);
                commit('SET_USER', null);
                commit('SET_ERROR', null); // Clear errors on logout
                localStorage.removeItem('user');
            } catch (error) {
                console.error("Logout failed:", error);
                commit('SET_ERROR', "Logout failed. Please try again."); // Optionally handle logout errors
            }
        },
        async updateShipping({ commit }, shipping) {
            try {
                const response = await axios.post('/api/shipping/update', shipping);
                commit('SET_SHIPPING', response.data); // Update the shipping details in Vuex store
                return response.data;
            } catch (error) {
                console.error('Failed to update shipping:', error);
                throw error;
            }
        },
    },
});

// Don't forget to export the store
export default store;
