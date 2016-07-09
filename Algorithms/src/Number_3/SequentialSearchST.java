package Number_3;

import edu.princeton.cs.algs4.Stack;

/**
 * 算法 3.1 P236 顺序查找（基于无序链表）
 * 
 * @author he
 *
 */
public class SequentialSearchST<Key, Value> {
	private Node first;// 链表首结点
	private int N; // 链表元素个数

	private class Node {
		Key key;
		Value value;
		Node next;

		public Node(Key key, Value value, Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}

	}

	/**
	 * 根据键获取值
	 * 
	 * @param key
	 * @return
	 */
	public Value get(Key key) {
		if (key == null) {
			throw new NullPointerException("key can't be null");
		}
		for (Node x = first; x != null; x = x.next) {
			if (x.key.equals(key)) {
				return x.value; // 命中
			}

		}
		return null;// 未命中
	}

	/**
	 * 向链表中添加新的键值对
	 * 
	 * @param key
	 * @param value
	 */
	public void put(Key key, Value value) {
		if (key == null) {
			throw new NullPointerException("key can't be null");
		}
		for (Node x = first; x != null; x = x.next) {
			if (key.equals(x.key)) {
				x.value = value;// 命中 更新value值
				return;
			}
		}
		first = new Node(key, value, first);// 未命中，新结点
		N++;
	}

	// 元素个数
	public int size() {
		return N;
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public boolean contains(Key key) {
		if (key == null)
			throw new NullPointerException("key 不能为null");
		return get(key) != null;
	}

	/**
	 * 根据键删除指定键值对
	 * 
	 * @param key
	 */
	public void delete(Key key) {
		if (key == null)
			throw new NullPointerException("key 不能为 null");
		first = delete(first, key);
	}

	private Node delete(Node x, Key key) {
		if (x == null) {
			return null;
		}
		if (x.key.equals(key)) {
			N--;
			return x.next;
		}
		x.next = delete(x.next, key);
		return x;
	}

	/**
	 * 因为链表的实现时以栈的形式，所以这里使用栈，这样就能保证return后得到的顺序数put时的顺序
	 * 
	 * @return
	 */
	public Iterable<Key> keys() {
		Stack<Key> stack = new Stack<Key>();
		for (Node x = first; x != null; x = x.next)
			stack.push(x.key);
		return stack;
	}

	public static void main(String[] args) {
		SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
		st.put("A", 3);
		st.put("B", 2);
		st.put("C", 1);

		System.out.println(st.get("A"));
		st.delete("A");
		System.out.println(st.size());// 2
		System.out.println(st.get("B"));// null

		for (String s : st.keys()) {
			System.out.print(s);
		}

	}

}
