package Number_4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

/**
 * P346 算法4.2 广度优先搜索查找图中的路径 args[0]:tinyCG.txt args[1]:0
 * 
 * @author he
 *
 */
public class BreadthFirstPaths {
	private boolean[] marked;// 保存被标记的顶点
	private int[] edgeTo;// 保存起点到与之连通的顶点之间的最短路径
	private final int s;// 起点

	public BreadthFirstPaths(Graph G, int s) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		bfs(G, s);
	}

	/**
	 * 先遍历每个与起点直接相连的顶点（1），再依次遍历与该顶点（1）相连的点
	 * 
	 * @param G
	 * @param s
	 */
	public void bfs(Graph G, int s) {
		Queue<Integer> queue = new Queue<Integer>();
		marked[s] = true;
		queue.enqueue(s);
		while (!queue.isEmpty()) {
			int v = queue.dequeue();
			// 遍历与顶点s直接相连的点
			for (int w : G.adj(v)) {
				if (!marked[w]) {
					marked[w] = true;// 标记
					edgeTo[w] = v;// 保存最短路径的结点
					queue.enqueue(w);
				}
			}
		}
	}

	public boolean hasPathTo(int v) {
		return marked[v];
	}

	public Iterable<Integer> pathTo(int v) {
		if (!hasPathTo(v))
			return null;
		Stack<Integer> path = new Stack<Integer>();
		for (int x = v; x != s; x = edgeTo[x]) {
			path.push(x);
		}
		path.push(s);
		return path;
	}

	public static void main(String[] args) {
		Graph G = new Graph(new In(args[0]));
		int s = Integer.valueOf(args[1]);// 起点
		BreadthFirstPaths dfp = new BreadthFirstPaths(G, s);
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
