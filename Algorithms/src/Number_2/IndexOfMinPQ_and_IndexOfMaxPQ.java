package Number_2;

import edu.princeton.cs.algs4.StdOut;

/**
 * 关联索引的 泛型优先队列 P203
 * 
 * @author he
 *
 */
public class IndexOfMinPQ_and_IndexOfMaxPQ<Key extends Comparable<Key>> {
	private int N = 0;// PQ中的元素数量
	private int[] pq;// 索引二叉堆，由1开始
	private int[] qp;// 逆序 qp[pq[i]]=pq[qp[i]]=i
						// qp存的是pq值的索引，主要用于pq的排序见方法change()
	private Key[] keys;// 有优先级之分的元素

	@SuppressWarnings("unchecked")
	public IndexOfMinPQ_and_IndexOfMaxPQ(int maxN) {
		keys = (Key[]) new Comparable[maxN + 1];
		pq = new int[maxN + 1];
		qp = new int[maxN + 1];
		for (int i = 0; i <= maxN; i++) {
			qp[i] = -1;
		}
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

			if (!less(k, j)) {
				break;
			}
			exch(k, j);
			k = j;
		}

	}

	/**
	 * 插入一个元素将它和索引k相关联
	 * 
	 * @param k
	 * @param key
	 */
	public void insert(int k, Key key) {
		N++;
		pq[N] = k;// pq在index=N 的值为k
		qp[k] = N;// qp在index=k 的值为N
		keys[k] = key;
		swim(N);
	}

	/**
	 * 返回最小元素
	 * 
	 * @return
	 */
	public Key min() {
		return keys[pq[1]];
	}

	/**
	 * 删除最小元素并返回索引
	 * 
	 * @return
	 */
	public int delMin() {
		int indexOfMin = pq[1];
		exch(1, N--);// 将最小index和末尾交换
		sink(1);
		keys[pq[N + 1]] = null;// 防止对象游离
		qp[pq[N + 1]] = -1;// 解除关联
		return indexOfMin;
	}

	/**
	 * 返回最小元素对应的index
	 * 
	 * @return
	 */
	public int minIndex() {
		return pq[1];
	}

	/**
	 * 将索引k的元素设置为key
	 * 
	 * @return
	 */

	public void change(int k, Key key) {
		keys[k] = key;
		// 通过qp找到在pq中k对应的N，并执行相应操作
		swim(qp[k]);
		sink(qp[k]);
	}

	/**
	 * 删除索引为k的元素
	 * 
	 * @return
	 */
	public void delete(int k) {
		int index = qp[k];
		exch(index, N--);
		swim(index);
		sink(index);
		keys[k] = null;
		qp[k] = -1;

	}

	public boolean isEmpty() {
		return N == 0;
	}

	public boolean contains(int k) {
		return qp[k] != -1;
	}

	public int size() {
		return N;
	}

	/**
	 * 使keys[] 按升序排列，则对应的移除最小元素
	 * 
	 * @param i
	 * @param j
	 * @return
	 */

	private boolean less(int i, int j) {
		return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
	}

	/**
	 * 使keys[] 按降序排序，则对应的输出是删除最大元素 即 IndexMaxPQ 只需要改动此处即可
	 * 
	 * @param i
	 * @param j
	 * @return
	 */

	// private boolean less(int i, int j) {
	// return keys[pq[i]].compareTo(keys[pq[j]]) < 0;
	// }

	
	private void exch(int i, int j) {
		//pq[]数组中的pq[i]和pq[j]交换
		int swap = pq[i];
		pq[i] = pq[j];
		pq[j] = swap;
		//同时更新qp[]数组,保证qp[]是pq[]的逆序
		qp[pq[i]] = i;
		qp[pq[j]] = j;
	}

	public static void main(String[] args) {
		String a[] = { "A","X","Z","C","B","E" };
		IndexOfMinPQ_and_IndexOfMaxPQ<String> pq = new IndexOfMinPQ_and_IndexOfMaxPQ<String>(a.length);
		for (int i = 0; i < a.length; i++) {
			pq.insert(i, a[i]);
		}
		System.out.println(pq.min());
		// 删除最小元素，输出最小元素对应的下表和元素
		while (!pq.isEmpty()) {
			int i = pq.delMin();
			StdOut.println(i + " " + a[i]);
		}

	}
}
