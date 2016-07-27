package Number_4;

import edu.princeton.cs.algs4.In;

/**
 * P339 深度优先搜索（DFS） 
 * 在其访问一个顶点时： 
 *  1、将它标记为已访问； 
 *  2、递归地访问它所有没有被标记过的邻居顶点
 * 如果图是连通的count=G.V,即count等于无向图的顶点数
 * 
 * @author he
 *args[0]:tinyCG.txt
 *args[1]:0
 */
public class DepthFirstSearch {
	private boolean[] marked;// 记录顶点是否被标记
	private int count;// 标记过的顶点数量

	// s为起点
	public DepthFirstSearch(Graph G, int s) {
		marked = new boolean[G.V()];
		dfs(G, s);
	}

	public void dfs(Graph G, int s) {
		marked[s] = true;
		count++;
		for (int w : G.adj(s))
			// 如果未被标记,递归
			if (!marked(w))
				dfs(G, w);
	}

	// 判断v是否被标记过
	public boolean marked(int v) {
		return marked[v];
	}

	// 返回已经被标记的顶点数量
	public int count() {
		return count;
	}

	public static void main(String[] args) {

		Graph G = new Graph(new In(args[0]));
		int s = Integer.valueOf(args[1]);// 起点
		DepthFirstSearch dfs = new DepthFirstSearch(G, s);
		System.out.println(G.V());
		System.out.println(dfs.count);
		System.out.println("无向图G是否连通？ " + (dfs.count == G.V()));
	}

}
