package Number_2


/**
 * 快速排序
 * Created by he on 2017/5/28.
 */

class Quick {
    fun sort(a: Array<Int>) {
        sort(a, 0, a.size - 1)
    }

    fun sort(a: Array<Int>, lo: Int, hi: Int) {
        if (lo >= hi)
            return
        var j = partition(a, lo, hi)
        sort(a, lo, j - 1)
        sort(a, j + 1, hi)
    }

    fun partition(a: Array<Int>, lo: Int, hi: Int): Int {
        var i = lo
        var j = hi + 1
        var v = a[lo]
        while (true) {
            while (less(a[++i], v)) {
                if (i == hi)
                    break
            }

            while (less(v, a[--j])) {

            }

            if (i >= j)
                break
            exch(a, i, j)
        }

        exch(a, lo, j)
        return j
    }

    fun less(v: Int, w: Int): Boolean {
        return v < w
    }

    fun exch(a: Array<Int>, i: Int, j: Int) {
        var temp = a[i]
        a[i] = a[j]
        a[j] = temp
    }

}


fun main(args: Array<String>) {
    val quick = Quick()
    val a = arrayOf(2, 5, 18, 26, 7, 88, 23)
    quick.sort(a)
    show(a)
}
