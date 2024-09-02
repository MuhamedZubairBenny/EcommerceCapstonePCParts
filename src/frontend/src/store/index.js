import { createStore } from 'vuex';
import axios from 'axios';

const store = createStore({
    state() {
        return {
            isAuthenticated: false
        };
    },
    mutations: {
        setAuthentication(state, status) {
            state.isAuthenticated = status;
        }
    },
    actions: {
        async login({ commit }, { email, password }) {
            try {
                const response = await axios.get(`/api/customer/login/${email}/${password}`);
                if (response.data) {
                    commit('setAuthentication', true);
                    return true;
                } else {
                    commit('setAuthentication', false);
                    return false;
                }
            } catch (error) {
                console.error('Login failed:', error);
                commit('setAuthentication', false);
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
                    return true;
                } else {
                    commit('setAuthentication', false);
                    return false;
                }
            } catch (error) {
                console.error('Registration failed:', error);
                commit('setAuthentication', false);
                return false;
            }
        },
        logout({ commit }) {
            commit('setAuthentication', false);
        }
    }
});

export default store;
