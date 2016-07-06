package Num1_3_03;

/**
 * P290 T39 40 41
 * 
 * @author he
 *
 */

class RBBST<Key extends Comparable<Key>, Value> {

	private final static boolean RED = true;
	private final static boolean BLACK = false;

	private Node root;

	private class Node {
		Key key;
		Value value;
		Node left, right;
		int N;
		boolean color;

		public Node(Key key, Value value, int N, boolean color) {
			this.key = key;
			this.value = value;
			this.N = N;
			this.color = color;
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

	// 左旋转
	private Node rotateLeft(Node x) {
		Node t = x.right;
		x.right = t.left;
		t.left = x;

		t.color = x.color;
		x.color = RED;

		t.N = x.N;
		x.N = 1 + size(x.left) + size(x.right);

		return t;
	}

	private Node rotateRight(Node x) {
		Node t = x.left;
		x.left = t.right;
		t.right = x;

		t.color = x.color;
		x.color = RED;

		t.N = x.N;
		x.N = 1 + size(x.left) + size(x.right);

		return t;

	}

	private boolean isRed(Node x) {
		if (x == null)
			return false;
		return x.color == RED;
	}

	private void flipColors(Node h) {
		h.color = !h.color;
		h.left.color = !h.left.color;
		h.right.color = !h.right.color;

	}

	private Node min(Node x) {
		if (x.left == null)
			return x;
		return min(x.left);
	}

	public void put(Key key, Value value) {
		root = put(root, key, value);
		root.color = BLACK;
	}

	private Node put(Node x, Key key, Value value) {
		if (x == null) {
			return new Node(key, value, 1, RED);
		}

		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			x.left = put(x.left, key, value);
		else if (cmp > 0)
			x.right = put(x.right, key, value);
		else {
			x.value = value;
		}

		if (isRed(x.right) && !isRed(x.left))
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

	public boolean isEmpty() {
		return root == null;
	}

	// 使结点的左子树变为红色
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

	// 删除最小键，保证当前结点不是2-结点
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
		// 假设结点h为红色，h.right和h.right.left都是黑色
		// 将h.right或者h.right的子结点之一变红
		flipColors(h);
		if (!isRed(h.left.left))
			h = rotateRight(h);
		return h;
	}

	public void deleteMax() {
		if (!isRed(root.left) && isRed(root.right))
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
	 * 删除指定键值
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
			if (isRed(h.left) && !isRed(h.left.left))
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
			} else
				h.right = delete(h.right, key);
		}
		return balance(h);

	}

}

public class Num_3_03_39_40_41 {
	public static void main(String[] args) {
		RBBST<String, Integer> b = new RBBST<String, Integer>();
		b.put("A", 1);
		b.put("B", 3);
		b.put("A", 2);
		b.put("C", 4);
		b.put("D", 5);
		b.deleteMin();
		System.out.println(b.get("A"));
		b.deleteMax();
		System.out.println(b.size());
		System.out.println("C "+b.get("C"));
		b.delete("C");
		System.out.println("C "+b.get("C"));
	}

}
