package Numbe_1;

/**
 * P138 union-find的实现
 * 
 * @author he
 */
public class UF {
	private int id[];// 分量id
	private int count;// 分量数量

	public UF(int N) {
		count = N;
		id = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
	}

	/**
	 * quick-find算法 分量标识符为触点的值
	 * 局限性：当且仅当id[p]等于id[q]是p和q是连通的，换而言之，在同一个连通分量中的所有触点在id[]中的值必须相同
	 * 分析：find()操作很快，但union()都需要扫描整个id[]数组，数组访问次数在（N+3）到（2N+1）之间
	 * 最坏情况下调用union()为N-1次，所以quick-find算法是平方级别的
	 * 
	 * args:4 3 3 8 6 5 9 4 2 1 8 9 5 0 7 2 6 1 1 0 6 7
	 *   结果：2 components
	 * @param p
	 * @param q
	 */
	public void union(int p, int q) {
		int pID = find(p);
		int qID = find(q);
		if (pID == qID) {
			return;
		}
		// 如果不相同将id[p]的值全部改为id[q]的值
		for (int i = 0; i < id.length; i++) {
			if (id[i] == pID) {
				id[i] = qID;
			}
		}
		count--;

	}

	public int find(int p) {
		return id[p];
	}

	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	public int count() {
		return count;
	}

	public static void main(String[] args) {
		UF uf = new UF(10);
		for (int i = 0; i < args.length; i += 2) {
			int p = Integer.parseInt(args[i]);
			int q = Integer.parseInt(args[i + 1]);
			if (uf.connected(p, q)) {
				continue;
			}
			uf.union(p, q);
		}
		System.out.println(uf.count() + " components");//2
	}

}
