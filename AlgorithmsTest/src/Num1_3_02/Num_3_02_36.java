package Num1_3_02;

import edu.princeton.cs.algs4.Queue;

/**
 * P267 T36
 * 
 * @author he
 *
 */

class BST4<Key extends Comparable<Key>, Value> {
	private Node root;

	private class Node {
		Key key;
		Value value;
		Node left, right;
		int N;

		public Node(Key key, Value value, int N) {
			this.key = key;
			this.value = value;
			this.N = N;
		}
	}

	public int size() {
		return size(root);
	}

	private int size(Node x) {
		if (x == null)
			return 0;
		else
			return x.N;
	}

	public void put(Key key, Value value) {
		root = put(root, key, value);
	}

	private Node put(Node x, Key key, Value value) {
		if (x == null) {
			x = new Node(key, value, 1);
		}
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			x.left = put(x.left, key, value);
		else if (cmp > 0)
			x.right = put(x.right, key, value);
		else
			x.value = value;
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}

	public Value get(Key key) {
		return get(root, key);
	}

	private Value get(Node x, Key key) {
		if (x == null) {
			return null;
		}

		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			return get(x.left, key);
		else if (cmp > 0)
			return get(x.right, key);
		else
			return x.value;

	}

	// 返回最小键
	public Key min() {
		return min(root).key;
	}

	private Node min(Node x) {
		if (x.left == null) {
			return x;
		}
		return min(x.left);
	}

	// 返回最大键
	public Key max() {
		return max(root).key;
	}

	private Node max(Node x) {
		if (x.right == null) {
			return x;
		} else {
			return max(x.right);
		}
	}

	public Key select(int k) {
		return select(root, k);
	}

	private Key select(Node x, int k) {
		if (x == null)
			return null;
		int t = size(x.left);
		if (t > k) {
			return select(x.left, k);
		} else if (t < k) {
			return select(x.right, k - t - 1);
		} else {
			return x.key;
		}
	}

	public Iterable<Key> keys() {
		return keys(min(), max());
	}

	public Iterable<Key> keys(Key lo, Key hi) {
		Queue<Key> queue = new Queue<Key>();
		keys(queue, root, lo, hi);
		return queue;
	}

	private void keys(Queue<Key> queue, Node x, Key lo, Key hi) {
		for (int i = 0; i < size(); i++) {
			if (select(i).compareTo(lo) >= 0 && select(i).compareTo(hi) <= 0)
				queue.enqueue(select(i));
		}
	}

}

public class Num_3_02_36 {
	public static void main(String[] args) {
		BST4<String, Integer> b = new BST4<String, Integer>();
		b.put("E", 0);
		b.put("D", 1);
		b.put("A", 2);
		b.put("A", 6);
		b.put("Q", 3);
		b.put("T", 5);
		b.put("M", 22);
		b.put("X", 22);
		System.out.println(b.keys());
	}

}
