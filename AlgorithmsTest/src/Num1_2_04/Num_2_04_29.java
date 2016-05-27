package Num1_2_04;

/**
 * P211 T29
 * 
 * @author he
 *
 */

class PQ {
	private int maxPq[];// 用于删除最大元素的堆
	private int minPq[];// 用于删除最小元素的堆
	private int MaxN = 0;// max堆中的元素
	private int MinN = 0;// min堆中的元素

	private int max = -99999;// 数组中最大的元素
	private int min = 99999;// 数组中最小的元素

	public PQ(int maxN) {
		maxPq = new int[maxN + 1];
		minPq = new int[maxN + 1];
	}

	/**
	 * 上浮
	 * 
	 * @param k
	 *            为索引
	 * @param a
	 *            为指定数组
	 * @param t
	 *            t为true时，对max堆进行上浮操作，t=false时对min堆进行上浮操作
	 */
	private void swim(int k, int a[], boolean t) {
		// 最大元素置于index=1的位置
		if (t == true) {
			while (k > 1 && less(k / 2, k, a)) {
				exch(k / 2, k, a);
				k = k / 2;
			}
		}

		// 最小元素置于index=1的位置
		if (t == false) {
			while (k > 1 && !less(k / 2, k, a)) {
				exch(k / 2, k, a);
				k = k / 2;
			}
		}

	}

	/**
	 * 下沉
	 * 
	 * @param k
	 *            为索引
	 * @param a
	 *            为指定数组
	 * @param N
	 *            指定的N
	 * @param t
	 *            t为true时，对max堆进行下沉操作，t=false时对min堆进行下沉操作
	 */
	private void sink(int k, int a[], int N, boolean t) {

		if (t == true) {
			while (2 * k <= N) {
				int j = 2 * k;
				if (j < N && less(j, j + 1, a)) {
					j++;
				}
				if (!less(k, j, a)) {
					break;
				}
				exch(k, j, a);
				k = j;
			}
		}

		if (t == false) {
			while (2 * k <= N) {
				int j = 2 * k;
				if (j < N && !less(j, j + 1, a)) {
					j++;
				}
				if (less(k, j, a)) {
					break;
				}
				exch(k, j, a);
				k = j;
			}
		}

	}

	private boolean less(int i, int j, int a[]) {
		return a[i] < a[j];
	}

	private void exch(int i, int j, int a[]) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public void insert(int v) {

		max = max < v ? v : max;
		min = min < v ? min : v;

		maxPq[++MaxN] = v;
		minPq[++MinN] = v;
		swim(MaxN, maxPq, true);
		swim(MinN, minPq, false);
	}

	// 删除最大元素
	public int delMax() {
		int max = maxPq[1];
		exch(1, MaxN--, maxPq);
		maxPq[MaxN + 1] = -1;
		sink(1, maxPq, MaxN, true);
		return max;
	}

	// 删除最小元素
	public int delMin() {
		int min = minPq[1];
		exch(1, MinN--, minPq);
		minPq[MinN + 1] = -1;
		sink(1, minPq, MinN, false);
		return min;
	}

	// 返回最大元素
	public int max() {
		return max;
	}

	// 返回最小元素
	public int min() {
		return min;
	}

	public boolean maxisEmpty() {
		return MaxN == 0;
	}

	public boolean minisEmpty() {
		return MinN == 0;
	}

}

public class Num_2_04_29 {
	public static void main(String[] args) {
		PQ mPq = new PQ(10);
		for (int i = 0; i < 10; i++) {
			mPq.insert(i);
		}

		System.out.println("max: " + mPq.max() + " min: " + mPq.min());

		while (!mPq.maxisEmpty()) {
			System.out.println("delMax: " + mPq.delMax());
			System.out.println("delMin: " + mPq.delMin());
		}

		// while (!mPq.minisEmpty()) {
		// System.out.println("min: "+mPq.delMin());
		// }

	}
}
