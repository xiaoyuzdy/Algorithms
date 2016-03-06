package Num1_1_02;

import edu.princeton.cs.algs4.Interval1D;

/**
 * 画直线
 * 
 * @author he
 *
 */
public class Interval1DText {
	public static void main(String[] args) {
		Interval1D t = new Interval1D(.1, .4);
		Interval1D t2 = new Interval1D(.2, .6);
		double x = .3;
		// 判断点.3是否在直线上
		System.out.println(t.contains(x));// true
		// 判断两条直线是否相交
		System.out.println(t.intersects(t2));// true
	}
}
