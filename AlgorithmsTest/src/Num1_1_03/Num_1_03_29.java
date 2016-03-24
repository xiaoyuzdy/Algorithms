package Num1_1_03;

import java.util.concurrent.TimeUnit;

/**
 * P103 T29
 * 
 * @author he 思路：用int size 控制链表的长度 (size=5)为了方便 使用static 不使用泛型 ，如要使用参考前面的写的习题
 *         last.next=first;
 */
public class Num_1_03_29 {
	private static int size = 5;// 环形链表的长度
	private static int N;// 存放元素个数
	private static Node first;
	private static Node last;

	public Num_1_03_29(int size) {
		this.size = size;
	}

	private static class Node {
		int item;
		Node next;
	}

	public static void enqueue(int item) {
		if (N >= size) {
			System.out.println("已满");
			throw new RuntimeException();
		}
		Node oldlast = last;
		last = new Node();
		last.item = item;

		if (N == 0) {
			first = last;
		} else {
			oldlast.next = last;
		}
		N++;
		if (N == size) {
			last.next = first;
		}
	}

	static boolean isEmpty() {
		return N == size;
	}

	public static void main(String[] args) throws Exception{
		//size =5;
		for (int i = 0; i < 5; i++) {
			enqueue(i);
		}
		System.out.println(isEmpty());// true
	    TimeUnit.SECONDS.sleep(2);
		enqueue(8);// java.lang.RuntimeException
	}

}
