package Num1_2_03;

import edu.princeton.cs.algs4.StdRandom;

/**
 * P193 T22
 * 
 * @author he
 *
 */
class Quick3 {
	public static void sort(int a[]) {
		StdRandom.shuffle(a);
		sort(a, 0, a.length - 1);
	}

	private static void sort(int a[], int lo, int hi) {
		if (lo >= hi) {
			return;
		}
		int p = lo, i = lo;
		int q = hi + 1, j = hi + 1;
		int temp = a[lo];
		while (true) {
			while (a[++i] < temp) {
				if (i == hi)
					break;
			}
			while (temp < a[--j]) {
				if (j == lo)
					break;
			}
			if (i == j && a[i] == temp) {
				exch(a, ++p, i);
			}
			if (i >= j) {
				break;
			}
			exch(a, i, j);

			if (a[i] == temp) {
				exch(a, ++p, i);
			}
			if (a[j] == temp) {
				exch(a, --q, j);
			}

		}
		i = j + 1;
		for (int k = lo; k <= p; k++) {
			exch(a, k, j--);
		}
		for (int k = hi; k >= q; k--) {
			exch(a, k, i++);
		}
		sort(a, lo, j);
		sort(a, i, hi);
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

public class Num_2_03_22 {
	public static void main(String[] args) {
		int a[] = { 2, 6, 6, 4, 4, 4, 5, 5, 5, 5 };
		Quick3.sort(a);
		Quick3.show(a);
	}

}
