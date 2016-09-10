package Num2_5_02;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;

/**
 * P491 T08 args[0]=shellsST.txt
 * 因为每个结点不代表一个键，所以不能按照二叉树那种递归写，我的思路就是将所有的key保存到一个数组中，
 * 调用方法的时候通过二分查找获取index，从数组中取出符合条件的key
 * 
 * @author he
 *
 */

class TrieS<Value> {

	private static final int R = 256;
	private Node root;
	private String temp[];// 保存键的数组
	private int N;
	private boolean change = true;// 用于判断在调用了array（）方法后是否发生了添加或删除操作

	private static class Node {
		Object val;
		Node next[] = new Node[R];
	}

	public void put(String key, Value val) {
		root = put(root, key, val, 0);
	}

	private Node put(Node x, String key, Value val, int d) {
		if (x == null) {
			x = new Node();
		}
		if (d == key.length()) {
			if (x.val == null)
				N++;
			x.val = val;
			change = true;
			return x;
		}
		char c = key.charAt(d);
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
		char c = key.charAt(d);
		return get(x.next[c], key, d + 1);

	}

	public void delete(String key) {
		root = delete(root, key, 0);
	}

	private Node delete(Node x, String key, int d) {
		if (x == null)
			return null;
		if (d == key.length()) {
			x.val = null;
			change = true;
		} else {
			char c = key.charAt(d);
			x.next[c] = delete(x.next[c], key, d + 1);
		}
		if (x.val != null)
			return x;
		for (char c = 0; c < R; c++)
			if (x.next[c] != null)
				return x;
		return null;

	}

	public Iterable<String> keys() {
		return keysWithPrefix("");
	}

	public Iterable<String> keysWithPrefix(String pre) {
		Queue<String> q = new Queue<String>();
		collect(get(root, pre, 0), pre, q);
		return q;
	}

	private void collect(Node x, String pre, Queue<String> q) {
		if (x == null)
			return;
		if (x.val != null)
			q.enqueue(pre);
		for (char c = 0; c < R; c++)
			collect(x.next[c], pre + c, q);
	}

	// 给temp数组赋值
	private void array() {
		// 数组是有序的，见collect的实现就是按照有序顺序进行的递归（升序）
		if (change || temp == null) {
			temp = new String[N];
			int ind = 0;
			for (String t : keys()) {
				temp[ind++] = t;
			}
		}
	}

	// 向上取整
	public String ceiling(String key) {
		array();
		int j = sel(temp, key);
		if (j >= N)
			throw new RuntimeException("未找到符合的键");
		return temp[j];
	}

	// 向下取整
	public String floor(String key) {
		array();
		int j = sel(temp, key);
		if (temp[j].compareTo(key) == 0)// 匹配到
			return temp[j];
		if (j - 1 < 0)// 未找到j可能为0
			throw new RuntimeException("未找到符合的键");
		return temp[j - 1];

	}

	// 小于key的键的数量
	public int rank(String key) {
		array();
		int j = sel(temp, key);
		return j;
	}

	public String select(int k) {
		if (k < 0 || k >= N)
			throw new RuntimeException("请输入有效排名");
		array();
		return temp[k];
	}

	// 二分查找
	private int sel(String[] t, String key) {
		int lo = 0, hi = N - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int cmp = key.compareTo(t[mid]);
			// System.out.println(" drr"+"z".compareTo("the"));
			if (cmp < 0)
				hi = mid - 1;
			else if (cmp > 0)
				lo = mid + 1;
			else
				return mid;
		}
		return lo;
	}

}

public class Num_5_02_08 {
	public static void main(String[] args) {
		TrieS<Integer> t = new TrieS<Integer>();
		In in = new In(args[0]);
		int i = 0;
		while (!in.isEmpty()) {
			String key = in.readString();
			t.put(key, i++);
		}
		System.out.println(t.get("shells"));
		// t.delete("shells");
		System.out.println("ceiling:" + t.ceiling("sh"));
		System.out.println("floor:" + t.floor("sh"));
		// System.out.println(t.get("shells"));
		System.out.println("rank:" + t.rank("she"));
		t.put("tha", 10);
		System.out.println("select:" + t.select(6));
	}

}
