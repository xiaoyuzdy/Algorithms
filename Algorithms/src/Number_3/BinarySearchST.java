package Number_3;

/**
 * P239 算法3.2 二分查找（基于有序数组）
 * 
 * @author he
 *
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {
	private Key keys[];
	private Value values[];
	private int N = 0;// 元素数量

	public BinarySearchST(int capacity) {
		keys = (Key[]) new Comparable[capacity];
		values = (Value[]) new Object[capacity];
	}

	public int size() {
		return N;
	}

	public boolean isEmpty() {
		return N == 0;
	}

	/**
	 * 根据Key返回对应的Value
	 * 
	 * @param key
	 * @return
	 */
	public Value get(Key key) {
		if (key == null) {
			throw new RuntimeException("key can't be null");
		}
		if (isEmpty()) {
			return null;
		}

		int i = rank(key);
		if (i < N && keys[i].compareTo(key) == 0) {
			return values[i];
		} else {
			return null;
		}

	}

	/**
	 * 二分查找，如过存在返回键的index，如果不存在返回小于它的键的数量,因为lo在迭代时改变
	 * 
	 * @param key
	 * @return
	 */
	public int rank(Key key) {
		int lo = 0, hi = N - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int t = key.compareTo(keys[mid]);
			if (t > 0) {
				lo = mid + 1;
			} else if (t < 0) {
				hi = mid - 1;
			} else {
				return mid;
			}
		}
		return lo;
	}

	/**
	 * 向符号表中添加键值对
	 * 
	 * @param key
	 * @param value
	 */
	public void put(Key key, Value value) {
		if (key == null) {
			throw new RuntimeException("key can't be null");
		}

		int i = rank(key);
		// 命中，已存在，更新
		if (i < N && keys[i].compareTo(key) == 0) {
			values[i] = value;
			return;
		}

		// 未命中添加,此时是有序添加

		for (int j = N; j > i; j--) {
			keys[j] = keys[j - 1];
			values[j] = values[j - 1];
		}
		keys[i] = key;
		values[i] = value;
		N++;
	}

	/**
	 * 根据key删除键值对 将该键后面的键前移
	 * 
	 * @param key
	 */
	public void delete(Key key) {
		if (key == null) {
			throw new RuntimeException("key can't be null");
		}
		int i = rank(key);
		for (int j = i; j < N - 1; j++) {
			keys[j] = keys[j + 1];
			values[j] = values[j + 1];
		}
		keys[N - 1] = null;
		values[N - 1] = null;
		N--;

	}

	// 返回最小键
	public Key min() {
		return keys[0];
	}

	public Key max() {
		return keys[N - 1];
	}

	/**
	 * 根据下标找key
	 * 
	 * @param k
	 *            下标
	 * @return
	 */
	public Key select(int k) {
		return keys[k];
	}

	/**
	 * 大于等于该键的最小键
	 * 
	 * @param key
	 * @return
	 */
	public Key ceiling(Key key) {
		// 因为rank做了处理，所以即使未找到key人能返回刚好比key大的index
		int i = rank(key);
		return keys[i];

	}

	/**
	 * 小于等于该键的最大键
	 * 
	 * @param key
	 * @return
	 */
	public Key floor(Key key) {
		// 有该键
		if (get(key) != null) {
			return keys[rank(key)];
		} else if (get(key) == null && rank(key) != 0) {// 不存在该键且rank(key)不再数组最左边
			return keys[rank(key) - 1];
		} else {
			return null;
		}

	}

	public static void main(String[] args) {
		BinarySearchST<String, Integer> st = new BinarySearchST<String, Integer>(10);
		st.put("A", 3);
		st.put("B", 2);
		st.put("C", 1);
		System.out.println(st.get("B"));
		System.out.println(st.ceiling("D"));// null
		st.delete("A");
		System.out.println(st.get("A"));// null
		System.out.println(st.floor("A"));// null

	}

}
