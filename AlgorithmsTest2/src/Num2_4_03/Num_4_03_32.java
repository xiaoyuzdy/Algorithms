package Num2_4_03;

import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.UF;

/**
 * P410 T32
 * @author he
 *
 */

/**
 * 包含指定集合S（一个边的集合且不含环）的最小生成树 使用KrukalMST算法
 * 
 * @author he
 * args[0]:tinyEWG.txt
 *
 */
class appointEWG {
	private Queue<Edge> mst;

	public appointEWG(EdgeWeightedGraph G, Edge[] S) {
		MinPQ<Edge> pq = new MinPQ<Edge>();
		mst = new Queue<Edge>();
		for (Edge e : G.edges())
			pq.insert(e);

		UF uf = new UF(G.V());
		for (int i = 0; i < S.length; i++) {
			int v = S[i].either();
			int w = S[i].other(v);
			uf.union(v, w);
			mst.enqueue(S[i]);
		}
		while (!pq.isEmpty() && mst.size() < G.V() - 1) {
			Edge e = pq.delMin();
			int v = e.either();
			int w = e.other(v);
			if (uf.connected(v, w))
				continue;
			uf.union(v, w);
			mst.enqueue(e);
		}

	}

	/**
	 * 返回包含集合S的最小生成树
	 * 
	 * @return
	 */
	public Iterable<Edge> edges() {
		return mst;
	}

}

public class Num_4_03_32 {
	public static void main(String[] args) {
		EdgeWeightedGraph G = new EdgeWeightedGraph(new In(args[0]));
		Edge S[] = { new Edge(0, 7, 0.16),new Edge(1, 3, 0.29) };
		appointEWG ewg = new appointEWG(G, S);
		for (Edge e : ewg.edges())
			System.out.println(e);

	}

}
