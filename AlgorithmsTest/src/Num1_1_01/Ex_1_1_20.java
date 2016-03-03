package Num1_1_01;

/**
 * p35 Çóln(n!)
 * 
 * @author he
 *
 */
public class Ex_1_1_20 {
	public static long ln(double e) {
		long sum = 1;
		for (int i = 0; i < e; i++) {
			sum = sum * i;
		}
		return (long) Math.log(sum);

	}

	public static void main(String[] args) {
		System.out.println(ln(0));
	}

}
