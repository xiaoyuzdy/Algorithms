package Num1_3_02;

/**
 * P265 T14
 * 测试通过
 * @author he
 *
 */

class iterBST<Key extends Comparable<Key>, V> {

	private Node root;

	private class Node {
		Key key;
		V v;
		Node left, right;
		int N;

		public Node(Key key, V v, int N) {
			this.key = key;
			this.v = v;
			this.N = N;
		}
	}

	public int size() {
		return size(root);
	}

	private int size(Node x) {
		if (x == null) {
			return 0;
		} else {
			return x.N;
		}
	}

	public void put(Key key, V v) {
		root = put(root, key, v);
	}

	private Node put(Node x, Key key, V v) {
		if (x == null) {
			x = new Node(key, v, 1);
		}
		int cmp = key.compareTo(x.key);
		if (cmp < 0) {
			x.left = put(x.left, key, v);
		} else if (cmp > 0) {
			x.right = put(x.right, key, v);
		} else {
			x.v = v;
		}
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}

	public V get(Key key) {
		return get(root, key);
	}

	private V get(Node x, Key key) {
		if (x == null) {
			return null;
		}
		int cmp = key.compareTo(x.key);
		if (cmp < 0) {
			return get(x.left, key);
		} else if (cmp > 0) {
			return get(x.right, key);
		} else {
			return x.v;
		}
	}

	public Key min() {
		return min(root).key;
	}

	private Node min(Node x) {
		while (x.left != null) {
			x = x.left;
		}
		return x;
	}

	public Key max() {
		return max(root).key;
	}

	private Node max(Node x) {
		while (x.right != null) {
			x = x.right;
		}
		return x;
	}

	// 向下取整
	public Key floor(Key key) {
		Node x = root;
		while (x != null) {
			int cmp = key.compareTo(x.key);
			if (cmp < 0) {
				x = x.left;
			} else {
				Node t = x.right;
				if (t == null) {
					return x.key;
				} else if (t != null && t.key.compareTo(key) > 0) {
					return x.key;
				} else {
					x = x.right;
				}
			}
		}
		return null;
	}

	// 向上取整
	public Key ceiling(Key key) {
		Node x = root;
		while (x != null) {
			int cmp = key.compareTo(x.key);
			if (cmp > 0) {
				x = x.right;
			} else {
				Node t = x.left;
				if (t == null) {
					return x.key;
				} else if (t != null && t.key.compareTo(key) < 0) {
					return x.key;
				} else {
					x = x.left;
				}
			}
		}
		return null;
	}

	public Key select(int k) {
		Node x = root;
		while (x != null) {
			int t = size(x.left);
			if (t > k) {
				x = x.left;
			} else {
				if (size(x.left) == k) {
					return x.key;
				} else {
					x = x.right;
					k=k-t-1;
				}
			}
		}
		return null;
	}

}

public class Num_3_02_14 {
	public static void main(String[] args) {
		iterBST<String, Integer> b = new iterBST<String, Integer>();
		b.put("E", 0);
		b.put("D", 1);
		b.put("A", 2);
		b.put("A", 6);
		b.put("Q", 3);
		b.put("T", 5);
		b.put("M", 22);
		b.put("X", 9);
		System.out.println("floor: " + b.floor("H"));// E
		System.out.println("ceiling:" + b.ceiling("B"));// D
		System.out.println(b.min());
		System.out.println(b.max());
		System.out.println(b.get("A"));
		System.out.println("select: " + b.select(3));//M
	}
}
