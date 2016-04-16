package Num1_1_04;

import edu.princeton.cs.algs4.Stack;

/**
 * P134 T29 两个stack 一个stack 进行pop push操作， 一个stack 进行enqueue操作
 *  ---|--- 
 *  ---|---
 * 
 * @author he
 *
 */

class Steque_29<T> {
	private Stack<T> left = new Stack<T>();
	private Stack<T> right = new Stack<T>();

	public void enqueue(T item) {
		right.push(item);
	}

	public void push(T item) {
		left.push(item);
	}

	public T pop() {
		if (!left.isEmpty()) {
			return left.pop();
		} else if (!right.isEmpty()) {
			return right.pop();
		} else {
			throw new RuntimeException();
		}
	}

	public boolean isEmpty() {
		return left.isEmpty() && right.isEmpty();
	}

}

public class Num_1_04_29 {
	public static void main(String[] args) {
		Steque_29<Integer> steque=new Steque_29<Integer>();
		steque.push(0);
		steque.push(1);
		steque.enqueue(2);
		System.out.println(steque.pop());//1
		System.out.println(steque.pop());//0
		System.out.println(steque.pop());//2	
	}

}
