package Number_2

/**
 * 插入排序
 * Created by he on 2017/5/27.
 */

class Insertion {

    fun sort(a: Array<Int>) {
        val N = a.size
        for (i in 1..N - 1) {
            for (j in i downTo 1) {
                if (less(a[j], a[j - 1])) {
                    exch(a, j, j - 1)
                }
            }
        }
    }

    fun less(v: Int, w: Int): Boolean {
        return v < w
    }

    fun exch(a: Array<Int>, i: Int, j: Int) {
        val temp = a[i]
        a[i] = a[j]
        a[j] = temp
    }

}

fun main(args: Array<String>) {
    var a = arrayOf(1, 2, 5, 9, 10, 7)
    val insertion = Insertion()
    insertion.sort(a)
    show(a)
}



