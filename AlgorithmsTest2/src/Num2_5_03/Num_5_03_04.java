package Num2_5_03;

import edu.princeton.cs.algs4.RabinKarp;

/**
 * P510 T04  π”√R-KÀ„∑®
 * 
 * @author he
 *
 */

public class Num_5_03_04 {
	private static RabinKarp rk;

	public static int index(int M, String txt) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			sb.append(" ");
		}
		rk = new RabinKarp(sb.toString());

		return rk.search(txt);

	}

	public static void main(String[] args) {
		 System.out.println(index(3, "1 2  3   4"));
	}
}
