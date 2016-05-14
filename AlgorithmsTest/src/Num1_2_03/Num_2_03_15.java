package Num1_2_03;

import java.util.Arrays;

import edu.princeton.cs.algs4.BinarySearch;

/**
 * 将螺帽排序，在使用二分查找进行匹配 b在被二分查找到后将数据改后要重写排序否则有的数据找不到
 * 
 * @author he
 *
 */
class Qu {
	private static int count;
	private static int match;

	public static int match(int a[], int b[]) {
		// matching(a, b);
		matching2(a, b);
		return match;
	}

	private static void matching(int[] a, int[] b) {
		count = a.length + b.length;// 螺丝和螺帽的总数量
		Arrays.sort(b);// 排序
		int N = a.length < b.length ? a.length : b.length;
		for (int i = 0; i < N; i++) {
			int t = BinarySearch.indexOf(b, a[i]);
			if (t > -1) {
				count = count - 2;
				match++;
				b[t] = -1;// 将之前匹配到的位置设置为-1 防止下次仍能匹配到
				Arrays.sort(b);// 将b重新排序，保证b的有序性
			}
		}
	}

	private static void matching2(int a[], int b[]) {
		count = a.length + b.length;// 螺丝和螺帽的总数量
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				if (b[j] == a[i]) {
					count = count - 2;
					match++;
					b[j] = -1;// 将之前匹配到的位置设置为-1 防止下次仍能匹配到
				}
			}
		}
	}

	public static int Unmatching() {
		return count;
	}
}

public class Num_2_03_15 {
	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6 };
		int b[] = { 3, 4, 5, 5, 7, 8, 88, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6 };
		System.out.println("匹配的对数：" + Qu.match(a, b) + "对");// 14
		System.out.println("有 " + Qu.Unmatching() + " 个未匹配");// 21
	}
}
