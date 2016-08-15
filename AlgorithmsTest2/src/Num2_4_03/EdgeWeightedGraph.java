package Num2_4_03;

import java.util.LinkedList;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.In;

/**
 * P395 加权无向图的数据类型
 * 
 * @author he
 *
 */
public class EdgeWeightedGraph {
	private final int V;// 顶点总数
	private int E;// 边的总数
	private LinkedList<Edge> adj[];// 领接表

	@SuppressWarnings("unchecked")
	public EdgeWeightedGraph(int V) {
		this.V = V;
		this.E = 0;
		adj = (LinkedList<Edge>[]) new LinkedList[V];
		for (int i = 0; i < V; i++)
			adj[i] = new LinkedList<Edge>();
	}

	public EdgeWeightedGraph(In in) {
		this(in.readInt());
		int E = in.readInt();
		for (int i = 0; i < E; i++) {
			int w = in.readInt();
			int v = in.readInt();
			double weight = in.readDouble();
			addEdge(new Edge(w, v, weight));
		}
	}

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

	/**
	 * 添加一条边
	 * 
	 * @param e
	 */
	public void addEdge(Edge e) {
		int w = e.either();
		int v = e.other(w);
		adj[w].add(e);
		adj[v].add(e);
		E++;
	}

	public void delEdge(Edge e) {
		int w = e.either();
		int v = e.other(w);
		adj[v].remove(e);
		adj[w].remove(e);
		E--;

	}

	/**
	 * 返回和v关联的边
	 * 
	 * @param v
	 * @return
	 */
	public Iterable<Edge> adj(int v) {
		return adj[v];
	}

	/**
	 * 返回图所有的边,不会统计自环
	 * 
	 * @return
	 */
	public Iterable<Edge> edges() {
		Bag<Edge> bag = new Bag<Edge>();
		for (int v = 0; v < V; v++)
			for (Edge e : adj[v])
				if (e.other(v) > v)// 保证每条边只会添加一次
					bag.add(e);
		return bag;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("总共有" + V + "个顶点 " + E + "条边" + "\n");
		for (int v = 0; v < V; v++) {
			sb.append("与" + v + "关联的边:");
			for (Edge e : adj[v]) {
				sb.append(e.toString() + "  ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		EdgeWeightedGraph G = new EdgeWeightedGraph(new In(args[0]));
		System.out.println(G.toString());

	}

}
