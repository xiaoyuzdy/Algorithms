package Num1_1_04;

import edu.princeton.cs.algs4.Queue;

/**
 * P134 T28 用一个数组保存队列出列的元素
 *  测试通过
 * 
 * @author he
 *
 */

class Stack<T> {
	private Queue<T> queue = new Queue<T>();
	@SuppressWarnings("unchecked")
	private T[] temp = (T[]) new Object[100000];
	private int N;

	public void push(T item) {
		queue.enqueue(item);
		N++;
	}

	public T pop() {
		// 取出元素
		for (int i = 0; i < N; i++) {
			temp[i] = queue.dequeue();
		}
		// 将元素再存进Queue
		for (int j = 0; j < N - 1; j++) {
			queue.enqueue(temp[j]);
		}
		N--;
		return temp[N];
	}

	public boolean isEmpty() {
		return N == 0;
	}

}

public class Num_1_04_28 {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < 5; i++) {
			stack.push(i);
		}
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}

	}
}
