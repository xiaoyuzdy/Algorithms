package Number_4;

import edu.princeton.cs.algs4.In;

/**
 * P385 ÅÐ¶Ï¿É´ïÐÔ
 * 
 * @author he
 * args[0]:tinyDG.txt
 */
public class TransitiveClosure {
	private DirectedDFS all[];

	public TransitiveClosure(Digraph G) {
		all = new DirectedDFS[G.V()];
		for (int v = 0; v < G.V(); v++)
			all[v] = new DirectedDFS(G, v);
	}

	public boolean reachable(int v, int w) {
		return all[v].marked(w);
	}
	
	public static void main(String[] args) {
		Digraph G=new Digraph(new In(args[0]));
		TransitiveClosure t=new TransitiveClosure(G);
		System.out.println(t.reachable(6, 12));
	}
	
}
