package Number_4_02;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.EdgeWeightedDirectedCycle;
import edu.princeton.cs.algs4.In;

/**
 * P438 算法4.11 基于队列的Bellman-Ford算法，寻找一般有向图的路径，所需时间和EV成正比，空间和V成正比
 * 
 * @author he args[0]:tinyEWDnc.txt args[1]:0
 */
public class BellmanFordSP {
	private DirectedEdge edgeTo[];// 从起点到某个顶点最短路径上的边
	private double distTo[];// 从起点到某顶点的权重
	private Queue<Integer> queue;// 保存正在放松的顶点
	private boolean onQ[];// 保证队列中不含重复的元素

	private int cost;// relac()的调用次数
	private Iterable<DirectedEdge> cycle;// edgeTo[]中是否含负权重环

	public BellmanFordSP(EdgeWeightedDigraph G, int s) {
		edgeTo = new DirectedEdge[G.V()];
		distTo = new double[G.V()];
		queue = new Queue<Integer>();
		onQ = new boolean[G.V()];

		for (int v = 0; v < G.V(); v++)
			distTo[v] = Double.POSITIVE_INFINITY;
		distTo[s] = 0.0;
		queue.enqueue(s);
		onQ[s] = true;

		while (!queue.isEmpty() && !hasNegativeCycle()) {
			int v = queue.dequeue();
			onQ[v] = false;
			relax(G, v);
		}

	}

	/**
	 * 放松边
	 * 
	 * @param G
	 * @param s
	 */
	private void relax(EdgeWeightedDigraph G, int v) {
		for (DirectedEdge e : G.adj(v)) {
			int w = e.to();
			if (distTo[w] > distTo[v] + e.weight()) {
				distTo[w] = distTo[v] + e.weight();
				edgeTo[w] = e;
				if (!onQ[w]) {
					queue.enqueue(w);// 如果存在负权重环，则队列永远不会为空
					onQ[w] = true;
				}
			}

			// 如果含有负权重环则edgeTo[index]标记过的边会含环，而图G含有一般的环则edgeTo[index]标记过的边不会含环
			if (cost++ % G.V() == 0) {
				findNegativeCycle();
				if (hasNegativeCycle()) {
					return;
				}
			}
		}

	}

	/**
	 * 返回起点到达顶点v的权重
	 * 
	 * @param v
	 * @return
	 */
	public double distTo(int v) {
		if (hasNegativeCycle())
			throw new UnsupportedOperationException("Negative cost cycle exists");
		return distTo[v];

	}

	/**
	 * 判断起点能否到达指定顶点
	 * 
	 * @return
	 */
	public boolean hasPathTo(int v) {
		return distTo[v] < Double.POSITIVE_INFINITY;
	}

	/**
	 * 返回从起点到达指定顶点的最短路径
	 * 
	 * @param v
	 * @return
	 */
	public Iterable<DirectedEdge> pathTo(int v) {
		if (hasNegativeCycle())
			throw new UnsupportedOperationException("Negative cost cycle exists");
		if (!hasPathTo(v))
			return null;
		Stack<DirectedEdge> stack = new Stack<DirectedEdge>();
		for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
			stack.push(e);
		}
		return stack;
	}

	/**
	 * 查找负权重环，只是一般的环检测
	 */
	private void findNegativeCycle() {
		int V = edgeTo.length;
		EdgeWeightedDigraph spt = new EdgeWeightedDigraph(V);
		for (int i = 0; i < V; i++) {
			if (edgeTo[i] != null)
				spt.addEdge(edgeTo[i]);
		}

		EdgeWeightedDirectedCycle c = new EdgeWeightedDirectedCycle(spt);
		cycle = c.cycle();
	}

	/**
	 * 判断是否含负权重环
	 * 
	 * @return
	 */
	public boolean hasNegativeCycle() {
		return cycle != null;
	}

	/**
	 * 返回负权重环
	 * 
	 * @return
	 */
	public Iterable<DirectedEdge> negativeCycle() {
		return cycle;
	}

	public static void main(String[] args) {
		In in = new In(args[0]);
		int s = Integer.parseInt(args[1]);
		EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);

		BellmanFordSP sp = new BellmanFordSP(G, s);

		if (sp.hasNegativeCycle()) {
			for (DirectedEdge e : sp.negativeCycle())
				StdOut.println(e);
		}

		else {
			for (int v = 0; v < G.V(); v++) {
				if (sp.hasPathTo(v)) {
					StdOut.printf("%d to %d (%5.2f)  ", s, v, sp.distTo(v));
					for (DirectedEdge e : sp.pathTo(v)) {
						StdOut.print(e + "   ");
					}
					StdOut.println();
				} else {
					StdOut.printf("%d to %d           no path\n", s, v);
				}
			}
		}

	}
}
