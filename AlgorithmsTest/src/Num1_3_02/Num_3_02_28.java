package Num1_3_02;

/**
 * P266 T28
 * 
 * @author he
 *
 */

class BST_28<Key extends Comparable<Key>, Value> {

	private Node root;
	private Node lately; // 记录最近访问的结点

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
		if (lately != null && lately.key.compareTo(key) == 0)
			lately.value = value;
		else
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

		if (lately != null && lately.key.compareTo(key) == 0) {
			return lately.value;
		}

		lately = get(root, key);
		return lately.value;
	}

	private Node get(Node x, Key key) {
		if (x == null)
			return null;
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			return get(x.left, key);
		else if (cmp > 0)
			return get(x.right, key);
		else
			return x;
	}

	// 最近访问的键值对
	public String lately() {
		return lately.key + "--" + lately.value;
	}

}

public class Num_3_02_28 {
	public static void main(String[] args) {
		BST_28<String, Integer> b = new BST_28<String, Integer>();
		b.put("E", 0);
		b.put("D", 1);
		b.put("A", 2);
		System.out.println(b.get("D"));
		System.out.println("lately " + b.lately());
		b.put("D", 10);
		System.out.println(b.get("D"));
		System.out.println(b.get("A"));
		System.out.println("lately " + b.lately());
	}

}
