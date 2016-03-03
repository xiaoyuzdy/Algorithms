package Num1_1_01;

/**
 * P35 24题
 * 
 * @author he
 *
 */
public class Ex_1_1_24 {
	// 求最大公约数
	public static int gcd(int p, int q) {
		if ( q== 0) {
			return p;
		}
		int r = p % q;
		return gcd(q, r);
	}

	public static void main(String[] args) {
		System.out.println(gcd(105, 24));
		System.out.println(gcd(1111111, 1234567));
	}
}
