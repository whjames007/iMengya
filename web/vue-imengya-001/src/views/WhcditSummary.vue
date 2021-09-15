<template>
  <div class="local-summary-div">
    <!-- <div>{{msg}}</div> -->
    <!-- <div class="showImg"><img src="static/image/summary.png"/></div> -->
    <div class="local-summary-text">武汉正维电子技术有限公司成立于2003年，是一家扎根于通信行业的国家级高新技术企业，现位于武汉市东湖开发区关东科技园。公司专注于无线通信产品的研发、生产和销售，产品广泛应用于3G、4G、5G无线通信基站及DAS系统，数字集群通信系统及行业专用无线通信系统；同时公司低功耗物联网方案，广泛用于智能交通、智能电网、智慧能源、智慧小区、智慧超市等领域，现有客户遍布国内外 。</div>
    <img class="local-summary-img" src="static/image/process.jpg">
  </div>
</template>

<script>
const log = '【系统简介子页面】'
export default {
  name: 'WhcditSummary',
  data () {
    return {
      msg: '欢迎登陆本系统！'
    }
  },
  mounted () {
    console.info(log, 'mounted')
  },
  methods: {
  }
}
</script>

<style scoped>
.local-summary-div {display: flex; height: 90vh;  align-items: center; justify-content: center;}
.local-summary-text {width: 380px;  font-size: 22px; text-indent: 2em; line-height: 2em; margin: 0px 80px 0px 0px;}
.local-summary-img { width: 40%; }
</style>
