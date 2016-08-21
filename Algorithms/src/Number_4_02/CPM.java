package Number_4_02;

import edu.princeton.cs.algs4.AcyclicLP;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.DirectedEdge;;

/**
 * P431 优先级限制下的并行任务调度问题的关键路径方法，转化为无环加权有向图的最长路径 
 * 解决的问题：如何在若干处理器上安排任务并在最短时间内完成所有任务
 * args[0]:jobsPC.txt
 *
 * 
 * @author he
 *
 */
public class CPM {
	public static void main(String[] args) {
		In in = new In(args[0]);
		int N = in.readInt();// 任务的数量
		in.readLine();
		/**
		 * 其中顶点0-N表示的是任务，多余的两个顶点s=2*N和t=2*N+1表示任务的起点和终点
		 * 由于0-N表示的是任务所以每条边表示是顶点对应的任务的时间，因此需要一个多余的顶点（i+N）与该顶点连接,
		 * 且顶点i+N与终点t连接，所以s-->i-->(i+N)-->t累计权重(只有i-->(i+N)有权重)表示该任务从开始到结束所需时间
		 */
		EdgeWeightedDigraph G = new EdgeWeightedDigraph(N * 2 + 2);
		int s = 2 * N, t = 2 * N + 1;
		for (int i = 0; i < N; i++) {
			String a[] = in.readLine().split("\\s+");
			double duration = Double.valueOf(a[0]);// 每个任务对应的时间
			G.addEdge(new DirectedEdge(i, i + N, duration));
			G.addEdge(new DirectedEdge(s, i, 0.0));
			G.addEdge(new DirectedEdge(i + N, t, 0.0));

			for (int j = 1; j < a.length; j++) {
				// 读取当前任务i的后继任务，即当前任务必须在后继任务之前完成
				int successor = Integer.valueOf(a[j]);
				G.addEdge(new DirectedEdge(i + N, successor, 0.0));
			}
		}

		// 求该无环加权有向图的最长路径
		AcyclicLP lp = new AcyclicLP(G, s);
		System.out.println("Start times");
		for (int i = 0; i < N; i++)
			System.out.printf("%4d: %5.1f\n", i, lp.distTo(i));
		System.out.printf("Finish time: %5.1f\n", lp.distTo(t));

	}

}
