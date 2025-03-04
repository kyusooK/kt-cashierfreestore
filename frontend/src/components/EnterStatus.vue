<template>
    <div>
        <v-card-title>
            EnterStatus
        </v-card-title>
        <v-card-text>
            <div v-if="editMode">
                <v-select
                        v-model="newValue"
                        :label="'name'"
                        :items="enterStatusList"
                ></v-select>
            </div>
            <div v-else>
                EnterStatus : {{ value }}
            </div>
        </v-card-text>
    </div>
</template>

<script>
    export default {
        name: 'EnterStatus',
        components:{},
        props: {
            value: [Object, String, Number, Boolean, Array],
            editMode: Boolean,
            isNew: Boolean,
            offline: Boolean,
            inList: Boolean,
            label: String,
        },
        data: () => ({
            enterStatusList : [ "ENTERED",  "EXITED", ],
            newValue: '',
        }),
        async created() {
            if(!this.value) {
                this.newValue = this.enterStatusList[0];
            } else {
                this.newValue = this.value;
            }
        },
        watch: {
            value(val) {
                this.$emit('input', val);
            },
            newValue(val) {
                this.$emit('input', val);
            },
        },
        methods: {
        }
    }
</script>

