package Number_5;

/**
 * P469 算法5.3 三向字符串快速排序 适合含有大量等值键、有较长公共前缀的键、取值范围较小的键和小数组
 * 
 * @author he
 *
 */
public class Quick3string {

	private static final int M = 0;// 切分数组的大小

	public Quick3string() {
	}

	private static int chatAt(String s, int d) {
		if (d < s.length())
			return s.charAt(d);
		else
			return -1;
	}

	public static void sort(String a[]) {
		sort(a, 0, a.length - 1, 0);
	}

	private static void sort(String a[], int lo, int hi, int d) {
		// if (hi <= lo)
		// return;
		// 对于小数组使用插入排序
		if (hi <= lo + M) {
			Insterion(a, lo, hi, d);
			return;
		}

		int lt = lo, gt = hi, i = lo + 1;
		int v = chatAt(a[lo], d);

		while (i <= gt) {
			int t = chatAt(a[i], d);
			if (t < v)
				exch(a, lt++, i++);
			else if (t > v)
				exch(a, i, gt--);
			else
				i++;
		}

		sort(a, lo, lt - 1, d);
		if (v > 0)
			sort(a, lo, hi, d+1);
		sort(a, gt + 1, hi, d);
	}

	// 插入排序
	private static void Insterion(String a[], int lo, int hi, int d) {
		for (int i = lo; i <= hi; i++)
			for (int j = i; j > 0 && less(a[j], a[j - 1], d); j--)
				exch(a, j, j - 1);
	}

	private static boolean less(String s, String v, int d) {
		for (int i = d; i < Math.min(s.length(), v.length()); i++) {
			if (s.charAt(i) < v.charAt(i))
				return true;
			if (s.charAt(i) > v.charAt(i))
				return false;
		}
		return s.length() < v.length();
	}

	private static void exch(String a[], int i, int j) {
		String temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		String a[] = { "com.cnn", "edu.uva.cs", "edu.uva.cs", "com.google" };
		sort(a);
		for (int i = 0; i < a.length; i++)
			System.out.println(a[i]);

	}

}
