package Num2_5_03;

/**
 * P510 T05
 * 
 * @author he
 *
 */

class BruteForceRL {
	public static int search(String txt, String pat) {
		int i, N = txt.length() - 1;
		int j, M = pat.length() - 1;

		for (i = N, j = M; i > M && j >= 0; i--) {
			if (txt.charAt(i) == pat.charAt(j))
				j--;
			else {
				i = i - (M - j);// ◊Û“∆
				j = M;
			}

			if (j == -1)// ’“µΩ∆•≈‰
				return i;
		}

		return N;

	}
}

public class Num_5_03_15 {
	public static void main(String[] args) {
		System.out.println(BruteForceRL.search("ABACADABRAC", "ABRA"));
	}

}
