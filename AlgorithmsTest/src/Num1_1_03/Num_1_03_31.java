package Num1_1_03;

/**
 * P104 T31 双向链表 用一个结点 从头插入就是在head结点的左边 尾部插入就是head结点的右边
 * 
 * @author he
 *
 */
class DoubleNode<T> {
	private int N;// 记录元素个数
	private Node head= new Node(null);// 头结点
	private Node last= new Node(null);//尾结点

	private class Node {
		T item;
		Node perv;// 前一个结点
		Node next;// 后一个结点

		public Node(T val) {
			item = val;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return item+"";
		}
	}

	//根据索引获取结点
	public Node getNode(int index){
		if (index <0 || index >= N) {
			throw new IndexOutOfBoundsException();
		}
		Node node=head;
		for(int i=0;i<index;i++){
			node=node.next;
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
		Node newnode = new Node(item);
//		head=newnode;//头结点往前移，让新插入的结点为头结点
		pushBefore(newnode, head);
//		
	}

	// 在指定结点前添加新结点
	public void pushBefore(Node newnode, Node node) {
		newnode.next = node;
		newnode.perv = node.perv;
		newnode.next.perv = newnode;
		if (newnode.perv != null) {
			newnode.perv.next = newnode;
		}
		head=newnode;//更新头结点
		N++;
	}

	// 从表尾插入
	public void pushLast(T item) {
		Node newnode = new Node(item);
		pushAfter(newnode, head);
	}

	// 在指定结点后添加新结点
	public void pushAfter(Node newnode, Node node) {
		newnode.perv = node;
		newnode.next = node.next;
		newnode.perv.next = newnode;
		if (newnode.next != null) {
			newnode.next.perv = newnode;
		}
		N++;
	}

	
	
}

public class Num_1_03_31 {
	public static void main(String[] args) {
		DoubleNode<Integer> d = new DoubleNode<Integer>();
		d.pushFirst(1);
		d.pushFirst(2);
		d.pushFirst(3);
		d.pushFirst(4);
		d.pushLast(5);
//		System.out.println(d.size());
       System.out.println(d.getNode(1));
	}

}
