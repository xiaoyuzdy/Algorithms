package Num1_2_03;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdRandom;

/**
 * P192 T18
 * 
 * @author he
 *
 */

class QuickM {
	// 获取中位数
	private static int median(int a[]) {
		Arrays.sort(a);
		int j = -1;
		int N = a.length;
		if (N % 2 != 0) {
			j = a[N / 2];
		} else {
			j = (a[N / 2] + a[N / 2 - 1]) / 2;
		}
		return j;
	}

	public static void sort(int a[]) {
		StdRandom.shuffle(a);
		sort(a, 0, a.length - 1);
	}

	private static void sort(int a[], int lo, int hi) {
		if (hi <= lo) {
			return;
		}
		int j = part(a, lo, hi);
		sort(a, lo, j - 1);
		sort(a, j + 1, hi);
	}

	private static int part(int a[], int lo, int hi) {
		int i = lo, j = hi + 1;
		int v = median(a);// 取中位数为切分元素
		while (true) {
			while (a[i++] < v) {
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

}

public class Num_2_03_18 {
	public static void main(String[] args) {
		int a[] = { 1, 5, 7, 8, 6, 3, 9, 0, 2, 4 };
		QuickM.sort(a);
		QuickM.show(a);
	}
}
