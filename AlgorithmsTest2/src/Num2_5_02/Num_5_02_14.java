package Num2_5_02;

import edu.princeton.cs.algs4.TST;

/**
 * P491 T14
 * 
 * @author he args[0]:cgcgggcgcg args[1]:3
 */
public class Num_5_02_14 {
	public static void main(String[] args) {
		String s = args[0];
		int L = Integer.valueOf(args[1]);
		TST<Integer> t = new TST<Integer>();
		for (int i = 0; i + L <=s.length(); i++) {
			String temp = s.substring(i, i + L);
			if (!t.contains(temp))
				t.put(temp, i);
		}
		System.out.println("不同字符串的数量:" + t.size() + "个");
		for (String x : t.keys())
			System.out.println(x);

	}

}
