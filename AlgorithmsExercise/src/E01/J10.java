package E01;

/**
 * 有两个用链表表示的整数，每个结点包含一个数位。这些数位是反向存放的，也就是个位排在链表的首部。编写函数对这两个整数求和，并用链表形式返回结果。
 * 给定两个链表ListNode* A，ListNode* B，请返回A+B的结果(ListNode*)。
 * 
 * 测试样例： {1,2,3},{3,2,1} 返回：{4,4,4}
 * 
 * @author he
 *
 */

class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return val + "";
	}
}

public class J10 {
	public static ListNode plusAB(ListNode a, ListNode b) {
		ListNode node = null;
		ListNode old = null;
		for (ListNode x = a; x != null; x = x.next) {
			// ListNode old=node;
			node = new ListNode(-1);
			if (x != null && b != null) {
				node.val = x.val + b.val;
			}
			if (b == null) {
				node.val = x.val;
			}
			if (b.next == null) {
				b.next = b;
				b.next.val = 0;
			}
			b = b.next;
			old = node;
			old.next = node;
			// node.next=old;
		}
		return node;
	}

	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		a.next = new ListNode(2);
		ListNode b = new ListNode(3);
		System.out.println(plusAB(a, b));
	}

}