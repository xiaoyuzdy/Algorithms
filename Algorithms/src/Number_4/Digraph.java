package Number_4;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

/**
 * P366 Digraph（有向图）数据类型 
 * 代码和无向图基本类似，只是在添加边时无需添加两次 
 * 同时加入了有向图取反，这样可以得到指向每个顶点的所有的边
 * 
 * @author he
 *  args[0]:tinyDG.txt
 */
public class Digraph {

	private final int V;// 有向图的顶点个数
	private int E;// 边的个数
	private Bag<Integer> adj[];// 邻接表

	@SuppressWarnings("unchecked")
	public Digraph(int v) {
		this.V = v;
		this.E = 0;
		adj = (Bag<Integer>[]) new Bag[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new Bag<Integer>();
		}
	}

	public Digraph(In in) {
		this(in.readInt());
		int E = in.readInt();
		for (int i = 0; i < E; i++) {
			int v = in.readInt();
			int w = in.readInt();
			addEdge(v, w);
		}
	}

	/**
	 * 添加边
	 * 
	 * @param v
	 * @param w
	 */
	public void addEdge(int v, int w) {
		adj[v].add(w);
		E++;
	}

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

	/**
	 * 返回所有顶点v指向的顶点
	 * 
	 * @param v
	 * @return
	 */
	public Iterable<Integer> adj(int v) {
		return adj[v];
	}

	/**
	 * 有向图的反向图，可得到所有指向顶点的边
	 * 
	 * @return
	 */
	public Digraph reverse() {
		Digraph d = new Digraph(V);
		for (int v = 0; v < V; v++) {
			for (int w : adj(v))
				d.addEdge(w, v);
		}
		return d;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("有" + V + "个顶点" + "   " + E + "条边" + "\n");
		for (int v = 0; v < V; v++) {
			s.append(v + ": ");
			for (int w : adj(v))
				s.append(w + " ");
			s.append("\n");
		}
		return s.toString();
	}

	public static void main(String[] args) {
		Digraph dg = new Digraph(new In(args[0]));
		System.out.println(dg.toString());
		Digraph gd = dg.reverse();
		System.out.println(gd.toString());
	}

}
