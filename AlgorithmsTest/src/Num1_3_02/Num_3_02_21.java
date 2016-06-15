package Num1_3_02;

import edu.princeton.cs.algs4.StdRandom;

/**
 * P265 T21
 * 
 * @author he
 *
 */

class BSTR<K extends Comparable<K>, V> {
	private Node root;

	private class Node {
		K k;
		V v;
		Node left, right;
		int N;

		public Node(K k, V v, int N) {
			this.k = k;
			this.v = v;
			this.N = N;
		}
	}

	public int size() {
		return size(root);
	}

	private int size(Node x) {
		if (x == null) {
			return 0;
		} else {
			return x.N;
		}
	}

	public void put(K key, V value) {
		root = put(root, key, value);
	}

	private Node put(Node x, K key, V value) {
		if (x == null) {
			x = new Node(key, value, 1);
		}

		int cmp = key.compareTo(x.k);
		if (cmp < 0) {
			x.left = put(x.left, key, value);
		} else if (cmp > 0) {
			x.right = put(x.right, key, value);
		} else {
			x.v = value;
		}

		x.N = size(x.left) + size(x.right) + 1;
		return x;

	}

	public V get(K key) {
		return get(root, key);
	}

	private V get(Node x, K key) {
		if (x == null) {
			return null;
		}

		int cmp = key.compareTo(x.k);

		if (cmp < 0) {
			return get(x.left, key);
		} else if (cmp > 0) {
			return get(x.right, key);
		} else {
			return x.v;
		}

	}

	public K select(int k) {
		if (k < 0 || k >= size()) {
			throw new RuntimeException();
		}
		return select(root, k);
	}

	private K select(Node x, int k) {
		if (x == null) {
			return null;
		}
		int t = size(x.left);
		if (t > k) {
			return select(x.left, k);
		} else if (t < k) {
			return select(x.right, k - t - 1);
		} else {
			return x.k;
		}
	}
	
	public K randomKey(){
		int r=StdRandom.uniform(size());
		return select(r);
	}
	

}

public class Num_3_02_21 {
	public static void main(String[] args) {
		BSTR<String, Integer> b = new BSTR<String, Integer>();
		b.put("E", 0);
		b.put("D", 1);
		b.put("A", 2);
		b.put("A", 6);
		b.put("Q", 3);
		b.put("T", 5);
		b.put("M", 22);
		b.put("X", 9);
		System.out.println(b.get("M"));
		System.out.println(b.select(3));
		System.out.println(b.randomKey());
	}

}
