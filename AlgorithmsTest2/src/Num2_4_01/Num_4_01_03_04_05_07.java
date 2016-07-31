package Num2_4_01;

import java.util.ArrayList;

import edu.princeton.cs.algs4.In;

/**
 * P359 T3 T4 T5 T7 将Bag换为ArrayList args[0]:tinyG.txt
 * 
 * @author he
 *
 */

class Graph {
	private ArrayList<Integer> adj[];// 用于绘图的邻接链表
	private final int V;// 顶点数
	private int E;// 边数

	@SuppressWarnings("unchecked")
	public Graph(int v) {
		this.V = v;
		this.E = 0;
		adj = (ArrayList<Integer>[]) new ArrayList[v];
		for (int i = 0; i < V; i++) {
			adj[i] = new ArrayList<Integer>();
		}
	}

	public Graph(In in) {
		this(in.readInt());
		int E = in.readInt();
		for (int i = 0; i < E; i++) {
			int w = in.readInt();
			int v = in.readInt();
			addEdge(w, v);
		}
	}

	// T3 创建一个图的副本
	public Graph(Graph G) {
		this(G.V());
		this.E = G.E();
		for (int i = 0; i < G.V(); i++) {
			for (int w : G.adj(i))
				adj[i].add(w);
		}
	}

	public void addEdge(int w, int v) {

		try {
			if (w == v)
				throw new Exception("不循序自环");
			if (adj[w] != null && adj[w].contains(v))
				throw new Exception("不允许有平行边");
		} catch (Exception e) {
			e.printStackTrace();
		}
		adj[w].add(v);
		adj[v].add(w);
		E++;
	}

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

	public Iterable<Integer> adj(int v) {
		return adj[v];
	}

	// T4 判断图是否含有此边
	public boolean hasEdge(int w, int v) {
		if (w >= V || v >= V)
			return false;
		for (int w2 : adj(v)) {
			if (w2 == w)
				return true;
			break;
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(V + " 顶点  " + E + " 条边" + "\n");
		for (int v = 0; v < V; v++) {
			sb.append(v + ": ");
			for (int w : adj(v)) {
				sb.append(w + " ");
			}
			sb.append("\n");
		}

		return sb.toString();
	}

}

public class Num_4_01_03_04_05_07 {
	public static void main(String[] args) {
		Graph G = new Graph(new In(args[0]));
		// Graph G2 = new Graph(G);
		System.out.println(G.toString());
		// System.out.println(G2.toString());
		System.out.println(G.hasEdge(9, 12));
		G.addEdge(3, 4);// 异常

	}

}
