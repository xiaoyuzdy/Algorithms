package Number_2;

/**
 * P163 希尔排序
 * 
 * @author he
 *
 */
public class Shell {
	// 排序
	public static void sort(Comparable[] a) {
		int N = a.length;
		int h = 1;
		while (h < N / 3) {
			h = 3 * h + 1;
		}
		while (h >= 1) {
			for (int i = h; i < N; i++) {
				// 将a[i]插入到a[i-h],a[i-2*h],....中
				for (int j = i; j - h >= 0 && less(a[j], a[j - h]); j -= h) {
					exch(a, j, j - h);
				}
			}
			h = h / 3;// 缩小h的范围
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
		Integer a[] = { 2, 3, 4, 1, 55, 6, 3, 6, 7 };
		sort(a);
		System.out.println(isShorted(a));
		show(a);
	}

}
