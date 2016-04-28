package Number_2;

/**
 * P157 插入排序
 * 
 * @author he
 *
 */
public class Insertion {
	// 排序
	public static void sort(Comparable[] a) {
		// 将a[]按升序排列
		int N = a.length;
		for (int i = 1; i < N; i++) {
			/**
			 * 将a[i]插入到a[i-1] a[i-2] a[i-3]之中
			 * 如果a[j]<a[j-1],则交换位置，此时a[j]中的元素给了a[j-1]，再将a[j-1]与a[j-2]比较，如此重复，
			 * 直到最小元素到达最左边
			 */

			for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
				exch(a, j, j - 1);
			}
		}
	}

	// 元素之间进行比较
	public static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0; // 如果v<w则为true
	}

	// 交换元素位置
	public static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	// 单行中打印数组
	public static void show(Comparable a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	// 测试数组是否有序
	public static boolean isShorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
			if (less(a[i], a[i - 1])) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Integer a[] = { 2, 3, 4, 1, 55, 6, 3, 6, 7, 8 };
		sort(a);
		System.out.println(isShorted(a));
		show(a);
	}
}
