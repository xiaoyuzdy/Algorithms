package Num2_4_04;

import java.util.Comparator;

import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;

/**
 * P449 T39
 * args[0]:tinyEWD.txt
 * @author he
 *
 */

class LazyDijkstraSP {
	private boolean[] marked;
	private double[] distTo;
	private DirectedEdge[] edgeTo;

	private MinPQ<DirectedEdge> pq;

	private class ByDistanceFromSource implements Comparator<DirectedEdge> {
		public int compare(DirectedEdge e, DirectedEdge f) {
			double dist1 = distTo[e.from()] + e.weight();
			double dist2 = distTo[f.from()] + f.weight();
			return Double.compare(dist1, dist2);
		}
	}

	public LazyDijkstraSP(EdgeWeightedDigraph G, int s) {
		for (DirectedEdge e : G.edges()) {
			if (e.weight() < 0)
				throw new IllegalArgumentException("edge " + e + " has negative weight");
		}

		pq = new MinPQ<DirectedEdge>(new ByDistanceFromSource());
		marked = new boolean[G.V()];
		edgeTo = new DirectedEdge[G.V()];
		distTo = new double[G.V()];

		for (int v = 0; v < G.V(); v++)
			distTo[v] = Double.POSITIVE_INFINITY;
		distTo[s] = 0.0;
		relax(G, s);
		while (!pq.isEmpty()) {
			DirectedEdge e = pq.delMin();
			int v = e.from(), w = e.to();
			if (!marked[w])
				relax(G, w);
		}

	}

	private void relax(EdgeWeightedDigraph G, int v) {
		marked[v] = true;
		for (DirectedEdge e : G.adj(v)) {
			int w = e.to();
			if (distTo[w] > distTo[v] + e.weight()) {
				distTo[w] = distTo[v] + e.weight();
				edgeTo[w] = e;
				pq.insert(e);
			}
		}
	}

	public double distTo(int v) {
		return distTo[v];
	}

	public boolean hasPathTo(int v) {
		return marked[v];
	}

	public Iterable<DirectedEdge> pathTo(int v) {
		if (!hasPathTo(v))
			return null;
		Stack<DirectedEdge> path = new Stack<DirectedEdge>();
		for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
			path.push(e);
		}
		return path;
	}

}

public class Num_4_04_39 {
	public static void main(String[] args) {
		EdgeWeightedDigraph G = new EdgeWeightedDigraph(new In(args[0]));
		int s = 0;
		LazyDijkstraSP sp = new LazyDijkstraSP(G, s);
		for (int t = 0; t < G.V(); t++) {
			System.out.print(s + " to " + t);
			System.out.printf(" (%4.2f): ", sp.distTo(t));
			if (sp.hasPathTo(t))
				for (DirectedEdge e : sp.pathTo(t))
					System.out.print(e + " ");
			System.out.println();
		}

	}

}
