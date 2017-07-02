package Number_2

/**
 *  归并排序
 * Created by he on 2017/5/28.
 */

class Merge{
 lateinit var aux: IntArray
    fun sort(a: Array<Int>) {
        aux = IntArray(a.size)
        sort(a, 0, a.size - 1)
    }

    fun sort(a: Array<Int>, lo: Int, hi: Int) {
        if (lo >= hi)
            return
        var mid = lo + (hi - lo) / 2
        sort(a, lo, mid)
        sort(a, mid + 1, hi)
        merge(a, lo, hi, mid)
    }

    fun merge(a: Array<Int>, lo: Int, hi: Int, mid: Int) {
        var i = lo
        var j = mid + 1
        for (k in lo..hi) {
            aux[k] = a[k]
        }

        for (k in lo..hi) {
            when {
                i > mid -> a[k] = aux[j++]
                j > hi -> a[k] = aux[i++]
                aux[j] < aux[i] -> a[k] = aux[j++]
                else -> a[k] = aux[i++]
            }
        }

    }
}

fun main(args: Array<String>) {
    var a = arrayOf(1, 5, 2, 68, 5, 2, 10, 4)
    val  merge=Merge()
    merge.sort(a)
    show(a)
}




