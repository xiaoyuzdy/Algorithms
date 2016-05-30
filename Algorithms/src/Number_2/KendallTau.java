package Number_2;

import java.util.concurrent.ForkJoinPool.ManagedBlocker;

import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.InsertionX;
import edu.princeton.cs.algs4.StdRandom;

/**
 * P225 T19 Kendall tau 距离
 * 
 * @author he
 *
 */
public class KendallTau {
	private static int a1[];// a[]的逆序
	private static int b1[];// b相对于a1[]的索引位置

	public static int distance(int a[], int b[]) {
		if (a.length != b.length) {
			System.out.println("输入有误");
			return -1;
		}

		int N = a.length;
		a1 = new int[N];
		b1 = new int[N];

		for (int i = 0; i < N; i++) {
			a1[a[i]] = i;
		}

		for (int i = 0; i < N; i++) {
			b1[i] = a1[b[i]];
		}

		return count(b1);

	}

	private static int count(int a[]) {
		int N = a.length;
		int count = 0;
		for (int i = 1; i < N; i++) {
			for (int j = i; j > 0 && a[j] < a[j - 1]; j--) {
				exch(a, j, j - 1);
				count++;
			}
		}
		return count;
	}

	private static void exch(int a[], int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	// 产生随机数组
	public static int[] random(int N) {
		int a[] = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = i;
		}
		StdRandom.shuffle(a);
		return a;
	}

	public static void main(String[] args) {
//		int a[] = { 0, 3, 1, 6, 2, 5, 4 };
//		int b[] = { 1, 0, 3, 6, 4, 2, 5 };
		
		int N=Integer.valueOf(args[0]);//7
		int a[]=random(N);
		int b[]=random(N);
		System.out.println(distance(a, b));
	}

}
