package Num2_4_03;

import java.util.HashSet;
import java.util.Set;
import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MaxPQ;

/**
 * P410 T23 删除的是形成环中的权重最大的边 
 * 修改Cycle类，实现检测加权无向图的环检测，
 * 修改无向加权边的数据结构实现可以删除指定边
 * 
 * @author he
 * args[0]:tinyEWG.txt
 *   测试通过
 *
 */
class Vyssotsky {
	private MaxPQ<Edge> pq;
	private Cycle cycle;
	private EdgeWeightedGraph G2;//假设的最小生成树

	public Vyssotsky(EdgeWeightedGraph G) {
		pq = new MaxPQ<Edge>();
		G2 = new EdgeWeightedGraph(G.V());
		for (Edge e : G.edges()) {
			G2.addEdge(e);
			cycle = new Cycle(G2);//每添加一条边就检测一次
			if (cycle.hasCycle()) {//如果形成环将环中最大的加权边删除
				pq = new MaxPQ<Edge>();
				for (Edge t : cycle.path()) {
					pq.insert(t);
				}
				G2.delEdge(pq.max());// 无权有向图中移除要删除的边
			}
		}
	}

	public Iterable<Edge> edges() {
		return G2.edges();
	}

}

public class Num_4_03_23 {
	public static void main(String[] args) {
		EdgeWeightedGraph G = new EdgeWeightedGraph(new In(args[0]));
		Vyssotsky v = new Vyssotsky(G);
		for (Edge e : v.edges())
			System.out.println(e);
	}

}
