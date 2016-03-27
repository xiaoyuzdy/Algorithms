package Numbe_1;

/**
 *  单链表的反转 1<-2<-3<-4 ==> 1->2->3->4
 * 
 * @author he
 *
 */
class Node<T> {
	T item;
	Node next = null;

	public Node(T item) {
		this.item = item;
	}
}

public class reverseLinkedlist {

	// 迭代实现链表反转
	public static Node reverse(Node x) {
		Node first = x;
		Node reverse = null;
		while (first != null) {
			Node second = first.next;
			first.next = reverse;
			reverse = first;
			first = second;
		}

		return reverse;
	}

	// 递归实现链表反转
	public static Node reverseGcd(Node first) {
		if (first == null) {
			return null;
		}
		if (first.next == null) {
			return first;
		}
		Node second = first.next;
		second.next = first;
		first.next = null;
		Node rest = reverseGcd(second);
		return rest;

	}

	public static void main(String[] args) {
		Node<Integer> node = new Node<Integer>(1);
		node.next = new Node<Integer>(2);
		node.next.next = new Node<Integer>(3);
		System.out.println(reverse(node).item);// 3
		System.out.println(reverseGcd(node).item);// 1 ,true 因为链表已经被反转过一次

	}

}
