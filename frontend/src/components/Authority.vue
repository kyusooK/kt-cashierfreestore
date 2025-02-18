<template>
    <div>
        <String label="사용자이름" v-model="value.userName" :editMode="editMode"/>
        <String label="사용자 직급" v-model="value.rank" :editMode="editMode"/>
        <String label="사용자 부서" v-model="value.department" :editMode="editMode"/>
        <String label="이용가능 시간" v-model="value.availableTime" :editMode="editMode"/>

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
    name: 'Authority',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "authorities"
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>
