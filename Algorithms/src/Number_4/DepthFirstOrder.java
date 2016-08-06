package Number_4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

/**
 * P374 有向图中基于深度优先搜索的顶点顺序
 * 
 * 1、前序：在递归调用之前将顶点加入队列，dfs（）的调用顺序 2、后序：在递归调用之后将顶点加入队列，顶点遍历完成的顺序
 * 3、逆后序：在递归调用之后将顶点压入栈，后序遍历的反向
 * 
 * @author he
 * args[0]:tinyDAG.txt
 *
 */
public class DepthFirstOrder {
	private boolean marked[];// 标记顶点
	private Queue<Integer> pre;// 所有顶点的前序遍历
	private Queue<Integer> post;// 所有顶点的后序遍历
	private Stack<Integer> reversePost;// 所有顶点的逆后序遍历

	public DepthFirstOrder(Digraph G) {
		marked = new boolean[G.V()];
		pre = new Queue<Integer>();
		post = new Queue<Integer>();
		reversePost = new Stack<Integer>();

		for (int v = 0; v < G.V(); v++) {
			if (!marked[v])
				dfs(G, v);
		}

	}

	private void dfs(Digraph G, int v) {
		pre.enqueue(v);
        marked[v]=true;
		for (int w : G.adj(v))
			if (!marked[w])
				dfs(G, w);
		post.enqueue(v);
		reversePost.push(v);
	}

	// 顶点的先序遍历
	public Iterable<Integer> pre() {
		return pre;
	}

	// 顶点的后序遍历
	public Iterable<Integer> post() {
		return post;
	}

	// 逆后序遍历
	public Iterable<Integer> reversePost() {
		return reversePost;
	}

	public static void main(String[] args) {
		Digraph G = new Digraph(new In(args[0]));
		DepthFirstOrder d = new DepthFirstOrder(G);
		System.out.println("前序遍历：");
		for (int x : d.pre())
			System.out.print(x + " ");
		System.out.println("\n"+"后序遍历：");
		for (int x : d.post())
			System.out.print(x + " ");
		System.out.println("\n"+"逆后序遍历：");
		for (int x : d.reversePost())
			System.out.print(x + " ");
	}

}
