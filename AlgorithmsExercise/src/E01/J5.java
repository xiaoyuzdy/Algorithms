package E01;

/**
 * 字符串压缩，利用字符串重复出现的次数 如 aabcccccaaa 压缩为 a2bc5a3 如果压缩后的字符长度与原来相同则 不压缩
 * 
 * @author he
 *
 */
public class J5 {
	public static String zipString(String s) {

		char a[] = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		char ss = a[0];
		int count = 1;
		sb.append(ss);
		for (int i = 1; i < a.length; i++) {
			if (ss == a[i]) {
				++count;
			} else {
				sb.append(count);
				count = 1;
				sb.append(a[i]);
				ss = a[i];
			}
		}
		// 将最后一个字符的个数加到sb
		sb.append(count);
		// 如果压缩后的字符长度与原来相同则 不压缩
		if (sb.length() == s.length()) {
			return s;
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(zipString("aaee"));
		System.out.println(zipString("aarrrrrsssssssffff"));
	}

}
