package Num1_3_02;

import java.util.HashSet;
import java.util.Set;

import edu.princeton.cs.algs4.Queue;

/**
 * P266 T31
 * 
 * @author he
 *
 */

class BST3<Key extends Comparable<Key>, Value> {
	private Node root;

	private class Node {
		Key key;
		Value value;
		Node left, right;
		int N;

		public Node(Key key, Value value, int N) {
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

	public void put(Key key, Value value) {
		root = put(root, key, value);
	}

	private Node put(Node x, Key key, Value value) {
		if (x == null) {
			x = new Node(key, value, 1);
		}
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			x.left = put(x.left, key, value);
		else if (cmp > 0)
			x.right = put(x.right, key, value);
		else
			x.value = value;
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}

	// 返回最小键
	public Key min() {
		return min(root).key;
	}

	private Node min(Node x) {
		if (x.left == null) {
			return x;
		}
		return min(x.left);
	}

	// 返回最大键
	public Key max() {
		return max(root).key;
	}

	private Node max(Node x) {
		if (x.right == null) {
			return x;
		} else {
			return max(x.right);
		}
	}

	public Value get(Key key) {
		return get(root, key);
	}

	private Value get(Node x, Key key) {
		if (x == null) {
			return null;
		}

		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			return get(x.left, key);
		else if (cmp > 0)
			return get(x.right, key);
		else
			return x.value;

	}

	public Iterable<Key> keys() {
		return keys(min(), max());
	}

	public Iterable<Key> keys(Key lo, Key hi) {
		Queue<Key> queue = new Queue<Key>();
		keys(root, queue, lo, hi);
		return queue;
	}

	private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
		if (x == null)
			return;
		int cmplo = lo.compareTo(x.key);
		int cmphi = hi.compareTo(x.key);

		if (cmplo < 0)
			keys(x.left, queue, lo, hi);
		if (cmplo <= 0 && cmphi >= 0)
			queue.enqueue(x.key);
		if (cmphi > 0)
			keys(x.right, queue, lo, hi);
	}

	// 检测二叉树中是否有相同的value值，如果不含有等值的value返回true，否则false
	public boolean hasNoduplicates() {
          return hasNoDuolicates(root);
	}
     
	/**
	 * 利用set的特性，将value添加到set中并对比size的大小
	 * @param x
	 * @return
	 */
	private boolean hasNoDuolicates(Node x){
		Queue<Key> queue=(Queue<Key>) keys();
		Set<Value> set=new HashSet<Value>();
		int size=queue.size();
		while(!queue.isEmpty()){
			set.add(get(queue.dequeue()));
		}
		return size==set.size();
		
	}
	
}

public class Num_3_02_31 {
	public static void main(String[] args) {
		BST3<String, Integer> b = new BST3<String, Integer>();
		b.put("E", 0);
		b.put("D", 1);
		b.put("A", 2);
		b.put("A", 6);
		b.put("Q", 3);
		b.put("T", 5);
		b.put("M", 22);
		b.put("X", 22);
		System.out.println(b.get("A"));
		System.out.println(b.keys());
		System.out.println(b.hasNoduplicates());//false
	}

}
