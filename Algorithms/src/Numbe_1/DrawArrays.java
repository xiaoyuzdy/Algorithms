package Numbe_1;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

/**
 * P27 利用algs.jar 画一个随机数组
 * 
 * @author he
 *
 */
public class DrawArrays {

	public static void main(String[] args) {
		int N = 50;
		double[] a = new double[N];
		// 产生0到1之间的随机数
		for (int i = 0; i < N; i++) {
			a[i] = StdRandom.random();
		}
		Arrays.sort(a);
		// 画随机数组
		for (int i = 0; i < N; i++) {
			// 坐标
			double x = 1.0 * i / N;
			double y = a[i] / 2.0;
			// 宽高
			double rw = 0.5 / N;
			double rh = a[i] / 2.0;
			StdDraw.filledRectangle(x, y, rw, rh);
		}
		
		
	}

}
