package Num1_2_04;

/**
 * P211 T27
 * 
 * @author he
 *
 */

class MaxPQ {
	private int a[];
	private int N = 0;

	public MaxPQ(int maxN) {
		a = new int[maxN + 1];
	}

	// 上浮
	private void swim(int k) {
		while (k > 1 && less(k / 2, k)) {
			exch(k, k / 2);
			k = k / 2;
		}
	}

	// 下沉
	private void sink(int k) {
		while (2 * k <= N) {
			int j = 2 * k;
			if (j < N && less(j, j + 1)) {
				j++;
			}
			// 插入位置在中间
			if (!less(k, j)) {
				break;
			}
			exch(k, j);
			k = j;
		}
	}

	public void insert(int v) {
		a[++N] = v;
		swim(N);
	}

	public int delMax() {
		int max = a[1];
		exch(1, N--);
		sink(1);
		return max;

	}

	/**
	 * 进行最后一层个数+2次比较，常数级
	 * 
	 * @return
	 */
	public int min() {
		int i = 1;
		int j = 1;
		while (2 * i + 1 <=N) {
			i = 2 * i + 1;
		}

		// 找到倒数第二层右边最小的元素
		if (less(i - 1, i)) {
			i = i - 1;
		}

		while (2 * j <=N) {
			j = 2 * j;
		}

		// 找到最后一层最小的元素
		int min = j;
		for (int k = j; k < N; k++) {
			if (less(k, min)) {
				min = k;
			}
		}

		if (less(i, min)) {
			return a[i];
		} else {
			return a[min];
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

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	public void show() {
		for (int i = 1; i <= N; i++) {
			System.out.println(a[i]);
		}
	}

}

public class Num_2_04_27 {

	public static void main(String[] args) {
		MaxPQ mPq = new MaxPQ(16);
		for (int i = 0; i < 16; i++) {
			mPq.insert(i);
		}
//		mPq.show();
		System.out.println("min: " + mPq.min());
		while (!mPq.isEmpty()) {
			System.out.println(mPq.delMax());
		}
	}
}
