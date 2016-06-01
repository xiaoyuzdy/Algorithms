package Num1_2_05;

/**
 * P225T14
 * 
 * @author he
 *
 */

class Domain {
	public static String reversed(String s) {
		StringBuilder sb = new StringBuilder();
		String a[] = s.split("\\.");
		int N = a.length;
		for (int i = N - 1; i >= 0; i--) {
			sb.append(a[i]);
			sb.append(".");
		}
		sb.deleteCharAt(s.length());//删除最后一个点"."
		return sb.toString();
	}
}

public class Num_2_05_14 {
	public static void main(String[] args) {
		String s="cs.princeton.edu";
		System.out.println(Domain.reversed(s));
	}

}
