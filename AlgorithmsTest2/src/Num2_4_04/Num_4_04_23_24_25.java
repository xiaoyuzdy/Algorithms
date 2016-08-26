package Num2_4_04;

import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;

/**
 * P447 T24 使用二维数组
 * 
 * @author he args[0]:tinyEWD.txt
 */

class Dijks {
	private double distTo[][];
	private DirectedEdge edgeTo[][];
	private MinPQ<Integer> q;
	private IndexMinPQ<Double> pq[];
	private int index = -1;

	@SuppressWarnings("unchecked")
	public Dijks(EdgeWeightedDigraph G, int S[]) {
		distTo = new double[G.V()][G.V()];
		edgeTo = new DirectedEdge[G.V()][G.V()];
		pq = (IndexMinPQ<Double>[]) new IndexMinPQ[S.length];
		for (int i = 0; i < pq.length; i++) {
			pq[i] = new IndexMinPQ<Double>(G.V());
		}
		q = new MinPQ<Integer>();

		for (int i = 0; i < S.length; i++) {
			int x = S[i];
			q.insert(x);// 将起点集合S[]保存到q中
		}

		while (!q.isEmpty()) {
			int t = q.delMin();// 起点集合中的一个起点
			for (int i = 0; i < distTo[t].length; i++)
				distTo[t][i] = Double.POSITIVE_INFINITY;

			distTo[t][t] = 0.0;// 起点
			pq[++index].insert(t, 0.0);
			while (!pq[index].isEmpty()) {
				relax(G, pq[index].delMin(), t);
			}

		}

	}

	/**
	 * 
	 * @param G
	 * @param v
	 * @param t
	 *            多起点集合中的某个起点
	 */
	private void relax(EdgeWeightedDigraph G, int v, int t) {
		for (DirectedEdge e : G.adj(v)) {

			int w = e.to();
			// 更新信息
			if (distTo[t][w] > distTo[t][v] + e.weight()) {
				distTo[t][w] = distTo[t][v] + e.weight();
				edgeTo[t][w] = e;
				if (pq[t].contains(w))
					pq[t].changeKey(w, distTo[t][w]);
				else
					pq[t].insert(w, distTo[t][w]);
			}
		}
	}

	// 指定起点和顶点
	public double distTo(int s, int v) {
		return distTo[s][v];
	}

	public boolean hasPathTo(int s, int v) {
		return distTo[s][v] < Double.POSITIVE_INFINITY;
	}

	/**
	 * 指定起点到某顶点的最短路径
	 * 
	 * @param s
	 * @param v
	 * @return
	 */
	public Iterable<DirectedEdge> pathTo(int s, int v) {
		if (!hasPathTo(s, v))
			return null;
		Stack<DirectedEdge> path = new Stack<DirectedEdge>();
		for (DirectedEdge e = edgeTo[s][v]; e != null; e = edgeTo[s][e.from()])
			path.push(e);
		return path;
	}

}

public class Num_4_04_23_24_25 {
	public static void main(String[] args) {
		EdgeWeightedDigraph G = new EdgeWeightedDigraph(new In(args[0]));// tinyEWD.txt
		int S[] = { 0, 1,2,3};
		Dijks sp = new Dijks(G, S);

		for (int i = 0; i < S.length; i++) {
			System.out.println("--------------------------------------");
			for (int v = 0; v < G.V(); v++) {
				System.out.print(S[i] + " to " + v);
				System.out.printf(" (%4.2f): ", sp.distTo(S[i], v));
				if (sp.hasPathTo(S[i], v))
					for (DirectedEdge e : sp.pathTo(S[i], v))
						System.out.print(e + " ");
				System.out.println();

			}

		}

	}

}
