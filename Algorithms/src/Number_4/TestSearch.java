package Number_4;
/**
 * P338 
 * args[0]:tinyG.txt
 * args[1]:0
 */
import edu.princeton.cs.algs4.In;

public class TestSearch {
	public static void main(String[] args) {
		Graph G = new Graph(new In(args[0]));
		int s = Integer.valueOf(args[1]);
		Search search = new Search(G, s);
		for (int v = 0; v < G.V(); v++) {
			if (search.marked(v))
				System.out.print(v + " ");
		}
		System.out.println();
		if (search.count() != G.V())
			System.out.print("NOT ");
		System.out.println("connected");
	}
}
