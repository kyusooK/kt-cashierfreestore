<template>
    <v-container>
        <v-snackbar
            v-model="snackbar.status"
            :timeout="snackbar.timeout"
            :color="snackbar.color"
        >
            
            <v-btn style="margin-left: 80px;" text @click="snackbar.status = false">
                Close
            </v-btn>
        </v-snackbar>
        <div class="panel">
            <div class="gs-bundle-of-buttons" style="max-height:10vh;">
                <v-btn @click="addNewRow" @class="contrast-primary-text" small color="primary">
                    <v-icon small style="margin-left: -5px;">mdi-plus</v-icon>등록
                </v-btn>
                <v-btn style="margin-left: 5px;" @click="openEditDialog()" class="contrast-primary-text" small color="primary">
                    <v-icon small>mdi-pencil</v-icon>수정
                </v-btn>
                <v-btn style="margin-left: 5px;" @click="enterStoreDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('Employee')">
                    <v-icon small>mdi-minus-circle-outline</v-icon>매장 입장
                </v-btn>
                <v-dialog v-model="enterStoreDialog" width="500">
                    <EnterStore
                        @closeDialog="enterStoreDialog = false"
                        @enterStore="enterStore"
                    ></EnterStore>
                </v-dialog>
                <v-btn style="margin-left: 5px;" @click="exitStoreDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('Employee')">
                    <v-icon small>mdi-minus-circle-outline</v-icon>매장 퇴장
                </v-btn>
                <v-dialog v-model="exitStoreDialog" width="500">
                    <ExitStore
                        @closeDialog="exitStoreDialog = false"
                        @exitStore="exitStore"
                    ></ExitStore>
                </v-dialog>
            </div>
            <div class="mb-5 text-lg font-bold"></div>
            <div class="table-responsive">
                <v-table>
                    <thead>
                        <tr>
                        <th>Id</th>
                        <th>이름</th>
                        <th>사원증</th>
                        <th>출입시간</th>
                        <th>퇴장시간</th>
                        <th>입장가능시간</th>
                        <th>이용종료시간</th>
                        <th>userId</th>
                        <th>출입상태</th>
                        <th>이용가능시간</th>
                        <th>사용자</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="(val, idx) in value" :key="val" @click="changeSelectedRow(val)" :style="val === selectedRow ? 'background-color: #f0f3ff;':''">
                            <td class="font-semibold">{{ idx + 1 }}</td>
                            <td class="whitespace-nowrap" label="이름">{{ val.userName }}</td>
                            <td class="whitespace-nowrap" label="사원증">{{ val.employeeIdCard }}</td>
                            <td class="whitespace-nowrap" label="출입시간">{{ val.enteringAt }}</td>
                            <td class="whitespace-nowrap" label="퇴장시간">{{ val.exitAt }}</td>
                            <td class="whitespace-nowrap" label="입장가능시간">{{ val.availableStartAt }}</td>
                            <td class="whitespace-nowrap" label="이용종료시간">{{ val.availableEndAt }}</td>
                            <td class="whitespace-nowrap" label="출입상태">{{ val.enterStatus }}</td>
                            <td class="whitespace-nowrap" label="이용가능시간">{{ val.availableTime }}</td>
                            <td class="whitespace-nowrap" label="사용자">
                                <UserId :editMode="editMode" v-model="val.userId"></UserId>
                            </td>
                            <Icon style="margin-top: 15px;" icon="mi:delete" @click="deleteRow(val)" />
                        </tr>
                    </tbody>
                </v-table>
            </div>
        </div>
        <v-col>
            <v-dialog
                v-model="openDialog"
                transition="dialog-bottom-transition"
                width="35%"
            >
                <v-card>
                    <v-toolbar
                        color="primary"
                        class="elevation-0"
                        height="50px"
                    >
                        <div style="color:white; font-size:17px; font-weight:700;">Store 등록</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <Store :offline="offline"
                            :isNew="!value.idx"
                            :editMode="true"
                            :inList="false"
                            v-model="newValue"
                            @add="append"
                        />
                    </v-card-text>
                </v-card>
            </v-dialog>
            <v-dialog
                v-model="editDialog"
                transition="dialog-bottom-transition"
                width="35%"
            >
                <v-card>
                    <v-toolbar
                        color="primary"
                        class="elevation-0"
                        height="50px"
                    >
                        <div style="color:white; font-size:17px; font-weight:700;">Store 수정</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <div>
                            <String label="이름" v-model="selectedRow.userName" :editMode="true"/>
                            <String label="사원증" v-model="selectedRow.employeeIdCard" :editMode="true"/>
                            <Date label="출입시간" v-model="selectedRow.enteringAt" :editMode="true"/>
                            <Date label="퇴장시간" v-model="selectedRow.exitAt" :editMode="true"/>
                            <Date label="입장가능시간" v-model="selectedRow.availableStartAt" :editMode="true"/>
                            <Date label="이용종료시간" v-model="selectedRow.availableEndAt" :editMode="true"/>
                            <String label="이용가능시간" v-model="selectedRow.availableTime" :editMode="true"/>
                            <UserId offline label="userId" v-model="selectedRow.userId" :editMode="true"/>
                            <EnterStatus offline label="출입상태" v-model="selectedRow.enterStatus" :editMode="true"/>
                            <v-divider class="border-opacity-100 my-divider"></v-divider>
                            <v-layout row justify-end>
                                <v-btn
                                    width="64px"
                                    color="primary"
                                    @click="save"
                                >
                                    수정
                                </v-btn>
                            </v-layout>
                        </div>
                    </v-card-text>
                </v-card>
            </v-dialog>
        </v-col>
    </v-container>
</template>

<script>
import { ref } from 'vue';
import { useTheme } from 'vuetify';
import BaseGrid from '../base-ui/BaseGrid.vue'


export default {
    name: 'storeGrid',
    mixins:[BaseGrid],
    components:{
    },
    data: () => ({
        path: 'stores',
        enterStoreDialog: false,
        exitStoreDialog: false,
    }),
    watch: {
    },
    methods:{
        enterStore(params){
            try{
                this.repository.invoke(this.getSelectedItem(), "enterStore", params)
                this.$EventBus.$emit('show-success','enter store 성공적으로 처리되었습니다.')
                this.enterStoreDialog = false
            }catch(e){
                console.log(e)
            }
            
        },
        exitStore(params){
            try{
                this.repository.invoke(this.getSelectedItem(), "exitStore", params)
                this.$EventBus.$emit('show-success','exit store 성공적으로 처리되었습니다.')
                this.exitStoreDialog = false
            }catch(e){
                console.log(e)
            }
            
        },
    }
}

</script>