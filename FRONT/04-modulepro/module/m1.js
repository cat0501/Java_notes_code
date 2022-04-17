// 所谓模块化开发：
// 零散的成员封装到一个对象中，通过对象的方式来调用里面的成员。避免和其它模块的同名成员产生冲突。

// export let star = '张三'

// 问题1：如何解决变量被覆盖的问题
// 问题2：如何解决变量定义冲突的问题

// export function sing(title){
//   console.log(title)
// }

// 第2种导出模块的方法
let star = '张三'

function sing(title){
  console.log(title)
}

export { star, sing }


