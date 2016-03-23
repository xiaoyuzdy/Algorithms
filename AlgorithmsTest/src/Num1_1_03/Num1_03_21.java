package Num1_1_03;

public class Num1_03_21<T> {
	private int N;
	private Node first;
	private Node last;

	private class Node {
		T item;
		Node next;
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

	boolean find(T key) {
		for (Node x = first; x != null; x = x.next) {
			if (x.item == key) {
				return true;
			}
		}
		return false;

	}

	public static void main(String[] args) {
		Num1_03_21<Integer> a= new Num1_03_21<Integer>();
		for (int i = 0; i < 5; i++) {
			a.enqueue(i);
		}
		System.out.println(a.find(2));
	}
	
}
