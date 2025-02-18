<template>
    <div>
        <String label="권한변경기록" v-model="value.changingAuth" :editMode="editMode"/>
        <AuthorityId offline label="authorityId" v-model="value.authorityId" :editMode="editMode" @change="change"/>

        <v-divider class="border-opacity-100 my-divider"></v-divider>
        <v-layout row justify-end>
            <v-btn
                width="64px"
                color="primary"
                @click="save"
            >
                저장
            </v-btn>
        </v-layout>
    </div>
</template>


<script>

import BaseEntity from './base-ui/BaseEntity.vue'

export default {
    name: 'AuthorityChaning',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "authorityChanings"
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>
