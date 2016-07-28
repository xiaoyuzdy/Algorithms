package Number_4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;

/**
 * P343 算法4.1 使用深度优先搜索查找图中的路径 args[0]:tinyCG.txt args[1]:0
 * 
 * @author he
 *
 */
public class DepthFirstPaths {
	private boolean marked[];// 用于存放被标记过的顶点
	private int edgeTo[];// 每个元素用于存放一个顶点的上一个连通的顶点，从而整个数组存放所有顶点到起点的路径
	private final int s;// 起点
	private int count;// 已遍历顶点的数量

	public DepthFirstPaths(Graph G, int s) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		dfs(G, s);
	}

	/**
	 * 遍历每个顶点和边
	 * 
	 * @param G
	 * @param s
	 */
	public void dfs(Graph G, int s) {
		marked[s] = true;
		count++;
		for (int w : G.adj(s)) {
			if (!marked[w]) {
				edgeTo[w] = s;
				dfs(G, w);
			}
		}
	}

	/**
	 * 无向图是否是连通性无向图
	 * 
	 * @return
	 */
	public boolean isConnectedGraoh() {
		return count == marked.length;
	}

	/**
	 * 是否存在倒达顶尖v的路径
	 * 
	 * @param v
	 * @return
	 */
	public boolean hasPathTo(int v) {
		return marked[v];
	}
	

	/**
	 * 返回到达顶点v的路径
	 * 
	 * @param v
	 * @return
	 */
	public Iterable<Integer> pathTo(int v) {
		if (!hasPathTo(v))
			return null;
		Stack<Integer> stack = new Stack<Integer>();
		for (int x = v; x != s; x = edgeTo[x])
			stack.push(x);
		stack.push(s);
		return stack;
	}

	public static void main(String[] args) {
		Graph G = new Graph(new In(args[0]));
		int s = Integer.valueOf(args[1]);// 起点
		DepthFirstPaths dfp = new DepthFirstPaths(G, s);
		for (int i = 0; i < G.V(); i++) {
			System.out.print(s + " to " + i + " : ");
			if (dfp.hasPathTo(i)) {
				for (int w : dfp.pathTo(i)) {
					if (w == s)
						System.out.print(s);
					else
						System.out.print("-" + w);
				}

			}
			System.out.println();
		}

	}
}
