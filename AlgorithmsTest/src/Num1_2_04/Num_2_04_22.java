package Num1_2_04;

/**
 * 实现数组动态扩容的优先队列 
 * P210 T22
 * 
 * @author he
 *
 */

class ResizingMaxPQ {
	private int a[];
	private int N = 0;

	public ResizingMaxPQ() {
		a = new int[2];
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

	// 数组扩容
	private void resize(int max) {
		int temp[] = new int[max];
		for (int i = 1; i <= N; i++) {
			temp[i] = a[i];
		}
		a = temp;
	}

	public void insert(int v) {
		// 扩容
		if (N == a.length - 1) {
			resize(2 * a.length);
		}
		a[++N] = v;
		swim(N);
	}

	public int delMax() {
		// 缩减
		if (N > 0 && N == a.length / 4) {
			resize(a.length / 2);
		}
		int max = a[1];
		exch(1, N--);
		sink(1);
		return max;

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

}

public class Num_2_04_22 {
	public static void main(String[] args) {
		ResizingMaxPQ mPq = new ResizingMaxPQ();
		// mPq.insert(4);
		// mPq.insert(101);
		// mPq.insert(0);
		// mPq.insert(99);

		for (int i = 0; i < 100; i++) {
			mPq.insert(i);
		}
		while (!mPq.isEmpty()) {
			System.out.println(mPq.delMax());
		}
	}

}
