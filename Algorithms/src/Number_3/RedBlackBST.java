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
	private boolean isRead(Node x) {
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

}
