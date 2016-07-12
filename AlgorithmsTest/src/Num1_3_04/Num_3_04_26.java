package Num1_3_04;

import edu.princeton.cs.algs4.Queue;

/**
 * P310 T26 思路：延时删除，要保证不能发生碰撞，碰撞就扩容，这样在删除时，删除键后面的元素就不用重新插入散列表， 同时在扩容时增大M
 * 
 * @author he
 *
 */

class LiearPHST<Key, Value> {
	private final static int CAP = 2;// 初始M值
	private static int k = 1;// 2的幂次,从属于类 否则创建新对象会被重置
	private final static int[] primes = { 0, 0, 3, 7, 13, 31, 61, 127, 251, 509, 1021, 2039, 4093, 8191 };// 小于2的k次方的最大素数

	private int N;
	private int M;// 散列表大小
	private Key keys[];
	private Value var[];

	public LiearPHST() {
		this(CAP);
	}

	@SuppressWarnings("unchecked")
	public LiearPHST(int cap) {
		this.M = cap;
		keys = (Key[]) new Object[M];
		var = (Value[]) new Object[M];
	}

	private boolean contains(Key key) {
		return get(key) != null;
	}

	private void resize(int cap) {
		LiearPHST<Key, Value> temp = new LiearPHST<Key, Value>(cap);
		for (int i = 0; i < M; i++) {
			if (keys[i] != null)
				temp.put(keys[i], var[i]);
		}
		M = temp.M;
		keys = temp.keys;
		var = temp.var;

	}

	private int hash(Key key) {
		return (key.hashCode() & 0x7fffffff) % M;
	}

	public void put(Key key, Value value) {

		int i = hash(key);
		// 发生碰撞则扩容
		if (var[i] != null && !keys[i].equals(key)) {
			resize(primes[++k]);
		}

		if (keys[i] != null && keys[i].equals(key)) {
			var[i] = value;
			return;
		}

		keys[i] = key;
		var[i] = value;
		N++;
	}

	public Value get(Key key) {
		int i = hash(key);
		return var[i];
	}

	public void delete(Key key) {
		if (!contains(key))
			return;
		int i = hash(key);
		keys[i] = null;
		var[i] = null;
	}

	public Iterable<Key> keys() {
		Queue<Key> queue = new Queue<Key>();
		keys(queue);
		return queue;
	}

	private void keys(Queue<Key> queue) {
		for (int i = 0; i < M; i++) {
			if (keys[i] != null)
				queue.enqueue(keys[i]);
		}

	}

}

public class Num_3_04_26 {
	public static void main(String[] args) {
		LiearPHST<String, Integer> st = new LiearPHST<String, Integer>();
		st.put("S", 0);
		st.put("E", 1);
		st.put("A", 3);
		st.put("R", 3);
		st.put("H", 4);
		st.put("E", 5);
		st.put("C", 6);
		 System.out.println(st.get("A"));
		 System.out.println(st.get("H"));
		 System.out.println(st.get("E"));
		 System.out.println(st.keys());
		 st.delete("C");
		 st.delete("E");
		 System.out.println(st.keys());
	}

}
