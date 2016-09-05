package Number_5;

import edu.princeton.cs.algs4.In;

/**
 * P486 算法5.5 基于三向单词查找树的符号表
 * args[0]:shellsST.txt
 * @author he
 *
 */
public class TST<Value> {
	private Node root;// 根结点
	private int N;//

	private class Node {
		char c;// 每个结点中保存的字符
		Node left, mid, right;
		Value val;
	}

	public void put(String key, Value val) {
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

	public static void main(String[] args) {
		TST<Integer> tst = new TST<Integer>();
		In in = new In(args[0]);
		int i = 0;
		while (!in.isEmpty()) {
			String key = in.readString();
			tst.put(key, i++);
		}
		System.out.println(tst.size());

	}

}
