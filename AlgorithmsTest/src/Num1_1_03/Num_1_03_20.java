package Num1_1_03;

public class Num_1_03_20<T> {
	private int N;
	private Node first;
	private Node last;

	public class Node {
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

	T delete(int k) {
		int temp = 1;
		if (k > N) {
			System.out.println("越界");
			return null;
		}
		for (Node x = first; x != null; x = x.next) {
			if (++temp == k) {
				T item = x.next.item;// 得到删除结点的元素
				x.next = x.next.next;// 移除删除的结点
				N--;
				return item;
			} else if (k == 1) {
				T item = first.item;
				first = first.next;
				N--;
				return item;
			}

		}
		return null;
	}
		

	public static void main(String[] args) {
		Num_1_03_20<Integer> a = new Num_1_03_20<Integer>();
		for (int i = 0; i < 5; i++) {
			a.enqueue(i);
		}
		System.out.println(a.delete(3));//2
		System.out.println(a.delete(3));//3

	}

}
