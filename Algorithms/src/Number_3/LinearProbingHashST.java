package Number_3;
import edu.princeton.cs.algs4.Queue;

/**
 * P301 算法3.6 基于线性探测的符号表 M>N,申请较大的数组,使用两个并行数组，一个储存key一个储存value
 * 
 * @author he
 *
 */
public class LinearProbingHashST<Key, Value> {
	private final static int CAP = 4;// 默认初始大小

	private int N;// 符号表中键值对的总数
	private int M;// 符号表的大小
	private Key[] keys;// 储存key
	private Value[] values;// 存储value

	@SuppressWarnings("unchecked")
	public LinearProbingHashST(int cap) {
		M = cap;
		keys = (Key[]) new Object[M];
		values = (Value[]) new Object[M];
	}

	public LinearProbingHashST() {
		this(CAP);
	}

	// 数组扩容
	private void resize(int cap) {
		LinearProbingHashST<Key, Value> temp = new LinearProbingHashST<Key, Value>(cap);
		for (int i = 0; i < M; i++) {
			if (keys[i] != null)
				temp.put(keys[i], values[i]);
		}
		keys = temp.keys;
		values = temp.values;
		M = temp.M;
	}

	private int hash(Key key) {
		return (key.hashCode() & 0x7fffffff) % M;
	}

	public boolean contains(Key key) {
		return get(key) != null;
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

	/**
	 * 删除操作，将被删除的键值都变为null，同时将被删除键的右侧所有的键重新插入散列表
	 * 
	 * @param key
	 */
	public void delete(Key key) {
		if (!contains(key))
			return;
		int i = hash(key);
		// 未命中向后找
		while (!keys[i].equals(key)) {
			i = (i + 1) % M;
		}
		keys[i] = null;
		values[i] = null;
		i = (i + 1) % M;
		// 将被删除键后面不为null的键值对重新插入散列表
		while (keys[i] != null) {
			Key keytemp = keys[i];
			Value valuetemp = values[i];
			// 删除
			keys[i] = null;
			values[i] = null;
			N--;
			put(keytemp, valuetemp);
			i = (i + 1) % M;
		}

		N--;
		if (N > 0 && N == M / 8)
			resize(M / 2);

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
		st.put("C", 6);
		System.out.println(st.get("A"));
		System.out.println(st.get("H"));
		System.out.println(st.get("E"));
		System.out.println(st.keys());
		st.delete("C");
		System.out.println(st.keys());

	}

}
