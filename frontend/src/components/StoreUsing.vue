<template>
    <div>
        <String label="입장시간" v-model="value.enteringDate" :editMode="editMode"/>
        <String label="퇴장시간" v-model="value.exitDate" :editMode="editMode"/>
        <StoreId offline label="storeId" v-model="value.storeId" :editMode="editMode" @change="change"/>

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
    name: 'StoreUsing',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "storeUsings"
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>
