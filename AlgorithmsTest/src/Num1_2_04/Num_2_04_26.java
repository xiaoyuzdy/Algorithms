package Num1_2_04;

/**
 * P211 T26
 * 
 * @author he
 *
 */

class MaxPQ2 {
	private int a[];
	private int N = 0;

	public MaxPQ2(int maxN) {
		a = new int[maxN + 1];
	}

	// 上浮，不需交换的堆
	private void swim(int k) {
		int t = a[k];
		while (k > 1 && less(k / 2, k)) {
			a[k] = a[k / 2];
			k = k / 2;
			a[k] = t;
		}

	}

	// 下沉不需交换
	private void sink(int k) {
		int t = a[k];
		while (2 * k <= N) {
			int j = 2 * k;
			if (less(j, j + 1)) {
				j = j + 1;
			}
			if (!less(k, j)) {
				break;
			}
			a[k] = a[j];
			a[j] = t;
			k = j;
		}

	}

	private boolean less(int i, int j) {
		return a[i] < a[j];
	}

	private void exch(int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public void insert(int v) {
		a[++N] = v;
		swim(N);
	}

	public int delMax() {
		int max = a[1];
		exch(1, N--);
		a[N + 1] = -1;
		sink(1);
		return max;
	}

	public boolean isEmpty() {
		return N == 0;
	}

}

public class Num_2_04_26 {
	public static void main(String[] args) {
		MaxPQ2 mPq = new MaxPQ2(10);
		for (int i = 0; i < 10; i++) {
			mPq.insert(i);
		}

		while (!mPq.isEmpty()) {
			System.out.println(mPq.delMax());
		}

	}
}
