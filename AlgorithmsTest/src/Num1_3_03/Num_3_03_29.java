package Num1_3_03;

/**
 * P289 T29 以左结点大于右结点表示红连接,颜色变换就是交换左右连接
 * 
 * @author he
 *
 */

class BRBST<Key extends Comparable<Key>, Value> {

	private Node root;

	private class Node {
		private Key key;
		private Value value;
		private Node left, right;
		private int N;

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

	private Node rotateLeft(Node h) {
		Node t = h.right;
		h.right = t.left;
		t.left = h;

		t.N = h.N;
		h.N = size(h.left) + size(h.right) + 1;
		return t;
	}

	private Node rotateRight(Node h) {
		Node t = h.left;
		h.left = t.right;
		t.right = h;

		t.N = h.N;
		h.N = size(h.left) + size(h.right) + 1;
		return t;
	}

	private boolean isRed(Node h) {
		if (h == null)
			return false;
		if (h.left == null || h.right == null)
			return false;
		return h.left.key.compareTo(h.right.key) >= 0;
	}

	private void flipColors(Node h) {
		Key tmp;
		// 交换结点
		tmp = h.left.left.key;
		h.left.left.key = h.left.right.key;
		h.left.right.key = tmp;

		tmp = h.right.left.key;
		h.right.left.key = h.right.right.key;
		h.right.right.key = tmp;

		tmp = h.left.key;
		h.left.key = h.right.key;
		h.right.key = tmp;

	}

	public void put(Key key, Value value) {
		root = put(root, key, value);
	}

	private Node put(Node x, Key key, Value value) {
		if (x == null)
			return new Node(key, value, 1);
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			x.left = put(x.left, key, value);
		else if (cmp > 0)
			x.right = put(x.right, key, value);
		else
			x.value = value;

		if (!isRed(x.left) && isRed(x.right))
			x = rotateLeft(x);
		if (isRed(x.left) && isRed(x.left.left))
			x = rotateRight(x);
		if (isRed(x.left) && isRed(x.right))
			flipColors(x);

		x.N = size(x.left) + size(x.right) + 1;
		return x;

	}

	public Value get(Key key) {
		return get(root, key);
	}

	private Value get(Node x, Key key) {
		if (x == null)
			return null;
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			return get(x.left, key);
		else if (cmp > 0)
			return get(x.right, key);
		else
			return x.value;
	}

}

public class Num_3_03_29 {
	public static void main(String[] args) {
		BRBST<String, Integer> b = new BRBST<String, Integer>();
		b.put("A", 1);
		b.put("B", 3);
		b.put("A", 2);
		b.put("C", 4);
		b.put("D", 5);
		System.out.println(b.get("C"));
	}

}
