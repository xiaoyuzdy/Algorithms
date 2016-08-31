package Num2_5_01;

/**
 * P472 T13
 * 
 * @author he
 *
 */

class MQ {
	private static final int M = 5;
	private static String aux[];
	private static final int R = 256;

	private static int charAt(String s, int d) {
		if (d < s.length())
			return s.charAt(d);
		else
			return -1;
	}

	public static void sort(String a[]) {
		int N = a.length;
		aux = new String[N];
		sort(a, 0, N - 1, 0);
	}

	private static void sort(String[] a, int lo, int hi, int d) {
		// 三向切分排序
		if (hi <= lo + M) {
			if (hi <= lo)
				return;
			int lt = lo, gt = hi, i = lo + 1;
			int v = charAt(a[lo], d);
			while (i <= gt) {
				int t = charAt(a[i], d);
				if (t < v)
					exch(a, i++, lt++);
				else if (t > v)
					exch(a, i, gt--);
				else
					i++;
			}

			sort(a, lo, lt - 1, d);
			if (v >= 0)
				sort(a, lo, hi, d + 1);
			;
			sort(a, gt + 1, hi, d);

		}
		
		int count[] = new int[R + 2];
		// 统计频率
		for (int i = lo; i <= hi; i++)
			count[charAt(a[i], d) + 2]++;

		// 转换为索引
		for (int r = 0; r < R + 1; r++)
			count[r + 1] += count[r];

		// 分类
		for (int i = lo; i <= hi; i++)
			aux[count[charAt(a[i], d) + 1]++] = a[i];
		// 回写
		for (int i = lo; i <= hi; i++)
			a[i] = aux[i - lo];
		for (int r = 0; r < R; r++)
			sort(a, lo + count[r], lo + count[r + 1] - 1, d + 1);
	}

	private static void exch(String a[], int i, int j) {
		String temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}

public class Num_5_01_13 {
	public static void main(String[] args) {
		String a[] = { "by", "are", "seashells", "seashells", "sells" };
		MQ.sort(a);
		for (int i = 0; i < a.length; i++)
			System.out.println(a[i]);
	}

}
