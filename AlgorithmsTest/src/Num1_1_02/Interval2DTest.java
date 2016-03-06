package Num1_1_02;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;

/**
 * Interval2D测试用例
 * 
 * @author he
 *
 */
public class Interval2DTest {
	public static void main(String[] args) {
		double xlo = .1;// x起始点
		double xhi = .5;// x的终止点
		double ylo = .4;// y起始点
		double yhi = .6;// y的终止点
		int T = 100000;
		//获取x的长度
		Interval1D xinterval = new Interval1D(xlo, xhi);
		System.out.println(xinterval.length());
		//获取y的长度
		Interval1D yinterval = new Interval1D(ylo, yhi);
		System.out.println(yinterval.length());
		//将两条直线相连，创建二维间隔   即平面图形
		Interval2D box = new Interval2D(xinterval, yinterval);
		box.draw();
		System.out.println(box.area());
	}
}
