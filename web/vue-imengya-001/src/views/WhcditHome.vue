<template>
  <div id="WhcditHome">
    <div class="local-home-head">
      <el-row>
        <el-col :span="6" class="local-home-head-col1">
          <el-popover placement="bottom-start" title="导航菜单" width="200" trigger="hover">
            <div slot="reference"><img class="local-home-logo" src="../../static/image/logo1.png"/></div>
            <el-menu class="local-home-menu" unique-opened router :default-active="activeRouter" @select="menuMethodSelect">
              <!-- 树枝菜单 <i :class="branch.systemMenuIcon"></i>去掉图标 -->
              <template v-for="branch in menu.childs">
                <el-submenu :key="branch.systemMenuUrl" :index="branch.systemMenuUrl"><template slot="title"><i :class="branch.systemMenuIcon"></i>{{branch.systemMenuName}}</template>
                  <!-- 叶子菜单 去掉图标 -->
                  <template v-for="leaf in branch.childs"><el-menu-item :key="leaf.systemMenuUrl" :index="leaf.systemMenuUrl"><i :class="leaf.systemMenuIcon"></i>{{leaf.systemMenuName}}</el-menu-item></template>
                </el-submenu>
              </template>
            </el-menu>
          </el-popover>
        </el-col>
        <el-col :span="12" class="local-home-head-col2">
          <el-tabs class="local-home-head-tabs" v-model="tabsValue" type="card">
            <el-tab-pane :key="item.systemMenuUrl" v-for="(item) in tabsList" :label="item.systemMenuName" :name="item.systemMenuName"
            :closable="item.systemBoolClose"></el-tab-pane>
          </el-tabs>
        </el-col>
        <el-col :span="6" class="local-home-head-col3">
          <div class="local-home-user"><i class="el-icon-setting"></i></div>
          <div class="local-home-user">{{user.systemUserNickname}}[{{user.systemRoleName}}]</div>
          <div class="local-home-user"></div>
          <div class="local-home-user" @click="loginMethodOut"><i class="el-icon-right"></i></div>
        </el-col>
      </el-row>
    </div>
    <div class="local-home-brmb"><el-breadcrumb separator-class="el-icon-arrow-right"><el-breadcrumb-item><i class="el-icon-s-home"></i>  {{activeMenu.systemSecondName}}</el-breadcrumb-item><el-breadcrumb-item>{{activeMenu.systemThirdName}}</el-breadcrumb-item></el-breadcrumb></div>
    <div class="local-home-main">
      <div class="local-home-router"><router-view/></div>
    </div>
    <div class="local-home-foot">版权 1999-2021 戴尔公司 (Dell Inc.) 仅适用于中国客户的内容设计 版权所有</div>
  </div>
</template>

<script>
const log = '【主页框架页面】'
const apath = 'activePath'
export default {
  name: 'WhcditHome',
  data () {
    return {
      user: {},
      menu: {},
      leafs: [], // 叶子集合
      activeRouter: 'summary',
      activeMenu: {},
      tabsValue: 'summary',
      tabsList: [],
      msg: 'Welcome to Your Vue.js App'
    }
  },
  mounted () { this.mountedMethodInit() },
  methods: {
    mountedMethodInit () {
      this.user = this.whc.func.getUser()
      this.menu = this.user.menu
      let arr = []
      this.menu.childs.forEach(branch => {
        arr = arr.concat(branch.childs)
      })
      this.leafs = arr
      this.activeRouter = 'summary'
      this.menuMethodSelect('summary')
      console.info(log, 'mounted')
    },
    menuMethodSelect (key, keyPath) {
      this.activeTabs = key
      this.menuMethodFind(key)
      let str = JSON.stringify(this.activeMenu)
      sessionStorage.setItem(apath, str)
    },
    menuMethodFind (val) {
      for (const key in this.leafs) {
        const ele = this.leafs[key]
        if (val === ele.systemMenuUrl) { this.tabsList.push(ele); this.activeMenu = ele; return }
      }
    },
    loginMethodOut () {
      this.$confirm('确定要退出系统吗？', '提示', {type: 'warning'}).then(() => {
        console.info(log, `用户决定退出系统！`)
        sessionStorage.clear()
        this.$router.push({name: 'login'})
      }).catch(() => { console.info(log, `用户放弃了退出操作！`) })
    },
    aaa () {
      console.info(log, '登陆成功，即将跳转进入主页面')
    }
  }
}
</script>

<style scoped>
.local-home-head {height: 6vh; background: #409EFF;}
.local-home-brmb {height: 4vh; padding: 0px 10px 0px 10px; background: #FFFFFF; display: flex; align-items: center; justify-content: left;}
.local-home-main {height: 86vh; background: #F2F6FC; overflow: auto;}
.local-home-foot {height: 4vh; background: #409EFF; color: #FFFFFF; display: flex; align-items: center; justify-content: center;}
.local-home-head-col1 {height: 6vh; display: flex; align-items: center; justify-content: left;}
.local-home-head-col2 {height: 6vh; display: flex; align-items: center; justify-content: left;}
.local-home-head-tabs {background: #FFFFFF; width: 50vw;}
.local-home-head-col3 {height: 6vh; display: flex; align-items: center; justify-content: flex-end; padding: 0px 10px 0px 0px; color: #FFFFFF;}
.local-home-logo {height: 4vh; margin: 0px 0px 0px 10px;}
.local-home-user {padding: 0px 10px 0px 0px;}

.local-home-router {padding: 10px 10px 10px 10px;}

</style>
