package Numbe_1

/**
 * Created by he on 2017/5/24.
 */

class Person {
    //主(一级)构造函数，如果主构造函数不需要声明注解或可见声明
    // 可省略constructor关键字
    class Person public constructor(val name: String) {
        //初始化代码块
        init {

        }

        //二级构造函数,每个二级构造函数都要，
        // 或直接或间接通过另一个二级构造
        //函数代理主构造函数,在同一个类中代理另一个构造函数使用 this 关键字
        constructor(name: String, parent: Person) : this(name) {
        }
    }


}