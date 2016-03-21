package Num1_1_03;

/**
 * P103 T19 表头插入元素，表尾删除元素。
 * 
 * @author he
 *
 */

class TQue<Item> {
	private int N;
	private Node first;// 表头
	private Node last;// 表为

	private class Node {
		Item item;
		Node next;
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public void push(Item item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		N++;
	}

	//从表尾删除
	public Item pop() {
		Item item = null;
		for (Node x = first; x != null; x = x.next) {
			//找到倒数第二个结点
			if (x.next.next == null) {
				last = x.next;
				item = last.item;
				x.next=null;
				break;
			}
		}
		return item;
	}
}

public class Num_1_03_19 {
	public static void main(String[] args) {
		TQue<Integer> t = new TQue<Integer>();
		for (int i = 0; i < 10; i++) {
			t.push(i);
			if (i >= 5) {
				System.out.println(t.pop());
			}
		}
	}
}
