package Num1_2_05;

import java.util.ArrayList;
import java.util.List;

/**
 * P225 T15
 * 
 * @author he 每个域名之间用空格" "隔开 将具有相同域名的邮件地址归到一起
 * 
 */

public class Num_2_05_15 {
	private static List<String> list = new ArrayList<String>();

	// 获取各个域名
	public static String counterfeit(String s) {
		String temp[] = s.split("\\ ");
		return same(temp);
	}

	// 找出相同的域名，并放在一起
	public static String same(String[] temp) {
		int N = temp.length;
		for (int i = 0; i < N; i++) {
			String t[] = temp[i].split("@");
			String domain = t[1];// 获取域名

			if (!list.contains(temp[i])) {
				list.add(temp[i]);// 将邮件地址添加到list
			}

			for (int j = i + 1; j < N; j++) {
				String t2[] = temp[j].split("@");
				String d = t2[1];// 获取域名
				// 无重复添加到list
				if (d.equals(domain) && !list.contains(temp[j])) {
					list.add(temp[j]);
					list.add("\n");
				}
			}
		}
		return list.toString();

	}

	public static void main(String[] args) {
		String s = "wayne@cs.princeton.edu wayne@cxx.princeton.edu "
				+ "rs@cs.princeton.edu wayne@csss.princeton.edu"
				+ " wa@cxx.princeton.edu";
		System.out.println(counterfeit(s));
	}

}
