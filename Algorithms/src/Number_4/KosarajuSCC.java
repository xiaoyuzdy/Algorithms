package Number_4;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

/**
 * P380 算法4.6 求有向图的强连通分量 对图G的反向图的逆后序进行查找连通分量（和无向图求连通 分量相同）
 * 
 * @author he args[0]:tinyDG.txt
 */
public class KosarajuSCC {
	private boolean marked[];// 用于标记顶点
	private int count;// 强连通分量的数量
	private int id[];// index为顶点的值，如果id[index]相同则表示在同一个强连通分量中

	public KosarajuSCC(Digraph G) {
		DepthFirstOrder order = new DepthFirstOrder(G.reverse());// 获取图G的反向图
		marked = new boolean[G.V()];
		id = new int[G.V()];
		// 反向图的逆后序排序，即反向图的拓扑图
		for (int v : order.reversePost()) {
			if (!marked[v]) {
				dfs(G, v);
				count++;
			}
		}
	}

	// 可达性分析,可达marked标记true
	private void dfs(Digraph G, int v) {
		marked[v] = true;
		id[v] = count;
		for (int w : G.adj(v))
			if (!marked[w])
				dfs(G, w);
	}

	/**
	 * 强连通分量的数量
	 * 
	 * @return
	 */
	public int count() {
		return count;
	}

	public boolean stronglyConnected(int v, int w) {
		return id[w] == id[v];
	}

	/**
	 * 返回顶点v所在的强连通分量
	 * 
	 * @param v
	 * @return
	 */
	public int id(int v) {
		return id[v];
	}

	public static void main(String[] args) {
		Digraph G = new Digraph(new In(args[0]));
		KosarajuSCC scc = new KosarajuSCC(G);
		int M = scc.count();
		@SuppressWarnings("unchecked")
		Bag<Integer> bag[] = (Bag<Integer>[]) new Bag[M];
		for (int i = 0; i < M; i++) {
			bag[i] = new Bag<Integer>();
		}
		for (int i = 0; i < G.V(); i++)
			bag[scc.id(i)].add(i);
		System.out.println("总共有"+M+"个强连通分量");
		System.out.println("打印所有的强连通分量：");
		for (int i = 0; i < M; i++) {
			for (int w : bag[i])
				System.out.print(w + " ");
			System.out.println();
		}
	}

}
