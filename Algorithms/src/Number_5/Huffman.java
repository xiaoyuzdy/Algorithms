package Number_5;

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;
import edu.princeton.cs.algs4.MinPQ;

/*****************************************************************************************************
 * P547 算法 5.10 霍夫曼压缩
 * 
 * 压缩的过程： 
 *  1、读取输入
 *  2、统计输入中每个char值出现的频率（读取完整的输入） 
 *  3、根据频率构造霍夫曼编码树
 *  4、根据霍夫曼编码树构造编译表，将每个字符与一个比特字符串相关联 
 *  5、将霍夫曼树编码成比特流写入输出 
 *  6、将字母总数编码为比特字符串写入输出
 *  7、使用编译表翻译每个输入字符 
 * 展开的过程：
 *  1、读取霍夫曼树 
 *  2、读取要解码的字符数量 
 *  3、使用单词查找树将比特流解码
 * 
 * 压缩算法测试：将console的input定向到abra.txt，console的output定向到HMcom.txt
 * 解压缩算法测试：将console的input定向到HMcom.txt
 * 如何定向看我的博客:http://blog.csdn.net/fuckluy/article/details/50999238
 * 
 * 
 * @author he
 *
 */
public class Huffman {
	private static int R = 256;// 8位ASCII表的字母数量

	/**
	 * 霍夫曼编码树的结点表示
	 */

	private static class Node implements Comparable<Node> {
		private char ch;// 叶子节点中需要被编码的字符
		private int freq;// 用于记录整个书中每个字符出现的频率
		private final Node left, right;

		public Node(char ch, int freq, Node left, Node right) {
			this.ch = ch;
			this.freq = freq;
			this.left = left;
			this.right = right;
		}

		// 如果左右连接都为Null则该结点是叶子结点
		public boolean isLeaf() {
			return left == null && right == null;
		}

		// 用于在MinPQ中进行比较
		public int compareTo(Node o) {
			return this.freq - o.freq;
		}
	}

	// 压缩
	public static void compress() {
		String s = BinaryStdIn.readString();// 读取输入
		char input[] = s.toCharArray();
		// 统计频率
		int freq[] = new int[R];
		for (int i = 0; i < input.length; i++)
			freq[input[i]]++;

		// 构造霍夫曼树
		Node root = buildTrie(freq);
		// 递归地构建编译表
		String st[] = new String[R];
		buildCode(st, root, "");
		// 递归地将霍夫曼树写成比特字符串到输出
		writeTrie(root);
		// 输出字符总数
		BinaryStdOut.write(input.length);

		// 通过编译表处理字符
		for (int i = 0; i < input.length; i++) {
			String code = st[input[i]];
			for (int j = 0; j < code.length(); j++)
				if (code.charAt(j) == '1')
					BinaryStdOut.write(true);
				else
					BinaryStdOut.write(false);
		}
		BinaryStdOut.close();
	}

	// 解压缩
	public static void expand() {
		Node root = readTrie();// 读取霍夫曼树
		int N = BinaryStdIn.readInt();// 被压缩的字母个数
		for (int i = 0; i < N; i++) {
			Node x = root;
			while (!x.isLeaf()) {
				if (BinaryStdIn.readBoolean())
					x = x.right;
				else
					x = x.left;
			}
			BinaryStdOut.write(x.ch);
		}
		BinaryStdOut.close();
	}

	/**
	 * 创建许多只有一个结点的树组成的森林，其中变量freq表示该字符在流中出现的频率，首先找到频率最小的结点，然后创建一个以二者为子结点的新结点，
	 * 新结点的频率为子结 点频率之和（非叶子结点的频率也是子结点频率之和），重复此过程直到所有结点合并为 一棵单独的单词查找树
	 * 
	 * @param freq
	 * @return
	 */
	private static Node buildTrie(int freq[]) {
		MinPQ<Node> mpq = new MinPQ<Node>();
		for (char c = 0; c < R; c++)
			if (freq[c] > 0)
				mpq.insert(new Node(c, freq[c], null, null));// 插入叶子节点

		// 合并子树直到只有一颗树
		while (mpq.size() > 1) {
			Node X = mpq.delMin();
			Node Y = mpq.delMin();
			Node parent = new Node('\0', X.freq + Y.freq, X, Y);
			mpq.insert(parent);
		}

		return mpq.delMin();
	}

	/**
	 * 构建编译表 每个叶子节点含有一个需要编码的字符，这样每个字符的编码就 是从根结点到该结点的路径表示的比特字符串， 其中左连接为0，右连接为1
	 * 
	 * @param root
	 * @return
	 */
	private static String[] buildCode(Node root) {
		String st[] = new String[R];
		buildCode(st, root, "");
		return st;
	}

	private static void buildCode(String st[], Node x, String s) {
		if (x.isLeaf()) {
			st[x.ch] = s;
			return;
		}

		buildCode(st, x.left, s + '0');
		buildCode(st, x.right, s + '1');
	}

	/**
	 * 递归地，将霍夫曼树写成比特字符串
	 * 
	 * @param x
	 */
	private static void writeTrie(Node x) {
		if (x.isLeaf()) {// 叶子结点（保存字符的结点）先写入1
			BinaryStdOut.write(true);
			BinaryStdOut.write(x.ch);
			return;
		}
		BinaryStdOut.write(false);// 内部结点（空结点，x.ch='\0'），写入0
		writeTrie(x.left);
		writeTrie(x.right);
	}

	// 从此特留的前序中重建霍夫曼树
	private static Node readTrie() {
		if (BinaryStdIn.readBoolean())
			return new Node(BinaryStdIn.readChar(), 0, null, null);
		return new Node('\0', 0, readTrie(), readTrie());
	}

	public static void main(String[] args) {
		 if (args[0].equals("-"))
		 compress();
		 else if (args[0].equals("+"))
		expand();
	}

}
