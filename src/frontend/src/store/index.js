import { createStore } from 'vuex';
import axios from 'axios';

const store = createStore({
    state() {
        return {
            isAuthenticated: false,
            isAdmin: false
        };
    },
    mutations: {
        setAuthentication(state, status) {
            state.isAuthenticated = status;
        },
        setAdminStatus(state, status) {
            state.isAdmin = status;
        }
    },
    actions: {
        async login({ commit }, { email, password }) {
            try {
                const response = await axios.get(`/api/customer/login/${email}/${password}`);
                if (response.data) {
                    commit('setAuthentication', true);

                    // Set admin status based on email
                    if (email === 'admin@gmail.com') {
                        commit('setAdminStatus', true);
                    } else {
                        commit('setAdminStatus', false);
                    }

                    return true;
                } else {
                    commit('setAuthentication', false);
                    commit('setAdminStatus', false);
                    return false;
                }
            } catch (error) {
                console.error('Login failed:', error);
                commit('setAuthentication', false);
                commit('setAdminStatus', false);
                return false;
            }
        },
        async register({ commit }, { email, password, firstName, lastName }) {
            try {
                const response = await axios.post('/api/customer/register', {
                    email,
                    password,
                    firstName,
                    lastName
                });
                if (response.status === 200) {
                    commit('setAuthentication', true);

                    // Set admin status based on email
                    if (email === 'admin@gmail.com') {
                        commit('setAdminStatus', true);
                    } else {
                        commit('setAdminStatus', false);
                    }

                    return true;
                } else {
                    commit('setAuthentication', false);
                    commit('setAdminStatus', false);
                    return false;
                }
            } catch (error) {
                console.error('Registration failed:', error);
                commit('setAuthentication', false);
                commit('setAdminStatus', false);
                return false;
            }
        },
        logout({ commit }) {
            commit('setAuthentication', false);
            commit('setAdminStatus', false);
        }
    }
});

export default store;
