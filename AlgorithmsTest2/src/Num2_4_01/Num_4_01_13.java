package Num2_4_01;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

/**
 * P360 T13
 * 
 * @author he
 * args[0]:tinyG.txt
 * args[1]:0
 */
class Breadth {
	private boolean marked[];
	private int edgTo[];
	private final int s;// 起点

	public Breadth(Graph G, int s) {
		this.s = s;
		marked = new boolean[G.V()];
		edgTo = new int[G.V()];
		dfs(G, s);
	}

	private void dfs(Graph G, int v) {
		Queue<Integer> queue = new Queue<Integer>();
		marked[v] = true;
		queue.enqueue(v);
		while(!queue.isEmpty()) {
			int t = queue.dequeue();
			for (int w : G.adj(t)) {
				if (!marked[w]) {
					marked[w] = true;
					edgTo[w] = t;
					queue.enqueue(w);
				}
			}
		}
	}

	public boolean hasPathTo(int v) {
		return marked[v];
	}

	public Iterable<Integer> pathTo(int v) {
		if (!hasPathTo(v))
			return null;
		Stack<Integer> path = new Stack<Integer>();
		for (int x = v; x != s; x = edgTo[x]) {
			path.push(x);
		}
		path.push(s);
		return path;
	}

	public String distTo(int v) {
		if (!hasPathTo(v))
			return null;
		StringBuilder s = new StringBuilder();
		s.append(this.s+"到"+v+"的最短路径:"+"\n");
		for (int w : pathTo(v)) {
			s.append(w + " ");
		}	
		return s.toString();
	}

}

public class Num_4_01_13 {
	public static void main(String[] args) {
		Graph G = new Graph(new In(args[0]));
		Breadth b = new Breadth(G, Integer.valueOf(args[1]));
		System.out.println(b.distTo(4));
	}
}
