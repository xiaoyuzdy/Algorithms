package Num1_2_03;

import edu.princeton.cs.algs4.StdRandom;

/**
 * P191 T05
 * 
 * @author he 
 */
class Quick2 {

	public static void sort(int a[]) {
		StdRandom.shuffle(a);
		sort(a, 0, a.length - 1);
	}

	private static void sort(int a[], int lo, int hi) {
		if (hi <= lo)
			return;
		int lt = lo, gt = hi;
		int i = lo;
		int temp = a[lo];
		while (i <= gt) {
			if (a[i] < temp)
				exch(a, i++, lt++);
			else if (a[i] > temp)
				exch(a, i, gt--);
			else
				i++;
		}
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

public class Num_2_03_05 {
	public static void main(String[] args) {
		int a[] = { 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1 };
		Quick2.sort(a);
		Quick2.show(a);
	}

}
