<template>
  <div id="WhcditLogoCompany">
    <div class="comp-logo-company-en">WHCDIT</div>
    <div class="comp-logo-company-cn">乾基信息技术</div>
  </div>
</template>

<script>
const log = '【WhcditLogoCompany组件】'
export default {
  name: 'WhcditLogoCompany',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App'
    }
  },
  mounted () {
    console.info(log, 'mounted')
  }
}
</script>

<style scoped>
#WhcditLogoCompany {position:absolute; left:10px; top:10px;}
.comp-logo-company-en {color: #E60012; font-size: 24px; font-family: "Eras Bold ITC"; font-weight: 900; font-style:italic;}
.comp-logo-company-cn {color: #FFFFFF; font-size: 18px; font-family: "KaiTi"; font-weight: 800; }
</style>
