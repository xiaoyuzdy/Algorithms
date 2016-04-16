package Num1_1_04;

import edu.princeton.cs.algs4.Stack;;

/**
 * 使用1.3.32写的Steque,使用1.3.33的API
 * Steque满足两端添加push()数据，同时Steque的pop()对应Deque的popRight() 对于popLeft()
 * Steque里的元素全部pop()出来存到一个数组，再把数组的里元素存到Steque和stack中 只用steque和stack感觉写不了
 *
 * @author he
 * 测试通过
 *
 */

class Deque1<T> {
	private Steque<T> steque = new Steque<T>();
	private Stack<T> stack = new Stack<T>();

	public void pushLeft(T item) {
		steque.enqueue(item);
	}

	public void pushRight(T item) {
		steque.push(item);
	}

	public T popLeft() {

		if (steque.isEmpty()) {
			throw new RuntimeException();
		}

		@SuppressWarnings("unchecked")
		T[] temp = (T[]) new Object[10000];
		int i = 0;
		while (!steque.isEmpty()) {
			temp[i++] = steque.pop();
		}
		// 将元素push到stack
		for (int j = 0; j < i; j++) {
			stack.push(temp[j]);
		}
		// 将元素重新pushRight到steque,并去除最左端的元素
		for (int k = 0; k < i - 1; k++) {
			steque.enqueue(temp[k]);
		}
		return stack.pop();

	}

	public T popRight() {
		if (steque.isEmpty()) {
			throw new RuntimeException();
		}
		return steque.pop();
	}
}

public class Num_1_04_30 {
	public static void main(String[] args) {
		Deque1<Integer> deque1 = new Deque1<Integer>();
		deque1.pushLeft(2);
		deque1.pushLeft(1);
		deque1.pushRight(3);
		deque1.pushRight(4);
		System.out.println(deque1.popRight());// 4
		System.out.println(deque1.popRight());// 3
		System.out.println(deque1.popLeft());// 1
		System.out.println(deque1.popLeft());// 2

	}
}
