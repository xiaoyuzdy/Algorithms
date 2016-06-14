package Num1_3_02;

/**
 * P264 T06  T07
 * 
 * @author he
 *
 */

class BSTH<Key extends Comparable<Key>, Value> {
	private Node root;// 根结点
	private int avg;//随机命中查找比较次数

	private class Node {
		Key key;
		Value value;
		Node left, right;
		int N;// 用于计算树的高度

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
		if (x == null) {
			return 0;
		} else {
			return x.N;
		}
	}

	public int height() {
		return height(root);
	}

	private int height(Node x) {
		if (x == null)
			return -1;
		return 1 + Math.max(height(x.left), height(x.right));
	}

	public void put(Key key, Value value) {
		root = put(root, key, value);
	}

	private Node put(Node x, Key key, Value value) {
		if (x == null) {
			x = new Node(key, value, 0);
		}

		int cmp = key.compareTo(x.key);
		if (cmp < 0) {
			x.left = put(x.left, key, value);
		} else if (cmp > 0) {
			x.right = put(x.right, key, value);
		} else {
			x.value = value;
		}
		x.N = size(x.left) + size(x.right) + 1;
		return x;

	}
	
	public Value get(Key key){
		return get(root, key);
	}
	
	private Value get(Node x,Key key){
		if (x==null) {
			return null;
		}
		int cmp=key.compareTo(x.key);
		avg++;
		if (cmp<0) {
			return get(x.left,key);
		}else if (cmp>0) {
			return get(x.right,key);
		}else {
			return x.value;
		}
		
	}
	
	//查询一个键所需要的比较次数
	public int avgCompares(Key key){
		avg=0;//重置
		get(root, key);
		return avg;
	}

}

public class Num_3_02_06_07 {
	public static void main(String[] args) {
		BSTH<String, Integer> b = new BSTH<String, Integer>();
		b.put("E", 0);
		b.put("D", 1);
		b.put("A", 2);
		b.put("A", 6);
		b.put("Q", 3);
		System.out.println(b.avgCompares("E"));
		System.out.println(b.get("A"));
		System.out.println(b.height());//2  true

	}

}
