package Num1_3_02;

import java.util.HashSet;
import java.util.Set;

import org.omg.PortableInterceptor.IORInterceptor;

import edu.princeton.cs.algs4.Queue;

/**
 * P266 T29 T30 T31 T32 T33
 * 
 * @author he
 *
 */

class BST3<Key extends Comparable<Key>, Value> {
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

	// 根据key返回index
	public int rank(Key key) {
		return rank(root, key);
	}

	private int rank(Node x, Key key) {
		if (x == null)
			return 0;
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			return rank(x.left, key);
		else if (cmp > 0)
			return 1 + size(x.left) + rank(x.right, key);
		else
			return size(x.left);
	}

	public Iterable<Key> keys() {
		return keys(min(), max());
	}

	public Iterable<Key> keys(Key lo, Key hi) {
		Queue<Key> queue = new Queue<Key>();
		keys(root, queue, lo, hi);
		return queue;
	}

	private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
		if (x == null)
			return;
		int cmplo = lo.compareTo(x.key);
		int cmphi = hi.compareTo(x.key);

		if (cmplo < 0)
			keys(x.left, queue, lo, hi);
		if (cmplo <= 0 && cmphi >= 0)
			queue.enqueue(x.key);
		if (cmphi > 0)
			keys(x.right, queue, lo, hi);
	}

	// 等值键检查 检查key是否有重复的 ,T33是这个答案
	private boolean hasNoDuplicates() {
		return hasNoDuplicates(root);
	}

	/**
	 * @param x
	 * @return
	 */
	private boolean hasNoDuplicates(Node x) {
		for (int i = 0; i < size(); i++) {
			if (i != rank(select(i)))
				return false;
		}
		for (Key key : keys())
			if (key.compareTo(select(rank(key))) != 0)
				return false;
		return true;
	}

	// 有序性检查
	private boolean isOrdered() {
		return isOrdered(root, null, null);
	}

	private boolean isOrdered(Node x, Key min, Key max) {
		if (x == null)
			return true;
		if (min != null && x.key.compareTo(min) <= 0)
			return false;
		if (max != null && x.key.compareTo(max) >= 0)
			return false;
		return isOrdered(x.left, min, x.key) && isOrdered(x.right, x.key, max);
	}

	// 二叉树检查
	private boolean isBinaryTree() {
		return isBinaryTree(root);
	}

	private boolean isBinaryTree(Node x) {
		if (x == null)
			return true;
		if (x.N != size(x.left) + size(x.right) + 1)
			return false;
		return isBinaryTree(x.left) && isBinaryTree(x.right);
	}

	// 验证结点是否为根结点
	public boolean isBST() {
		if (!isBinaryTree()) {
			System.out.println("二叉树检查错误");
			return false;
		}
		if (!isOrdered()) {
			System.out.println("有序性检查错误");
			return false;
		}
		if (!hasNoDuplicates()) {
			System.out.println("等值键检查错误");
			return false;
		}
		return true;
	}

}

public class Num_3_02_29_30_31_32_33 {
	public static void main(String[] args) {
		BST3<String, Integer> b = new BST3<String, Integer>();
		b.put("E", 0);
		b.put("D", 1);
		b.put("A", 2);
		b.put("A", 6);
		b.put("Q", 3);
		b.put("T", 5);
		b.put("M", 22);
		b.put("X", 22);
		System.out.println(b.get("A"));
		System.out.println(b.keys());
		System.out.println(b.isBST());//true

	}

}
