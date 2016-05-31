package Num1_2_05;

import java.util.Arrays;

/**
 * P224 T02
 * 
 * @author he
 *
 */

/**
 * 用于String类型的二分查找
 * 
 * @author he
 *
 */
class BinarySearch {
	public static int indexOf(String a[], String key) {
		int lo = 0;
		int hi = a.length - 1;

		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;

			if (key.compareTo(a[mid]) < 0)
				hi = mid - 1;
			else if (key.compareTo(a[mid]) > 0)
				lo = mid + 1;
			else
				return mid;
		}
		return -1;
	}

}

public class Num_2_05_02 {

	public static String find(String a[]) {
		StringBuilder sb = new StringBuilder();
		Arrays.sort(a);// 排序，用于二分查找
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (BinarySearch.indexOf(a, a[i] + a[j]) >= 0) {
					sb.append(a[i] + a[j]);
					sb.append(" ");
				}
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		String a[] = { "after", "thought", "afterthought","a","b","ab","ba" };
		System.out.println(find(a));
	}

}
