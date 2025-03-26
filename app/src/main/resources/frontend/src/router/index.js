import { createRouter, createWebHistory } from 'vue-router'
import LoginView from '../views/auth/LoginView.vue'
import AccountListView from '../views/account/AccountListView.vue'
import AccountRegisterView from '../views/account/AccountRegisterView.vue'

const routes = [
  {
    path: '/',
    name: 'Login',
    component: LoginView
  },
  {
    path: '/accounts',
    name: 'AccountList',
    component: AccountListView
  },
  {
    path: '/accounts/register',
    name: 'AccountRegister',
    component: AccountRegisterView
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
