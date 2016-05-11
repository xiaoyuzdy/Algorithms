package Num1_2_03;

import edu.princeton.cs.algs4.StdRandom;

/**
 * P192 T17
 * 
 * @author he
 *
 */

class GuardQuick {

	public static void sort(int a[]) {
		StdRandom.shuffle(a);
		Max(a);
		sort(a, 0, a.length - 1);
	}
     
	//将最大的元素移动到最右边
	 private static void Max(int a[]){
		int max=0;
		for(int i=1;i<a.length;i++){
			if (a[i]>a[max]) {
				max=i;
			}
		}
		exch(a, a.length-1, max);
	}
	
	private static void sort(int a[], int lo, int hi) {
		if (lo >= hi) {
			return;
		}
		int j = part(a, lo, hi);
		sort(a, lo, j - 1);
		sort(a, j + 1, hi);
	}

	private static int part(int a[], int lo, int hi) {
		int i = lo, j = hi + 1;
		int t = a[lo];
		while (true) {
			while (less(a[++i], t)) {
			}

			while (less(t, a[--j])) {
			}
			
			if (i >= j) {
				break;
			}
			exch(a, i, j);
		}
		exch(a, lo, j);

		return j;
	}

	private static boolean less(int a, int b) {
		return a < b;
	}

	private static void exch(int a[], int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void show(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

}

public class Num_2_03_17 {
	public static void main(String[] args) {
		int a[] = { 2, 3, 5, 1, 6, 7, 9, 4, 8 };
		GuardQuick.sort(a);
		GuardQuick.show(a);// 1 2 3 4 5 6 7 8 9
	}

}
