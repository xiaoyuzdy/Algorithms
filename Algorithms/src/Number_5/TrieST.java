package Number_5;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;

/**
 * P479 算法5.4 基于单词查找树的符号表 注意：除了d==key.length对应的数组保存的结点有值其他所有的结点不保存值的，如key-->she
 * 对应的值为0，'s' 'h' 'e'
 * 对应只是数组的下标(字符转化为十进制数)而已而不是Node.c=s，书中化的图那一个圆圈代表的是数组中的一个元素且index=s(转换为十进制)
 * args[0]:shellsST.txt
 * 只有R向的单词查找树具有唯一性
 * @author he
 *
 */
public class TrieST<Value> {
	private static final int R = 256;// 字母表的大小，8位的ASCII表中元素个数
	private Node root;// 单词查找树的根结点,root.val==null
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

	/*
	 * 返回单词查找树中所有的键
	 */
	public Iterable<String> keys() {
		return keysWithPrefix("");

	}

	/**
	 * 返回所有以pre为前缀的键 比如单词查找树中有“shells”,pre为"shel"则返回shells
	 * 
	 * @param pre
	 * @return
	 */
	public Iterable<String> keysWithPrefix(String pre) {
		Queue<String> q = new Queue<String>();
		collect(get(root, pre, 0), pre, q);
		return q;
	}

	// 匹配以pre为前缀的键
	private void collect(Node x, String pre, Queue<String> q) {
		if (x == null)
			return;
		if (x.val != null)
			q.enqueue(pre);
		for (char c = 0; c < R; c++)
			collect(x.next[c], pre + c, q);

	}

	/**
	 * 所有和pat匹配的键，其中“.”表示能够匹配任意字符 比如单词查找树中有“shells”,pre为"shel.."则返回shells
	 * 
	 * @param pat
	 * @return
	 */
	public Iterable<String> keysThatMath(String pat) {
		Queue<String> q = new Queue<String>();
		collect(root, "", pat, q);
		if (q.size() == 0)
			throw new RuntimeException("未找到匹配项");
		return q;
	}

	private void collect(Node x, String pre, String pat, Queue<String> q) {
		if (x == null)
			return;
		int d = pre.length();
		if (d == pat.length() && x.val != null)
			q.enqueue(pre);
		// 未匹配到
		if (d == pat.length())
			return;
		char next = pat.charAt(d);
		for (char c = 0; c < R; c++)
			if (next == '.' || next == c)
				collect(x.next[c], pre + c, pat, q);
	}

	/**
	 * 返回s的前缀中最长的键,比如单词查找树中有"she"，则s="shell"，返回"she"
	 * 
	 * @param s
	 * @return
	 */
	public String longestPrefixOf(String s) {
		int length = search(root, s, 0, 0);// 单词查找树中与s匹配的key的最大长度
		return s.substring(0, length);

	}

	// 记录查找与s相关的路径上所找到的最长键的长度
	private int search(Node x, String s, int d, int length) {
		if (x == null)
			return length;
		if (x.val != null)
			length = d;// 更新长度
		if (d == s.length())// 单词查找树中包含s
			return length;

		char c = s.charAt(d);
		return search(x.next[c], s, d + 1, length);

	}

	/**
	 * 删除操作
	 * 
	 * @param key
	 */
	public void delete(String key) {
		root = delete(root, key, 0);
	}

	private Node delete(Node x, String key, int d) {
		if (x == null)
			return null;
		// 匹配到要删除的键
		if (d == key.length())
			x.val = null;
		else {
			char c = key.charAt(d);
			x.next[c] = delete(x.next[c], key, d + 1);
		}
		// 非空结点不能删除
		if (x.val != null)
			return x;
		// 非空连接不能删除
		for (char c = 0; c < R; c++)
			if (x.next[c] != null)
				return x;
		// 该结点的值为null且所有的连接也为null
		return null;

	}

	public int size() {
		return N;
	}

	/**
	 * 书中框注中的方法：延时递归实现，很耗时 public int size() { return size(root); } private int
	 * size(Node x) { if (x == null) return 0; int cn = 0; if (x.val != null)
	 * cn++; for (char r = 0; r < R; r++) cn += size(x.next[r]); return cn;
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
			trieST.put(key, i++);
		}

		for (String s : trieST.keys())
			System.out.println(s);
		System.out.println("---------------");
		System.out.println(trieST.keysThatMath(".h."));
		System.out.println("longestPre:" + trieST.longestPrefixOf("shells"));
		trieST.delete("sea");
		for (String s : trieST.keys())
			System.out.println(s);
	}

}
