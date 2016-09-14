package Number_5;

/**
 * P501 算法 5.6 KMP字符串查找算法
 * args[0]:AACAA
 * args[1]:AABRAACADABRAACAADABRA
 * @author he
 *
 */
public class KMP {
	private String pat;// 查找模式
	private int[][] dfa;// 构建有限状态自动机

	public KMP(String pat) {
		// 有模式字符串构建DFA（有限状态自动机）
		this.pat = pat;
		int M = pat.length();
		int R = 256;// 8位ASCII符号表的字符数量
		dfa = new int[R][M];
		dfa[pat.charAt(0)][0] = 1;// 首字母的状态为1
		// 每个字符dfa[][j]记录状态X
		for (int X = 0, j = 1; j < M; j++) {
			// 计算dfa[][j]
			for (char c = 0; c < R; c++)
				dfa[c][j] = dfa[c][X];// 复制匹配失败情况下的值（状态）
			dfa[pat.charAt(j)][j] = j + 1;// 设置匹配成功后的值（状态）
			X = dfa[pat.charAt(j)][X];// 更新重启状态
		}

	}

	public int search(String txt) {
		int i, N = txt.length();
		int j, M = pat.length();

		for (i = 0, j = 0; i < N && j < M; i++)
			j = dfa[txt.charAt(i)][j];
		if (j == M)
			return i - M;// 找到匹配（到达模式字符串的末尾）
		else
			return N;// 未找到匹配（到达文本字符串的末尾）

	}

	public static void main(String[] args) {
		String pat = args[0];
		String txt = args[1];
		KMP kmp = new KMP(pat);
		System.out.println("text:   " + txt);
		int offset = kmp.search(txt);
		System.out.print("pattern:");
		for (int i = 0; i < offset; i++)
			System.out.print(" ");
		System.out.println(pat);
	}

}
