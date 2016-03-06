package Numbe_1;

import edu.princeton.cs.algs4.Point2D;

/**
 * ≤‚ ‘ª≠µ„
 * 
 * @author he
 *
 */
public class Point2DTest {
	public static void main(String[] args) {
		for (int i = 0; i < 100000; i++) {
			double x = Math.random();
			double y = Math.random();
			Point2D p = new Point2D(x, y);
			p.draw();
		}
	}
}
