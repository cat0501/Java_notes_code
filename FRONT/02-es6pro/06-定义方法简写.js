// 传统
let person1 = {
  sayHi: function () {
    console.log('Hi')
  },
  sing: function(){
    console.log('唱歌。。。')
  }
}
person1.sayHi()
person1.sing()

// ES6
let person2 = {
  sayHi() {
    console.log('Hi')
  },
  sing(){
    console.log('唱歌。。。')
  }
}
person2.sayHi()
person2.sing()