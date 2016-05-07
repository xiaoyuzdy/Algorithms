package Num1_2_02;

/**
 * P180 T17
 * 
 * @author he
 *
 */

class ListNode {
	int val;
	ListNode next = null;

	ListNode(int x) {
		val = x;
	}

}

class listNodeMerge {
	public static ListNode sort(ListNode list) {
		if (list == null || list.next == null) {
			return list;
		}
		ListNode before = list;
		ListNode after = list;

		// before 往后移动一个位置，after往后移动两个位置 这样当after移至末尾时，before正好在链表的中间
		while (after.next != null && after.next.next != null) {
			before = before.next;
			after = after.next.next;
		}

		// 归并后半段链表
		ListNode aTemp = sort(before.next);
		before.next = null;
		// 归并前半段链表
		ListNode bTemp = sort(list);
		return merge(aTemp, bTemp);

	}

	public static ListNode merge(ListNode h1, ListNode h2) {
		// c用来连接链表，hn始终指向链表头
		ListNode hn = new ListNode(-1);
		ListNode c = hn;
		while (h1 != null && h2 != null) {
			if (h1.val <= h2.val) {
				c.next = h1;
				h1 = h1.next;
			} else {
				c.next = h2;
				h2 = h2.next;
			}
			c = c.next;
		}
		if (h1 == null) {
			c.next = h2;
		} else {
			c.next = h1;
		}

		return hn.next;
	}

	public static void show(ListNode list) {
		StringBuilder builder = new StringBuilder();
		while (list != null) {
			builder.append(list.val);
			list = list.next;
		}
		System.out.println(builder.toString());
	}

}

public class Num_2_02_17 {

	public static void main(String[] args) {
		// ListNode l1 = new ListNode(0);
		// l1.next = new ListNode(2);
		// l1.next.next = new ListNode(4);
//		ListNode l2 = new ListNode(1);
//		 l2.next = new ListNode(3);
//		 l2.next.next = new ListNode(5);
//		listNodeMerge.show(listNodeMerge.merge(l1, l2));//0 1 2 3 4 5
		
		ListNode l3 = new ListNode(0);
		l3.next = new ListNode(5);
		l3.next.next = new ListNode(3);
		l3.next.next.next=new ListNode(9);
		listNodeMerge.show(listNodeMerge.sort(l3));
		

	}
}
