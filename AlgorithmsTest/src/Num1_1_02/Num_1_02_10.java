package Num1_1_02;

import java.util.Random;

import edu.princeton.cs.algs4.StdDraw;

/**
 * VisualCount
 * 
 * @author he
 *
 */

class VisualCount {
	private int count = 0;
	private final int XMAX = 1000;// 设置X最大值
	private final double YMAX = 1.0;// 设置Y最大值
	private boolean temp = false;
	private Random random = new Random(47);

	public VisualCount(int N, int Max) {
		StdDraw.setXscale(0, XMAX);// 设置X范围
		StdDraw.setYscale(0, YMAX);// 设置Y范围
		StdDraw.setPenRadius(.005);

		for (int i = 0; i < N; i++) {

			// 设置随机增减
			temp = random.nextBoolean();
			// 设置随机增减
			count = temp ? count + 1 : count - 1;

			StdDraw.setPenColor(StdDraw.RED);
			// 画点
			StdDraw.point(count * 40, Math.random());
			if (count == Max || -count == Max) {
				System.out.println("达到最大值");
				break;
			}

		}
	}
}

public class Num_1_02_10 {
	public static void main(String[] args) {
		VisualCount a = new VisualCount(10000, 20);
	}

}
