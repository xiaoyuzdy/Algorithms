package Num1_2_03;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdRandom;

/**
 * P192 T20
 * 
 * @author he
 *
 */

class QuickW {

	public static void sort(int a[]) {
		StdRandom.shuffle(a);
		sort(a, 0, a.length - 1);
	}

	private static void sort(int a[], int lo, int hi) {
		if (a == null || a.length == 1)
			return;
		// 存放开始与结束索引
		Stack<Integer> s = new Stack<Integer>();
		// 压栈
		s.push(0);
		s.push(a.length - 1);
		// 利用循环里实现
		while (!s.isEmpty()) {
			int right = s.pop();
			int left = s.pop();
			// 如果最大索引小于等于左边索引，说明结束了
			if (right <= left)
				continue;

			int i = part(a, left, right);
			if (left < i - 1) {
				s.push(left);
				s.push(i - 1);
			}
			if (i + 1 < right) {
				s.push(i + 1);
				s.push(right);
			}
		}
	}

	private static int part(int a[], int lo, int hi) {
		int i = lo, j = hi + 1;
		int v = a[lo];
		while (true) {
			while (a[++i] < v) {
				if (i == hi)
					break;
			}
			while (v < a[--j]) {
				if (j == lo)
					break;
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
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static void show(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static boolean isShorted(int[] a) {
		for (int i = 1; i < a.length; i++) {
			if (a[i] < a[i - 1]) {
				return false;
			}
		}
		return true;
	}
}

public class Num_2_03_20 {
	public static void main(String[] args) {
		int a[] = { 3, 5, 6, 8, 4, 9, 2, 1 };
		QuickW.sort(a);
		QuickW.show(a);
	}

}
