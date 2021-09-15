<template>
  <div id="WhcditLogin">
      <div class="local-login-div">
        <img class="local-home-logo" src="../../static/image/logo1.png"/>
        <el-form :size="whc.cont.size" :model="dialogData" ref="dialogData" :rules="dialogRules" :label-width="whc.cont.formLabelWidth">
            <el-form-item prop="systemUserAccount"><el-input prefix-icon="el-icon-user" v-model="dialogData.systemUserAccount" placeholder="请输入账号" @keyup.enter.native="loginMethodFirst"></el-input></el-form-item>
            <el-form-item prop="systemUserPassword"><el-input prefix-icon="el-icon-lock" v-model="dialogData.systemUserPassword" type="password" placeholder="请输入密码"  @keyup.enter.native="loginMethodFirst"></el-input></el-form-item>
            <el-form-item>
                <el-button @click="loginMethodFirst" type="primary" icon="el-icon-user-solid">登录</el-button>
                <el-button @click="loginMethodSecond" type="primary" icon="el-icon-user-solid">注册</el-button>
                <el-button @click="loginMethodSecond" type="primary" icon="el-icon-user-solid">忘记密码</el-button>
            </el-form-item>
        </el-form>
      </div>
  </div>
</template>

<script>
const log = '【登录页面】'
export default {
  name: 'WhcditLogin',
  data () {
    return {
      dialogData: {systemUserAccount: 'administrator', systemUserPassword: '123456'},
      dialogRules: {systemUserAccount: this.whc.cont.ruleArr001, systemUserPassword: this.whc.cont.ruleArr001}, // 各校验对象名称要和参数名称一致
      msg: 'Welcome to Your Vue.js App'
    }
  },
  methods: {
    loginMethodFirst () {
      // 先做校验
      let check = true
      if (check) {
        this.loginMethodSecond()
      } else {
        console.info(log, '校验不通过')
      }
    },
    loginMethodSecond () {
      this.$axios.post(this.whc.cont.userLogin, this.dialogData).then((resp) => {
        this.whc.func.respParse(this, resp, this.loginMethodThird)
      })
    },
    loginMethodThird (val) {
      console.info(log, val)
      this.whc.func.setUser(val.info)
      this.$router.push({name: 'home'})
    },
    loginMethodThird2 (val) {
      this.$axios.post(this.whc.cont.userLogin, this.dialogData).then((res) => {
        if (this.whc.func.respSuccess(res.data.code)) {
          this.whc.func.setUser(res.data.info)
          this.$router.push({name: 'home'})
          console.info(log, '登陆成功，即将跳转进入主页面')
        } else { this.whc.func.respParse(this, res.data.code) }
      })
    }
  }
}
</script>

<style scoped>
#WhcditLogin {height: 100vh; display: flex; align-items: center; justify-content: center;}
.local-login-div {width: 30vh; padding: 0px 0px 100px 0px;}
</style>
