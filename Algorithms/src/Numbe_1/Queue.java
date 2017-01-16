package Numbe_1;

import java.util.Iterator;

/**
 * 用链表实现队列 ， 表尾添加结点，表头删除结点
 * args:a s d - - f g h - j k l o
 * @author he
 *
 */
public class Queue<Item> implements Iterable<Item> {

	private Node first;// 头部
	private Node last;// 尾部
	private int N;// 记录元素数目

	private  class Node {
		Item item;
		Node next;
	}

	public void enqueue(Item item) {
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;

		if (isEmpty()) {
			first = last;
		} else {
			oldlast.next = last;
		}

		N++;
	}

	public Item dequeue() {
		Item item = first.item;
		first = first.next;

		if (isEmpty()) {
			last = null;
		}
		N--;
		return item;
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new listIterator();
	}

	private class listIterator implements Iterator<Item> {

		private Node current = first;

		public boolean hasNext() {
			return current != null;
		}

		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}

	}

	public static void main(String[] args) {
		Queue<String> queue = new Queue<String>();
		for (String string : args) {
			if (!string.equals("-")) {
				queue.enqueue(string);
			} else if (!queue.isEmpty()) {
				System.out.print(queue.dequeue() + " ");
			}
		}
		System.out.println("(" + queue.size() + " left on stack" + ")");
	}

}
