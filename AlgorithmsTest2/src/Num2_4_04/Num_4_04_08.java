package Num2_4_04;

import edu.princeton.cs.algs4.DijkstraAllPairsSP;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.In;

/**
 * P446 T08
 * 
 * @author he
 *
 */
public class Num_4_04_08 {
	public static void main(String[] args) {
		EdgeWeightedDigraph G = new EdgeWeightedDigraph(new In(args[0]));
		DijkstraAllPairsSP sp = new DijkstraAllPairsSP(G);
		double max = 0.0;
		for (int i = 0; i < G.V(); i++) {
			for (int j = i + 1; j < G.V(); j++) {
				if (max < sp.dist(i, j))
					max = sp.dist(i, j);
			}
		}
		System.out.println("Ö±¾¶£º" + max);

	}
}
