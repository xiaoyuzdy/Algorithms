package Num1_1_04;

import edu.princeton.cs.algs4.Stack;

/**
 * P134 T27
 * 
 * @author he
 *
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

public class Num_1_04_27 {
	public static void main(String[] args) {

		Que<Integer> que = new Que<Integer>();
		for (int i = 0; i < 5; i++) {
			que.enqueue(i);
		}
		System.out.println("que size-->" + que.size());
		while (!que.isEmpty()) {
			System.out.println(que.dequeue());
		}
	}
}
