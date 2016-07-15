package Num1_3_05;

import edu.princeton.cs.algs4.StdRandom;

/**
 * P326 T09 用String类型保存Value值，命中则将值连接,get时返回随机值
 * 
 * @author he
 *
 */

class BST<Key extends Comparable<Key>> {

	private Node root;

	private class Node {
		int N;// 结点个数
		Key key;
		String value;
		Node left, right;

		public Node(Key key, String value, int N) {
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

	public void put(Key key, String value) {
		root = put(root, key, value);
	}

	private Node put(Node x, Key key, String value) {
		if (x == null)
			return new Node(key, value, 1);
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			x.left = put(x.left, key, value);
		else if (cmp > 0)
			x.right = put(x.right, key, value);
		else
			x.value = x.value + "." + value;

		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}

	//将值切分出来并取随机值
	private String random(String s) {
		String t[] = s.split("\\.");
		int N = t.length;
		return t[StdRandom.uniform(N)];
	}

	public String get(Key key) {
		return get(root, key);

	}

	
	private String get(Node x, Key key) {
		if (x == null)
			return null;
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			return get(x.left, key);
		else if (cmp > 0)
			return get(x.right, key);
		else
			//命中返回随机值
			return random(x.value);
	}

	public Key min() {
		return min(root).key;
	}

	private Node min(Node x) {
		if (x.left == null)
			return x;
		else
			return min(x.left);
	}

	public void deleteMin() {
		root = deleteMin(root);
	}

	private Node deleteMin(Node x) {
		if (x.left == null)
			return x.right;
		x.left = deleteMin(x.left);
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}

	public void delete(Key key) {
		root = delete(root, key);
	}

	private Node delete(Node x, Key key) {
		if (x == null)
			return null;
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			x.left = delete(x.left, key);
		else if (cmp > 0)
			x.right = delete(x.right, key);
		else {
			if (x.right == null)
				return x.left;
			if (x.left == null)
				return x.right;
			Node t = x;
			x = min(t.right);
			x.left = t.left;
			x.right = deleteMin(t.right);

		}
		x.N = size(x.left) + size(x.right) + 1;
		return x;

	}

}

public class Num_3_05_09 {
	public static void main(String[] args) {
		BST<String> bst = new BST<String>();
		bst.put("S", "0");
		bst.put("E", "1");
		bst.put("A", "2");
		bst.put("C", "3");
		bst.put("R", "4");
		bst.put("X", "5");
		bst.put("M", "6");
		bst.put("M", "7");
		bst.put("M", "8");
		bst.put("M", "9");
		bst.put("M", "10");
		bst.put("M", "11");
		System.out.println(bst.get("E"));
		System.out.println(bst.get("M"));
		System.out.println(bst.min());
		bst.deleteMin();
		bst.delete("M");
		System.out.println(bst.get("M"));
	}

}
