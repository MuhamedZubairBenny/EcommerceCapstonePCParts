import axios from 'axios';

const API_BASE_URL = "http://localhost:8080/auth";

class AuthService {
    register(user) {
        return axios.post(`${API_BASE_URL}/register`, user);
    }

    login(user) {
        return axios.post(`${API_BASE_URL}/login`, user);
    }

    logout(user){
        return axios.post(`${API_BASE_URL}/logout`, user);
    }

    getUserByEmail(email) {
        return axios.get(`${API_BASE_URL}/findByEmail/${email}`)
            .then(response => response.data)
            .catch(error => {
                console.error('Error fetching user by email:', error);
                throw error; // Rethrow the error for further handling
            });
    }
}

export default new AuthService();