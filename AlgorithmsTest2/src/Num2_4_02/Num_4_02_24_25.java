package Num2_4_02;

/**
 * P387 T24 T25
 * @author he
 *
 */
import edu.princeton.cs.algs4.Topological;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;;

class TraceablePath {
	private Topological t;// 图G的拓扑
	private Digraph G;
	private Iterable<Integer> order;// 拓扑图
	private boolean marked[];
	private boolean hasOnlyPath;

	public TraceablePath(Digraph G) {
		this.G = G;
		t = new Topological(G);
		order = t.order();
		marked = new boolean[G.V()];
	}

	// 可达性分析
	private void dfs(Digraph G, int v) {
		marked[v] = true;
		for (int w : G.adj(v))
			if (!marked[w])
				dfs(G, w);
	}

	public boolean hasTraceablePath() {
		int temp[] = new int[G.V()];
		int i = 0;
		for (int w : order) {
			 temp[i++] = w;
		}
		for (int j = 0; j < temp.length - 1; j++) {
			dfs(G, temp[j]);
			if (marked[temp[j+1]] != true)
				return false;
			marked = new boolean[G.V()];//重置
		}
		hasOnlyPath = true;
		return true;
	}

	public boolean onlyOrder() {
		return hasOnlyPath;
	}

}

public class Num_4_02_24_25 {
	public static void main(String[] args) {
		Digraph G = new Digraph(4);
		G.addEdge(0, 1);
		G.addEdge(1, 2);
		G.addEdge(2, 3);
		TraceablePath t = new TraceablePath(G);
		System.out.println(t.hasTraceablePath());
		System.out.println(t.onlyOrder());
	}

}
