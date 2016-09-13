package Number_5;

/**
 * P494 暴力子字符串查找
 * 
 * @author he
 *
 */
public class Search {
	/**
	 * 未匹配到返回txt.length 
	 * 匹配到返回模式pat的首字母在txt中对应的index
	 * 
	 * @param txt
	 *            文本
	 * @param pat
	 *            匹配模式
	 * @return
	 */
	public static int search(String txt, String pat) {
		int N = txt.length();
		int M = pat.length();
		for (int i = 0; i <= N - M; i++) {
			int j;
			for (j = 0; j < M; j++) {
				if (txt.charAt(i + j) != pat.charAt(j))
					break;
			}
			if (j == M)
				return i;// 找到匹配
		}
		return N;// 未找到匹配
	}

	/**
	 * 暴力子字符匹配算法的另一种实现（显式回退）
	 *  未匹配到返回txt.length 
	 *  匹配到返回模式pat的首字母在txt中对应的index
	 * 
	 * @param txt
	 * @param pat
	 * @return
	 */
	public static int search2(String txt, String pat) {
		int j, M = pat.length();
		int i, N = txt.length();
		for (i = 0, j = 0; i < N && j < M; i++) {
			if (txt.charAt(i) == pat.charAt(j))
				j++;
			else {
				i -= j;// 回退
				j = 0;// 重置
			}
		}
		if (j == M)
			return i - M;// 找到匹配
		else
			return N;// 未找到匹配
	}

	public static void main(String[] args) {
		System.out.println(search2("ABACADABRAC", "ABRA"));
	}

}
