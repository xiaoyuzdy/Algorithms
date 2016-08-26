package Num2_4_04;

import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.Topological;

/**
 * P448 T28 求有向无环加权图的最长路径
 * 
 * @author he
 *
 */

class AcyclicLP {
	private DirectedEdge edgeTo[];
	private double distTo[];

	public AcyclicLP(EdgeWeightedDigraph G, int s) {
		edgeTo = new DirectedEdge[G.V()];
		distTo = new double[G.V()];
		for (int i = 0; i < G.V(); i++)
			distTo[i] = Double.MIN_VALUE;
		distTo[s] = 0.0;
		Topological t = new Topological(G);
		for (int v : t.order()) {
			relax(G, v);
		}

	}

	private void relax(EdgeWeightedDigraph G, int v) {
		for (DirectedEdge e : G.adj(v)) {
			int w = e.to();
			if (distTo[w] < distTo[v] + e.weight()) {
				distTo[w] = distTo[v] + e.weight();
				edgeTo[w] = e;
			}
		}
	}

	public double distTo(int v) {
		return distTo[v];
	}

	public boolean hasPathTo(int v) {
		return distTo[v] > Double.MIN_VALUE;
	}

	public Iterable<DirectedEdge> pathTo(int v) {
		if (!hasPathTo(v))
			return null;
		Stack<DirectedEdge> path = new Stack<DirectedEdge>();
		for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()])
			path.push(e);
		return path;
	}

}

public class Num_4_04_28 {
	public static void main(String[] args) {
		EdgeWeightedDigraph G = new EdgeWeightedDigraph(new In(args[0]));
		int s = 5;
		AcyclicLP lp = new AcyclicLP(G, s);
		for (int t = 0; t < G.V(); t++) {
			System.out.print(s + " to " + t);
			System.out.printf(" (%.2f): ", lp.distTo(t));
			if (lp.hasPathTo(t))
				for (DirectedEdge e : lp.pathTo(t))
					System.out.print(e + " ");
			System.out.println();
		}
	}
}
