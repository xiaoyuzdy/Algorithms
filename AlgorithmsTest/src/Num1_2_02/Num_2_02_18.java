package Num1_2_02;

import java.util.Random;

/**
 * P181 T18 符合要求
 * 
 * @author he
 *
 */

class RandomList {
	private static Random random;

	public static ListNode random(ListNode list) {
		if (list == null || list.next == null) {
			return list;
		}
		ListNode before = list;
		ListNode after = list;

		while (after.next != null && after.next.next != null) {
			before = before.next;
			after = after.next.next;
		}
		ListNode aTemp = random(before.next);
		before.next = null;
		ListNode bTemp = random(list);
		return random(aTemp, bTemp);

	}

	public static ListNode random(ListNode list1, ListNode list2) {
		ListNode t = new ListNode(-1);
		ListNode temp = t;
		/**
		 * 随机数如果这么写  会导致链表不完整  应该是没有进行同步控制的原因
		 * while (list1 != null && list2 != null) { random = new Random(); if
		 * (random.nextBoolean()) { temp.next = list1; list1 = list1.next; }
		 * else { temp.next = list2; list2 = list2.next; } temp = temp.next; }
		 * if (list1 == null) { temp.next = list2; } else { temp.next = list1; }
		 * 
		 * 按照下面这样写可以保证链表的完整性和随机性
		 */
		while (list1 != null && list2 != null) {
			random = new Random();
			if (list1.val <= list2.val) {
				if (random.nextBoolean()) {
					temp.next = list1;
					list1 = list1.next;
				} else {
					temp.next = list2;
					list2 = list2.next;
				}
			} else {
				temp.next = list2;
				list2 = list2.next;
			}
			temp = temp.next;
		}
		if (list1 == null) {
			temp.next = list2;
		} else {
			temp.next = list1;
		}

		return t.next;
	}

	public static void show(ListNode list) {
		StringBuilder builder = new StringBuilder();
		while (list != null) {
			builder.append(list.val);
			builder.append(",");
			list = list.next;
		}
		System.out.println(builder.toString());
	}
}

public class Num_2_02_18 {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(10);
		l1.next.next = new ListNode(15);
		l1.next.next.next = new ListNode(9);
		l1.next.next.next.next=new ListNode(99);
		l1.next.next.next.next.next=new ListNode(20);
	    RandomList.show(l1);
		RandomList.random(l1);
		System.out.println("---------------------------------");
		RandomList.show(l1);
	}

}
