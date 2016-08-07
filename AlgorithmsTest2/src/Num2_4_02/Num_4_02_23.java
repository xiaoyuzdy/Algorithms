package Num2_4_02;

import java.util.ArrayList;
import java.util.Collections;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;

/**
 * P387 T23
 * 
 * @author he args[0]:tinyDG.txt
 */

class SC {
	private Digraph G;
	private ArrayList<Integer> l1;// 保存顶点v可到达的顶点
	private boolean marked[];
	ArrayList<String> l;// 保存所有的强连通分量

	public SC(Digraph G) {
		this.G = G;
		marked = new boolean[G.V()];
	}

	// 可达性分析
	private void dfs(int v) {
		marked[v] = true;
		for (int w : G.adj(v))
			if (!marked[w])
				dfs(w);
	}

	/**
	 * 返回v所在的强连通量包含的所有顶点
	 * 
	 * @param v
	 * @return
	 */
	public String count(int v) {
		l1 = new ArrayList<Integer>();
		dfs(v);// 可达性检测
		for (int i = 0; i < G.V(); i++) {
			if (marked[i] == true && i != v)
				l1.add(i);
		}

		marked = new boolean[G.V()];// 重置

		for (int i = 0; i < l1.size(); i++) {
			dfs(l1.get(i));
			if (marked[v] != true) {
				l1.remove(i);// 将不是强连通的顶点移除
				i--;// 因为l1.size改变
			}
			marked = new boolean[G.V()];// 重置
		}
		l1.add(v);
		Collections.sort(l1);// 排序，便于过滤相同的强连通分量
		return l1.toString();
	}

	/**
	 * 返回强连通分量的数目
	 * 
	 * @return
	 */
	public int count() {
		if (l == null)
			Allcont();
		return l.size();
	}

	/**
	 * 返回所有的强连通分量
	 * 
	 * @return
	 */
	public String Allcont() {
		l = new ArrayList<String>();
		l.add(count(0));
		for (int v = 1; v < G.V(); v++) {
			if (l.get(l.size() - 1).contains(String.valueOf(v))) {
				continue;
			}
			if (l.contains(count(v)))
				continue;
			l.add(count(v));
		}
		return l.toString();
	}

}

public class Num_4_02_23 {
	public static void main(String[] args) {
		Digraph G = new Digraph(new In(args[0]));
		SC sc = new SC(G);
		System.out.println(sc.count());
		System.out.println(sc.count(7));
		System.out.println(sc.Allcont());

	}
}
