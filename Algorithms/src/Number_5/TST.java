package Number_5;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;

/**
 * P486 算法5.5 基于三向单词查找树的符号表 args[0]:shellsST.txt
 * 
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

	// s的前缀中最长的键
	public String longestPrefixOf(String s) {
		if (s == null || s.length() == 0)
			return null;
		int length = 0;
		Node x = root;
		int i = 0;
		while (x != null && i < s.length()) {
			char c = s.charAt(i);
			if (c < x.c)
				x = x.left;
			else if (c > x.c)
				x = x.right;
			else {
				// 命中
				i++;
				if (x.val != null)
					length = i;
				x = x.mid;
			}
		}
		return s.substring(0, length);

	}

	public Iterable<String> keys() {
		Queue<String> queue = new Queue<String>();
		collect(root, new StringBuilder(), queue);
		return queue;
	}

	// 所有以s为前缀的键
	public Iterable<String> keysWithPrefix(String prefix) {
		Queue<String> queue = new Queue<String>();
		Node x = get(root, prefix, 0);
		if (x == null)
			return queue;
		if (x.val != null)
			queue.enqueue(prefix);
		collect(x.mid, new StringBuilder(prefix), queue);
		return queue;
	}

	private void collect(Node x, StringBuilder prefix, Queue<String> queue) {
		if (x == null)
			return;
		collect(x.left, prefix, queue);
		if (x.val != null)
			queue.enqueue(prefix.toString() + x.c);
		collect(x.mid, prefix.append(x.c), queue);
		prefix.deleteCharAt(prefix.length() - 1);// 将记录过的key删除，回溯到最初的首字母
		collect(x.right, prefix, queue);
	}

	// 所有和s匹配的键(其中"."能匹配任意字符)
	public Iterable<String> keysThatMatch(String pattern) {
		Queue<String> queue = new Queue<String>();
		collect(root, new StringBuilder(), 0, pattern, queue);
		return queue;
	}

	private void collect(Node x, StringBuilder prefix, int i, String pattern, Queue<String> queue) {
		if (x == null)
			return;
		char c = pattern.charAt(i);
		if (c == '.' || c < x.c)
			collect(x.left, prefix, i, pattern, queue);
		if (c == '.' || c == x.c) {
			if (i == pattern.length() - 1 && x.val != null)
				queue.enqueue(prefix.toString() + x.c);
			if (i < pattern.length() - 1) {
				collect(x.mid, prefix.append(x.c), i + 1, pattern, queue);
				prefix.deleteCharAt(prefix.length() - 1);
			}
		}
		if (c == '.' || c > x.c)
			collect(x.right, prefix, i, pattern, queue);
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
		// System.out.println(tst.get(""));
		System.out.println("----------------------keys-------------");
		for (String key : tst.keys())
			System.out.println(key);

	}

}
