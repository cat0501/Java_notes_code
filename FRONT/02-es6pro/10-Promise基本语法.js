// Promise 是ES6 引入的异步编程的新解决方案。语法上 Promise 是一个构造函数， 用来封装异步操作并可以获取其成功或失败的结果。
// 异步编程解决方案：文件的读取、ajax等等

const fs = require('fs') // 引入node.js中的本地文件扩展模块。require类似于java中的import

//实例化 Promise 对象：
//Promise对象有三个状态：初始化、成功、失败
// 2个内置的参数，函数数据类型的参数。
// resolve：函数数据类型的参数，可以修改Promise的状态，设置为成功
// reject：函数数据类型的参数，可以修改Promise的状态，设置为处理失败
const p = new Promise((resolve, reject) => {
  //调用readFile方法读取磁盘文件：异步操作
  // 参数1：读取的文件的路径
  // 参数2：读取过程中对响应结果的处理
  fs.readFile('./他.txt', (err, data) => {
    //当文件读取失败时，可以获取到err的值
    if (err) reject(err) //reject将Promise对象的状态设置为失败

    //当文件读取成功时，可以获取到data的值
    resolve(data) //resolve将Promise对象的状态设置为成功
  })
})


// 根据状态调用相应的业务逻辑

//调用 promise 对象的方法
//then：当 Promise状态成功时执行，即then被调用
//catch：当 Promise状态失败时执行
p.then(response => {
  console.log(response.toString())
}).catch(error => {
  console.log('出错了')
  console.error(error)
})




// 总结：借助于Promise，可以使异步操作中的成功和失败的处理函数独立出来。