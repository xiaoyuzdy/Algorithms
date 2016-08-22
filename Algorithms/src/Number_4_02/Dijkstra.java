package Number_4_02;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;

public class Dijkstra {

	private double distTo[];// 保存权重，最短路径的总权重，distTo[w]表示起点到w最短路径的总权重
	private DirectedEdge edgeTo[];// 最短路径的边
	private boolean marked[];

	/**
	 * 
	 * @param G
	 *            有向加权图
	 * @param s
	 *            起点s
	 */
	public Dijkstra(EdgeWeightedDigraph G, int s) {
		for (DirectedEdge e : G.edges()) {
			if (e.weight() < 0)
				throw new IllegalArgumentException("edge " + e + " has negative weight");
		}

		distTo = new double[G.V()];
		edgeTo = new DirectedEdge[G.V()];
		marked = new boolean[G.V()];

		for (int i = 0; i < distTo.length; i++)
			distTo[i] = Double.POSITIVE_INFINITY;
		distTo[s] = 0.0;
		for (int v = 0; v < G.V(); v++) {
			relax(G, v);
		}

	}

	/**
	 * 边的放松
	 * 
	 * @param G
	 * @param v
	 */
	private void relax(EdgeWeightedDigraph G, int v) {
		marked[v] = true;
		for (DirectedEdge e : G.adj(v)) {
			int w = e.to();
			if (distTo[w] > distTo[v] + e.weight()) {
				distTo[w] = distTo[v] + e.weight();
				edgeTo[w] = e;
			}
			if (!marked[w]) {
				relax(G, w);
			}
		}
	}

	/**
	 * 从顶点s到v的权重
	 * 
	 * @param v
	 * @return
	 */
	public double distTo(int v) {
		return distTo[v];

	}

	/**
	 * 是否存在顶点s到v的路径
	 * 
	 * @param v
	 * @return
	 */
	public boolean hasPathTo(int v) {
		return distTo[v] < Double.POSITIVE_INFINITY;
	}

	/**
	 * 从起点到v的路径
	 * 
	 * @param v
	 * @return
	 */
	public Iterable<DirectedEdge> pathTo(int v) {
		if (!hasPathTo(v))
			return null;
		Stack<DirectedEdge> path = new Stack<DirectedEdge>();
		for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()])
			path.push(e);
		return path;
	}

	public static void main(String[] args) {
		EdgeWeightedDigraph G = new EdgeWeightedDigraph(new In(args[0]));
		int s = Integer.valueOf(args[1]);// 起点
		Dijkstra sp = new Dijkstra(G, s);

		for (int t = 0; t < G.V(); t++) {
			System.out.print(0 + " to " + t);
			System.out.printf(" (%4.2f): ", sp.distTo(t));
			if (sp.hasPathTo(t))
				for (DirectedEdge e : sp.pathTo(t))
					System.out.print(e + " ");
			System.out.println();
		}

	}

}
