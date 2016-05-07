package Num1_1_03;

import edu.princeton.cs.algs4.Queue;

/**
 * P105 T37 思路：使用单链表,重置first结点，形成环形链表，然后删除结点， 0,1,2,3,4,5,6 删除位置为2的结点
 * 1,3,5,0,4,2
 * 
 * 测试通过
 * 
 * @author Administrator 16/5/07 修改，之前写的很蠢,灵感来自第二章第二节里的Fun.java
 */
/**
 * class Josephus <T>{ private int N; private int size;//链表总长度 private Node
 * first; private Node last;
 * 
 * public Josephus(int size){ this.size=size; } public class Node { T item; Node
 * next; }
 * 
 * public void enqueue(T item) { Node oldlast = last; last = new Node();
 * last.item = item; last.next = null; if (N == 0) { first = last; } else {
 * oldlast.next = last; } N++; //形成环形 if(N==size){ last.next=first; } }
 * 
 * public T josephus(int i){ T item=delete(i); return item; } public T
 * delete(int k) { int temp = 1; if (k > N) { System.out.println("越界"); return
 * null; } for (Node x = first; x!= null; x = x.next) { if (++temp == k) {
 * if(x.next==null){ x.next=first; //形成环形 } T item = x.next.item;// 得到删除结点的元素
 * x.next = x.next.next;// 移除删除的结点 first=x.next; N--; return item; } else if (k
 * == 1) { T item = first.item; first = first.next; N--; return item; }
 * 
 * } return null; } } public class Num_1_03_37 { public static void
 * main(String[] args) { Josephus<Integer> a=new Josephus<Integer>(7); for (int
 * i = 0; i < 7; i++) { a.enqueue(i); } for(int i=0;i<6;i++){
 * System.out.println(a.josephus(2)); } System.out.println(a.josephus(1)); } }
 **/
public class Num_1_03_37 {
	public static int Josephus(Queue<Integer> queue, int N) {
		while (N-- > 1) {
			queue.enqueue(queue.dequeue());
		}
		return queue.dequeue();
	}

	public static void main(String[] args) {
		Queue<Integer> queue = new Queue<Integer>();
		int length = Integer.parseInt(args[0]);// 7
		int N = Integer.parseInt(args[1]);// 2
		for (int i = 0; i < length; i++) {
			queue.enqueue(i);
		}
		while (!queue.isEmpty()) {
			System.out.print(Josephus(queue, N)+" ");//1 3 5 0 4 2 6 
		}
	}
}
