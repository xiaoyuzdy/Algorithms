package Num1_2_01;

/**
 * P168 T24
 * 测试通过
 * @author he
 *
 */
class SentryInsertion {
	public static void sort(Comparable a[]) {
		int N = a.length;
		SwopMin(a);
		for (int i = 1; i < N; i++) {
			for (int j = i; less(a[j], a[j - 1]); j--) {
				exch(a, j, j - 1);
			}
		}
	}

	//将最小的元素移动到最左边
	private static Comparable[] SwopMin(Comparable a[]) {
		int N = a.length;
		int min = 0;
		for (int i = 1; i < N; i++) {
			if (less(a[i], a[min])) {
				min = i;
			}
		}
		exch(a, min, 0);
		return a;
	}

	public static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	public static void exch(Comparable a[], int i, int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void show(Comparable a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

}

public class Num_2_01_24 {

	public static void main(String[] args) {
		Integer a[] = { 2, 3, 4, 1, 55, 6, 3, 6, 7, 8 };
		SentryInsertion.sort(a);
		SentryInsertion.show(a);
	}
}
