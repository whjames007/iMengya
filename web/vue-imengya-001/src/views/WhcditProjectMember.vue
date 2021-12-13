<template>
  <div>111
  </div>
</template>

<script>
const log = '【WhcditAbcd页面】'
export default {
  name: 'WhcditAbcd',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App'
    }
  },
  mounted () {
    console.info(log, 'mounted')
  },
  methods: {
    zzz () {
      console.info(log, '武汉加油')
    }
  }
}
</script>

<style scoped>

</style>
