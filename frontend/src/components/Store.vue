<template>
    <div>
        <String label="이름" v-model="value.userName" :editMode="editMode"/>
        <String label="사원증" v-model="value.employeeIdCard" :editMode="editMode"/>
        <Date label="출입시간" v-model="value.enteringAt" :editMode="editMode"/>
        <Date label="퇴장시간" v-model="value.exitAt" :editMode="editMode"/>
        <Date label="입장가능시간" v-model="value.availableStartAt" :editMode="editMode"/>
        <Date label="이용종료시간" v-model="value.availableEndAt" :editMode="editMode"/>
        <UserId offline label="userId" v-model="value.userId" :editMode="editMode" @change="change"/>
        <EnterStatus offline label="출입상태" v-model="value.enterStatus" :editMode="editMode" @change="change"/>

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
    name: 'Store',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "stores"
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>
