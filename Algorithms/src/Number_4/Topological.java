package Number_4;

/**
 * P375 算法4.5 拓扑排序（借助于有向图的无环检查和顶点排序） 
 * 无环有向图的拓扑排序就是顶点的逆后序排列
 * 
 * @author he
 * args[0]:jobs.txt
 * args[1]:/
 */
public class Topological {
	private Iterable<Integer> order;// 顶点的拓扑顺序

	public Topological(Digraph G) {
		DirectedCycle cycle = new DirectedCycle(G);
		if (!cycle.hasCycle()) {
			DepthFirstOrder d = new DepthFirstOrder(G);
			order = d.reversePost();
		}
	}

	public Iterable<Integer> order() {
		return order;
	}

	public boolean isDAG() {
		return order != null;
	}

	public static void main(String[] args) {
		String filename = args[0];// 文件名
		String sp = args[1];// 分隔符
		SymbolDigraph sg = new SymbolDigraph(filename, sp);
		Topological top = new Topological(sg.G());
		for (int w : top.order)
			System.out.println(sg.name(w));
	}
}
