package Num1_1_04;

/**
 * P133 T8 感觉题目有问题，数据是乱序的，不停的折半和遍历数组没区别，而且折半只能单向折半
 * 
 * @author he
 *
 */

public class Num_1_04_18 {

	public static int minElement(int a[]) {
		for (int i = 1; i < a.length - 1; i++) {
			if (a[i] < a[i - 1] && a[i] < a[i + 1]) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5, 0, 7 };
		System.out.println(minElement(a));
	}

}
