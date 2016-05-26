package Num1_2_04;

import edu.princeton.cs.algs4.MinPQ;

/**
 * P211 T25
 * 
 * @author he
 *
 */

class CubeSum implements Comparable<CubeSum> {
	private final int sum;
	final int i;
	final int j;

	public CubeSum(int i, int j) {
		this.sum = i * i * i + j * j * j;
		this.i = i;
		this.j = j;
	}

	@Override
	public int compareTo(CubeSum o) {
		if (this.sum < o.sum) {
			return -1;
		}
		if (this.sum > o.sum) {
			return +1;
		}
		return 0;
	}

	@Override
	public String toString() {

		return sum + "=" + i + "^3" + "+" + j + "^3";
	}

}

public class Num_2_04_25 {
	public static void main(String[] args) {
		int N = Integer.valueOf(args[0]);//100
		MinPQ<CubeSum> mPq = new MinPQ<CubeSum>();
		for (int i = 0; i <= N; i++) {
			mPq.insert(new CubeSum(i, i));
		}

		while (!mPq.isEmpty()) {
			CubeSum s = mPq.delMin();
			System.out.println(s);
			if (s.j < N) {
				mPq.insert(new CubeSum(s.i, s.j + 1));
			}
		}

	}

}
