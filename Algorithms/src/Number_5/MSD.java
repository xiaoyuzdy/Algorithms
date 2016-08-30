package Number_5;

/**
 * P462 算法5.2 高位优先的字符串排序（从左向右，字符串长度不一定相同）
 * 
 * @author he
 *
 */
public class MSD {
	private static int R = 256;// 8为ASCII表中的字符数量
	private static final int M = 15;// 小数组的切分
	private static String aux[];// 辅助数组

	public MSD() {

	}

	private static int charAt(String s, int d) {
		if (d < s.length())
			return s.charAt(d);
		else {
			return -1;
		}
	}

	public static void sort(String a[]) {
		int N = a.length;
		aux = new String[N];
		sort(a, 0, N - 1, 0);
	}

	private static void sort(String a[], int lo, int hi, int d) {
		// 对于小于一定长度的数组进行插入排序
		if (hi <= lo + M) {
			insertion(a, lo, hi, d);
			return;
		}

		int count[] = new int[R + 2];// count[0]不保存东西，count[1]保存的是长度不大于d的字符串数量
		// 计算频率
		for (int i = lo; i <= hi; i++) {
			int t = charAt(a[i], d);
			count[t + 2]++;
		}

		// 转换为索引
		for (int r = 0; r < R + 1; r++)
			count[r + 1] += count[r];

		// 分类
		for (int i = lo; i <= hi; i++) {
			int t = charAt(a[i], d);
			aux[count[t + 1]++] = a[i];
		}

		for (int i = lo; i <= hi; i++)
			a[i] = aux[i - lo];

		// 递归以每个字符为键进行排序,这里看不懂
		for (int r = 0; r < R; r++)
			sort(a, lo + count[r], lo + count[r + 1] - 1, d + 1);

	}

	private static void insertion(String a[], int lo, int hi, int d) {
		for (int i = lo; i <= hi; i++)
			for (int j = i; j > lo && less(a[j], a[j - 1], d); j--)
				exch(a, j, j - 1);
	}

	private static boolean less(String w, String v, int d) {
		for (int i = d; i < Math.min(w.length(), v.length()); i++) {
			if (w.charAt(i) < v.charAt(i))
				return true;
			if (w.charAt(i) > v.charAt(i)) {
				return false;
			}
		}

		return w.length() < v.length();
	}

	private static void exch(String a[], int i, int j) {
		String temp = a[i];
		a[i] = a[j];
		a[j] = temp;

	}

	public static void main(String[] args) {
		String[] a = { "by", "are", "seashells", "seashells", "sells" };
		sort(a);
		for (int i = 0; i < a.length; i++)
			System.out.println(a[i]);

	}

}
