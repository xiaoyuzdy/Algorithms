package Num1_3_01;

import edu.princeton.cs.algs4.Merge;

/**
 * P247 T12 
 * 用一个实体类保存键-值对 使用归并排序的原因：归并排序是稳定排序，见书P218
 * 
 * @author he
 *
 */

class BinarySearchST2<Key extends Comparable<Key>, Value> {

	private Item[] temp;// 用于保存键值对
	private Item[] t;// 用于排序，因为归并排序的数组必须全部赋值,否则空指针异常
	private int N = 0;// 保存键值对的数量

	public BinarySearchST2() {
		temp = new Item[100000];
	}

	private void Merge(Item[] temp) {
		t = new Item[N];
		for (int i = 0; i < N; i++) {
			t[i] = temp[i];
		}
		Merge.sort(t);
	}

	@SuppressWarnings("hiding")
	private class Item<Key extends Comparable<Key>, Value> implements Comparable<Key> {
		Key key;
		Value value;

		public Item(Key key, Value value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public int compareTo(Key o) {
			return o.compareTo(this.key);
		}

	}

	@SuppressWarnings("unchecked")
	public void put(Key key, Value value) {
		if (key == null) {
			throw new RuntimeException("key can't be null");
		}
		if (rank(key) != -1) {
			temp[rank(key)].value = value;
		} else {
			temp[N++] = new Item<Key, Value>(key, value);
		}

	}

	@SuppressWarnings("unchecked")
	public Value get(Key key) {
		if (key == null) {
			throw new RuntimeException("key can't be null");
		}
		if (isEmpty()) {
			return null;
		}

		if (rank(key) != -1) {
			return (Value) temp[rank(key)].value;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public Key min() {
		Merge(temp);
		return (Key) t[0].key;
	}

	@SuppressWarnings("unchecked")
	public Key max() {
		Merge(temp);
		return (Key) t[N - 1].key;
	}

	public boolean isEmpty() {
		return N == 0;
	}

	// 有序查找
	public Key select(int k) {
		if (k >= N) {
			throw new NullPointerException();
		}
		Merge(temp);
		return (Key) t[k].key;
	}

	public void delete(Key key) {
		if (key == null) {
			throw new RuntimeException("key can't be null");
		}
		int i = rank(key);
		// 不包含key
		if (i == N || temp[i].key.compareTo(key) != 0) {
			return;
		}
		for (int j = i; j < N - 1; j++) {
			temp[j] = temp[j + 1];
		}
		temp[N - 1] = null;
		N--;
	}

	// 遍历数组返回index
	private int rank(Key key) {
		for (int i = 0; i < N; i++) {
			if (temp[i].key.equals(key)) {
				return i;
			}
		}
		return -1;
	}

}

public class Num_3_01_12 {
	public static void main(String[] args) {
		BinarySearchST2<String, Integer> st = new BinarySearchST2<String, Integer>();
		st.put("D", 1);
		st.put("C", 2);
		st.put("B", 3);
		st.put("B", 100);
		System.out.println(st.select(0));// B
		System.out.println(st.get("B"));// 100
		System.out.println(st.min());// B
		System.out.println(st.max());// D
		st.delete("C");
		System.out.println(st.get("C"));// null

	}

}
