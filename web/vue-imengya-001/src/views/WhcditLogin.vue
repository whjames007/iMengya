<template>
  <div id="WhcditLogin">
    <!-- <WhcditLogoCompany/> -->
    <div class="local-login-center">
      <img class="local-login-imgrht" src="../../static/image/loginright.png"/>
      <div class="local-login-divlft">
        <el-form :model="dialogData" ref="dialogData" :rules="dialogRules" :label-width="whc.cont.formLabelWidth">
            <el-form-item><img class="local-login-logo" src="../../static/image/logo1.png"/></el-form-item>
            <el-form-item prop="systemUserAccount"><el-input prefix-icon="el-icon-user" v-model="dialogData.systemUserAccount" placeholder="请输入账号" @keyup.enter.native="loginMethodFirst"></el-input></el-form-item>
            <el-form-item prop="systemUserPassword"><el-input prefix-icon="el-icon-lock" v-model="dialogData.systemUserPassword" type="password" placeholder="请输入密码"  @keyup.enter.native="loginMethodFirst"></el-input></el-form-item>
            <el-form-item><el-button class="local-login-button" @click="loginMethodFirst" type="primary" icon="el-icon-user-solid">用户登录</el-button></el-form-item>
            <el-form-item><el-button class="local-login-button" @click="loginMethodSecond" icon="el-icon-user" plain>用户注册</el-button></el-form-item>
            <el-form-item><el-button class="local-login-button" @click="loginMethodSecond" icon="el-icon-question">忘记密码</el-button></el-form-item>
        </el-form>
      </div>
    </div>
  </div>
</template>

<script>
import WhcditLogoCompany from '@/components/WhcditLogoCompany'
const log = '【登录页面】'
export default {
  name: 'WhcditLogin',
  components: {WhcditLogoCompany},
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
#WhcditLogin {
  background: url('../../static/image/background.png') no-repeat;
  background-size: cover;
  height: calc(100vh - 40px);
  padding: 20px;
  display: flex; align-items: center; justify-content: center;}
.local-login-enterprise {position:absolute; left:10px; top:10px; color: #E60012; font-size: 24px; font: "Eras Bold ITC"; font-weight: 800; font-style:italic;}
.local-login-center {width: 50vw; height: 60vh; padding: 0px 50px 0px 50px; background: #FFFFFF; display: flex; align-items: center; justify-content: space-between; border-radius: 20px 20px 20px 20px;}
.local-login-imgrht {width: 30vw;}
.local-login-divlft {width: 18vw; padding: 0px 0px 0px 0px;}
.local-login-logo {width: 18vw;}
.local-login-button {width: 100%;}
</style>
