package Number_4_02;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.UF;

/**
 * P411 Boruvka算法和Boruvka算法类似 基本思想：找出所有连接两棵不同的树的权重最小的边，并将它们全部加入最小生成树
 * args[0]:tinyEWG.txt
 * 
 * @author he
 *
 */
public class Boruvka {
	private Bag<Edge> mst = new Bag<Edge>();// 保存最小生成树
	private double weight;// 生成树的权重

	public Boruvka(EdgeWeightedGraph G) {
		UF uf = new UF(G.V());
		Edge closest[] = new Edge[G.V()];

		// 找到权重最小的边，顶点i=index,closet[index]保存的都是与顶点i相关联的最小的加权边
		// 因为顶点i关联的另一条权重比较大的加权边可能也是最小生成树的一部分（保证生成树的连通性,比如测试用例的0-2边），因此需要循环
		// 0-2 保存在closet[4]中
		for (int t = 1; t < G.V() && mst.size() < G.V() - 1; t = t + t) {
			for (Edge e : G.edges()) {
				int v = e.either(), w = e.other(v);
				int i = uf.find(v), j = uf.find(w);
				if (i == j)// 表示在同一棵树
					continue;
				if (closest[i] == null || less(e, closest[i]))
					closest[i] = e;
				if (closest[j] == null || less(e, closest[j]))
					closest[j] = e;

			}

			// 第一次遍历已经将每个顶点关联的最小加权边添加到最小生成树中
			for (int i = 0; i < G.V(); i++) {
				Edge e = closest[i];
				int v = e.either();
				int w = e.other(v);
				if (!uf.connected(v, w)) {// 跳过重复的
					mst.add(e);
					weight += e.weight();
					uf.union(v, w);
				}
			}

		}

	}

	private boolean less(Edge e, Edge t) {
		return e.weight() < t.weight();
	}

	public double weight() {
		return weight;
	}

	public Iterable<Edge> mst() {
		return mst;
	}

	public static void main(String[] args) {
		EdgeWeightedGraph G = new EdgeWeightedGraph(new In(args[0]));
		Boruvka mst = new Boruvka(G);
		for (Edge e : mst.mst())
			System.out.println(e);
	}

}
