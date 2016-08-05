package Number_4;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

/**
 * P367 算法4.4 有向图的可达性
 * args[0]:tinyDG.txt
 * args[1]:1
 * args[2]:2
 * args[3]:6
 * @author he
 *
 */
public class DirectedDFS {

	private boolean marked[];// 用于标记顶点

	/**
	 * 在G中找到从s可达的所有顶点
	 * 
	 * @param G
	 * @param s
	 */
	public DirectedDFS(Digraph G, int s) {
		marked = new boolean[G.V()];
		dfs(G, s);
	}

	/**
	 * 返回在sources中顶点可达的所有顶点
	 * 
	 * @param G
	 * @param sources
	 */
	public DirectedDFS(Digraph G, Iterable<Integer> sources) {
		marked = new boolean[G.V()];
		for (int w : sources)
			if (!marked[w])
				dfs(G, w);
	}

	private void dfs(Digraph G, int v) {
		marked[v] = true;
		for (int w : G.adj(v)) {
			if (!marked[w])
				dfs(G, w);
		}
	}

	
	/**
	 * 判断顶点v是否可达
	 * 
	 * @param v
	 * @return
	 */
	public boolean marked(int v) {
		return marked[v];
	}

	public static void main(String[] args) {
		Digraph G = new Digraph(new In(args[0]));
		Bag<Integer> bag = new Bag<Integer>();
		for (int i = 1; i < args.length; i++) {
			bag.add(Integer.valueOf(args[i]));
		}

		DirectedDFS dfs = new DirectedDFS(G, bag);
		for (int i = 0; i < G.V(); i++) {
			if (dfs.marked(i))
				System.out.print(i + " ");
		}
		System.out.println();
	}

}
