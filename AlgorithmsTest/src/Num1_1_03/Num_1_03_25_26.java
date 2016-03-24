package Num1_1_03;

/**
 * P103 T25 T26 参数的两个结点，一个为链表里的结点，一个为要插入的结点
 * 
 * @author he
 *
 */
public class Num_1_03_25_26<T> {
	private int N;
	private Node first;
	private Node last;

	private class Node {
		T item;
		Node next;
	}

	void enqueue(T item) {
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

	//T 25
	void insertAfter(Node node1, Node node2) {
		if (node1 != null && node2 != null) {
			for (Node x = first; x != null; x = x.next) {
				if (x.item == node1.item) {
					node2.next = x.next.next;
					x.next = node2;
					node2.item = node2.item;
					N++;
				}
			}
		} else {
			System.out.println("node1 and node2 =null");
		}

	}

	int size(){
		return N;
	}
	
	boolean find(T key) {
		for (Node x = first; x != null; x = x.next) {
			if (x.item == key) {
				return true;
			}
		}
		return false;

	}

	//T 26
	void remove(T key) {
		for (Node x = first; x != null; x = x.next) {
			if (x.next.item == key) {
               x.next=x.next.next;
               N--;
			}
		}
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Num_1_03_25_26<Integer> a = new Num_1_03_25_26<Integer>();
		for (int i = 0; i < 5; i++) {
			a.enqueue(i);
		}
		
		//测试T 26
		System.out.println(a.size());//5
		a.enqueue(2);
		System.out.println(a.size());//6
		a.remove(2);
		System.out.println(a.size());//4
		System.out.println(a.find(2));//false
		
		//测试T25
		@SuppressWarnings("rawtypes")
		Num_1_03_25_26.Node node1 = a.new Node();
		node1.item = 3;
		@SuppressWarnings("rawtypes")
		Num_1_03_25_26.Node node2 = a.new Node();
		node2.item = 10;

		a.insertAfter(node1, node2);
		System.out.println(a.find(10)); // true

	}

}
