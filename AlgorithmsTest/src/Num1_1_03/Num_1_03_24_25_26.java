package Num1_1_03;

import edu.princeton.cs.algs4.Queue;

/**
 * P103 T24 25 26
 * 
 * @author he
 *
 */

class List<T extends Comparable<T>> {
	private Node last;
	private Node first;
	private int N;

	private class Node {
		T item;
		Node next;
	}

	public void euqueue(T item) {
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if (N == 0)
			first = last;
		else
			oldlast.next = last;
		N++;
	}

	public int size() {
		return N;
	}

	public T getOfIndex(int index) {
		return getNode(index).item;
	}

	// 删除指定index后面的元素
	public void removeAfter(int index) {
		if(index>size() || index<0)
			throw new NullPointerException();
		Node x = getNode(index);
		x.next = x.next.next;

	}

	// 在指定index后面插入新结点
	public void insertAfter(int index, T item) {
		Node x = getNode(index);
		Node t = new Node();
		t.item = item;
		t.next = x.next;
		x.next = t;
	}

	// 通过下标获取结点，由于
	private Node getNode(int index) {
		if (index >= N || index < 0)
			throw new NullPointerException();

		Node x = first;
		for (int i = 0; i < index; i++) {
			x = x.next;
		}
		return x;
	}

	public void remove(T item) {
		first = remove(first, item);
	}

	private Node remove(Node x, T item) {
		if (x == null)
			return null;
		if (x.item.equals(item)) {
			N--;
			return x.next;
		}
		x.next = remove(x.next, item);
		return x;

	}

	// 打印所有结点元素
	public Iterable<T> print() {
		Queue<T> queue = new Queue<T>();
		print(queue);
		return queue;
	}

	private void print(Queue<T> queue) {
		for (Node x = first; x != null; x = x.next) {
			queue.enqueue(x.item);
		}
	}

}

public class Num_1_03_24_25_26 {
	public static void main(String[] args) {
		List<Integer> list = new List<Integer>();
		for (int i = 0; i < 5; i++) {
			list.euqueue(i);
		}
		System.out.println(list.getOfIndex(0));
		list.removeAfter(0);// 1删除了
		System.out.println(list.getOfIndex(1));// 2
		System.out.println(list.print());// 0 2 3 4
		list.insertAfter(1, 9);
		System.out.println(list.print());// 0 2 9 3 4
		list.remove(2);
		System.out.println(list.print());//0 9 3 4

	}

}
