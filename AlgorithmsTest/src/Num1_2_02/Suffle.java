package Num1_2_02;

import java.util.Random;

/**
 * 随机打乱一个数组，无重复获取随机数
 * 
 * @author he
 *
 */
public class Suffle {
	private static Random random = new Random(System.currentTimeMillis());

	public static void suffle(int a[]) {
		if (a == null) {
			throw new RuntimeException();
		}
		int N = a.length;
		for (int i = 0; i < N; i++) {
			int t = i + random.nextInt(N - i);// 保证了t不重复
			// 交换元素
			int temp = a[i];
			a[i] = a[t];
			a[t] = temp;
		}

	}

	public static void show(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		suffle(a);
		show(a);
	}

}
