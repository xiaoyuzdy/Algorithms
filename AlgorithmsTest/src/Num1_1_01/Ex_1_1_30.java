package Num1_1_01;

/**
 * P36
 * 
 * @author he
 *
 */
public class Ex_1_1_30 {
	public static int gcd(int i, int j) {
		if (j == 0) {
			return i;
		}
		else {
			int r;
			r = i % j;
			return gcd(j, r);
		}
	}

	static void print(boolean a[][], int N) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.println(a[i][j]);
			}
		}
	}

	public static void main(String[] args) {
		boolean a[][] = new boolean[6][6];

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if (gcd(i, j) == 1) {
					a[i][j] = true;
				} else {
					a[i][j] = false;
				}
			}
		}

		print(a, 6);
	}
}
