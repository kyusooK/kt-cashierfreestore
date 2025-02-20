<template>
    <div>
        <!-- namefield의 값은 참조하는 어그리거트의 속성값중 하나로 변경하면 변경한 속성에 맞는 필드명이 표시됩니다. -->
        <BasePicker v-if="editMode" searchApiPath="stores" searchParameterName="userName"  idField="id" nameField="userName" path="stores" label="StoreId" v-model="value" @selected="pick" :editMode="editMode" />
        <div v-else style="height:100%">
            <span>{{ value && value.name ? value.name : '' }}</span>
        </div>
    </div>

</template>

<script>
import BaseEntity from './base-ui/BaseEntity.vue'
import BasePicker from './base-ui/BasePicker.vue'

export default {
    name: 'StoreId',
    mixins:[BaseEntity],
    components:{
        BasePicker
    },
    data: () => ({
        path: 'stores',
    }),
    props: {
    },
    watch: {
        value(val){
            this.value = val;
            this.change();
        },
    },
    async created(){
        this.value = this.modelValue
        if (this.value && this.value.id !== undefined) {
            this.value = await this.repository.findById(this.value.id)
        }
    },
    methods: {
        pick(val){
            this.value = val;
            this.change();
        },
    }
}
</script>

