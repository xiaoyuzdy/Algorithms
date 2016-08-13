package Number_4_02;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;

/**
 * P400 最小生成树的Prim算法的延时实现，优先队列中会保存失效的边，等要删除时(delMin())再检查有效性
 *      有递归的思想
 * @author he
 *   args[0]:tinyEWG.txt
 *
 */
public class LazyPrimMST {
	private boolean marked[];// 标记最小生成树的顶点
	private Queue<Edge> mst;// 最小生成树的边
	private MinPQ<Edge> pq;// 优先队列，保存横切边
	private double Weight;// 最小生成树的总权重

	// 有递归的思想
	public LazyPrimMST(EdgeWeightedGraph G) {
		marked = new boolean[G.V()];
		mst = new Queue<Edge>();
		pq = new MinPQ<Edge>();
		for (int v = 0; v < G.V(); v++) {
			if (!marked[v])
				prim(G, v);
		}
	}

	private void prim(EdgeWeightedGraph G, int v) {
		visit(G, v);
		while (!pq.isEmpty()) {
			Edge e = pq.delMin();
			int w = e.either();
			int t = e.other(w);
			if (marked[w] && marked[t])
				continue;// 过滤失效的边
			mst.enqueue(e);// 最小生成树添加边
			Weight += e.weight();
			if (!marked[t])
				visit(G, t);
			if (!marked[w])
				visit(G, w);
		}
	}

	// 遍历指定顶点关联的边
	private void visit(EdgeWeightedGraph G, int v) {
		marked[v] = true;// 标记
		for (Edge e : G.adj(v)) {
			if (!marked[e.other(v)])// 和顶点v相连且另一个顶点未被标记
				pq.insert(e);
		}
	}

	/**
	 * 返回最小生成树所有的边
	 * 
	 * @return
	 */
	public Iterable<Edge> edges() {
		return mst;
	}

	/**
	 * 返回最小生成树的总权重
	 * 
	 * @return
	 */
	public double weight() {
		return Weight;
	}

	public static void main(String[] args) {
		EdgeWeightedGraph G = new EdgeWeightedGraph(new In(args[0]));
		LazyPrimMST mst = new LazyPrimMST(G);
		for (Edge e : mst.edges()) {
			System.out.println(e);
		}
		System.out.println(mst.weight());
	}

}
