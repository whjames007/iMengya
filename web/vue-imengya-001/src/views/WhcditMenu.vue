<template>
  <div>
    <!-- 分页表格 -->
     <el-table :data="pages"  size="mini" stripe border highlight-current-row style="width: 99%">
        <el-table-column prop="length" label="序号" type="index" width="60"/>
        <el-table-column prop="systemMenuId" label="菜单ID" show-overflow-tooltip/>
        <el-table-column prop="systemMenuName" label="菜单名称" show-overflow-tooltip/>
        <el-table-column prop="systemMenuType" label="菜单类型" show-overflow-tooltip/>
        <el-table-column prop="systemMenuIcon" label="菜单图标" show-overflow-tooltip/>
        <el-table-column prop="systemMenuUrl" label="菜单路由" show-overflow-tooltip/>
        <el-table-column prop="systemParentId" label="上级菜单ID" show-overflow-tooltip/>
        <el-table-column prop="systemMenuClose" label="菜单可关闭" show-overflow-tooltip/>
        <el-table-column prop="systemMenuDesc" label="菜单描述" show-overflow-tooltip/>
        <el-table-column label="最后更新时间" show-overflow-tooltip><template slot-scope="scope">{{whc.dfmt.dts(scope.row.lastUpdateDate)}}</template></el-table-column>
        <el-table-column label="操作" width="100"><template slot-scope="scope"><el-link type="primary" @click="dialogMethodOpen(scope.row)">编辑</el-link></template></el-table-column>
    </el-table>
    <!-- 操作对话框 -->
    <el-dialog :title="dialogTitle" :visible.sync="dialogShow" width="30%">
      <el-form :model="dialogData" ref="dialogData" :rules="dialogRules" size="mini" label-width="100px">
        <el-form-item label="菜单名称" prop="systemMenuName"><el-input v-model.trim="dialogData.systemMenuName"></el-input></el-form-item>
        <el-form-item class="whc-dialog-button"><el-button type='primary' plain icon="el-icon-folder" @click="dialogMethodClose">取消</el-button><el-button type='primary' size="mini" icon="el-icon-folder-checked" @click="dialogMethodSave">确认</el-button></el-form-item>
      </el-form>
    </el-dialog>
  </div>
</template>

<script>
var log = '【菜单管理子页面】'
export default {
  name: 'WhcditMenu',
  data () {
    return {
      param: {uid: null, pageNum: null, pageSize: null},
      pages: [],
      totalRows: 0,
      dialogShow: false,
      dialogTitle: this.whc.cont.edit, // 对话框标题
      dialogData: {uid: null, systemMenuId: null, systemMenuName: null},
      dialogRules: {systemMenuName: this.whc.cont.ruleArr001}, // 各校验对象名称要和参数名称一致
      aaaaa: 1
    }
  },
  mounted () {
    this.whc.func.paramInit(this.param) // 利用缓存初始化参数
    this.tableMethodPage()
    console.info(log, 'mounted')
  },
  methods: {
    tableMethodPage () {
      this.$axios.post(this.whc.cont.url.menuList, this.param).then((res) => {
        if (this.whc.func.respSuccess(res.data.code)) { this.pages = res.data.list } else { this.whc.func.respParse(this, res.data.code) }
      })
    },
    dialogMethodOpen (val) {
      this.dialogShow = true
      this.dialogData.uid = this.param.uid
      let crow = this.whc.func.clone(val)
      this.dialogData.systemMenuId = crow.systemMenuId
      this.dialogData.systemMenuName = crow.systemMenuName
    },
    dialogMethodSave () {
      this.$axios.post(this.whc.cont.url.menuEdit, this.dialogData).then((res) => {
        if (this.whc.func.respSuccess(res.data.code)) {
          this.tableMethodPage()
          this.dialogMethodClose()
          this.$message.success(this.whc.cont.updateSuccess)
        } else { this.whc.func.respParse(this, res.data.code) }
      })
    },
    dialogMethodClose () { this.dialogShow = false; this.$refs['dialogData'].resetFields() }
  }
}
</script>

<style scoped>
.local-role-dialog { display: flex; flex-direction: row; }
.local-role-dleft { flex: 1 1 auto; padding: 10px 100px 10px 10px; }
.local-role-dright { flex: 1 1 auto; padding: 10px 100px 20px 10px; }
</style>
