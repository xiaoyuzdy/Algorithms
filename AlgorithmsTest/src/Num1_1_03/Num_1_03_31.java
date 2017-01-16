package Num1_1_03;

/**
 * P104 T31 双向链表 相当于简化版的Linkedlist
 * 主要实现了从表头，表尾插入一个结点，在指定结点之前或之后插入一个结点，
 * 从表头，表尾删除一个结点，删除指定结点 
 * 指定索引返回结点
 * 
 * 
 * 测试通过；
 * 
 * @author he
 *
 */
class DoubleNode<T> {
	private int N;// 记录元素个数
	private Node first;// 头结点
	private Node last;// 尾结点

	private class Node {
		T item;
		Node perv;// 前一个结点
		Node next;// 后一个结点

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return item + "";
		}
	}

	// 根据索引获取结点
	public Node getNode(int index) {
		if (index < 0 || index >= N) {
			throw new IndexOutOfBoundsException();
		}

		Node node = first;

		for (int i = 0; i < index; i++) {
			node = node.next;
		}

		return node;
	}

	// 判断是否为空
	public boolean isEmpty() {
		return N == 0;
	}

	// 元素个数
	public int size() {
		return N;
	}

	// 表头插入结点
	public void pushFirst(T item) {

		Node oldfirst = first;
		first = new Node();
		first.item = item;
		if (isEmpty()) {
			last = first;
		} else {
			first.next = oldfirst;
			oldfirst.perv = first;
		}
		N++;
	}

	// 在指定结点前添加新结点
	public void pushBefore(Node newnode, Node node) {
		newnode.next = node;
		newnode.perv = node.perv;
		newnode.next.perv = newnode;
		// 防止在头结点前面插入新结点
		if (newnode.perv != null) {
			newnode.perv.next = newnode;
		}
		N++;
	}

	// 在指定索引前插入新结点
	public void pushBeforeOfIndex(T item, int index) {
		Node node = getNode(index);
		Node newnode = new Node();
		newnode.item = item;
		if(index==0){
			first=newnode;
		}
		pushBefore(newnode, node);
	}

	// 从表尾插入
	public void pushLast(T item) {
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if (isEmpty()) {
			first = last;
		} else {
			oldlast.next = last;
			last.perv = oldlast;
		}
		N++;
	}

	// 在指定结点后添加新结点
	public void pushAfter(Node newnode, Node node) {
		newnode.perv = node;
		newnode.next = node.next;
		newnode.perv.next = newnode;
		// 防止在尾结点之后插入新结点
		if (newnode.next != null) {
			newnode.next.perv = newnode;
		}
		N++;
	}

	// 在指定索引之后添加结点
	public void pushAfterOfIndex(T item, int index) {
		Node newnode = new Node();
		newnode.item = item;
		Node node = getNode(index);
		pushAfter(newnode, node);

	}

	// 从表头删除一个结点
	public void popFirst() {
		first = first.next;
		if (first != null) {
			first.perv = null;
		}
		N--;
	}

	// 从表为删除一个结点
	public void popLast() {
		last.perv.next = null;
		last.perv = null;
		N--;
	}

	// 删除指定的结点
	private void pop(Node node) {

		node.perv.next = node.next;
		node.next.perv = node.perv;
		node.perv = null;
		node.next = null;
		N--;
	}

	// 删除指定索引的结点
	public void popOfIndex(int index) {
		if (index == 0) {
			popFirst();
		} else if (index == N - 1) {
			popLast();
		} else {
			Node node = getNode(index);
			pop(node);
		}

	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node node = first;
		for (int i = 0; i < N; i++) {
			sb.append("[");
			sb.append(node);
			sb.append("]");
			sb.append(",");
			node = node.next;
		}
		return sb.toString();
	}

}

public class Num_1_03_31 {
	public static void main(String[] args) {
		DoubleNode<Integer> d = new DoubleNode<Integer>();
		d.pushFirst(1);
		d.pushFirst(2);
		d.pushFirst(3);
		// d.pushFirst(4);
		d.pushLast(5);
		// d.pushLast(6);
		// System.out.println(d.size());
		// d.pushBeforeOfIndex(10, 1);
		// d.pushAfterOfIndex(9, 0);
		// d.popFirst();
		// d.popFirst();
		d.popOfIndex(0);
		// d.popOfIndex(3);
		// d.popLast();
		System.out.println(d.toString());
		// System.out.println(d.getNode(2));
	}

}
