package Number_4_02;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Queue;

/**
 * P403 算法4.7 最小生成树的Prim算法（即使版本，不添加无效的边）
 * 
 * @author he
 *
 */
public class PrimMST {
	private Edge edgeTo[];// 距离树最近的边
	private double distTo[];// 保存顶点的权值，disTo[v]=edgeTo[v].weight()
	private IndexMinPQ<Double> pq;// 保存有效的横切边，保存顶点和顶点对应的权重
	private boolean marked[];

	public PrimMST(EdgeWeightedGraph G) {
		edgeTo = new Edge[G.V()];
		distTo = new double[G.V()];
		marked = new boolean[G.V()];
		pq = new IndexMinPQ<Double>(G.V());
		for (int i = 0; i < G.V(); i++)
			distTo[i] = Double.POSITIVE_INFINITY;// 保存Double类型正无穷大值的常量
		for (int v = 0; v < G.V(); v++) {
			prim(G, v);
		}
	}

	private void prim(EdgeWeightedGraph G, int v) {
		distTo[v] = 0.0;
		pq.insert(v, distTo[v]);
		while (!pq.isEmpty()) {
			int t = pq.delMin();
			visit(G, t);
		}
	}

	private void visit(EdgeWeightedGraph G, int v) {

		marked[v] = true;// 标记
		for (Edge e : G.adj(v)) {
			int w = e.other(v);
			if (marked[w])
				continue;// 过滤无效的边
			if (e.weight() < distTo[w]) {
				edgeTo[w] = e;
				distTo[w] = e.weight();
				if (pq.contains(w))
					pq.changeKey(w, e.weight());// 更新索引优先队列顶点w对应的权重
				else
					pq.insert(w, e.weight());
			}
		}
	}

	public Iterable<Edge> edges() {
		Queue<Edge> mst = new Queue<Edge>();
		for (int i = 0; i < edgeTo.length; i++)
			if (edgeTo[i] != null)
				mst.enqueue(edgeTo[i]);
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
		PrimMST mst = new PrimMST(G);
		for (Edge e : mst.edges())
			System.out.println(e);
		System.out.printf("树的权重：%.2f", mst.weight());
	}
}
