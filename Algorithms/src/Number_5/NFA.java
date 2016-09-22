package Number_5;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.DirectedDFS;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;

/**
 * P524 正则表达式的模式匹配（grep） 参考书P520、521
 * 
 * @author he
 *
 */
public class NFA {
	private char re[];// 匹配转换
	private Digraph G;// epsilon转换
	private int M;

	// 构建NFA（不确定有限状态机）并转换为有向图

	/**
	 * 注意注意！！！！！所有字母指向后一个字符的可达性都是在方法recognizes中添加的（见该方法）！！！！！！
	 * 书中P525的图是执行了构造函数NFA（String pre）和方法recognizes后才能产生的NFA，只执行构造函数有几个状态是不可达的
	 * 比如：2-->3的另一条边，4-->5，6-->7，7-->8，9-->10，只有在执行了recognizes方法后才具有可达性，
	 * 书中的图有一定的误导性
	 * 
	 * @param pre
	 */
	public NFA(String pre) {
		Stack<Integer> ops = new Stack<Integer>();
		re = pre.toCharArray();
		M = re.length;
		G = new Digraph(M + 1);

		for (int i = 0; i < M; i++) {
			int lp = i;
			if (re[i] == '(' || re[i] == '|')
				ops.push(i);
			else if (re[i] == ')') {
				int or = ops.pop();
				if (re[or] == '|') {
					lp = ops.pop();
					G.addEdge(lp, or + 1);
					G.addEdge(or, i);
				} else
					lp = or;
			}

			if (i < M - 1 && re[i + 1] == '*') {
				G.addEdge(lp, i + 1);
				G.addEdge(i + 1, lp);
			}
			if (re[i] == '(' || re[i] == '*' || re[i] == ')')
				G.addEdge(i, i + 1);

		}

		// 只执行构造函数9-->10 不可达
		// DirectedDFS dfs = new DirectedDFS(G, 9);
		// System.out.println(dfs.marked(10));

	}

	/**
	 * 判断NFA能否识别文本 就是有向图的可向性检测（单起点，多起点），经过多次的可达性检测（后一个字符是否能由前一个字符可达）能否到达可接受状态M，
	 * 如果可达则表示该文本能被模式识别
	 * 
	 * @param txt
	 * @return
	 */
	public boolean recognizes(String txt) {
		Bag<Integer> pc = new Bag<Integer>();
		DirectedDFS dfs = new DirectedDFS(G, 0);
		for (int v = 0; v < G.V(); v++)
			if (dfs.marked(v))
				pc.add(v);// 可达则添加，获得所有初始状态0的可达状态

		for (int i = 0; i < txt.length(); i++) {
			Bag<Integer> match = new Bag<Integer>();// 用于记录字符所有的可转换状态，比如A的可转换状态有3和7
			for (int v : pc) {
				if (v < M) {// 未到达可接受状态M，M的值表示可接受状态
					if (re[v] == txt.charAt(i) || re[v] == '.') {
						// 如果re[v]在字母表中那么可以得到v到v+1的转化，比如字符A具有状态2和状态6两种状态，那么可以得到它的转换状态3和7
						// 见书P521
						//
						// 在此处添加了字母指向后一个字符的可达性！！！！！
						//
						match.add(v + 1);
					}
				}
			}

			pc = new Bag<Integer>();// 重置
			dfs = new DirectedDFS(G, match);

			// 多起点可达性检测，比如字符A的转换状态有{3,7}，则以{3,7}为起点进行可达性检测并将可达的状态添加到pc中
			for (int v = 0; v < G.V(); v++)
				if (dfs.marked(v))
					pc.add(v);

		}

		for (int v : pc)
			if (v == M)
				return true;// 到达可接受状态，则NFA能识别文本
		return false;
	}

	public static void main(String[] args) {
		String regexp = "(.*" + args[0] + ".*)";
		// String regexp = "((A*B|AC)D)";
		NFA nfa = new NFA(regexp);

		In in = new In(args[1]);
		while (!in.isEmpty()) {
			String txt = in.readLine();
			if (nfa.recognizes(txt))
				System.out.println(txt);
		}

	}

}
