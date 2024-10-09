import { createStore } from 'vuex';
import AuthService from "@/AuthService";

export const store = createStore({
    state: {
        isAuthenticated: false,
        user: null,
        error: null, // To store error messages
        loading: false // To manage loading state
    },
    mutations: {
        SET_AUTHENTICATION(state, status) {
            state.isAuthenticated = status;
        },
        SET_USER(state, user) {
            state.user = user;
        },
        SET_ERROR(state, error) {
            state.error = error; // Set error message
        },
        SET_LOADING(state, loading) {
            state.loading = loading; // Set loading state
        }
    },
    actions: {
        async login({ commit }, user) {
            commit('SET_LOADING', true); // Start loading
            commit('SET_ERROR', null); // Clear any previous errors
            try {
                const response = await AuthService.login(user); // Call the API
                commit('SET_AUTHENTICATION', true); // Update authentication state
                commit('SET_USER', response.data); // Store user info

                // Optionally, set admin status based on email
                if (user.email === 'admin@gmail.com') {
                    commit('SET_ADMIN_STATUS', true);
                } else {
                    commit('SET_ADMIN_STATUS', false);
                }
            } catch (error) {
                console.error("Login failed:", error);
                commit('SET_ERROR', "Invalid email or password."); // Set error message
            } finally {
                commit('SET_LOADING', false); // End loading
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
            } catch (error) {
                console.error("Logout failed:", error);
                commit('SET_ERROR', "Logout failed. Please try again."); // Optionally handle logout errors
            }
        }
    },
});

// Don't forget to export the store
export default store;
