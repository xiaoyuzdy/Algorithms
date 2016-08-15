package Num2_4_03;

import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.Queue;

/**
 * P409 T10
 * 
 * @author he
 *
 */

class EWG {
	private Edge adj[][];// 二维数组构成的邻接表
	private final int V;
	private int E;

	public EWG(int v) {
		this.V = v;
		this.E = 0;
		adj = new Edge[V][V];
	}

	public void addEdge(Edge e) {
		int v = e.either();
		int w = e.other(v);
		if (adj[v][w] == null) {// 不允许平行边
			adj[v][w] = e;
			adj[w][v] = e;
			E++;
		} else
			throw new RuntimeException("不允许有平行边");
	}

	public int E() {
		return E;
	}

	public int V() {
		return V;
	}

	public Iterable<Edge> adj(int v) {
		Queue<Edge> queue = new Queue<>();
		for (int i = 0; i < V; i++) {
			if (adj[v][i] != null)
				queue.enqueue(adj[v][i]);
		}
		return queue;
	}

}

public class Num_4_03_10 {

	public static void main(String[] args) {
		EWG ewg = new EWG(3);
		ewg.addEdge(new Edge(0, 1, .2));
		ewg.addEdge(new Edge(0, 2, .3));
		ewg.addEdge(new Edge(2, 1, .4));
		for (Edge e : ewg.adj(0))
			System.out.println(e);

	}
}
