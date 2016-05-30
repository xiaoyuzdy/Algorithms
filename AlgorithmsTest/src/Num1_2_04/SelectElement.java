package Num1_2_04;

import edu.princeton.cs.algs4.StdRandom;

/**
 * P221 寻找一组数中第k小元素，用于寻找中位数可以保证在线性时间内解决 利用快速排序的切分思想
 * 
 * @author he
 *
 */
public class SelectElement {

	/**
	 * 
	 * @param a
	 *            数组
	 * @param k
	 *            数组中第k小的元素,k为下标
	 * @return 返回该元素
	 */
	public static double select(int a[], int k) {
		StdRandom.shuffle(a);
		int lo = 0, hi = a.length - 1;
		while (lo < hi) {
			int j = partition(a, lo, hi);
			if (j == k) {
				return a[k];
			} else if (j < k) {
				lo = j + 1;
			} else if (j > k) {
				hi = j - 1;
			}
		}
		return a[k];
	}

	// 查找中位数
	public static double findMedian(int a[]) {
		int N = a.length;
		if (N % 2 != 0) {
			return select(a, N / 2);
		} else {
			return (select(a, N / 2) + select(a, N / 2 - 1)) / 2;
		}
	}

	private static int partition(int a[], int lo, int hi) {
		int i = lo, j = hi + 1;
		int v = a[lo];

		while (true) {
			while (a[++i] < v) {
				if (i == hi) {
					break;
				}
			}
			while (v < a[--j]) {
				if (j == lo) {
					break;
				}
			}
			if (i >= j) {
				break;
			}
			exch(a, i, j);
		}
		exch(a, lo, j);

		return j;
	}

	private static void exch(int a[], int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5, 6, 7 };
		System.out.println(findMedian(a));
	}

}
