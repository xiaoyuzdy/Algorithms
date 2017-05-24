package Numbe_1

/**
 * 二分查找
 */
class BinarySearch {

}

fun main(args: Array<String>) {
    var arr = arrayOf(1, 2, 3, 4, 5, 6)
    println(rank(arr, 5))
}

fun rank(array: Array<Int>, key: Int): Int {
    var hi = array.size
    var lo = 0
    while (lo <= hi) {
        var mid = (lo + hi) / 2
//        if(array[mid]<key){
//            lo=mid+1
//        }else if (array[mid]>key){
//            hi=mid-1
//        }else{
//            return  mid
//        }
        //使用 when 代替 if else if else
        when {
            array[mid] < key -> lo = mid + 1
            array[mid] > key -> hi = mid - 1
            else -> return mid
        }

    }
    return -1
}
