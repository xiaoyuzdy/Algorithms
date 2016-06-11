package Number_3;

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
		root=put(root, key, value);
	}

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

	public static void main(String[] args) {
		BST<String,Integer> bst=new BST<String, Integer>();
		bst.put("A", 1);
		bst.put("B", 2);
		System.out.println(bst.get("B"));
		
	}
}
