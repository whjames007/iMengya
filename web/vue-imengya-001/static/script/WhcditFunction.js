let gresp = 'WHCDIT_RESPONSE_'
let keyUser = 'userstr'
let func = {
  respSuccess (code) {
    if (code === gresp + '10000') { return true } else { return false }
  },
  respParse (my, resp, callback) {
    let msg = null
    let code = resp.data.code
    switch (code) {
      case gresp + '10000': msg = 'OK'; break
      case gresp + '20001': msg = '系统故障，请与管理员联系！'; break
      case gresp + '30001': msg = '账号或密码不正确，请重新输入！'; break
      case gresp + '30002': msg = '您输入的用户账号已存在，请重新输入！'; break
      case gresp + '30003': msg = '资源在当前月份的空闲工时不足！'; break
      case gresp + '30004': msg = '资源已在本计划中分配过了！'; break
      case gresp + '30005': msg = '您好，此部门尚有关联用户，请先解除其关联关系！'; break
      default: msg = '未知的异常：' + code; break
    }
    if (msg === 'OK') { callback(resp.data) } else { my.$message.error(msg) }
  },
  respParse2 (my, code) {
    let res = null
    switch (code) {
      case gresp + '10000': res = '10000'; break
      case gresp + '20001': res = '系统故障，请与管理员联系！'; break
      case gresp + '30001': res = '账号或密码不正确，请重新输入！'; break
      case gresp + '30002': res = '您输入的用户账号已存在，请重新输入！'; break
      case gresp + '30003': res = '资源在当前月份的空闲工时不足！'; break
      case gresp + '30004': res = '资源已在本计划中分配过了！'; break
      case gresp + '30005': res = '您好，此部门尚有关联用户，请先解除其关联关系！'; break
      default: res = '未知的异常：' + code; break
    }
    if (res === '10000') { return true } else { my.$message.error(res) }
  },
  getUser () {
    let json = sessionStorage.getItem(keyUser)
    let res = null
    if (json) { res = JSON.parse(json) } else { console.error('未能从会话缓存中获取到用户信息') }
    return res
  },
  setUser (val) {
    let json = JSON.stringify(val)
    sessionStorage.setItem(keyUser, json)
  },
  paramInit (val) {
    // 前后端约定在此初始化通用参数
    let json = sessionStorage.getItem(keyUser)
    let user = JSON.parse(json)
    val.uid = user.systemUserId
    val.dataSeparateId = user.dataSeparateId
    val.pageNum = 1
    val.pageSize = 10
  },
  clone (val) {
    let str = JSON.stringify(val)
    let json = JSON.parse(str)
    return json
  },
  geweiNotNull (val) {
    let res = true
    if (val === null) {
      res = false
    } else {
      if (val === '') {
        res = false
      } else {
        res = true
      }
    }
    return res
  },
  postMethodList (my, url, param) {
    var list = []
    my.$axios.post(url, param).then((res) => { if (func.respSuccess(res.data.code)) { list = res.data.list } else { func.respParse(my, res.data.code) } })
    return list
  },
  postMethodPage (my, url, param) {
    my.$axios.post(url, param).then((res) => {
      if (my.whc.func.respSuccess(res.data.code)) {
        my.pages = res.data.page.list
        my.totalRows = res.data.page.total
      } else { func.respParse(my, res.data.code) }
    })
  },
  postMethodDel (my, url, param) {
    my.$confirm(my.whc.cont.deleteQuestion, my.whc.cont.del, {type: 'warning'}).then(() => {
      my.axios.post(url, param).then((res) => {
        if (func.respSuccess(res.data.code)) {
          my.$message.success(my.whc.cont.deleteSuccess)
          my.tableMethodPage()
        } else { func.respParse(my, res.data.code) }
      })
    }).catch(() => { console.info(`用户放弃了删除操作！`) })
  },
  tableMethodSize (my, val) {
    my.param.pageSize = val
    my.tableMethodPage()
    console.info(`【tableMethodSize函数】`, `【每页 ${val} 条】`)
  },
  tableMethodCurr (my, val) {
    my.param.pageNum = val
    my.tableMethodPage()
    console.info(`【tableMethodCurr函数】`, `【当前页: ${val}】`)
  },
  bbb (val) { }
}
export { func }
