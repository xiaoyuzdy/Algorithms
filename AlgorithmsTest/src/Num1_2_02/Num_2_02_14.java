package Num1_2_02;

import edu.princeton.cs.algs4.Queue;

/**
 * P180 T14
 * 
 * @author he
 * 测试通过
 */
class MergeQueue {
	private static Queue<Comparable> temp;

	public static Queue<Comparable> mergeQueue(Queue<Comparable> queue1, Queue<Comparable> queue2) {
		temp = new Queue<Comparable>();
		while (!queue1.isEmpty() || !queue2.isEmpty()) {
			if (queue1.isEmpty()) {
				temp.enqueue(queue2.dequeue());// queue1取完取queue2
			} else if (queue2.isEmpty()) {
				temp.enqueue(queue1.dequeue());// queue2取完取queue1
			} else if (less(queue1, queue2)) {
				temp.enqueue(queue1.dequeue());//如果queue1里的元素比queue2中的小添加queue1
			} else {
				temp.enqueue(queue2.dequeue());
			}
		}
		return temp;
	}

	private static boolean less(Queue<Comparable> queue1, Queue<Comparable> queue2) {
		boolean t;
		Comparable q1 = queue1.dequeue();
		Comparable q2 = queue2.dequeue();
		int count=0;//queue中元素的数量
		t = q1.compareTo(q2) < 0 ? true : false;
		//保证queue1的顺序
		count=queue1.size();
		queue1.enqueue(q1);
		while (count-->0) {
			queue1.enqueue(queue1.dequeue());
		}

		//保证queue2的顺序
		count=queue2.size();
		queue2.enqueue(q2);
		while (count-->0) {
			queue2.enqueue(queue2.dequeue());
		}
		return t;
	}

	public static void show(Queue<Comparable> queue) {
		while (!queue.isEmpty()) {
			System.out.print(queue.dequeue() + " ");
		}
	}
}

public class Num_2_02_14 {
	public static void main(String[] args) {
		Queue queue1 = new Queue();
		Queue queue2 = new Queue();

		for (Integer i = 0; i < 10; i++) {
			if (i < 5) {
				queue1.enqueue(i);
			}
			if (i > 5) {
				queue2.enqueue(i);
			}
		}

		//结果 12345
//		queue1.enqueue(1);
//		queue1.enqueue(3);
//		queue1.enqueue(5);
//		queue2.enqueue(2);
//		queue2.enqueue(4);
		MergeQueue.show(MergeQueue.mergeQueue(queue1, queue2));//0 1 2 3 4 6 7 8 9 
	}
}
