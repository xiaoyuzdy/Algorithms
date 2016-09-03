package Number_5;

import edu.princeton.cs.algs4.In;

/**
 * P479 算法5.4 基于单词查找树的符号表
 * 
 * args[0]:shellsST.txt
 * 
 * @author he
 *
 */
public class TrieST<Value> {
	private static final int R = 256;// 字母表的大小，8位的ASCII表中元素个数
	private Node root;// 单词查找树的根结点
	private int N;// 查找树中键的数量

	public TrieST() {
	}

	private static class Node {
		private Object val;// 键对应的值
		private Node next[] = new Node[R];// 保存指向其他Node对象的引用

	}

	public void put(String key, Value val) {
		root = put(root, key, val, 0);
	}

	private Node put(Node x, String key, Value val, int d) {
		if (x == null)
			x = new Node();
		// 将值保存到键的最后一个字符所在结点
		if (d == key.length()) {
			if (x.val == null)
				N++;
			x.val = val;
			return x;
		}
		char c = key.charAt(d);// 找到d个字符对应的子单词查找树
		x.next[c] = put(x.next[c], key, val, d + 1);
		return x;
	}

	@SuppressWarnings("unchecked")
	public Value get(String key) {
		Node x = get(root, key, 0);
		if (x == null)
			return null;
		return (Value) x.val;
	}

	private Node get(Node x, String key, int d) {
		if (x == null)
			return null;
		if (d == key.length())
			return x;
		char c = key.charAt(d);// 找到d个字符所对应的子单词查找树
		return get(x.next[c], key, d + 1);
	}

	public int size() {
		return N;
	}

	/**
	 * public int size() { return size(root); }
	 * 
	 * private int size(Node x) { if (x == null) return 0; int cn = 0; if (x.val
	 * != null) cn++; for (char r = 0; r < R; r++) cn += size(x.next[r]); return
	 * cn;
	 * 
	 * }
	 * 
	 * 
	 */

	public static void main(String[] args) {
		TrieST<Integer> trieST = new TrieST<Integer>();
		In in = new In(args[0]);
		int i = 0;
		while (!in.isEmpty()) {
			String key = in.readString();
			System.out.println(key);
			trieST.put(key, i++);
		}

		System.out.println(trieST.get("sea"));

	}

}
