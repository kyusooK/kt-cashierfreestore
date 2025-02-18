<template>

    <v-card outlined>
        <v-card-title>
            EnterStore
        </v-card-title>

        <v-card-text>
            <String label="EmployeeIdCard" v-model="value.employeeIdCard" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="enterStore"
            >
                EnterStore
            </v-btn>
            
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>

export default {
    name: 'EnterStoreCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.employeeIdCard = '';
    },
    watch: {
    },
    methods: {
        enterStore() {
            this.$emit('enterStore', this.value);
        },
        close() {
            this.$emit('closeDialog');
        },
        change() {
            this.$emit("update:modelValue", this.value);
        },
    }
}
</script>

