package Num1_1_04;


public class Steque<T> {
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
	
	public boolean isEmpty(){
		return N==0;
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
