import store from '@/store'


export default async function logout () {
    store.commit('CLEAR_ALL')
}