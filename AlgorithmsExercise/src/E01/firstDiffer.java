package E01;

import java.util.HashSet;

/**
 * 计算第一个不同字符的位置
 */
public class firstDiffer {
	static int test(String s) {
		int j=-1;
		HashSet<Character> hs = new HashSet<Character>();
		char a[] = s.toCharArray();
		hs.add(a[0]);
		for (int i = 1; i < a.length; i++) {
			if (!hs.contains(a[i])) {
				hs.add(a[i]);
			} else {
				 j=i;
				break;
			}
		}
		return j;
	}
   public static void main(String[] args) {
	 System.out.println(test("asda"));
}
}
