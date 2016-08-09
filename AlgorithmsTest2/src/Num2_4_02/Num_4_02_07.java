package Num2_4_02;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.Queue;

/**
 * P386 T7
 * 
 * @author he
 *
 */

class Degrees {
	private Digraph G;
	private Digraph reG;// G的反向图

	public Degrees(Digraph G) {
		this.G = G;
		reG = G.reverse();
	}

	/**
	 * 顶点v的入度
	 * 
	 * @param v
	 * @return
	 */
	public int indegree(int v) {
		int t = 0;
		for (int w : reG.adj(v))
			t++;
		return t;
	}

	/**
	 * 顶点v的出度
	 * 
	 * @param v
	 * @return
	 */
	public int outdegree(int v) {
		int t = 0;
		for (int w : G.adj(v))
			t++;
		return t;
	}

	/**
	 * 所有起点的集合，入度为0的顶点为起点
	 * 
	 * @return
	 */
	public Iterable<Integer> sources() {
		Queue<Integer> queue = new Queue<Integer>();
		for (int i = 0; i < G.V(); i++) {
			if (indegree(i) == 0)
				queue.enqueue(i);
		}
		return queue;

	}

	/**
	 * 所有终点的集合,出度为0的顶点为终点
	 * 
	 * @return
	 */
	public Iterable<Integer> sinks() {
		Queue<Integer> queue = new Queue<Integer>();
		for (int i = 0; i < G.V(); i++) {
			if (outdegree(i) == 0)
				queue.enqueue(i);
		}
		return queue;
	}

	/**
	 * G是否是一幅映射，每个顶点出度均为1的有向图为映射
	 * 
	 * @return
	 */
	public boolean isMap() {
		for (int i = 0; i < G.V(); i++) {
			if (outdegree(i) != 1)
				return false;
		}
		return true;
	}

}

public class Num_4_02_07 {
	public static void main(String[] args) {
		Digraph G = new Digraph(3);
		G.addEdge(1, 0);
		G.addEdge(2, 1);
		Degrees d = new Degrees(G);
		System.out.println(d.indegree(0));
		System.out.println(d.outdegree(0));
		System.out.println(d.isMap());

	}

}
