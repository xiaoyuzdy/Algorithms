package Num2_4_04;

import edu.princeton.cs.algs4.DepthFirstOrder;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.In;

/**
 * P446 T12 加权有向图的拓扑图（无环）
 *  args[0]:tinyEWDAG.txt
 * @author he
 *
 */
public class EdgeWeightTopological {
	private Iterable<Integer> order;

	public EdgeWeightTopological(EdgeWeightedDigraph G) {
		EdgeWeightedCycleFinder cycle = new EdgeWeightedCycleFinder(G);
		if (!cycle.hasCycle()) {
			DepthFirstOrder d = new DepthFirstOrder(G);
			order = d.reversePost();
		}
	}

	public Iterable<Integer> order() {
		return order;
	}

	public boolean isDAG() {
		return order != null;
	}

	public static void main(String[] args) {
		EdgeWeightedDigraph G = new EdgeWeightedDigraph(new In(args[0]));
		EdgeWeightTopological t = new EdgeWeightTopological(G);
		if (t.isDAG()) {
			for (int e : t.order)
				System.out.print(e+" ");//5 1 3 6 4 7 0 2
		}

	}

}
