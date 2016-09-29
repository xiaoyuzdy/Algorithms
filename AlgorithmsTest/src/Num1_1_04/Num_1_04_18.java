package Num1_1_04;

import edu.princeton.cs.algs4.StdRandom;

/**
 * P133 T8 题目说的是比较次数最坏为~2lgN,不是时间
 * 
 * @author he
 *
 */

public class Num_1_04_18 {

	// public static int minElement(int a[]) {
	// for (int i = 1; i < a.length - 1; i++) {
	// if (a[i] < a[i - 1] && a[i] < a[i + 1]) {
	// return i;
	// }
	// }
	// return -1;
	// }

	/**
	 * 很臃肿，感觉比较次数也没少多少 返回目标元素的index
	 * 
	 * @param a
	 * @return
	 */
	public static int minElement(int a[]) {
		int temp = 0;// 用防止死循环
		for (int i = a.length / 2; i > 0 && i < a.length - 1;) {
			if (a[i - 1] > a[i] && a[i] < a[i + 1])
				return i;// 命中
			// 上坡
			if (a[i - 1] < a[i] && a[i] < a[i + 1]) {
				if (i - 2 >= 0 && a[i - 2] > a[i - 1])
					return i - 1;
				// 跳到非顶点元素
				else if (i - 2 > 0) {
					i = i - 2;
				} else {
					i--;
				}
				// 移动到最左边还没有发现目标元素，此时扫描右边
				if (i <= 1 && temp <= 1) {
					i = a.length / 2 + 1;
					temp++;
				} else if (temp > 1) {
					return -1;
				}

			}

			// 下坡
			if (a[i - 1] > a[i] && a[i] > a[i + 1]) {
				if (i + 2 < a.length && a[i + 2] > a[i + 1])
					return i + 1;
				// 跳到非顶点元素
				else if (i + 2 < a.length - 1) {
					i = i + 2;
				} else {
					i++;
				}

				// 移动到最右边还没有发现目标元素，此时扫描左边
				if (i >= a.length - 2 && temp <= 1) {
					i = a.length / 2 - 1;
					temp++;
				} else if (temp > 1) {
					return -1;
				}
			}

			// 三角形
			if (a[i] > a[i - 1] && a[i] > a[i + 1]) {
				if (a[i - 1] < a[i + 1])
					i = i - 1;
				else
					i = i + 1;
			}

		}

		return -1;
	}

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5, 0, 7, 1 };
		int a2[] = { 7, 6, 5, 4, 3, 0, 2, 1 };
		int a3[] = { 1, 6, 7, 3, 5, 6, 4, 2 };
		int a4[] = { 1, 2, 3, 4, 5, 6 };
		int a5[] = { 5, 0, 3, 2, 1 };

		int a6[] = new int[50];
		for (int i = 0; i < a6.length; i++)
			a6[i] = i;
		StdRandom.shuffle(a6);
		System.out.println(minElement(a6));
	}

}
