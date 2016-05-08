package Num1_2_02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdRandom;

/**
 * ╤сап
 * @author he
 *
 */

class RandomQueue {
	public static Queue<Integer> random(Queue<Integer> queue) {
		random(queue, queue.size());
		return queue;
	}

	private static void random(Queue<Integer> queue, int N) {
		Set<Integer> set = new HashSet<Integer>();
		while (!queue.isEmpty()) {
			set.add(queue.dequeue());
		}
		Iterator<Integer> iterator=set.iterator();
		while(iterator.hasNext()){
            int x=iterator.next();
			queue.enqueue(iterator.next());
			queue.enqueue(x);
		}

	}

	public static void show(Queue<Integer> queue) {
		while (!queue.isEmpty()) {
			System.out.print(queue.dequeue() + " ");
		}
	}
}

public class Num_2_02_18_Queue {
	public static void main(String[] args) {
		Queue<Integer> queue = new Queue<Integer>();
		for (int i = 0; i < 10; i++) {
			queue.enqueue(i);
		}
		// RandomQueue.show(queue);
		System.out.println("\n-------------");
		RandomQueue.random(queue);
		RandomQueue.show(queue);
	}

}
