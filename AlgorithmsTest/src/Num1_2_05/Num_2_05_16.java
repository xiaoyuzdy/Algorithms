package Num1_2_05;

import java.util.Arrays;
import java.util.Comparator;

/**
 * P225 T16
 * 名字用"."隔开
 * args:qwr.pdu.ahb
 * @author he
 *
 */
class California implements Comparator<String> {
	private static final String STANDARD = "RWQOJMVAHBSGZXNTCIEKUPDYFL";// 字母顺序准则

	@Override
	public int compare(String o1, String o2) {
		if (o1 == o2) {
			return 0;
		}
		int n = Math.min(o1.length(), o2.length());
		for (int i = 0; i < n; i++) {
			int aindex = STANDARD.indexOf(o1.charAt(i));//获取对应的下表
			int bindex = STANDARD.indexOf(o2.charAt(i));
			if (aindex < bindex) {
				return -1;
			} else if (aindex > bindex) {
				return +1;
			}
		}
		return o1.length() - o2.length();
	}

}

public class Num_2_05_16 {
	public static void main(String[] args) {
      
		String[] a = args[0].toUpperCase().split("\\.");
		int N = a.length;
		Arrays.sort(a, new California());
		for (int i = 0; i < N; i++) {
			System.out.println(a[i]);
		}

	}
}
