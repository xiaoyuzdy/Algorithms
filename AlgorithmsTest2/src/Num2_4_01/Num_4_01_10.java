package Num2_4_01;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;

/**
 * P360 T11
 * args[0]:G.txt  
 * args[1]:2
 * 
 * @author he
 *
 */
class DeepS {
	private boolean marked[];
	private int t;// 可删除的顶点

	public DeepS(Graph G, int v) {
		marked = new boolean[G.V()];
		dfs(G, v);
	}

	public void dfs(Graph G, int v) {
		marked[v] = true;
		for (int w : G.adj(v)) {
			if (!marked[w])
				dfs(G, w);
			else
				t = v;
		}
	}

	//可以删除的顶点
	public int canDel() {
		return t;
	}

}

public class Num_4_01_10 {
	public static void main(String[] args) {
		Graph G = new Graph(new In(args[0]));
		int v = Integer.valueOf(args[1]);//起点
		DeepS d=new DeepS(G, v);
		System.out.println(d.canDel());//0
	}
}
