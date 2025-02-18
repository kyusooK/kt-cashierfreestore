<template>

    <v-card outlined>
        <v-card-title>
            UpdateAuthority
        </v-card-title>

        <v-card-text>
            <String label="AvailableTime" v-model="value.availableTime" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="updateAuthority"
            >
                UpdateAuthority
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
    name: 'UpdateAuthorityCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.availableTime = '';
    },
    watch: {
    },
    methods: {
        updateAuthority() {
            this.$emit('updateAuthority', this.value);
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

