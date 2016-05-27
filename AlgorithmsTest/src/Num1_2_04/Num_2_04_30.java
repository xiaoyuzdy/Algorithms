package Num1_2_04;

import edu.princeton.cs.algs4.MaxPQ;

/**
 * P211 T30
 * 
 * @author he
 *
 */

class findMedian {
	private MaxPQ<Integer> max;

	public findMedian() {
		max = new MaxPQ<Integer>();
	}

	public void insert(int v) {
		max.insert(v);
	}

	public int median() {
		int size = max.size();
		if (size % 2 != 0) {
			int t = size / 2;
			while (t-- > 0) {
				max.delMax();
			}
			return max.delMax();
		} else {
			int t = size / 2;
			while (t-- > 1) {
				max.delMax();
			}
			return (max.delMax() + max.delMax()) / 2;
		}
	}

}

public class Num_2_04_30 {
	public static void main(String[] args) {
		findMedian f = new findMedian();
		for (int i = 0; i < 6; i++) {
			f.insert(i);
		}

		System.out.println(f.median());
	}

}
