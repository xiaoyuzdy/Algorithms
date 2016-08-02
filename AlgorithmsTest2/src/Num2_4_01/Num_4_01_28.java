package Num2_4_01;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;

/**
 * P361 T28
 * args[0]:tinyCG.txt
 * 
 * @author he
 *
 */

class Cycle {
	private boolean marked[];
	private int edgeTo[];// 用于保存环
	private Stack<Integer> path;

	public Cycle(Graph G) {
		if (hasSelfLoop(G))
			return;
		if (hasParallelEdges(G))
			return;
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		for (int v = 0; v < G.V(); v++) {
			if (!marked[v])
				dfs(G, v, v);
		}

	}

	/**
	 * 判断是否含有自环
	 * 
	 * @param G
	 * @return
	 */
	private boolean hasSelfLoop(Graph G) {
		for (int v = 0; v < G.V(); v++) {
			for (int w : G.adj(v)) {
				if (w == v) {
					path = new Stack<Integer>();
					path.push(w);
					path.push(v);
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 判断是否含有平行边
	 * 
	 * @param G
	 * @return
	 */
	private boolean hasParallelEdges(Graph G) {
		marked = new boolean[G.V()];
		for (int i = 0; i < G.V(); i++) {
			for (int w : G.adj(i)) {
				// 平行边，顶点i有两条边到达顶点w，如果一个顶点已经被标记过则表明至少有两条边到达同一顶点
				if (marked[w]) {
					path = new Stack<Integer>();
					path.push(i);
					path.push(w);
					path.push(i);
					return true;
				}
				marked[w] = true;
			}

			// 重置marked数组,让其恢复至初始状态
			for (int w : G.adj(i))
				marked[w] = false;

		}
		return false;
	}

	private void dfs(Graph G, int u, int v) {
		marked[v] = true;

		for (int w : G.adj(v)) {
			// 已发现环
			if (path != null)
				return;
			if (!marked[w]) {
				marked[w] = true;
				edgeTo[w] = v;
				dfs(G, v, w);
			}
			// 因为这是深度遍历，所以如果可以通过两个顶点递归遍历到v则认为有环
			else if (w != u) {
				path = new Stack<Integer>();
				for (int x = v; x != w; x = edgeTo[x]) {
					path.push(x);
				}
				path.push(w);
				path.push(v);
			}
		}
	}

	public Iterable<Integer> path() {
		return path;
	}

	public boolean hasCycle() {
		return path != null;
	}

}

public class Num_4_01_28 {
	public static void main(String[] args) {
		Graph G = new Graph(new In(args[0]));
		Cycle cycle = new Cycle(G);
		if (cycle.hasCycle()) {
			for (int i : cycle.path()) {
				System.out.print(" " + i);//1 0 2 1
			}
		}
	}

}
