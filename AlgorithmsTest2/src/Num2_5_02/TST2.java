package Num2_5_02;

public class TST2<Value> {
	private Node root;// 根结点
	private int N;//
	private String firstKey;// 保存第一个添加的key

	private class Node {
		char c;// 每个结点中保存的字符
		Node left, mid, right;
		Value val;
	}

	public void put(String key, Value val) {
		if (firstKey == null)
			firstKey = key;
		root = put(root, key, val, 0);
	}

	private Node put(Node x, String key, Value val, int d) {
		char c = key.charAt(d);
		if (x == null) {
			x = new Node();
			x.c = c;
		}

		if (c < x.c)
			x.left = put(x.left, key, val, d);
		else if (c > x.c)
			x.right = put(x.right, key, val, d);
		else if (d < key.length() - 1)// d=0表示的是根结点
			x.mid = put(x.mid, key, val, d + 1);
		else {
			if (x.val == null)
				N++;
			x.val = val;
		}
		return x;
	}

	public Value get(String key) {
		if (key == null)
			throw new NullPointerException();
		if (key.length() == 0)
			throw new IllegalArgumentException("key must have length >= 1");
		Node x = get(root, key, 0);
		if (x == null)
			return null;
		return x.val;
	}

	private Node get(Node x, String key, int d) {
		if (x == null)
			return null;
		char c = key.charAt(d);
		if (c < x.c)
			return get(x.left, key, d);
		else if (c > x.c)
			return get(x.right, key, d);
		else if (d < key.length() - 1)
			return get(x.mid, key, d + 1);
		else
			return x;
	}

	public int size() {
		return N;
	}

	public boolean contains(String key) {
		return get(key) != null;
	}

	public String firstKey() {
		return firstKey;
	}

}
