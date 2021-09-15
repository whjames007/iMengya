<template>
  <div>
    <!-- 分页表格 -->
    <el-table :data="pages" size="mini" stripe border highlight-current-row style="width: 99%">
      <el-table-column prop="length" label="序号" type="index" width="60"/>
      <el-table-column prop="systemRoleId" label="角色编号" show-overflow-tooltip/>
      <el-table-column prop="systemRoleName" label="角色名称" show-overflow-tooltip/>
      <el-table-column prop="systemRoleCode" label="角色代码" show-overflow-tooltip/>
      <el-table-column prop="systemRoleDesc" label="角色描述" show-overflow-tooltip/>
      <el-table-column label="最后更新时间" show-overflow-tooltip><template slot-scope="scope">{{whc.dfmt.dts(scope.row.lastUpdateDate)}}</template></el-table-column>
      <el-table-column label="操作" width="120"><template slot-scope="scope"><el-link type="primary" @click="dialogMethodOpen(scope.row)">编辑</el-link></template></el-table-column>
    </el-table>
    <div class="whc-div-pagination"><el-pagination @size-change="tableMethodSize" @current-change="tableMethodCurr" :current-page="param.pageNum" :page-sizes="whc.cont.pageArray" :page-size="param.pageSize" background layout="total, sizes, prev, pager, next, jumper" :total="totalRows"></el-pagination></div>
    <!-- 操作对话框 -->
    <el-dialog :title="dialogTitle" :visible.sync="dialogShow" width="50%" @close="dialogMethodClose">
      <div class="local-role-dialog">
        <div class="local-role-dleft">
          编辑角色信息
          <el-form :model="dialogData" ref="dialogData" :rules="dialogRules" size="mini" label-width="100px">
            <el-form-item label="角色编号"><el-input v-model.trim="dialogData.systemRoleId" disabled></el-input></el-form-item>
            <el-form-item label="角色名称" prop="systemRoleName"><el-input v-model.trim="dialogData.systemRoleName"></el-input></el-form-item>
            <el-form-item label="角色代码"><el-input v-model.trim="dialogData.systemRoleCode" disabled></el-input></el-form-item>
            <el-form-item label="角色描述" prop="systemRoleDesc"><el-input v-model.trim="dialogData.systemRoleDesc"></el-input></el-form-item>
          </el-form>
        </div>
        <div class="local-role-dright">
          编辑菜单权限
          <el-tree :data="trees" show-checkbox node-key="systemMenuId" :props="treeProps" :default-expand-all="true" :default-checked-keys="treeChecks" ref="tree"></el-tree>
        </div>
      </div>
      <div class="whc-dialog-button"><el-button type='primary' size="mini" plain icon="el-icon-folder" @click="dialogMethodClose">取消</el-button><el-button type='primary' size="mini" icon="el-icon-folder-checked" @click="dialogMethodSave">确认</el-button></div>
    </el-dialog>
  </div>
</template>

<script>
const log = '【角色管理子页面】'
export default {
  name: 'WhcditRole',
  data () {
    return {
      param: {uid: null, pageNum: null, pageSize: null},
      pages: [],
      totalRows: 0, // 总行数
      dialogShow: false,
      dialogTitle: null, // 对话框标题
      dialogData: {uid: null, systemRoleId: null, systemRoleCode: null, systemRoleName: null, systemRoleDesc: null, relations: [], leafs: []},
      dialogRules: {systemRoleName: this.whc.cont.ruleArr001, systemRoleDesc: this.whc.cont.ruleArr002}, // 各校验对象名称要和参数名称一致
      trees: [],
      treeProps: {label: 'systemMenuName', children: 'childs'},
      treeChecks: [31, 32]
    }
  },
  mounted () { this.whc.func.paramInit(this.param); this.tableMethodPage(); console.info(log, 'mounted') },
  methods: {
    treeMethodInit () { this.$axios.post(this.whc.cont.url.menuTree, {}).then((res) => { if (this.whc.func.respSuccess(res.data.code)) { this.trees = []; this.trees.push(res.data.info) } else { this.whc.func.respParse(this, res.data.code) } }) },
    tableMethodPage () { this.whc.func.postMethodPage(this, this.whc.cont.url.rolePage, this.param) },
    dialogMethodOpen (val) {
      this.dialogShow = true
      this.dialogData.uid = this.param.uid
      this.treeMethodInit()
      this.treeChecks = []
      val.relations.forEach(e => {
        this.treeChecks.push(e.systemMenuId)
      })
      if (val) { // 编辑
        this.dialogTitle = this.whc.cont.edit
        let crow = this.whc.func.clone(val)
        this.dialogData.systemRoleId = crow.systemRoleId
        this.dialogData.systemRoleCode = crow.systemRoleCode
        this.dialogData.systemRoleName = crow.systemRoleName
        this.dialogData.systemRoleDesc = crow.systemRoleDesc
        this.dialogData.relations = crow.relations
      }
    },
    dialogMethodSave () {
      this.dialogData.leafs = this.$refs.tree.getCheckedKeys()
      this.$axios.post(this.whc.cont.url.roleEdit, this.dialogData).then((res) => {
        if (this.whc.func.respSuccess(res.data.code)) {
          this.tableMethodPage()
          this.dialogMethodClose()
          this.$message.success(this.whc.cont.updateSuccess)
        } else { this.whc.func.respParse(this, res.data.code) }
      })
    },
    dialogMethodClose () { this.dialogShow = false; this.$refs['dialogData'].resetFields() },
    tableMethodSize (val) { this.whc.func.tableMethodSize(this, val) },
    tableMethodCurr (val) { this.whc.func.tableMethodCurr(this, val) }
  }
}
</script>

<style scoped>
.local-role-dialog {display: flex; flex-direction: row;}
.local-role-dleft {flex: 1 1 auto; margin: 10px 10px 10px 10px; border: 1px solid #C0C4CC; padding: 0px 20px 10px 0px;}
.local-role-dright {flex: 1 1 auto; margin: 10px 10px 10px 10px; border: 1px solid #C0C4CC;}
</style>
