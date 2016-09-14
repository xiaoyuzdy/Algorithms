package Number_5;

/**
 * P504 算法5.7 Boyer-Moore字符串匹配算法（启发式地处理不匹配的字符） 从右向左扫描模式字符串（线性级别）
 * args[0]:AACAA
 * args[1]:AABRAACADABRAACAADABRA
 * @author he
 *
 */
public class BoyerMoore {
	private int right[];
	private String pat;

	public BoyerMoore(String pat) {
		this.pat = pat;
		int R = 256;// 八位ASCII字符表对应的字符数量
		int M = pat.length();
		right = new int[R];

		for (char c = 0; c < R; c++)
			right[c] = -1; // 文本中不包含在模式字符串中的字符的为-1，原因见skip=j-right[txt.charAt(i+j)]的注释
		for (int j = 0; j < M; j++)
			right[pat.charAt(j)] = j;// 包含在模式字符串中的字符的值为它在模式中出现的最右位置,skip=j-right[txt.charAt(i+j)]会出现skip<1的情况
	}

	public int search(String txt) {
		int i, N = txt.length();
		int j, M = pat.length();
		int skip;
		for (i = 0; i < N - M; i += skip) {
			skip = 0;
			for (j = M - 1; j >= 0; j--) {
				if (txt.charAt(i + j) != pat.charAt(j)) {
					/**
					 * 如果right[index]=-1，skip=j+1,则i+skip的含义就是文本（从左往右）舍弃了与模式等长的字段
					 */
					skip = j - right[txt.charAt(i + j)];
					/**
					 * skip<1表明，当前j对应的值小于j对应的字符在模式中出现的最右边的位置（index），这时i=i+1,
					 * 文本右移一位
					 */
					if (skip < 1)
						skip = 1;

				}

			}

			if (skip == 0)
				return i; // 找到匹配

		}
		return N;// 未找到匹配
	}

	public static void main(String[] args) {
		String pat = args[0];
		String txt = args[1];
		BoyerMoore kmp = new BoyerMoore(pat);
		System.out.println("text:   " + txt);
		int offset = kmp.search(txt);
		System.out.print("pattern:");
		for (int i = 0; i < offset; i++)
			System.out.print(" ");
		System.out.println(pat);
	}

}
