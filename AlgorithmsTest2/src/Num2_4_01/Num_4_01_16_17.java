package Num2_4_01;

import edu.princeton.cs.algs4.BreadthFirstPaths;
import edu.princeton.cs.algs4.CC;
import edu.princeton.cs.algs4.Cycle;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;

/**
 * P361 T16 假设图的每条边都相等且每条边变长1
 * 
 * @author he 
 * args[0]:G.txt 
 * args[1]:1
 */

class GraphPreoperties {

	private BreadthFirstPaths b;
	private CC c;
	private Graph G;
	private int rad = 99;// 半径初始为1防止 得到 比如顶点0到顶点0的距离
	private int center;// G的某个中点
	private Cycle cycle;// 用于求周长

	public GraphPreoperties(Graph G) {
		this.G = G;
		c = new CC(G);
		cycle = new Cycle(G);
		if (c.count() != 1)
			try {
				throw new Exception("G不是连通图");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	/**
	 * v的离心率 --->它和离它最远的顶点的最短距离
	 * 
	 * @param v
	 * @return
	 */
	public int eccentricity(int v) {
		b = new BreadthFirstPaths(G, v);
		int length = -1;// 因为b.pathTo添加了起点所以为-1
		int max = length;
		for (int i = 0; i < G.V(); i++) {
			for (int w : b.pathTo(i))
				length++;
			if (max < length)
				max = length;
			length = -1;// 重置
		}
		return max;
	}

	/**
	 * G的直径
	 * 
	 * @return
	 */
	public int diameter() {
		int max = 0;// 直径

		for (int v = 0; v < G.V(); v++) {
			if (max < eccentricity(v))
				max = eccentricity(v);
			// 找半径和中点
			if (eccentricity(v) != 0 && rad > eccentricity(v)) {
				rad = eccentricity(v);
				center = v;
			}
		}
		return max;
	}

	/**
	 * G的半径
	 * 
	 * @return
	 */
	public int radius() {
		if (rad == 0)
			diameter();
		return rad;
	}

	public int center() {
		if (center == 0)
			diameter();
		return center;
	}

	// T17 求图的周长
	public int girth() {

		if (!cycle.hasCycle()) {
			try {
				throw new Exception("图G无环 周长无限大");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int gir = -1;// 会重复起点所以为-1
		for (int c : cycle.cycle()) {
			System.out.print(c + " ");
			gir++;
		}
		return gir;
	}

}

public class Num_4_01_16_17 {

	public static void main(String[] args) {
		Graph G = new Graph(new In(args[0]));
		GraphPreoperties p = new GraphPreoperties(G);
		int i = Integer.valueOf(args[1]);
		System.out.println(i + "离心率为为:" + p.eccentricity(1));// 3
		System.out.println("图G的直径为：" + p.diameter());// 3
		System.out.println("图G的半径为：" + p.radius());// 2
		System.out.println("图G的中心为顶点:" + p.center());// 0
		System.out.println("图G的周长为：" + p.girth());

	}

}
