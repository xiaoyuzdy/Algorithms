package Number_2;

/**
 * P202 基于堆的优先队列
 * 
 * @author he
 *
 */
public class MaxPQ<key extends Comparable<key>> {
	private key[] pq;
	private int N = 0;

	private boolean less(int i, int j) {
		return pq[i].compareTo(pq[j]) < 0;
	}

	private void exch(int i, int j) {
		key t = pq[i];
		pq[i] = pq[j];
		pq[j] = t;
	}

	public MaxPQ(int maxN) {
		pq = (key[]) new Comparable[maxN + 1];
	}

	/**
	 * 上浮，在插入操作后调用保证堆的有序性
	 * 
	 * @param k
	 */
	private void swim(int k) {
		while (k > 1 && less(k / 2, k)) {
			exch(k, k / 2);
			k = k / 2;
		}
	}

	/**
	 * 下沉，在删除最大元素后调用，保证有序性
	 * 
	 * @return
	 */

	private void sink(int k) {
		while (k * 2 <= N) {
			int i = 2 * k;
			// 找到子结点中最大的一个结点
			if (i < N && less(i, i + 1)) {
				i++;
			}
			// 插入位置在中间
			if (!less(k, i)) {
				break;
			}
			exch(k, i);
			k = i;
		}
	}

	public void insert(key v) {
		pq[++N] = v;
		swim(N);
	}

	public key delMax() {
		key max = pq[1];// 从根节点得到最大的元素
		exch(1, N--);// 将其和最后一个元素交换
		pq[N + 1] = null;// 防止对象游离
		sink(1);
		return max;
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	public static void main(String[] args) {
		MaxPQ<Integer> mPq = new MaxPQ<Integer>(10);
		mPq.insert(4);
		mPq.insert(100);
		mPq.insert(0);
		mPq.insert(99);

		while (!mPq.isEmpty()) {
			System.out.println(mPq.delMax());
		}
	}

}
