let username = 'Tom'
let age = 2
let sing = function () {
  console.log('I love Jerry')
}

// 传统
let person1 = {
  username: username,
  age: age,
  sing: sing,
}
console.log(person1)
person1.sing()

// ES6：这样的书写更加简洁(当且仅当前面的变量和后面的属性名完全一致的时候，可以将变量和属性名合并为一个关键字，作用同上) 
let person2 = {
  age,
  username,
  sing,
}
console.log(person2)
person2.sing()