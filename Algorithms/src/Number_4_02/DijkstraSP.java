package Number_4_02;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Stack;

/**
 * P423 算法4.9 最短路径的Dijkstra算法，能够解决边权重非负的加权有向图的单起点最短路径问题
 * 
 * args[0]:tinyEWD.txt 
 * args[1]:0
 * 
 * @author he
 *
 */
public class DijkstraSP {
	private double distTo[];// 保存权重，最短路径的总权重，distTo[w]表示起点到w最短路径的总权重
	private DirectedEdge edgeTo[];// 最短路径的边
	private IndexMinPQ<Double> pq;// 保存顶点和起点到达该顶点累加的权重

	/**
	 * 
	 * @param G
	 *            有向加权图
	 * @param s
	 *            起点s
	 */
	public DijkstraSP(EdgeWeightedDigraph G, int s) {
		distTo = new double[G.V()];
		edgeTo = new DirectedEdge[G.V()];
		pq = new IndexMinPQ<Double>(G.V());

		for (int i = 0; i < distTo.length; i++)
			distTo[i] = Double.POSITIVE_INFINITY;
		distTo[s] = 0.0;
		pq.insert(s, distTo[s]);

		while (!pq.isEmpty()) {
			relax(G, pq.delMin());
		}

	}

	/**
	 * 边的放松
	 * 
	 * @param G
	 * @param v
	 */
	private void relax(EdgeWeightedDigraph G, int v) {
		for (DirectedEdge e : G.adj(v)) {

			int w = e.to();
			// 更新信息
			if (distTo[w] > distTo[v] + e.weight()) {
				distTo[w] = distTo[v] + e.weight();
				edgeTo[w] = e;
				if (pq.contains(w))
					pq.changeKey(w, distTo[w]);
				else
					pq.insert(w, distTo[w]);
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
	 * 从顶点到s的路径
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
		int s = Integer.valueOf(args[1]);
		DijkstraSP sp = new DijkstraSP(G, s);

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
