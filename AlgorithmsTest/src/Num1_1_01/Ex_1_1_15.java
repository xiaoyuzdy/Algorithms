package Num1_1_01;

/**
 * P34
 * 
 * @author he
 *
 */
public class Ex_1_1_15 {

	public static int[] histogram(int a[], int M) {
		int h[] = new int[M];
		for (int i = 0; i < h.length; i++) {
			h[i] = count(i, a);
		}
		return h;
	}

	// 统计次数
	public static int count(int number, int a[]) {
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			if (number == a[i]) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int a[] = { 1, 2, 2, 2, 7 };
		int b[] = histogram(a, 7);
		for (int i = 0; i < b.length; i++) {
			System.out.println(i + "出现的次数 " + b[i]);
		}
	}

}
