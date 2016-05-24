package Num1_2_04;

import java.util.LinkedList;

/**
 * P210 24 用链表实现一个优先队列 基于linkedlist，由于储存时是从index=0开始的，所以在上浮和下沉出做了相应的修改
 * 能力有限只会这样写了，如果你能按照书中要求使用有三个方向的结点，请借我参考参考
 * 
 * @author he
 *
 */

class MaxPQbyList {
	private int N = 0;
	private LinkedList<Integer> linkedList;

	public MaxPQbyList() {
		linkedList = new LinkedList<Integer>();
	}

	public void insert(int item) {
		linkedList.add(item);
		N++;
		swim(N - 1);// 上浮
	}

	public int delMax() {
		int max = linkedList.get(0);
		if (N - 1 == 0) {
			N--;
			return max;
		} else {
			exch(0, --N);// 将其和最后一个元素交换
			linkedList.removeLast();// 移除最后一个元素
			sink(0);// 下沉
			return max;
		}

	}

	// 上浮
	private void swim(int k) {
		while (k > 0 && less(k / 2, k)) { // 修改
			exch(k / 2, k);
			k = k / 2;
		}
	}

	// 修改
	private void sink(int k) {
		while (k * 2 < N) { // 修改
			int i = 2 * k;
			// 找到子结点中最大的一个结点
			if (i < N - 1 && less(i, i + 1)) { // 修改
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

	private boolean less(int i, int j) {
		return linkedList.get(i) < linkedList.get(j);
	}

	// 在linkedlist中交换元素
	private void exch(int i, int j) {
		/*
		 * 这样写也是正确的
		 */
		// int Itemp = linkedList.get(i);
		// int Jtemp = linkedList.get(j);
		// linkedList.remove(i);
		// linkedList.remove(j - 1);
		// linkedList.add(i, Jtemp);
		// linkedList.add(j, Itemp);

		int temp = linkedList.get(i);
		linkedList.set(i, linkedList.get(j));
		linkedList.set(j, temp);

	}

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	public String show() {
		return linkedList.toString();
	}

}

public class Num_2_04_24 {
	public static void main(String[] args) {
		MaxPQbyList x = new MaxPQbyList();
		// x.insert(4);
		// x.insert(100);
		// x.insert(0);
		// x.insert(99);

		for (int i = 0; i < 10; i++) {
			x.insert(i);
		}

		System.out.println(x.show());
		while (!x.isEmpty()) {
			System.out.println(x.delMax());
		}

	}
}
