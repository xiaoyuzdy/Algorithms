package Num2_5_02;

import edu.princeton.cs.algs4.TST;

/**
 * P491 T15
 * args[0]:cgcgggcgcg
 * @author he
 *
 */
public class Num_5_02_15 {
	public static void main(String[] args) {
		String s = args[0];

		for (int length = 1; length <= s.length(); length++) {
			TST<Integer> t = new TST<Integer>();
			for (int i = 0; i + length <=s.length(); i++) {
				String temp = s.substring(i, i + length);
				if (!t.contains(temp))
					t.put(temp, i);
			}
			System.out.println("length:" + length + " :" + t.size() + "¸ö");
			for (String x : t.keys())
				System.out.println(x);
		}

	}

}
