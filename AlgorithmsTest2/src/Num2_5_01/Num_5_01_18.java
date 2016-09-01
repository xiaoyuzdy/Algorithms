package Num2_5_01;

import edu.princeton.cs.algs4.StdRandom;

/**
 * P472 T18
 * 
 * @author he
 *
 */
public class Num_5_01_18 {
	private static String a[];

	public static void randomDecimalKeys(int N, int W) {
		a = new String[N];
		for (int i = 0; i < N; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < W; j++) {
				int t = StdRandom.uniform(65, 90);// 随机生成字母在ASCII表中对应的十进制数
				sb.append((char) t);
			}
			a[i] = sb.toString();
		}

	}

	public static void main(String[] args) {
		randomDecimalKeys(5, 10);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
