package Num1_1_02;

import edu.princeton.cs.algs4.Point2D;

/**
 * P71 T1.2.1
 * 
 * @author he
 *
 */
public class Num_1_02_1 {
	public static double shortPath(int n) {
		double path = 1.0;// 用于找最短距离
		for (int i = 0; i < n; i++) {
			double x1 = Math.random();
			double y1 = Math.random();
			double x2 = Math.random();
			double y2 = Math.random();
			// 画两个点
			Point2D p1 = new Point2D(x1, y1);
			Point2D p2 = new Point2D(x2, y2);

			if (p1.distanceTo(p2) < path) {
				path = p1.distanceTo(p2);
			}
		}
		return path;
	}
	public static void main(String[] args) {
		System.out.println(shortPath(10));
	}
}
