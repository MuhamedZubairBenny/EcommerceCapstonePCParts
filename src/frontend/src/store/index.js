// import { createStore } from 'vuex';
// import axios from 'axios';
//
// const store = createStore({
//     state() {
//         return {
//             isAuthenticated: false,
//             isAdmin: false,
//             user: null // Store user details if needed
//         };
//     },
//     mutations: {
//         setAuthentication(state, status) {
//             state.isAuthenticated = status;
//         },
//         setAdminStatus(state, status) {
//             state.isAdmin = status;
//         },
//         setUser(state, user) {
//             state.user = user;
//         }
//     },
//     actions: {
//         async login({ commit }, { email, password }) {
//             try {
//                 const response = await axios.post('/auth/login', { email, password });
//                 if (response.data) {
//                     commit('setAuthentication', true);
//                     commit('setUser', { email }); // You may want to store more user details if available
//
//                     // Set admin status based on email
//                     if (email === 'admin@gmail.com') {
//                         commit('setAdminStatus', true);
//                     } else {
//                         commit('setAdminStatus', false);
//                     }
//
//                     return true;
//                 } else {
//                     commit('setAuthentication', false);
//                     commit('setAdminStatus', false);
//                     return false;
//                 }
//             } catch (error) {
//                 console.error('Login failed:', error);
//                 commit('setAuthentication', false);
//                 commit('setAdminStatus', false);
//                 return false;
//             }
//         },
//         async register({ commit }, { email, password, firstName, lastName }) {
//             try {
//                 const response = await axios.post('/auth/register', {
//                     email,
//                     password,
//                     firstName,
//                     lastName
//                 });
//                 if (response.status === 200) {
//                     commit('setAuthentication', true);
//                     commit('setUser', { email }); // Store user details
//
//                     // Set admin status based on email
//                     if (email === 'admin@gmail.com') {
//                         commit('setAdminStatus', true);
//                     } else {
//                         commit('setAdminStatus', false);
//                     }
//
//                     return true;
//                 } else {
//                     commit('setAuthentication', false);
//                     commit('setAdminStatus', false);
//                     return false;
//                 }
//             } catch (error) {
//                 console.error('Registration failed:', error);
//                 commit('setAuthentication', false);
//                 commit('setAdminStatus', false);
//                 return false;
//             }
//         },
//         logout({ commit }) {
//             commit('setAuthentication', false);
//             commit('setAdminStatus', false);
//             commit('setUser', null); // Clear user details
//         }
//     }
// });
//
// export default store;
// store.js

//import Vue from 'vue'; // Ensure Vue is imported
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
            } catch (error) {
                console.error("Login failed:", error);
                commit('SET_ERROR', "Invalid email or password."); // Set error message
            } finally {
                commit('SET_LOADING', false); // End loading
            }
        },
        logout({ commit }, user) {
            return AuthService.logout(user)
                .then(() => {
                    commit('SET_AUTHENTICATION', false);
                    commit('SET_USER', null);
                    commit('SET_ERROR', null); // Clear errors on logout
                })
                .catch(error => {
                    // Optionally handle any errors here
                    commit('SET_ERROR', error.response.data);
                });
        }
    },
});

// Don't forget to export the store
export default store;


