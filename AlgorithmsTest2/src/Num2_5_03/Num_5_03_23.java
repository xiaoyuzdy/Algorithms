package Num2_5_03;

/**
 * P511 T23
 * 
 * 从字符串的两端同时计算散列值
 * 
 * @author he
 *
 */

class Palindrome {
	private StringBuilder lo;
	private StringBuilder hi;
	private int R = 256;
	private int Q = 997;
	private boolean isPalindrome = true;

	public Palindrome(String txt) {
		lo = new StringBuilder();
		hi = new StringBuilder();

		int N = txt.length();
		// 长度为奇数
		if (N % 2 != 0) {
			for (int i = 0, j = N - 1; i < N / 2 && j > N / 2; i++, j--) {
				lo.append(txt.charAt(i));
				hi.append(txt.charAt(j));
				if (hash(lo.toString()) != hash(hi.toString())) {
					isPalindrome = false;
					break;
				}
			}
		} else {// 长度为偶数

			for (int i = 0, j = N - 1; i < N / 2 && j >= N / 2; i++, j--) {
				lo.append(txt.charAt(i));
				hi.append(txt.charAt(j));
				if (hash(lo.toString()) != hash(hi.toString())) {
					isPalindrome = false;
					break;
				}
			}

		}
	}

	// 计算散列值
	private long hash(String txt) {
		long h = 0;
		for (int i = 0; i < txt.length(); i++)
			h = (h * R + txt.charAt(i)) % Q;
		return h;
	}

	public boolean isPalindrome() {
		return isPalindrome;
	}

}

public class Num_5_03_23 {
	public static void main(String[] args) {
		Palindrome p = new Palindrome("abcba");
		System.out.println(p.isPalindrome());
	}

}
