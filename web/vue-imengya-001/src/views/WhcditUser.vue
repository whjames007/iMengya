<template>
  <div>
    <!-- 查询条件 -->
    <el-form :model="param" size="mini" label-width="100px">
      <el-row>
        <el-col :span="6"><el-form-item label="用户工号"><el-input v-model="param.systemUserAccount" :placeholder="whc.cont.vague"></el-input></el-form-item></el-col>
        <el-col :span="6"><el-form-item label="用户名称"><el-input v-model="param.systemUserNickname" :placeholder="whc.cont.vague"></el-input></el-form-item></el-col>
        <el-col :span="6"><el-form-item label="用户角色"><el-select v-model="param.systemRoleId"><el-option v-for="item in roles" :key="item.systemRoleId" :label="item.systemRoleName" :value="item.systemRoleId"></el-option></el-select></el-form-item></el-col>
        <el-col :span="6" class="whc-col-search"><el-form-item>
          <el-button type="primary" icon="el-icon-search" @click="tableMethodSearch">{{whc.cont.search}}</el-button>
          <el-button type="warning" icon="el-icon-refresh-left" @click="tableMethodReset">{{whc.cont.reset}}</el-button>
          <el-button type="success" icon="el-icon-plus" @click="dialogMethodOpen(null)">{{whc.cont.add}}</el-button>
        </el-form-item></el-col>
      </el-row>
    </el-form>
    <!-- 分页表格 -->
    <el-table :data="pages" size="mini" stripe border highlight-current-row>
      <el-table-column prop="length" label="序号" type="index" width="60"/>
      <el-table-column label="最后登录时间" show-overflow-tooltip><template slot-scope="scope">{{whc.dfmt.dts(scope.row.lastLoginTime)}}</template></el-table-column>
      <el-table-column prop="systemRoleName" label="用户角色" show-overflow-tooltip/>
      <el-table-column prop="systemCenterName" label="中心名称" show-overflow-tooltip/>
      <el-table-column prop="systemDepartmentName" label="部门名称" show-overflow-tooltip/>
      <el-table-column prop="systemUserAccount" label="工号" show-overflow-tooltip/>
      <el-table-column prop="systemUserNickname" label="用户名称" show-overflow-tooltip/>
      <el-table-column prop="systemUserAccname" label="用户联名" show-overflow-tooltip/>
      <el-table-column label="最后更新时间" width="140"><template slot-scope="scope">{{whc.dfmt.dts(scope.row.lastUpdateDate)}}</template></el-table-column>
      <el-table-column label="操作" width="140"><template slot-scope="scope"><el-link type="primary" @click="dialogMethodOpen(scope.row)">编辑</el-link> <el-link type="danger" @click="tableMethodDel(scope.row)">删除</el-link> <el-link type="success" @click="tableMethodInit(scope.row)">初始化</el-link></template></el-table-column>
    </el-table>
    <div class="whc-div-pagination"><el-pagination @size-change="tableMethodSize" @current-change="tableMethodCurr" :current-page="param.pageNum" :page-sizes="whc.cont.pageArray" :page-size="param.pageSize" background layout="total, sizes, prev, pager, next, jumper" :total="totalRows"></el-pagination></div>
    <!-- 操作对话框 -->
    <el-dialog :title="dialogTitle" :visible.sync="dialogShow" width="30%">
      <el-form :model="dialogData" ref="dialogData" :rules="dialogRules" size="mini" label-width="100px">
        <el-form-item label="所属部门" prop="systemDepartmentId"><el-select v-model="dialogData.systemDepartmentId"><el-option v-for="item in depts" :key="item.systemDepartmentId" :label="item.systemDepartmentName" :value="item.systemDepartmentId"></el-option></el-select></el-form-item>
        <el-form-item label="用户角色" prop="systemRoleId"><el-select v-model="dialogData.systemRoleId"><el-option v-for="item in roles" :key="item.systemRoleId" :label="item.systemRoleName" :value="item.systemRoleId"></el-option></el-select></el-form-item>
        <el-form-item label="工号" prop="systemUserAccount"><el-input v-model.trim="dialogData.systemUserAccount"></el-input></el-form-item>
        <el-form-item label="用户名称" prop="systemUserNickname"><el-input v-model.trim="dialogData.systemUserNickname"></el-input></el-form-item>
        <el-form-item v-show="dialogPasswordShow" label="用户密码" prop="systemUserPassword"><el-input :disabled="passwordStatus" v-model.trim="dialogData.systemUserPassword"></el-input></el-form-item>
        <el-form-item class="whc-dialog-button"><el-button type='primary' plain icon="el-icon-folder" @click="dialogMethodClose">取消</el-button><el-button type='primary' size="mini" icon="el-icon-folder-checked" @click="dialogMethodSave">确认</el-button></el-form-item>
      </el-form>
    </el-dialog>
  </div>
</template>

<script>
const log = '【用户管理子页面】'
export default {
  name: 'WhcditUser',
  data () {
    return {
      param: {uid: null, pageNum: null, pageSize: null, systemUserAccount: null, systemUserNickname: null, systemRoleId: null},
      roles: [],
      depts: [],
      pages: [],
      totalRows: 0, // 总行数
      dialogShow: false,
      dialogTitle: null, // 对话框标题
      dialogData: {uid: null, systemUserAccount: null, systemUserPassword: null, systemUserNickname: null, systemRoleId: null, systemDepartmentId: null},
      dialogRules: {systemUserAccount: this.whc.cont.ruleArr001, systemUserPassword: this.whc.cont.ruleArr001, systemUserNickname: this.whc.cont.ruleArr001}, // 各校验对象名称要和参数名称一致
      dialogPasswordShow: false,
      passwordStatus: false
    }
  }, // 利用缓存初始化参数
  mounted () { this.whc.func.paramInit(this.param); this.mountedMethodInit(); this.tableMethodPage() },
  methods: {
    mountedMethodInit () {
      this.$axios.post(this.whc.cont.roleList, {}).then((res) => { if (this.whc.func.respSuccess(res.data.code)) { this.roles = res.data.list } else { this.whc.func.respParse(this, res.data.code) } })
    },
    tableMethodPage () { this.whc.func.postMethodPage(this, this.whc.cont.userPage, this.param) },
    tableMethodSearch () { if (this.param.systemUserAccount || this.param.systemUserNickname || this.param.systemRoleId) { this.param.pageNum = 1 }; this.tableMethodPage() },
    tableMethodReset () { this.param.systemUserAccount = null; this.param.systemUserNickname = null; this.param.systemRoleId = null; this.tableMethodPage() },
    dialogMethodOpen (val) {
      this.dialogShow = true
      this.dialogData.uid = this.param.uid
      if (val) { // 编辑
        this.dialogTitle = this.whc.cont.edit
        this.passwordStatus = true
        this.dialogPasswordShow = false
        let crow = this.whc.func.clone(val)
        this.dialogData.systemUserId = crow.systemUserId
        this.dialogData.systemUserAccount = crow.systemUserAccount
        this.dialogData.systemUserPassword = 'aaabbb' // 先给个字符串蒙混过关
        this.dialogData.systemUserNickname = crow.systemUserNickname
        this.dialogData.systemRoleId = crow.systemRoleId
        this.dialogData.systemDepartmentId = crow.systemDepartmentId
      } else { // 新增
        this.dialogTitle = this.whc.cont.add
        this.passwordStatus = false
        this.dialogPasswordShow = true
        this.dialogData.systemUserId = null
        this.dialogData.systemUserAccount = null
        this.dialogData.systemUserPassword = '123456'
        this.dialogData.systemUserNickname = null
        this.dialogData.systemRoleId = 60
        this.dialogData.systemDepartmentId = this.depts[0].systemDepartmentId
      }
    },
    dialogMethodSave () {
      let url = null
      let msg = null
      let loading = null // 由于新增时，后台要初始化忙闲基础数据，耗时较长
      if (this.dialogData.systemUserId) {
        console.info(log, `调用后台编辑接口并置空密码，可防止mybatis修改密码`)
        url = this.whc.cont.url.userEdit
        msg = this.whc.cont.updateSuccess
        this.dialogData.systemUserPassword = null
      } else {
        console.info(log, `调用后台新增接口`)
        url = this.whc.cont.url.userAdd
        msg = this.whc.cont.createSuccess
        loading = this.$loading(this.whc.cont.loading)
      }
      this.$axios.post(url, this.dialogData).then((res) => {
        if (loading) { loading.close() }
        if (this.whc.func.respSuccess(res.data.code)) {
          this.tableMethodPage()
          this.dialogMethodClose()
          this.$message.success(msg)
        } else { this.whc.func.respParse(this, res.data.code) }
      })
    },
    dialogMethodClose () { this.dialogShow = false; this.$refs['dialogData'].resetFields() },
    tableMethodDel (val) { val.uid = this.param.uid; this.whc.func.postMethodDel(this, this.whc.cont.url.userDel, val) },
    tableMethodInit (val) {
      this.$confirm(this.whc.cont.userInitQuestion, '初始化', {type: 'warning'}).then(() => {
        val.uid = this.param.uid
        val.systemUserPassword = '123456'
        this.axios.post(this.whc.cont.url.userEdit, val).then((res) => {
          if (this.whc.func.respSuccess(res.data.code)) {
            this.$message.success(this.whc.cont.userInitSuccess)
            this.tableMethodPage()
          } else { this.whc.func.respParse(this, res.data.code) }
        })
      }).catch(() => { console.info(`用户放弃了初始化操作！`) })
    },
    tableMethodSize (val) { this.whc.func.tableMethodSize(this, val) },
    tableMethodCurr (val) { this.whc.func.tableMethodCurr(this, val) }
  }
}
</script>

<style scoped>

</style>
