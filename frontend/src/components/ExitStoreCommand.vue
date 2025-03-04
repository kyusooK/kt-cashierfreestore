<template>
    <v-card outlined>
        <v-card-title>
            ExitStore
        </v-card-title>

        <v-card-text>
            <String label="EmployeeIdCard" v-model="value.employeeIdCard" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="exitStore"
            >
                ExitStore
            </v-btn>
            
            <v-btn
                    color="primary"
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
        name: 'ExitStoreCommand',
        components:{},
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
            exitStore() {
                this.$emit('exitStore', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

