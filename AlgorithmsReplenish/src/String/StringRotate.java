package String;

/**
 * 字符串旋转， 比如一个字符串 abcdefgh,左旋转3个位置 变为 defghabc n=8,i=3 要求占用少量的内存空间
 * 
 * 基本思路： 
 * 将 a[0]保存到一个临时变量t中 然后移动a[i]至a[0]，a[2i]至a[i] 
 * a[1]保存到临时变量t 移动a[i+1]至a[1]，依此类推
 * 
 * 
 * @author he
 *
 */

public class StringRotate {
	public static String rotate(String text, int rotdist) {

		int n = text.length();
		int end = gcd(rotdist, n);
		char x[] = text.toCharArray();
		char t;
		int j;
		int k;

		// 循环左旋
		for (int i = 0; i < end; i++) {
			t = x[i];
			j = i;
			while (true) {
				k = j + rotdist;
				if (k >= n) {
					k -= n;
				}
				if (k == i) {
					break;
				}
				x[j] = x[k];
				j = k;
			}
			x[j] = t;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < x.length; i++) {
			sb.append(x[i]);
		}
		return sb.toString();
	}

	/**
	 * 求最大公约数，旋转rotdist个位置和n的最大公约数是所需的置换次数
	 * 
	 * @param rotdist
	 * @param n
	 * @return
	 */
	private static int gcd(int rotdist, int n) {
		if (n == 0) {
			return rotdist;
		}
		int r = rotdist % n;
		
		return gcd(n, r);
	}

	public static void main(String[] args) {

		System.out.println(rotate("abcdefghigk", 3));

	}

}
