package Number_3;

import java.awt.RenderingHints.Key;

import edu.princeton.cs.algs4.Queue;

/**
 * P301 算法3.6 基于线性探测的符号表 M>N,申请较大的数组,使用两个并行数组，一个储存key一个储存value
 * 
 * @author he
 *
 */
public class LinearProbingHashST<Key, Value> {
	private int N;// 符号表中键值对的总数
	private int M = 16;// 符号表的大小
	private Key[] keys;// 储存key
	private Value[] values;// 存储value

	@SuppressWarnings("unchecked")
	public LinearProbingHashST() {
		keys = (Key[]) new Object[M];
		values = (Value[]) new Object[M];
	}

	// 数组扩容
	private void resize(int cap) {

	}

	private int hash(Key key) {
		return (key.hashCode() & 0x7fffffff) % M;
	}

	public void put(Key key, Value value) {
		if (N >= M / 2)
			resize(2 * M);
		int i;
		// 如果不符合条件index加 1
		for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
			if (keys[i].equals(key)) {
				values[i] = value;
				return;
			}
		}
		keys[i] = key;
		values[i] = value;
		N++;
	}

	public Value get(Key key) {
		if (key == null)
			throw new NullPointerException();
		for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
			if (keys[i].equals(key))
				return values[i];
		}
		return null;
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

	public static void main(String[] args) {
		LinearProbingHashST<String, Integer> st = new LinearProbingHashST<String, Integer>();
		st.put("S", 0);
		st.put("E", 1);
		st.put("A", 2);
		st.put("R", 3);
		st.put("H", 4);
		st.put("E", 5);
		System.out.println(st.get("A"));
		System.out.println(st.get("H"));
		System.out.println(st.get("E"));
		System.out.println(st.keys());

	}

}
