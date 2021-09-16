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
          <el-tabs class="local-home-head-tabs" v-model="activetaber" type="card" @tab-click="tabsMethodClick" @tab-remove="tabsMethodClose">
            <el-tab-pane :key="item.systemMenuUrl" v-for="(item) in tabsList" :label="item.systemMenuName" :name="item.systemMenuUrl" :closable="item.systemBoolClose"></el-tab-pane>
          </el-tabs>
        </el-col>
        <el-col :span="6" class="local-home-head-col3">
          <el-button type="primary" icon="el-icon-setting" @click="userMethodSet">{{user.systemUserNickname}}[{{user.systemRoleName}}]</el-button>
          <el-button circle type="primary" icon="el-icon-right" @click="userMethodOut"></el-button>
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
const keyActiveMenu = 'keyActiveMenu'
const keyActiveTabs = 'keyActiveTabs'
const defultRouter = 'summary'
export default {
  name: 'WhcditHome',
  data () {
    return {
      user: {},
      menu: {},
      leafs: [], // 叶子集合
      activeRouter: '',
      activeMenu: {},
      activetaber: '',
      tabsList: [],
      msg: 'Welcome to Your Vue.js App'
    }
  },
  mounted () { this.mountedMethodInit() },
  methods: {
    mountedMethodInit () {
      this.user = this.whc.func.getUser()
      if (!this.user) {
        this.$message.error('您好，请先登录！')
        this.$router.push({name: 'login'})
        return
      }
      this.menu = this.user.menu
      let arr = [] // 拼凑叶子集合
      this.menu.childs.forEach(branch => {
        arr = arr.concat(branch.childs)
      })
      this.leafs = arr
      // 确定当前活动对象以及选项卡列表
      let jstrMenu = sessionStorage.getItem(keyActiveMenu)
      if (jstrMenu) {
        // 如果有缓存，获取这些内容吧
        let jsonMenu = JSON.parse(jstrMenu)
        this.activeRouter = jsonMenu.systemMenuUrl
        this.activetaber = jsonMenu.systemMenuUrl
        this.activeMenu = jsonMenu
        let jstrTabs = sessionStorage.getItem(keyActiveTabs)
        this.tabsList = JSON.parse(jstrTabs)
      } else {
        // 如果无缓存，则构造系统简介相关的默认路由
        this.menuMethodOper(defultRouter)
      }
    },
    menuMethodFind (val) { for (const key in this.leafs) { const ele = this.leafs[key]; if (val === ele.systemMenuUrl) { return ele } } },
    menuMethodSelect (key, keyPath) { this.menuMethodOper(key) },
    menuMethodOper (val) {
      let who = this.menuMethodFind(val) // 本方法是菜单对象的操作流程，先获取目标对象
      this.activeRouter = val
      this.activetaber = val
      this.activeMenu = who // 赋值当前活动对象
      let tabsHave = false // 判断选项卡列表中是否拥有该菜单
      for (const key in this.tabsList) { const ele = this.tabsList[key]; if (val === ele.systemMenuUrl) { tabsHave = true; break } }
      // 如果没有，就向选项卡列表push该菜单
      if (!tabsHave) { this.tabsList.push(who) }
      // 缓存当前活动对象以及选项卡列表
      sessionStorage.setItem(keyActiveMenu, JSON.stringify(this.activeMenu))
      sessionStorage.setItem(keyActiveTabs, JSON.stringify(this.tabsList))
    },
    tabsMethodClick (tab, event) {
      let tname = tab.name
      if (tname === this.activeRouter) {
        console.info(log, '点击的是当前页，不做任何操作')
      } else {
      // 选项卡也要走菜单对象操作流程，然后可以直接路由
        this.menuMethodOper(tname)
        this.$router.push({name: this.activeRouter})
      }
    },
    tabsMethodFind (val) { for (const key in this.tabsList) { const ele = this.tabsList[key]; if (val === ele.systemMenuUrl) { return ele } } },
    tabsMethodClose (val) {
      debugger
      // 先获取此项的前一个成员，以及本项的索引
      let prev = null
      let acti = -1
      for (let i = 0; i < this.tabsList.length; i++) {
        const item = this.tabsList[i]
        if (val === item.systemMenuUrl) {
          prev = this.tabsList[i - 1]
          acti = i
          break
        }
      }
      // 从选项卡列表中移除此项
      this.tabsList.splice(acti, 1)
      console.info(log, val, prev, this.tabsList)
      // 选项卡的关闭方法，先判断要关闭的是否是当前页面
      if (val === this.activetaber) {
        console.info(log, '要关闭的是当前页面啊，要动路由了', acti)
        this.tabsMethodClick({name: prev.systemMenuUrl}, null)
      } else {
        console.info(log, '要关闭的不是当前页面，重新缓存一下选项卡列表即可')
        sessionStorage.setItem(keyActiveTabs, JSON.stringify(this.tabsList))
      }
    },
    userMethodSet () { this.$confirm('您好，您确定要退出本系统吗？', '提示', {type: 'warning'}).then(() => { sessionStorage.clear(); this.$router.push({name: 'login'}) }).catch(() => { console.info(log, `用户放弃了退出操作！`) }) },
    userMethodOut () { this.$confirm('您好，您确定要退出本系统吗？', '提示', {type: 'warning'}).then(() => { sessionStorage.clear(); this.$router.push({name: 'login'}) }).catch(() => { console.info(log, `用户放弃了退出操作！`) }) }
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

.local-home-router {padding: 10px 10px 10px 10px;}

</style>
