package Num1_2_01;

import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * P168 T26
 * 
 * @author he
 *
 */

class intInsertion {
	public static void sort(int a[]) {
		int N = a.length;
		for (int i = 1; i < N; i++) {
			for (int j = i; j > 0 && a[j] < a[j - 1]; j--) {
				int temp = a[j];
				a[j] = a[j - 1];
				a[j - 1] = temp;
			}
		}
	}

	public static void show(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

}

class Compare {
	private static double timerInteger(Integer a[]) {
		Stopwatch timer = new Stopwatch();
		Insertion.sort(a);
		return timer.elapsedTime();
	}

	private static double timerInt(int a[]) {
		Stopwatch timer = new Stopwatch();
		intInsertion.sort(a);
		return timer.elapsedTime();
	}

	public static String comp(int N, int T) {
		double total1 = 0.0;
		double total2 = 0.0;
		Integer a1[] = new Integer[N];
		int a2[] = new int[N];
		for (int i = 0; i < T; i++) {
			for (int j = 0; j < N; j++) {
				a1[j] = StdRandom.uniform(1000);
				a2[j] = StdRandom.uniform(1000);
			}
			total1 += timerInteger(a1);
			total2 += timerInt(a2);
		}
		return "Integer tim /int time  :  " + total1 / total2;
	}
}

public class Num_2_01_26 {
	public static void main(String[] args) {
		// int a[]={2,4,5,22,56,3,1,0};
		// intInsertion.sort(a);
		// intInsertion.show(a);

		System.out.println(Compare.comp(1000, 100));

	}

}
