package Num2_4_04;

import java.text.DecimalFormat;
import java.util.LinkedList;

import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Stack;

/**
 * P446 T07 加权有向图中从起点到达指定顶点有两条权重相同的边 
 * 注意double在计算的时候小数点后面有16位，因此在比较的时候要强转
 * 我写的只适合起点到某个顶点（只有这一个顶点）含有两条相同的最短路径
 * @author he
 *	args[0]:tinyEWDsame.txt
 */

class Dijkdtra {
	private DirectedEdge edgeTo[];
	private LinkedList<DirectedEdge> q;// 记录另一条最短路径
	private double distTo[];
	private IndexMinPQ<Double> pq;
	DecimalFormat d;// 指定double在计算时保留的位数

	/**
	 * 
	 * @param G
	 *            不含负权重的有向图
	 * @param s
	 *            起点
	 * @param bit
	 *            指定权重在计算时保留的位数
	 */
	public Dijkdtra(EdgeWeightedDigraph G, int s, int bit) {
		edgeTo = new DirectedEdge[G.V()];
		distTo = new double[G.V()];
		pq = new IndexMinPQ<Double>(G.V());
		q = new LinkedList<DirectedEdge>();
		String b = "0.";
		for (int i = 0; i < bit; i++) {
			b += "0";
		}
		d = new DecimalFormat("###" + b);

		for (int i = 0; i < G.V(); i++) {
			distTo[i] = Double.POSITIVE_INFINITY;
		}
		distTo[s] = 0.0;
		pq.insert(s, distTo[s]);

		while (!pq.isEmpty()) {
			relax(G, pq.delMin());
		}
	}

	private void relax(EdgeWeightedDigraph G, int v) {
		for (DirectedEdge e : G.adj(v)) {
			int w = e.to();
			if (distTo[w] == Double.valueOf(d.format(distTo[v] + e.weight()))) {
				for (DirectedEdge t : path(v)) {
					q.add(t);
				}
				q.add(e);
			}
			if (distTo[w] > distTo[v] + e.weight()) {
				distTo[w] = distTo[v] + e.weight();
				edgeTo[w] = e;
				if (pq.contains(w))
					pq.changeKey(w, distTo[w]);
				else
					pq.insert(w, distTo[w]);
			} else if (distTo[w] == distTo[v] + e.weight()) {
				System.out.println("xxxx");
			}
		}
	}

	public boolean hasPathTo(int v) {
		return distTo[v] < Double.POSITIVE_INFINITY;
	}

	public Iterable<DirectedEdge> path(int v) {
		if (!hasPathTo(v))
			return null;
		Stack<DirectedEdge> path = new Stack<DirectedEdge>();
		for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()])
			path.push(e);
		return path;
	}

	public double distTo(int v) {
		return distTo[v];
	}

	public boolean hasOtherPath(int v) {
		if (q.size() == 0)
			return false;
		DirectedEdge e = q.getLast();
		int w = e.to();
		return w == v;
	}

	public Iterable<DirectedEdge> otherPath(int v) {
		if (!hasPathTo(v))
			return null;
		if (!hasOtherPath(v))
			return null;
		return q;

	}

}

public class Num_4_04_07 {
	public static void main(String[] args) {
		EdgeWeightedDigraph G = new EdgeWeightedDigraph(new In(args[0]));
		int s = 0;
		Dijkdtra sp = new Dijkdtra(G, s, 2);
		for (int t = 0; t < G.V(); t++) {
			System.out.print(s + " to " + t);
			System.out.printf(" (%4.2f): ", sp.distTo(t));
			if (sp.hasPathTo(t))
				for (DirectedEdge e : sp.path(t))
					System.out.print(e + " ");
			System.out.println();
			if (sp.hasOtherPath(t)) {
				System.out.println("other path:");
				System.out.print("    " + s + " to " + t);
				System.out.printf(" (%4.2f): ", sp.distTo(t));
				for (DirectedEdge e : sp.otherPath(t))
					System.out.print(e + " ");
				System.out.println();
			}
		}
	}

}
