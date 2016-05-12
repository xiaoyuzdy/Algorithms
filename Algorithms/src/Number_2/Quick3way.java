package Number_2;

import edu.princeton.cs.algs4.StdRandom;

/**
 * P189 三向切分的快速排序
 * 
 * 将数组分为三部分，小于、等于、大于切分元素的数组元素：
 *  维护一个指针lt使得a[lo...lt-1]中的元素都小于v，
 * 一个指针gt使得a[gt+1...hi]中所有的元素都大于v 
 * 一个指针i使得a[lt...i-1]中的元素都等于v 
 * a[i...gt]中的元素未确定
 * 
 * @author he
 *
 *         三向切分处理情况如下： 
 *         1、a[i]小于v，将a[lt]和a[i]交换，将lt和i加一
 *         2、a[i]大于v，将a[gt]和a[i]交换，将gt减一 
 *         3、a[i]等于v，将i加一
 *
 *
 */
public class Quick3way {
	// 排序
	public static void sort(Comparable[] a) {
		StdRandom.shuffle(a);// 将数组打乱,消除对输入的依赖
		sort(a, 0, a.length - 1);
	}

	private static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo)
			return;
		int lt = lo, i = lo + 1, gt = hi;
		Comparable v = a[lo];
		while (i <= gt) {
			int cmp = a[i].compareTo(v);
			if (cmp < 0)
				exch(a, i++, lt++);
			else if (cmp > 0)
				exch(a, i, gt--);
			else
				i++;
		}

		sort(a, lo, lt - 1);
		sort(a, gt + 1, hi);

	}

	// 交换元素位置
	private static void exch(Comparable[] a, int i, int j) {
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
	
	public static void main(String[] args) {
//		String[] a = { "A", "U", "I", "C", "K", "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E" };
		Integer a[] = { 1,1,2,2,2,2,2,2,3,4,99,5,6,7 };
		sort(a);
		show(a);
	}

}
