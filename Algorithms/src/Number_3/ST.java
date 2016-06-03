package Number_3;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

/**
 * P231 有序符号表，借助TreeMap
 * 
 * @author he
 *
 */
public class ST<Key extends Comparable<Key>, Value> implements Iterable<Key> {
	private TreeMap<Key, Value> st;

	public ST() {
		st = new TreeMap<Key, Value>();
	}

	/**
	 * 将键值对存入表中
	 * 
	 * @param key
	 * @param value
	 */
	public void put(Key key, Value value) {
		if (key == null) {
			throw new NullPointerException("key can't be null");
		}
		if (value == null) {
			st.remove(key);
		}
		st.put(key, value);
	}

	/**
	 * 获取key对应的值，如果不存在返回空
	 * 
	 * @param key
	 * @return
	 */
	public Value get(Key key) {
		return st.get(key);
	}

	/**
	 * 删除键key及其对应的值
	 * 
	 * @param key
	 */
	public void delete(Key key) {
		if (key == null) {
			throw new NullPointerException("key can't be null");
		}
		st.remove(key);
	}

	public boolean contains(Key key) {
		return st.containsKey(key);
	}

	public boolean isEmpty() {
		return st.isEmpty();
	}

	public int size() {
		return st.size();
	}

	public Key min() {
		return st.firstKey();
	}

	public Key max() {
		return st.lastKey();
	}

	/**
	 * 向下取整
	 * 
	 * @param key
	 * @return
	 */
	public Key floor(Key key) {
		return st.floorKey(key);
	}

	/**
	 * 向上取整
	 * 
	 * @param key
	 * @return
	 */
	public Key ceiling(Key key) {
		return st.ceilingKey(key);
	}

	/**
	 * 小于key的键的数量
	 * 
	 * @param key
	 * @return
	 */
	public int rank(Key key) {
		if (key == null) {
			throw new NullPointerException("key can't be null");
		}
		return st.headMap(key).size();
	}

	/**
	 * 排名为k的键
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Key select(int k) {
		if (k < 0 || k >= size()) {
			throw new RuntimeException("the k is bad");
		}
		Set<Key> set = st.keySet();
		Object t[] = set.toArray();
		return (Key) t[k];
	}

	/**
	 * 删除最小的键
	 */
	public void deleteMin() {
		if (st.size() == 0) {
			throw new RuntimeException("the key is null");
		}
		delete(min());
	}

	/**
	 * 删除最大的键
	 */
	public void deleteMax() {
		if (st.size() == 0) {
			throw new RuntimeException("the key is null");
		}
		delete(max());
	}

	public Iterable<Key> key() {
		return st.keySet();
	}

	/**
	 * 返回键的集合
	 * 
	 * @return
	 */
	public Iterator<Key> iterator() {
		return st.keySet().iterator();
	}

	public static void main(String[] args) {
		ST<String, Integer> st = new ST<String, Integer>();
		st.put("A", 3);
		st.put("B", 2);
		st.put("C", 1);

		System.out.println("index of 0:" + st.select(0));
		System.out.println("max key:" + st.max());
		System.out.println("the index of key=B:" + st.rank("B"));// 1
		st.deleteMax();
		System.out.println("size: " + st.size());

		for (String s : st.key()) {
			System.out.println(s);
		}
	}

}
