package Number_1

/**
 * Created by he on 2017/5/24.
 */

typealias QueueKt= Number_1.Queue<Any>

fun main(args: Array<String>) {
    var queue=QueueKt()
    queue.enqueue(1)
    queue.enqueue(2)
    queue.enqueue(3)
    for (i in queue){
        println(" "+i)
    }
}
