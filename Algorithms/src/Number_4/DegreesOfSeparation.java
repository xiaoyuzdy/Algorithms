package Number_4;

import edu.princeton.cs.algs4.StdIn;

/**
 * P358 间隔的度数（找最短路径）
 * 
 * @author he 
 * args[0]:routes.txt 
 * args[1]:" " 
 * args[2]:JFK
 */
public class DegreesOfSeparation {
	public static void main(String[] args) {
		SymbolGraph sg = new SymbolGraph(args[0], args[1]);
		Graph G = sg.G();
		String database = args[2];
		if (!sg.contains(database)) {
			System.out.println("not in database");
			return;
		}

		// 以database为起点的广度优先搜索
		BreadthFirstPaths bfp = new BreadthFirstPaths(G, sg.index(database));
		while (!StdIn.isEmpty()) {
			String sink = StdIn.readLine();
			if (sg.contains(sink)) {
				if (bfp.hasPathTo(sg.index(sink))) {
					for (int w : bfp.pathTo(sg.index(sink))) {
						System.out.println(" " + sg.name(w));
					}
				} else {
					System.out.println("No connected");
				}

			} else {
				System.out.println(sink + "not in database");
			}
		}

	}

}
