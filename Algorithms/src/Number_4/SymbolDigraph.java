package Number_4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;

public class SymbolDigraph {
	private ST<String, Integer> st;// 顶点的符号名-->index
	private String keys[];// index--->顶点的符号名
	private Digraph G;// 图

	/**
	 * 
	 * @param filename
	 *            文件的名字
	 * @param sp
	 *            分隔符
	 */
	public SymbolDigraph(String filename, String sp) {
		st = new ST<String, Integer>();
		In in = new In(filename);
		while (in.hasNextLine()) {
			String a[] = in.readLine().split(sp);// 将每行的信息进行分割
			for (int i = 0; i < a.length; i++) {
				if (!st.contains(a[i]))
					st.put(a[i], st.size());// 为每个键分配一个索引
			}
		}

		// index--->顶点符号名
		keys = new String[st.size()];
		for (String name : st.keys())
			keys[st.get(name)] = name;

		G = new Digraph(st.size());
		in = new In(filename);
		while (in.hasNextLine()) {
			String a[] = in.readLine().split(sp);
			int v = st.get(a[0]);
			for (int i = 1; i < a.length; i++) {
				G.addEdge(v, st.get(a[i]));// 将每行的第一个顶点与改行其他顶点相连
			}
		}

	}

	/**
	 * 符号图中是否包含该键
	 * 
	 * @param s
	 * @return
	 */
	public boolean contains(String s) {
		return st.contains(s);
	}

	/**
	 * 返回符号名s的index
	 * 
	 * @param s
	 * @return
	 */
	public int index(String s) {
		return st.get(s);
	}

	/**
	 * 返回index对应的符号名
	 * 
	 * @param index
	 * @return
	 */
	public String name(int index) {
		return keys[index];
	}

	/**
	 * 返回无向图G
	 * 
	 * @return
	 */
	public Digraph G() {
		return G;
	}
}
