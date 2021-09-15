// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
// 引入饿了么
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import WhcditUtils from '../static/script/WhcditUtils'
import App from './App'
import axios from 'axios'
import VueAxios from 'vue-axios'
import router from './router'

Vue.use(ElementUI)
Vue.use(VueAxios, axios)

Vue.config.productionTip = false

Vue.prototype.$axios = axios
Vue.prototype.whc = WhcditUtils

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
