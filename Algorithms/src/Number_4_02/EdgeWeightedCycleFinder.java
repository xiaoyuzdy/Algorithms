package Number_4_02;

import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;

/**
 * P446 T12 有向加权图的环检测
 * args[0]:tinyEWD.txt
 * @author he
 *
 */
public class EdgeWeightedCycleFinder {
	private boolean onStack[];
	private boolean marked[];
	private DirectedEdge edgeTo[];
	private Stack<DirectedEdge> cycle;

	public EdgeWeightedCycleFinder(EdgeWeightedDigraph G) {
		onStack = new boolean[G.V()];
		marked = new boolean[G.V()];
		edgeTo = new DirectedEdge[G.V()];
		for (int v = 0; v < G.V(); v++) {
			if (!marked[v])
				dfs(G, v);
		}

	}

	private void dfs(EdgeWeightedDigraph G, int v) {
		onStack[v] = true;
		marked[v] = true;

		for (DirectedEdge e : G.adj(v)) {
			int w = e.to();
			if (cycle != null)// 只要检测到环就返回
				return;
			if (!marked[w]) {
				edgeTo[w] = e;
				dfs(G, w);
			} else if (onStack[w]) {
				cycle = new Stack<DirectedEdge>();
				while (e.from() != w) {
					cycle.push(e);
					e = edgeTo[e.from()];
				}
				cycle.push(e);
				return;
			}

		}

		onStack[v] = false;

	}

	public boolean hasCycle() {
		return cycle != null;
	}

	public Iterable<DirectedEdge> cycle() {
		return cycle;
	}

	public static void main(String[] args) {
		EdgeWeightedDigraph G = new EdgeWeightedDigraph(new In(args[0]));
		EdgeWeightedCycleFinder cycle = new EdgeWeightedCycleFinder(G);
		if (cycle.hasCycle()) {
			for (DirectedEdge e : cycle.cycle)
				System.out.print(e + "  ");
		}

	}

}
