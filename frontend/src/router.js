
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import UserUserManager from "./components/listers/UserUserCards"
import UserUserDetail from "./components/listers/UserUserDetail"

import StoreStoreManager from "./components/listers/StoreStoreCards"
import StoreStoreDetail from "./components/listers/StoreStoreDetail"

import AuthorityAuthorityManager from "./components/listers/AuthorityAuthorityCards"
import AuthorityAuthorityDetail from "./components/listers/AuthorityAuthorityDetail"

import RecordingStoreUsingManager from "./components/listers/RecordingStoreUsingCards"
import RecordingStoreUsingDetail from "./components/listers/RecordingStoreUsingDetail"
import RecordingAuthorityChaningManager from "./components/listers/RecordingAuthorityChaningCards"
import RecordingAuthorityChaningDetail from "./components/listers/RecordingAuthorityChaningDetail"
import RecordingWarningManager from "./components/listers/RecordingWarningCards"
import RecordingWarningDetail from "./components/listers/RecordingWarningDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/users/users',
                name: 'UserUserManager',
                component: UserUserManager
            },
            {
                path: '/users/users/:id',
                name: 'UserUserDetail',
                component: UserUserDetail
            },

            {
                path: '/stores/stores',
                name: 'StoreStoreManager',
                component: StoreStoreManager
            },
            {
                path: '/stores/stores/:id',
                name: 'StoreStoreDetail',
                component: StoreStoreDetail
            },

            {
                path: '/authorities/authorities',
                name: 'AuthorityAuthorityManager',
                component: AuthorityAuthorityManager
            },
            {
                path: '/authorities/authorities/:id',
                name: 'AuthorityAuthorityDetail',
                component: AuthorityAuthorityDetail
            },

            {
                path: '/recordings/storeUsings',
                name: 'RecordingStoreUsingManager',
                component: RecordingStoreUsingManager
            },
            {
                path: '/recordings/storeUsings/:id',
                name: 'RecordingStoreUsingDetail',
                component: RecordingStoreUsingDetail
            },
            {
                path: '/recordings/authorityChanings',
                name: 'RecordingAuthorityChaningManager',
                component: RecordingAuthorityChaningManager
            },
            {
                path: '/recordings/authorityChanings/:id',
                name: 'RecordingAuthorityChaningDetail',
                component: RecordingAuthorityChaningDetail
            },
            {
                path: '/recordings/warnings',
                name: 'RecordingWarningManager',
                component: RecordingWarningManager
            },
            {
                path: '/recordings/warnings/:id',
                name: 'RecordingWarningDetail',
                component: RecordingWarningDetail
            },



    ]
})
