package Num1_1_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * P35 删除重复元素
 * 
 * @author he
 *
 */
public class Ex_1_1_28 {
	// 删除数组中的重复元素
	public static List<Integer> del(int a[]) {
		List<Integer> list = new ArrayList<Integer>();
		int temp = a[0];
		list.add(a[0]);
		for (int i = 0; i < a.length; i++) {
			if (temp != a[i]) {
				temp = a[i];
				list.add(a[i]);
			}
		}
		return list;
	}
	public static void main(String[] args) {
		int a[] = { 2, 3, 4, 4, 4, 5, 66, 66, 5 };
		Arrays.sort(a);
		System.out.println(del(a));
	}
}
