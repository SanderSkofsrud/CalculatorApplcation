import router from '../../router';
import store from '@/store'; // Ensure this path is correct for your project structure

export default async function sessionToken() {
    // Get the token from Vuex store instead of localStorage
    const token = store.state.auth.token;

    if (token === null) {
        alert("Log in to access your profile!");
        await router.push("/login");
        throw new Error("Session token cannot be null. Login in again.");
    }

    return token;
}
