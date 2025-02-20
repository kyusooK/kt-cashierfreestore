<script setup>
import {
  VerticalNavLink,
  VerticalNavSectionTitle,
} from '@layouts'
</script>

<template>
    <ul>
        <VerticalNavSectionTitle :item="{ heading: '사용자' }" />
        <VerticalNavLink
            :item="{
                title: '사용자',
                to: '/users/users',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: '매장' }" />
        <VerticalNavLink
            :item="{
                title: '매장',
                to: '/stores/stores',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: '인증' }" />
        <VerticalNavLink
            :item="{
                title: '권한',
                to: '/authorities/authorities',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: '기록' }" />
        <VerticalNavLink
            :item="{
                title: '매장이용기록',
                to: '/recordings/storeUsings',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '권한변경기록',
                to: '/recordings/authorityChanings',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '경고상황기록',
                to: '/recordings/warnings',
            }"
        />
    </ul>
</template>
