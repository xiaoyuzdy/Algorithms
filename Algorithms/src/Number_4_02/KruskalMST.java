package Number_4_02;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.UF;

/**
 * P406 算法4.8最小生成树的Kruskal算法，按边的权重顺序处理，
 * Kruskal算法一般比Prim算法慢，因为处理每条边时要进行一次connect（）操作, 需要使用1.5节的union-find算法检查是否形成环
 * 
 * @author he
 *
 */
public class KruskalMST {
	private Queue<Edge> mst;// 最小生成树
	private MinPQ<Edge> pq;

	public KruskalMST(EdgeWeightedGraph G) {
		mst = new Queue<Edge>();
		pq = new MinPQ<Edge>();
		UF uf = new UF(G.V());// 用于检测是否会形成环
		for (Edge e : G.edges())
			pq.insert(e);

		// 生成树只有V-1条边
		while (!pq.isEmpty() && mst.size() < G.V() - 1) {
			Edge e = pq.delMin();
			int v = e.either();
			int w = e.other(v);
			if (uf.connected(v, w))
				continue; // 过滤无效的边
			uf.union(v, w);
			mst.enqueue(e);
		}

	}

	public Iterable<Edge> edges() {
		return mst;
	}

	public double weight() {
		double weight = 0.0;
		for (Edge e : edges())
			weight += e.weight();
		return weight;
	}

	public static void main(String[] args) {
		EdgeWeightedGraph G = new EdgeWeightedGraph(new In(args[0]));
		KruskalMST mst = new KruskalMST(G);
		for (Edge e : mst.edges())
			System.out.println(e);
		System.out.println("总权重："+mst.weight());
	}

}
