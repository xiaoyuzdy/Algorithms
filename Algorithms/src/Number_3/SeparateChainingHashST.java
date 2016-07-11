package Number_3;

import edu.princeton.cs.algs4.Queue;

/**
 * P297 算法3.5 基于拉链法的散列表，借助之前写的用链表实现的无序符号表,数组保存的是链表
 * 
 * @author he
 *
 */
public class SeparateChainingHashST<Key extends Comparable<Key>, Value> {
	private int N;// 键值对总数
	private int M;// 散列表大小
	private SequentialSearchST<Key, Value>[] st;// 存放链表对象的数组

	public SeparateChainingHashST() {
		this(997);// 997为素数
	}

	@SuppressWarnings("unchecked")
	public SeparateChainingHashST(int M) {
		// 创建M条链表
		this.M = M;
		st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
		for (int i = 0; i < M; i++) {
			st[i] = new SequentialSearchST<Key, Value>();
		}
	}

	// 计算数组下标
	private int hash(Key key) {
		return (key.hashCode() & 0x7fffffff) % M;
	}

	// 将键值对添加到对应数组位置的链表中
	public void put(Key key, Value value) {
		if (key == null)
			throw new NullPointerException("key 不能为null");
		int i = hash(key);
		if (!st[i].contains(key))
			N++;
		st[hash(key)].put(key, value);
	}

	public Value get(Key key) {
		return st[hash(key)].get(key);
	}

	public int size() {
		return N;
	}

	/**
	 * 删除操作
	 * 
	 * @param key
	 */
	public void delete(Key key) {
		int i = hash(key);
		if (st[i].contains(key))
			N--;
		st[i].delete(key);
	}

	/**
	 * 返回所有键
	 * 
	 * @return
	 */
	public Iterable<Key> keys() {
		Queue<Key> queue = new Queue<Key>();
		keys(queue);
		return queue;
	}

	private void keys(Queue<Key> queue) {
		for (int i = 0; i < M; i++) {
			for (Key key : st[i].keys()) {
				queue.enqueue(key);
			}
		}
	}

	public static void main(String[] args) {
		SeparateChainingHashST<String, Integer> st = new SeparateChainingHashST<String, Integer>();
		st.put("A", 1);
		st.put("B", 2);
		st.put("A", 3);
		st.put("D", 4);
		st.put("E", 5);
		System.out.println(st.get("A"));
		System.out.println(st.get("B"));
		st.delete("A");
		System.out.println(st.get("A"));
		System.out.println(st.size());
		System.out.println(st.keys());

	}

}
