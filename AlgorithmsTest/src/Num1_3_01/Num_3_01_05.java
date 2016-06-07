package Num1_3_01;

import edu.princeton.cs.algs4.Stack;

/**
 * P246T5
 * 
 * @author he
 *
 */

class SequentialSearchST<Key, Value> {
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

	/**
	 * 根据键删除指定键值对
	 * 
	 * @param key
	 */
	public void delete(Key key) {
		if (key == null) {
			throw new NullPointerException("key can't be null");
		}

		for (Node x = first; x.next != null; x = x.next) {
			if (x.next.key.equals(key)) {
				x.next.value = null;
				x.next = x.next.next;
				N--;
			}
		}
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
}

public class Num_3_01_05 {
	public static void main(String[] args) {
		SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
		st.put("A", 3);
		st.put("B", 2);
		st.put("C", 1);

		System.out.println(st.get("A"));//3
		st.delete("B");
		System.out.println(st.size());// 2
		System.out.println(st.get("B"));// null

		for (String s : st.keys()) {
			System.out.println(s);
		}
	}
}
