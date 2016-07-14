package Number_3;

import edu.princeton.cs.algs4.Queue;

/**
 * P252 算法3.3 基于二叉查找树的符号表(有序)
 * 
 * @author he
 *
 */
public class BST<Key extends Comparable<Key>, Value> {

	private Node root;// 根结点

	/**
	 * 结点类，用于储存键-值对、左右结点以及结点计数器 size(x)=size(x.left)+size(x.right)+1;
	 * 
	 * @author he
	 *
	 */
	private class Node {
		private Key key;// 键
		private Value value;// 值
		private Node left, right;// 指向左右子树的连接
		private int N;// 以该结点为根的子树中的结点数

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

	// 根据键返回值
	public Value get(Key key) {
		return get(root, key);
	}

	// 递归遍历二叉查找树
	private Value get(Node x, Key key) {
		if (x == null) {
			return null;
		}

		int cmp = key.compareTo(x.key);
		if (cmp < 0) {
			return get(x.left, key);
		} else if (cmp > 0) {
			return get(x.right, key);
		} else {
			return x.value;
		}

	}

	// 添加键值对
	public void put(Key key, Value value) {
		root = put(root, key, value);
	}

	// 始终返回的是根结点
	private Node put(Node x, Key key, Value value) {
		// 如果key存在则更新，否则添加新结点
		if (x == null) {
			return new Node(key, value, 1);
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

	// 向下取整，小于等于key的最大键
	public Key floor(Key key) {
		Node x = floor(root, key);
		if (x == null) {
			return null;
		} else {
			return x.key;
		}
	}

	/**
	 * 如果key小于根节点则向下取整一定左子树中， 如果大于根结点，则可能在右子树中如果没有，则根结点就是满足条件的key
	 *
	 * @param x
	 * @param key
	 * @return
	 */
	private Node floor(Node x, Key key) {
		if (x == null) {
			return null;
		}

		int cmp = key.compareTo(x.key);
		if (cmp < 0) {
			return floor(x.left, key);
		}

		Node t = floor(x.right, key);
		if (t != null) {
			return t;
		} else {
			return x;
		}

	}

	// 向上取整,大于等于key的最小键
	public Key ceiling(Key key) {
		Node x = ceiling(root, key);
		if (x == null) {
			return null;
		} else {
			return x.key;
		}
	}

	/**
	 * 如果key大于根结点则向上取整一定在右子树中，如果key小于根结点，则可能在左子树中， 如果为未命中，则根结点就是向上取整的值
	 * 
	 * @param x
	 * @param key
	 * @return
	 */
	private Node ceiling(Node x, Key key) {
		if (x == null) {
			return null;
		}
		int cmp = key.compareTo(x.key);
		if (cmp == 0) {
			return x;
		}
		if (cmp > 0) {
			return ceiling(x.right, key);
		}

		Node t = ceiling(x.left, key);
		if (t != null) {
			return t;
		} else {
			return x;
		}

	}

	// 根据索引查找键
	public Key select(int k) {
		if (k < 0 || k >= size())
			throw new IllegalArgumentException();
		return select(root, k).key;
	}

	/**
	 * 如果左子树的结点数大于k，则递归地在左子树中查找排名为k的键； 如果t等于k，在返回根结点的键；
	 * 如果t小于k，递归地在右子树中查找排名为（k-t-1）的键
	 * 
	 * @param x
	 * @param k
	 * @return
	 */
	private Node select(Node x, int k) {
		// 返回排名为k的结点
		if (x == null) {
			return null;
		}
		int t = size(x.left);
		if (t > k) {
			return select(x.left, k);
		} else if (t < k) {
			return select(x.right, k - t - 1);
		} else {
			return x;
		}
	}

	// 根据键返回下下标（排名）
	public int rank(Key key) {
		return rank(root, key);
	}

	/**
	 * 如果给定的键和根结点的键相等，返回根节点左子树的结点总数t size(x.left); 如果给定的键比根结点的键小,递归计算在做子树的排名；
	 * 如果给定的键比根结点的键大，返回根结点左子树结点总数t+1+它在右子树的排名
	 * 
	 * @param x
	 * @param key
	 * @return
	 */
	private int rank(Node x, Key key) {
		if (x == null) {
			return 0;
		}

		int cmp = key.compareTo(x.key);
		if (cmp < 0) {
			return rank(x.left, key);
		} else if (cmp > 0) {
			return 1 + size(x.left) + rank(x.right, key);
		} else {
			return size(x.left);
		}

	}

	// 删除最小的结点
	public void deleteMin() {
		root = deleteMin(root);
	}

	private Node deleteMin(Node x) {
		if (x.left == null) {
			return x.right;
		}
		x.left = deleteMin(x.left);
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}

	// 删除最大的结点
	public void deleteMax() {
		root = deleteMax(root);
	}

	private Node deleteMax(Node x) {
		if (x.right == null) {
			return x.left;
		}
		x.right = deleteMax(x.right);
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}

	// 删除指定结点
	public void delete(Key key) {
		root = delete(root, key);
	}

	/**
	 * 如果该结点只有单边，参考deleteMin(),deleteMax(),在该结点有左右结点的情况下，
	 * 它的后继结点就是其右子树中最小的结点，这样保证了二叉树的有序性 1、将执行即将被删除的结点的链表保存为t；
	 * 2、将x指向它的后继结点min(t.right); 3、将x的右连接指向deleteMin(t.right); 4、x.left=t.left;
	 * 
	 * @param x
	 * @param key
	 * @return
	 */
	private Node delete(Node x, Key key) {
		if (x == null) {
			return null;
		}
		int cmp = key.compareTo(x.key);
		if (cmp < 0) {
			x.left = delete(x.left, key);
		} else if (cmp > 0) {
			x.right = delete(x.right, key);
		} else {
			if (x.right == null)
				return x.left;
			if (x.left == null)
				return x.right;
			Node t = x;
			x = min(t.right);
			x.right = deleteMin(t.right);
			x.left = t.left;
		}
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}

	// 遍历树中所有的键,采用中序遍历-->左-根-右
	public Iterable<Key> keys() {
		return keys(min(), max());
	}

	// 遍历指定范围内的键
	public Iterable<Key> keys(Key lo, Key hi) {
		Queue<Key> queue = new Queue<Key>();
		keys(root, queue, lo, hi);
		return queue;
	}

	private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
		if (x == null) {
			return;
		}

		int cmplo = lo.compareTo(x.key);
		int cmphi = hi.compareTo(x.key);

		if (cmplo < 0) {
			keys(x.left, queue, lo, hi);
		}
		if (cmplo <= 0 && cmphi >= 0) {
			queue.enqueue(x.key);
		}
		if (cmphi > 0) {
			keys(x.right, queue, lo, hi);
		}

	}

	public static void main(String[] args) {
		BST<String, Integer> bst = new BST<String, Integer>();
		bst.put("S", 0);
		bst.put("E", 1);
		bst.put("A", 2);
		bst.put("C", 3);
		bst.put("R", 4);
		bst.put("X", 5);
		bst.put("H", 6);
		bst.put("M", 7);
		System.out.println(bst.get("E"));
		bst.deleteMin();
		System.out.println(bst.min());
		System.out.println(bst.max());
		System.out.println(bst.floor("G"));
		System.out.println("ceiling:" + bst.ceiling("A"));
		System.out.println(bst.select(1));
		System.out.println(bst.rank("S"));
		bst.deleteMin();
		System.out.println(bst.select(0));
		bst.deleteMax();
		System.out.println(bst.select(bst.size() - 1));
		bst.delete("X");
		System.out.println(bst.get("X"));
		for (String s : bst.keys()) {
			System.out.print(s + " ");
		}
	}
}
