//声明变量
let a
let b, c, d
let e = 100
let f = 521,
  g = 'iloveyou',
  h = []

//1. 变量不能重复声明
// let name = 'Helen'
// let name = '环' //报错：SyntaxError: Identifier 'name' has already been declared






//2. let 存在块儿级作用域（更严谨）,var没有块级作用域
// if else while for 

var flag = true  // 形成是否结束
if(flag){
  // 作用域
  var star = 5;
}
console.log(star)


// var和let都具备函数级别的作用域
function test1(){
  var f1 = '函数test1的变量'
  console.log(f1)
}

// test1()
// console.log(f1)


{
  let star = 5
}
console.log(star) //报错：star is not defined









//3. let不存在变量提升的特性，var存在变量提升
// console.log(song) //报错：Cannot access 'song' before initialization
let song = '依然爱你';

var username  // undefined
console.log(username)  // ReferenceError: username is not defined
// var username  // 变量提升，默认到前几行的地方
