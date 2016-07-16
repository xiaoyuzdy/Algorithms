package Num1_3_05;

import edu.princeton.cs.algs4.StdRandom;

/**
 * P326 T10 和T9思路一样
 * 
 * @author he
 *
 */

class BRBST<Key extends Comparable<Key>> {
	private final static boolean RED = true;
	private final static boolean BLACK = false;

	private Node root;

	private class Node {
		Key key;
		String value;
		int N;
		boolean color;
		Node left, right;

		public Node(Key key, String value, int N, boolean color) {
			this.key = key;
			this.value = value;
			this.N = N;
			this.color = color;
		}

	}

	private int size(Node x) {
		if (x == null)
			return 0;
		else
			return x.N;
	}

	private Node rotateLeft(Node h) {
		Node t = h.right;
		h.right = t.left;
		t.left = h;

		t.color = h.color;
		h.color = RED;

		t.N = h.N;
		h.N = size(h.left) + size(h.right) + 1;
		return t;
	}

	private Node rotateRight(Node h) {
		Node t = h.left;
		h.left = t.right;
		t.right = h;

		t.color = h.color;
		h.color = RED;

		t.N = h.N;
		h.N = size(h.left) + size(h.right) + 1;
		return t;

	}

	private void flipColors(Node h) {
		h.color = !h.color;
		h.left.color = !h.left.color;
		h.right.color = !h.right.color;
	}

	private boolean isRed(Node x) {
		if (x == null)
			return false;
		else
			return x.color == RED;
	}

	public void put(Key key, String value) {
		root = put(root, key, value);
		root.color = BLACK;
	}

	private Node put(Node x, Key key, String value) {
		if (x == null)
			return new Node(key, value, 1, RED);
		int cmp = key.compareTo(x.key);

		if (cmp < 0)
			x.left = put(x.left, key, value);
		else if (cmp > 0)
			x.right = put(x.right, key, value);
		else
			x.value = x.value + "." + value;

		if (!isRed(x.left) && isRed(x.right))
			x = rotateLeft(x);
		if (isRed(x.left) && isRed(x.left.left))
			x = rotateRight(x);
		if (isRed(x.left) && isRed(x.right))
			flipColors(x);

		x.N = size(x.right) + size(x.left) + 1;
		return x;

	}

	// 将值切分出来并取随机值
	private String random(String s) {
		String t[] = s.split("\\.");
		int N = t.length;
		return t[StdRandom.uniform(N)];
	}

	public String get(Key key) {
		return get(root, key);
	}

	private String get(Node x, Key key) {
		if (x == null)
			return null;
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			return get(x.left, key);
		else if (cmp > 0)
			return get(x.right, key);
		else
			return random(x.value);

	}
	
	public Key min() {
		return min(root).key;
	}

	private Node min(Node x) {
		if (x.left == null)
			return x;
		else
			return min(x.left);
	}

	public boolean isEmpty() {
		return root == null;
	}

	/**
	 * 使结点的左子树变为红树
	 * 
	 * @param h
	 * @return
	 */
	private Node moveRedLeft(Node h) {
		// 假设结点h为红色,h.left和h.left.left都是黑色
		// 将h.left或者h.left的子结点之一变红
		flipColors(h);
		if (isRed(h.right.left)) {
			h.right = rotateRight(h.right);
			h = rotateLeft(h);
		}
		return h;
	}

	// 保证树的平衡
	private Node balance(Node h) {
		if (isRed(h.right))
			h = rotateLeft(h);
		if (isRed(h.left) && isRed(h.left.left))
			h = rotateRight(h);
		if (isRed(h.left) && isRed(h.right))
			flipColors(h);

		h.N = size(h.left) + size(h.right) + 1;
		return h;

	}

	/**
	 * 删除最小键，保证当前结点不是2-结点
	 */
	public void deleteMin() {
		if (!isRed(root.left) && !isRed(root.right))
			root.color = RED;
		root = deleteMin(root);
		if (!isEmpty())
			root.color = BLACK;
	}

	private Node deleteMin(Node h) {
		if (h.left == null)
			return null;
		if (!isRed(h.left) && !isRed(h.left.left))
			h = moveRedLeft(h);
		h.left = deleteMin(h.left);
		return balance(h);
	}

	private Node moveRedRight(Node h) {
		// 假设h结点为红,h.right和h.right.left为黑
		// 将h.right或h.right的子结点变红
		flipColors(h);
		if (isRed(h.left.left))
			h = rotateRight(h);
		return h;
	}

	/**
	 * 删除最大键保证当前节点不是2-结点
	 * 
	 */
	public void deleteMax() {
		if (!isRed(root.left) && !isRed(root.right))
			root.color = RED;
		root = deleteMax(root);
		if (!isEmpty())
			root.color = BLACK;
	}

	private Node deleteMax(Node h) {
		if (isRed(h.left))
			h = rotateRight(h);
		if (h.right == null)
			return null;
		if (!isRed(h.right) && !isRed(h.right.left))
			h = moveRedRight(h);
		h.right = deleteMax(h.right);
		return balance(h);

	}

	/**
	 * 删除指定的键
	 * 
	 * @param key
	 */
	public void delete(Key key) {
		if (!isRed(root.left) && !isRed(root.right))
			root.color = RED;
		root = delete(root, key);
		if (!isEmpty())
			root.color = BLACK;

	}

	private Node delete(Node h, Key key) {
		if (key.compareTo(h.key) < 0) {
			if (!isRed(h.left) && !isRed(h.left.left))
				h = moveRedLeft(h);
			h.left = delete(h.left, key);
		} else {
			if (isRed(h.left))
				h = rotateRight(h);
			if (key.compareTo(h.key) == 0 && h.right == null)
				return null;
			if (!isRed(h.right) && !isRed(h.right.left))
				h = moveRedRight(h);
			if (key.compareTo(h.key) == 0) {
				h.value = get(h.right, min(h.right).key);
				h.key = min(h.right).key;
				h.right = deleteMin(h.right);
			} else {
				h.right = delete(h.right, key);
			}

		}
		return balance(h);
	}
	
	
}

public class Num_3_05_10 {
	public static void main(String[] args) {
		BRBST<String> bst = new BRBST<String>();
		bst.put("S", "0");
		bst.put("E", "1");
		bst.put("A", "2");
		bst.put("C", "3");
		bst.put("R", "4");
		bst.put("X", "5");
		bst.put("M", "6");
		bst.put("M", "7");
		bst.put("M", "8");
		bst.put("M", "9");
		bst.put("M", "10");
		bst.put("M", "11");
		System.out.println(bst.get("E"));
		System.out.println(bst.get("M"));
		System.out.println(bst.min());
		bst.deleteMin();
		bst.delete("M");
		System.out.println(bst.min());
		System.out.println(bst.get("M"));
	}
}
