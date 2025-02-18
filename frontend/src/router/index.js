import { createRouter, createWebHashHistory } from 'vue-router';

const router = createRouter({
  history: createWebHashHistory(),
  routes: [
    {
      path: '/',
      component: () => import('../components/pages/Index.vue'),
    },
    {
      path: '/users',
      component: () => import('../components/ui/UserGrid.vue'),
    },
    {
      path: '/stores',
      component: () => import('../components/ui/StoreGrid.vue'),
    },
    {
      path: '/authorities',
      component: () => import('../components/ui/AuthorityGrid.vue'),
    },
    {
      path: '/storeUsings',
      component: () => import('../components/ui/StoreUsingGrid.vue'),
    },
    {
      path: '/authorityChanings',
      component: () => import('../components/ui/AuthorityChaningGrid.vue'),
    },
    {
      path: '/warnings',
      component: () => import('../components/ui/WarningGrid.vue'),
    },
  ],
})

export default router;
