package Number_2;

import edu.princeton.cs.algs4.StdRandom;

/**
 * P182 快速排序
 * 
 * @author he
 *
 */
public class Quick {
	// 快速排序的切分
	private static int partition(Comparable[] a, int lo, int hi) {
		int i = lo, j = hi + 1;// 左右扫描指针
		Comparable v = a[lo];// 切分元素
		while (true) {
			// 如果a[i]小于v时，增大i
			while (less(a[++i], v)) {
				if (i == hi)
					break;
			}
			// 如果a[j]大于v时，减小j
			while (less(v, a[--j])) {
				// 可去掉 多余的
				// if (j == lo)
				// break;
			}

			if (i >= j) {
				break;
			}
			exch(a, i, j);// 交换i,j的位置
		}

		exch(a, lo, j);// 将v=a[j]放入正确的位置
		return j;
	}

	// 排序
	public static void sort(Comparable[] a) {
		StdRandom.shuffle(a);// 将数组打乱,消除对输入的依赖
		sort(a, 0, a.length - 1);
	}

	private static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo) {
			return;
		}
		int j = partition(a, lo, hi);// 切分
		sort(a, lo, j - 1);// 左边排序
		sort(a, j + 1, hi);// 右边排序

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
		String[] a = { "A", "U", "I", "C", "K", "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E" };
		sort(a);
		assert isShorted(a);// 断言 防止程序进入死循环导致系统崩溃
		show(a);
		System.out.println(isShorted(a));
	}
}
