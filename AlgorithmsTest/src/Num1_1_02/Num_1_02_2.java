package Num1_1_02;

import edu.princeton.cs.algs4.Interval1D;

/**
 * P71 T1.2.2
 * 
 * @author he
 *
 */
public class Num_1_02_2 {

	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		double xlo = Math.random();
		double xhi = Math.random();
		Interval1D it[] = new Interval1D[N];
		it[0] = (xlo <= xhi) ? new Interval1D(xlo, xhi) : new Interval1D(xhi, xlo);

		for (int i = 1; i < N; i++) {
			xlo = Math.random();
			xhi = Math.random();
			// 利用下面的三目运算符 等价于下面的if()else()
			it[i] = (xlo <= xhi) ? new Interval1D(xlo, xhi) : new Interval1D(xhi, xlo);
			// if (xlo <= xhi) {
			// it[i] = new Interval1D(xlo, xhi);
			// } else {
			// it[i] = new Interval1D(xhi, xlo);
			// }
			// System.out.println(it[i]);

			if (it[i].intersects(it[i - 1])) {
				System.out.println("相交：" + it[i] + "  " + it[i - 1] + "\n");
			}
		}
		String s1="hello";
		String s2=s1;
		s1="world";
		System.out.println(s1);
		System.out.println(s2);
		
	}
}
