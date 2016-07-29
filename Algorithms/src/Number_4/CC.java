package Number_4;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

/**
 * P349 算法4.3 使用深度优先搜索找出图的中连通分量，判断图是否有环以及图是否是二分图 args[0]:tinyG.txt
 * 
 * @author he
 *
 */
public class CC {
	private boolean marked[];// 用于标记已探索过的点
	private int id[];// 用于储存连通分量，用顶点为index,如果保存的值相同则认为顶点在一个连通分量上
	private int count;// 连通分量的数量

	public CC(Graph G) {
		marked = new boolean[G.V()];
		id=new int[G.V()];
		for (int v = 0; v < G.V(); v++) {
			if (!marked[v]) {
				dfs(G, v);
				// 因为在dfs之后执行，所以当图的所有顶点都遍历完后又执行了count++，
				// 所以即使count是从0开始，结束时count的值也和连通分量的个数相同
				count++;
			}
		}
	}

	/**
	 * 遍历所有连通分量
	 * 
	 * @param G
	 * @param v
	 */
	public void dfs(Graph G, int v) {
		marked[v] = true;
		id[v] = count;// 存储连通分量的信息
		for (int w : G.adj(v)) {
			if (!marked[w])
				dfs(G, w);
		}
	}

	/**
	 * 连通分量的数量
	 * 
	 * @return
	 */
	public int count() {
		return count;
	}

	/**
	 * 判断两个顶点是否连通
	 * 
	 * @param w
	 * @param v
	 * @return
	 */
	public boolean connected(int w, int v) {
		return id[w] == id[v];
	}

	/**
	 * 返回顶点v所属的连通分量
	 * 
	 * @param v
	 * @return
	 */
	public int id(int v) {
		return id[v];
	}

	public static void main(String[] args) {
		Graph G = new Graph(new In(args[0]));
		CC c = new CC(G);

		int M = c.count;
		System.out.println("总共有" + M + "个连通分量");
		// 使用bag保存在同一个连通分量上的顶点
		@SuppressWarnings("unchecked")
		Bag<Integer> bag[] = (Bag<Integer>[]) new Bag[M];
		for (int i = 0; i < M; i++)
			bag[i] = new Bag<Integer>();

		for (int v = 0; v < G.V(); v++)
			bag[c.id(v)].add(v);// 将在同一个连通分量的顶点添加到同一个背包中

		// 打印
		for (int i = 0; i < M; i++) {
			for (int x : bag[i]) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
	}

}
