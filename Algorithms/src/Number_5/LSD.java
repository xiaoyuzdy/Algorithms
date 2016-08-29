package Number_5;

/**
 * P459 低位优先的字符串排序（从左至右，适合键长度相同的字符串）
 * 
 * @author he
 *
 */
public class LSD {
	public LSD() {
	}

	public static void sort(String[] a, int W) {
		// 通过前W个字符将a[]排序
		int N = a.length;
		String aux[] = new String[N];
		int R = 256;// ASCII字符集的字符数量，8位的ASCII字符集
		for (int d = W - 1; d >= 0; d--) {
			int count[] = new int[R + 1];

			// 统计频率
			for (int i = 0; i < N; i++)
				count[a[i].charAt(d) + 1]++;
			// 将频率转换为索引
			for (int r = 0; r < R; r++)
				count[r + 1] += count[r];
			// 将元素分类
			for (int i = 0; i < N; i++)
				aux[count[a[i].charAt(d)]++] = a[i];
			// 回写
			for (int i = 0; i < N; i++)
				a[i] = aux[i];
		}

	}

	public static void main(String[] args) {
		String a[] = { "4PGC938", "2IYE230", "3CIO720", "1ICK750", "1OHV845" };
		int W = 7;
		sort(a, W);
		for (int i = 0; i < a.length; i++)
			System.out.println(a[i]);

	}

}
