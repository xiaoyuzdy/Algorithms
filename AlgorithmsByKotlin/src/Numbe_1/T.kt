package Numbe_1

import java.io.File

/**
 * Created by he on 2017/5/24.
 */

fun main(args: Array<String>) {
    var map = mapOf("a" to 1, "b" to 2)
//    var map2 = map.plus("c" to 3)//返回一个只读的map
    //遍历map
    for ((k, v) in map) {
        println("key--->value: $k->$v")
    }

    val p: String by lazy<String> {
        " hello "
    }

    println(p)
    println(map.size)

    val data = File("text").listFiles()
    println(data?.size ?: "empty")

    //for循环
    for (i in 2..9) {
        print("   " + i)
    }

    val c: Byte = 1
    val b: Int = 2
    val f = c + b
    val x = f is Int
    println(" 类型转换 " + x)

}