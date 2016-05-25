package Num1_2_04;

import java.util.LinkedList;

/**
 * P210 24 用链表实现一个优先队列 按书中的提示涉及到结点表示完美二叉树以及二叉树遍历等问题，是后面章节的内容未学到
 * 本题目借助linkedlist部分必要方法，实现与数组类似 由于储存时是从index=0开始的，所以在上浮和下沉出做了相应的修改
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
		exch(0, --N);// 将其和最后一个元素交换
		linkedList.removeLast();// 移除最后一个元素
		sink(0);// 下沉
		return max;

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
