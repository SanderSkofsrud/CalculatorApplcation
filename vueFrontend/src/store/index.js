import { createStore } from 'vuex';
import createPersistedState from 'vuex-persistedstate';

export default createStore({
    state: {
        contact: {
            name: '',
            email: ''
        },
        auth: {
            token: null,
            username: null
        }
    },
    mutations: {
        updateName(state, name) {
            state.contact.name = name;
        },
        updateEmail(state, email) {
            state.contact.email = email;
        },
        updateContact(state, contact) {
            state.contact.name = contact.name;
            state.contact.email = contact.email;
        },
        updateContactForm(state, formData) {
            state.contactForm = formData;
        },
        setAuthToken(state, token) {
            state.auth.token = token;
        },
        setUsername(state, username) {
            state.auth.username = username;
        },
        clearAuthData(state) {
            state.auth.token = null;
            state.auth.username = null;
        }
    },
    actions: {
        loginUser({ commit }, { token, username }) {
            commit('setAuthToken', token);
            commit('setUsername', username);
        },
        logoutUser({ commit }) {
            commit('clearAuthData');
        }
    },
    modules: {},
    plugins: [
        createPersistedState({
            storage: window.sessionStorage, // Use sessionStorage
            paths: ['auth'], // Persist only the auth module
        })
    ],
});