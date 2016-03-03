package Num1_1_01;

/**
 * P35 斐波那契数列
 * 
 * @author he
 *
 */
public class Ex_1_1_19 {
	public static long F(int N) {
		if (N == 0) {
			return 0;
		}
		if (N == 1) {
			return 1;
		}
		return F(N - 1) + F(N - 2);
	}

	// 利用数组
	public static long Fib(int N) {

		long a[] = new long[N + 1];
		return Fib(N, a);

	}

	public static long Fib(int N, long a[]) {

		if (N == 0) {
			a[N] = 0;
		}
		if (N == 1) {
			a[N] = 1;
		} else if (N > 1) {
			a[N] = Fib(N - 1, a) + Fib(N - 2, a);
		}

		return a[N];

	}

	public static void main(String[] args) {
		// for (int N = 0; N < 100; N++) {
		// System.out.println(N + " " + F(N));
		// }
		for (int N = 0; N < 100; N++) {
			System.out.println(N + " " + Fib(N));
		}

	}

}
