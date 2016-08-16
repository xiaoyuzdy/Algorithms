package Num2_4_03;

import java.util.Collections;
import java.util.LinkedList;
import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.UF;

/**
 * P410 T24
 * 
 * @author he
 *
 */

class EWG_ {
	private UF uf;
	private LinkedList<Edge> list;// 保存所有的加权边,默认升序排列
	private int E;
	private final int V;

	public EWG_(EdgeWeightedGraph G) {
		list = new LinkedList<Edge>();
		this.E = G.E();
		this.V = G.V();
		for (Edge e : G.edges()) {
			list.add(e);
		}
		Collections.sort(list);//升序
		find(list);
	}

	/**
	 * 找到最小生成树
	 * 
	 * @param G
	 * @param set
	 */
	private void find(LinkedList<Edge> list) {
		int index = E;
		while (list.size() > V - 1) {
			Edge t = list.get(index - 1);// 从后向前获取边
			uf = new UF(V);
			int v = t.either();
			int w = t.other(v);
			for (Edge e : list) {
				if (e == t)
					continue;// 过滤t,如果t的两个端点还能连通表示t可以remove()
				int tv = e.either();
				int tw = e.other(tv);
				uf.union(tv, tw);
			}
			if (uf.connected(v, w)) {
				list.remove(t);
				index--;// list.size减小,index--
			} else {
				index--;// 跳过无法remove的边
			}

		}

	}

	/**
	 * 返回最小生成树
	 * @return
	 */
	public String mst() {
		return list.toString();
	}

}

public class Num_4_03_24 {
	public static void main(String[] args) {
		EdgeWeightedGraph G = new EdgeWeightedGraph(new In(args[0]));
		EWG_ e = new EWG_(G);
		System.out.println(e.mst());
	}

}
