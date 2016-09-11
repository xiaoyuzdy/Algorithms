package Num2_5_02;

import edu.princeton.cs.algs4.In;

/**
 * P491 T09 args[0]:shellsST.txt
 * 
 * @author he
 *
 */

class TST<Value> {
	private Node root;
	private int N;

	private class Node {
		char c;// 当前结点保存的字符
		Node left, mid, right;
		Value val;
	}

	public void put(String key, Value value) {
		root = put(root, key, value, 0);
	}

	private Node put(Node x, String key, Value value, int d) {
		char c = key.charAt(d);
		if (x == null) {
			x = new Node();
			x.c = c;
		}

		if (c < x.c)
			x.left = put(x.left, key, value, d);
		else if (c > x.c)
			x.right = put(x.right, key, value, d);
		else if (d < key.length() - 1)
			x.mid = put(x.mid, key, value, d + 1);
		else {
			if (x.val == null)
				N++;
			x.val = value;
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

	// 所有以s为前缀的键
	public Iterable<String> keysWithPrefix() {
			
	}
	
	private void collect(){
		
	}
	
	
	// 所有和s匹配的键(其中"."能匹配任意字符)
	public Iterable<String> keysThatMath(String s) {

	}

}

public class Num_5_02_09 {
	public static void main(String[] args) {
		TST<Integer> tst = new TST<Integer>();
		In in = new In(args[0]);
		int i = 0;
		while (!in.isEmpty()) {
			String key = in.readString();
			tst.put(key, i++);
		}
		System.out.println(tst.get("shells"));
	}

}
