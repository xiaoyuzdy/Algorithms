package Number_4;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

/**
 * P349 算法4.3 
 * 使用深度优先搜索找出图的中连通分量，
 * 判断图是否有环(假设图不存在自环或平行边)以及图是否是二分图 
 * args[0]:tinyG.txt
 * 
 * @author he
 *
 */
public class CC {
	private boolean marked[];// 用于标记已探索过的点
	private int id[];// 用于储存连通分量，用顶点为index,如果保存的值相同则认为顶点在一个连通分量上
	private int count;// 连通分量的数量
	private Graph G;
	private boolean hasCycle;// 假设图不存在自环或平行边
	private boolean[] color;// 保存顶点的颜色
	private boolean isTwoColorable = true;// 判断是否是二分图

	public CC(Graph G) {
		this.G = G;
		marked = new boolean[G.V()];
		color = new boolean[G.V()];
		id = new int[G.V()];
		for (int v = 0; v < G.V(); v++) {
			if (!marked[v]) {
				dfs(G, v, v);
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
	public void dfs(Graph G, int v, int u) {
		marked[v] = true;
		id[v] = count;// 存储连通分量的信息
		for (int w : G.adj(v)) {
			if (!marked[w]) {
				color[w] = !color[v];
				dfs(G, w, v);
			} else if (w != u)
				//如果可以通过两个顶点递归遍历到v则认为有环
				hasCycle = true;
			if (color[w] == color[v])
				isTwoColorable = false;
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

	/**
	 * 打印连通分量
	 * 
	 * @return
	 */
	public String printComponents() {
		StringBuilder sb = new StringBuilder();
		@SuppressWarnings("unchecked")
		// 使用bag保存在同一个连通分量上的顶点
		Bag<Integer> bag[] = (Bag<Integer>[]) new Bag[count];
		for (int i = 0; i < count; i++) {
			bag[i] = new Bag<Integer>();
		}
		// 将在同一个连通分量上的顶点添加到对于的bag中
		for (int v = 0; v < G.V(); v++) {
			bag[id(v)].add(v);
		}
		for (int v = 0; v < count; v++) {
			for (int w : bag[v]) {
				sb.append(w + " ");
			}
			sb.append("\n");
		}

		return sb.toString();
	}

	/**
	 * 判断图是否有环 假设图不存在自环或平行边
	 * 
	 * @return
	 */
	public boolean hasCycle() {
		return hasCycle;
	}

	/**
	 * 判断图是否是二分图
	 * 
	 * @return
	 */
	public boolean isBipartite() {
		return isTwoColorable;
	}

	public static void main(String[] args) {
//		Graph G = new Graph(new In(args[0]));
		Graph G=new Graph(3);
		G.addEdge(0, 1);
		G.addEdge(0, 2);
		CC c = new CC(G);

		int M = c.count;
		System.out.println("总共有" + M + "个连通分量");
		System.out.println(c.printComponents());
		System.out.println(c.hasCycle);// true
		System.out.println(c.isTwoColorable);// false
	}

}
