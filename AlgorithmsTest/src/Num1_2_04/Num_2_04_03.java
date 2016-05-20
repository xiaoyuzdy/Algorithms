package Num1_2_04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.text.AbstractDocument.BranchElement;

import edu.princeton.cs.algs4.Queue;

/**
 * P209 T03
 * @author he
 *
 */

/**
 * 数组（无序） 在delMax()时交换最大元素和边界元素
 */
class unorderedArray {
	private int a[];
	private int N;// 元素个数

	public unorderedArray(int size) {
		a = new int[size];
	}

	public int delMax() {
		if (isEmpty()) {
			throw new RuntimeException();
		}
		int max = a[N - 1];
		for (int i = 0; i < N; i++) {
			if (a[i] > a[max]) {
				max = i;
			}
		}
		exch(a, N - 1, max);
		return a[--N];
	}

	private void exch(int a[], int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public void insert(int T) {
		a[N++] = T;
	}

	public int size() {
		return N;
	}

	public boolean isEmpty() {
		return N == 0;
	}

}

/**
 * 数组（有序） 在insert()中保持数组有序
 * 
 * @author he
 *
 */

class orderedArray {
	private int a[];
	private int N;// 元素个数

	public orderedArray(int size) {
		a = new int[size];
	}

	public int delMax() {
		if (isEmpty()) {
			throw new RuntimeException();
		}
		return a[--N];
	}

	private void exch(int a[], int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	// 保证数组的有序性
	public void insert(int T) {
		a[N++] = T;
		for (int j = N - 1; j > 0 && a[j] < a[j - 1]; j--) {
			exch(a, j, j - 1);
		}
	}

	public int size() {
		return N;
	}

	public boolean isEmpty() {
		return N == 0;
	}
}

/**
 * 链表实现（无序），借助于基于链表的Queue
 * 
 * @author he
 *
 */

class unorderedList {
	private Queue<Integer> queue;

	public unorderedList() {
		queue = new Queue<Integer>();
	}

	public int delMax() {
		int max = queue.peek();
		int i = size();
		int j = i;

		// 找到max
		while (i-- > 0) {
			if (queue.peek() > max) {
				max = queue.peek();
			}
			queue.enqueue(queue.dequeue());
		}

		// 保证dequeue出的是max
		while (j-- > 0) {
			if (queue.peek() == max) {
				queue.dequeue();
				break;
			} else {
				queue.enqueue(queue.dequeue());
			}
		}
		return max;
	}

	public void insert(int T) {
		queue.enqueue(T);
	}

	public boolean isEmpty() {
		return queue.isEmpty();
	}

	public int size() {
		return queue.size();
	}

}

/**
 * 链表实现（有序），借助于List
 * 
 * @author he
 *
 */
class orderedList {
	private List<Integer> list;

	public orderedList() {
		list = new ArrayList<Integer>();
	}

	public int delMax() {

		return list.remove(list.size()-1);
	}

	public void insert(int T) {
		list.add(T);
		Collections.sort(list);//排序
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public int size() {
		return list.size();
	}

}

public class Num_2_04_03 {
	public static void main(String[] args) {
		// unorderedArray u=new unorderedArray(10);
		// orderedArray u = new orderedArray(10);
		// unorderedList u = new unorderedList();
		orderedList u = new orderedList();

		u.insert(1);
		u.insert(59);
		u.insert(7);
		u.insert(0);
		// System.out.println(u.size());
		while (!u.isEmpty()) {
			System.out.println(u.delMax());
		}
	}

}
