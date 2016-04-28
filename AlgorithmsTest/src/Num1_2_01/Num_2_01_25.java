package Num1_2_01;

/**
 * P168 T25
 * 优化版的插入排序
 */
class QuickInsertion {
	public void sort(Comparable[] a) {
		int N = a.length;
		for (int i = 1; i < N; i++) {
			int t = (int) a[i];
			int j = i;
			while ((j > 0) && (a[j - 1].compareTo(t) > 0)) {
				a[j] = a[j - 1];
				--j;
			}
			a[j] = t;
		}
	}

	public void show(Comparable a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
}

public class Num_2_01_25 {
	public static void main(String[] args) {
		QuickInsertion q = new QuickInsertion();
		Integer a[] = { 2, 3, 4, 1, 55, 6, 3, 6, 7, 8 };
		q.sort(a);
		q.show(a);

	}

}
