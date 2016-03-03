package E01;

/**
 * 编写一个方法比较两个字符串是否相同
 * 
 * @author he
 *
 */
public class J3 {
	public static boolean check(String a, String b) {
		int i1 = a.length();
		int i2 = b.length();

		if (i1 != i2) {
			return false;
		}

		else {
			char a1[] = a.toCharArray();
			char b1[] = b.toCharArray();
			for (int i = 0; i < a.length(); i++) {
				if (a1[i] != b1[i]) {
					return false;

				}

			}
			return true;

		}

	}

	public static void main(String[] args) {
		System.out.println(check("ASD", "asd"));
	}

}
