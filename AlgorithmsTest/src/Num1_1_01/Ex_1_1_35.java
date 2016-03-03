package Num1_1_01;

import edu.princeton.cs.algs4.StdRandom;

/**
 * 模拟掷骰子
 * 
 * @author he
 *
 */
public class Ex_1_1_35 {
	final static int SIDES = 6;
	static double[] dist = new double[2 * SIDES + 1];

	// 概率统计
	public static double[] proS() {
		for (int i = 1; i <= SIDES; i++) {
			for (int j = 1; j <= SIDES; j++) {
				dist[i + j] += 1.0;
			}
		}
		for (int k = 2; k <= 2 * SIDES; k++) {
			dist[k] /= 36.0;
		}
		return dist;
	}

	// 计算两数值和
	static int sum() {

		int sum;
		sum = StdRandom.uniform(1, 6) + StdRandom.uniform(1, 6);
		return sum;
	}

	public static void main(String[] args) {
		double a[] = proS();

		for (int i = 2; i < a.length; i++) {
			int k = sum();
			if (i == k) {
				System.out.println("两数之和" + k + "概率" + a[i]);
			}

		}
	}

}
