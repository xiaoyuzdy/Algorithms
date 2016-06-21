package Number_3;

/**
 * P281 算法3.4 红黑树 用红连接将两个2-结点构成2-3结点
 * 
 * @author he
 *
 */
public class RedBlackBST<Key extends Comparable<Key>, Value> {

	private final static boolean RED = true;// true,表示红连接
	private final static boolean BLACK = false;// false，表示普通连接和空连接

	private Node root;// 根结点

	private class Node {
		Key key;
		Value value;
		Node left, right;// 左右子树
		int N;// 结点总数
		boolean color;// 由其父结点指向它的连接的颜色

		public Node(Key key, Value value, int N, boolean color) {
			this.key = key;
			this.value = value;
			this.N = N;
			this.color = color;
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

	// 判断是否为红连接
	private boolean isRed(Node x) {
		if (x == null)
			return false;
		return x.color == RED;
	}

	/**
	 * 左旋转，将一条红色的右连接转换为左连接，连接的颜色是该结点指向父结点连接的颜色
	 * 
	 * @param h
	 * @return
	 */
	private Node rotateLeft(Node h) {
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = h.color;
		h.color = RED;// 更新连接颜色
		x.N = h.N;
		h.N = 1 + size(h.left) + size(h.right);// 更新结点数量
		return x;
	}

	/**
	 * 右旋转，将一条红色的左连接转换为右连接，连接的颜色是该结点指向父结点连接的颜色
	 * 
	 * @param h
	 * @return
	 */
	private Node rotateRight(Node h) {
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		h.color = RED;
		x.N = h.N;
		h.N = 1 + size(h.left) + size(h.right);// 更新结点数量
		return x;
	}

	/**
	 * 颜色转换，将子结点的颜色由红变黑，同时将父结点的颜色由黑变红
	 * 
	 * @param x
	 */
	private void flipColors(Node h) {
		h.color = RED;
		h.left.color = BLACK;
		h.right.color = BLACK;
	}

	public void put(Key key, Value value) {
		root = put(root, key, value);
		root.color = BLACK;// 每次插入都将根结设置为黑连接
	}

	private Node put(Node h, Key key, Value value) {
		if (h == null)
			h = new Node(key, value, 1, RED);

		int cmp = key.compareTo(h.key);
		if (cmp < 0)
			h.left = put(h.left, key, value);
		else if (cmp > 0)
			h.right = put(h.right, key, value);
		else
			h.value = value;

		// 右连接为红连接，左旋转
		if (!isRed(h.left) && isRed(h.right))
			h = rotateLeft(h);
		// 左连接为红连接，并且左连接的左连接为红连接,有旋转
		if (isRed(h.left) && isRed(h.left.left))
			h = rotateRight(h);
		// 左右连接都为红连接，颜色替换
		if (isRed(h.left) && isRed(h.right))
			flipColors(h);

		h.N = size(h.left) + size(h.right) + 1;// 更新结点数量
		return h;

	}

	public Value get(Key key) {
		return get(root, key);
	}

	private Value get(Node x, Key key) {
		if (x == null)
			return null;
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			return get(x.left, key);
		else if (cmp > 0)
			return get(x.right, key);
		else
			return x.value;
	}

	public static void main(String[] args) {
		RedBlackBST<String, Integer> bst = new RedBlackBST<String, Integer>();
		bst.put("S", 0);
		bst.put("E", 1);
		bst.put("A", 2);
		bst.put("C", 3);
		bst.put("R", 4);
		bst.put("X", 5);
		bst.put("H", 6);
		bst.put("M", 7);
		bst.put("E", 12);
		System.out.println(bst.size());
		System.out.println(bst.get("E"));
	}

}
