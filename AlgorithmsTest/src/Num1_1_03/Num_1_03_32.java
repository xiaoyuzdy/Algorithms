package Num1_1_03;

/**
 * P104 T32
 *push(),pop()在队列的一端操作，enqueue()在队列的另一端
 * @author Administrator
 *
 */

class Steque<T> {
	private int N;// size
	private Node first;
	private Node last;

	private class Node {
		T item;
		Node next;
	}

	public void push(T item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		if (N == 0) {
			last = first;
		}
		first.next = oldfirst;
		N++;
	}

	public T pop() {
		if (N == 0) {
			throw new IndexOutOfBoundsException();
		}
		T item = first.item;
		first = first.next;
		N--;
		return item;
	}

	public void enqueue(T item) {
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if (N == 0) {
			first = last;
		} else {
			oldlast.next = last;
		}
		N++;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		Node temp = first;
		for (int i = 0; i < N; i++) {
			s.append("[");
			s.append(temp.item);
			s.append("]");
			s.append(",");
			temp = temp.next;
		}
		return s.toString();
	}

}

public class Num_1_03_32 {
	public static void main(String[] args) {
		Steque<Integer> s = new Steque<Integer>();
		// s.push(7);
		s.enqueue(3);
		s.enqueue(5);
		s.enqueue(6);
		s.push(2);
		s.push(1);
		s.push(4);
		// System.out.println(s.pop());//4
		// System.out.println(s.pop());//1
		System.out.println(s);// 4 1 2 3 5 6
	}
}
