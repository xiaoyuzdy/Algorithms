package Number_1

/**
 * Created by he on 2017/5/24.
 */

typealias StackKt = Number_1.Stack<Any>


fun main(args: Array<String>) {
    val stack = StackKt()
    stack.push(1)
    stack.push(2)
    stack.push(3)
    for (i in stack){
        println("  "+i)
    }
}

