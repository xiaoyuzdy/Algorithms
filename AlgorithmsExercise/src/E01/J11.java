package E01;

import java.util.ArrayList;
import java.util.List;

/**
 * 请编写一个函数，检查链表是否为回文。 给定一个链表ListNode* pHead，请返回一个bool，代表链表是否为回文。 测试样例：
 * {1,2,3,2,1} 返回：true {1,2,3,2,3} 返回：false
 * 
 * @author he
 *
 */

class ListNode4 {
	int val;
	ListNode4 next = null;

	ListNode4(int val) {
		this.val = val;
	}
}

public class J11 {
	public static boolean isPalindrome(ListNode4 pHead) {
		int count = 0;//结点个数
		List<ListNode4> list = new ArrayList<ListNode4>();
		for (ListNode4 x = pHead; x != null; x = x.next) {
			count++;
			list.add(x);
		}
		for (int i = 0; i < count / 2; i++) {
			if (list.get(i).val != list.get(count - i - 1).val) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		ListNode4 ll1 = new ListNode4(1);
		ll1.next = new ListNode4(2);
		ll1.next.next = new ListNode4(1);
		System.out.println(isPalindrome(ll1));

	}
}