package Num1_1_04;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * P132 T8 用HashMap保存数据， 1，1，1 算一对1， 1，1，1，1 算两对1
 * 
 * 如果用二分查找必须要修改二分查找的first下标值，不然很容易找的key的下标为原来的下标
 * 
 * @author he
 *
 */
public class Num_1_04_08 {
	public static void count(int a[]) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < a.length; i++) {
			if (map.get(a[i]) == null) {
				map.put(a[i], 1);
			} else {
				map.put(a[i], map.get(a[i]) + 1);
			}
		}
		Set<Integer> set = map.keySet();
		Iterator<Integer> iterator = set.iterator();
		while (iterator.hasNext()) {
			int i = iterator.next();
			System.out.println(i + " 有" + (map.get(i) / 2) + " 对");
		}
	}

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 1, 2, 1, 1 };
		count(a); // 1 有2 对 ；2 有1 对 ；3 有0 对
	}

}
