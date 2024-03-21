import { createApp } from 'vue';
import App from './App.vue';
import router from './router';
import store from './store'; // This imports the store from './store/index.js'

const app = createApp(App);
app.use(store);
app.use(router);
app.mount('#app');


import axios from 'axios';

axios.interceptors.request.use(
    (config) => {
        // Accessing the store directly, consider injecting the store if this doesn't work
        const token = store.state.auth.token;

        if (token) {
            config.headers.Authorization = `Bearer ${token}`;
        }
        return config;
    },
    (error) => {
        return Promise.reject(error);
    }
);

