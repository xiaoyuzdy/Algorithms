package Num1_1_03;

import edu.princeton.cs.algs4.Stack;

/**
 * P107 T49
 * 
 * @author he 思路：用两个栈实现一个队列，保证了元素的相对顺序和FIFO
 * 用栈实现队列会造成空间浪费，其中一个栈仅仅是做中转保证FIFO的顺序
 */

class Que<T> {
	private Stack<T> left = new Stack<T>();
	private Stack<T> right = new Stack<T>();

	// 添加元素
	void enqueue(T item) {
		left.push(item);
	}

	T dequeue() {
		while (!left.isEmpty()) {
			// 将left中的元素给right
			right.push(left.pop());
		}
		return right.pop();
	}

	int size() {
		return left.size();
	}

	boolean isEmpty() {
		if (left.isEmpty() && right.isEmpty()) {
			return true;
		}
		return false;
	}
}

public class Num_1_03_49 {
	public static void main(String[] args) {

		Que<Integer> que = new Que<Integer>();
		for (int i = 0; i < 5; i++) {
			que.enqueue(i);
		}
		System.out.println("que size-->"+que.size());
		while (!que.isEmpty()) {
			System.out.println(que.dequeue());
		}
	}

}
