import { createRouter, createWebHashHistory } from 'vue-router';

const router = createRouter({
  history: createWebHashHistory(),
  routes: [
    {
      path: '/',
      component: () => import('../components/pages/Index.vue'),
    },
    {
      path: '/users/users',
      component: () => import('../components/ui/UserGrid.vue'),
    },
    {
      path: '/stores/stores',
      component: () => import('../components/ui/StoreGrid.vue'),
    },
    {
      path: '/authorities/authorities',
      component: () => import('../components/ui/AuthorityGrid.vue'),
    },
    {
      path: '/recordings/storeUsings',
      component: () => import('../components/ui/StoreUsingGrid.vue'),
    },
    {
      path: '/recordings/authorityChanings',
      component: () => import('../components/ui/AuthorityChaningGrid.vue'),
    },
    {
      path: '/recordings/warnings',
      component: () => import('../components/ui/WarningGrid.vue'),
    },
  ],
})

export default router;
