import Vue from 'vue'
import Router from 'vue-router'
import WhcditLogin from '@/views/WhcditLogin'
import WhcditHome from '@/views/WhcditHome'
import WhcditSummary from '@/views/WhcditSummary'
import WhcditUser from '@/views/WhcditUser'
import WhcditRole from '@/views/WhcditRole'
import WhcditMenu from '@/views/WhcditMenu'
import WhcditAbcd from '@/views/WhcditAbcd'

Vue.use(Router)

let childs = [
  {path: 'summary', name: 'summary', component: WhcditSummary},
  {path: 'user', name: 'user', component: WhcditUser},
  {path: 'role', name: 'role', component: WhcditRole},
  {path: 'menu', name: 'menu', component: WhcditMenu},
  {path: 'aaa', name: 'aaa', component: WhcditAbcd}
]

export default new Router({
  routes: [
    {path: '/', name: 'login', component: WhcditLogin},
    {path: '/home', name: 'home', component: WhcditHome, redirect: '/home/summary', children: childs}
  ]
})
