package Num2_5_02;

import edu.princeton.cs.algs4.In;

/**
 * P490 T5 非递归版的TrieST args[0]:shellsST.txt
 * 	
 * @author he
 *
 */
public class TrieST<Value> {
	private static final int R = 256;
	private Node root;
	private int N;

	private static class Node {
		private Object val;
		Node next[] = new Node[R];
	}

	public void put(String key, Value val) {
		if (root == null) {
			root = new Node();
		}
		put(root, key, val, 0);
	}

	// put 操作非递归实现
	private void put(Node x, String key, Value val, int d) {
		while (d < key.length()) {
			char c = key.charAt(d);
			if (x.next[c] == null)// 防止被覆盖
				x.next[c] = new Node();
			x = x.next[c];
			d++;
		}
		if (d == key.length()) {
			if (x.val == null)
				N++;
			x.val = val;
		}

	}

	@SuppressWarnings("unchecked")
	public Value get(String key) {
		Node x = get(root, key, 0);
		if (x == null)
			return null;
		return (Value) x.val;
	}

	//get 非递归实现
	private Node get(Node x, String key, int d) {
		while (d < key.length()) {
			if (x == null)
				return null;
			char c = key.charAt(d);
			x = x.next[c];
			d++;
		}
		return x;
	}

	public int size() {
		return N;
	}

	public static void main(String[] args) {
		TrieST<Integer> t = new TrieST<Integer>();
		In in = new In(args[0]);
		In in2 = new In(args[0]);
		int i = 0;
		while (!in.isEmpty()) {
			String key = in.readString();
			t.put(key, i++);
		}

		while (!in2.isEmpty()) {
			String key = in2.readString();
			System.out.println(key + "---->" + t.get(key));
		}

		System.out.println(t.size());

	}

}
