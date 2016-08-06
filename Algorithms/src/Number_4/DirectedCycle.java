package Number_4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;

/**
 * P372 寻找有向图中的环（基于深度优先搜索）
 * 
 * @author he
 *  args[0]:tinyDG.txt
 */
public class DirectedCycle {
	private boolean marked[];// 标记顶点
	private int edgeTo[];// 保存自环路径上的顶点
	private boolean onStack[];// 递归调用的栈上的所有顶点
	private Stack<Integer> cycle;// 保存完整的自环路径

	public DirectedCycle(Digraph G) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		onStack = new boolean[G.V()];

		for (int v = 0; v < G.V(); v++) {
			if (!marked[v])
				dfs(G, v);
		}

	}

	private void dfs(Digraph G, int v) {

		onStack[v] = true;
		marked[v] = true;
		for (int w : G.adj(v)) {
			if (this.hasCycle())// 找到一个环以后就退出
				return;
			else if (!marked[w]) {
				edgeTo[w] = v;
				dfs(G, w);
			}
			// 表是存在w-v的边
			else if (onStack[w]) {
				cycle = new Stack<Integer>();
				for (int x = v; x != w; x = edgeTo[x]) {
					cycle.push(x);
				}
				cycle.push(w);
				cycle.push(v);
			}

		}
		onStack[v] = false;
	}

	public boolean hasCycle() {
		return cycle != null;
	}

	public Iterable<Integer> cycle() {
		return cycle;
	}

	public static void main(String[] args) {
		Digraph G = new Digraph(new In(args[0]));
		DirectedCycle d = new DirectedCycle(G);
		if (d.hasCycle()) {
			for (int x : d.cycle())
				System.out.print(x + " ");
		}
	}

}
