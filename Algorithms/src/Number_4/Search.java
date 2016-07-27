package Number_4;

/**
 * 	P337 API
 */

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Search {
	private WeightedQuickUnionUF uf;
	private int s;// 起点
	private int V;// 顶点总数

	// 找到和起点s连通的所有顶点（包含自身）
	public Search(Graph G, int s) {
		uf = new WeightedQuickUnionUF(G.V());
		this.s = s;
		this.V = G.V();
		// 将图G所有的边添加到uf中
		for (int i = 0; i < G.V(); i++) {
			for (int w : G.adj(i)) {
				uf.union(w, i);
			}
		}
	}

	// v和s是否连通
	public boolean marked(int v) {
		return uf.connected(v, s);
	}

	// 与起点连通的顶点总数
	public int count() {
		int count = 0;
		for (int i = 0; i < V; i++) {
			if (marked(i))
				count++;
		}
		return count;
	}
}
