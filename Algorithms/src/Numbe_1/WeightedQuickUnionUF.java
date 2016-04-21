package Numbe_1;

/**
 * P145 加权 quick-union,保证总是将最小树连接到大树，降低数的高度，从而减少find()迭代的次数
 * args:4 3 3 8 6 5 9 4 2 1 8 9 5 0 7 2 6 1 1 0 6 7
 * @author he
 *
 */
public class WeightedQuickUnionUF {
	private int id[];// 触点索引
	private int sz[];// 模拟树的高度但不等同于树的高度
	private int count;// 连通分量的数量

	public WeightedQuickUnionUF(int N) {
		count = N;
		id = new int[N];
		sz = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
			sz[i] = 1;
		}
	}

	public int find(int p) {
		while (p != id[p]) {
			p = id[p];
		}
		return p;
	}

	public void union(int p, int q) {
		int i = find(p);
		int j = find(q);
		if (i == j) {
			return;
		}
		// 将高度小的树添加到大树中
		if (sz[i] < sz[j]) {
			id[i] = j;
			sz[j] += sz[i];
		}else {
			id[j]=i;
			sz[i]+=sz[j];
		}

		count--;
	}
	
	public boolean connected(int p,int q){
		return find(p)==find(q);
	}
	
	public int count(){
		return count;
	}

	public static void main(String[] args) {
		WeightedQuickUnionUF uf = new WeightedQuickUnionUF(10);
		for (int i = 0; i < args.length; i += 2) {
			int p = Integer.parseInt(args[i]);
			int q = Integer.parseInt(args[i + 1]);
			if (uf.connected(p, q)) {
				continue;
			}
			uf.union(p, q);
		}
		System.out.println(uf.count() + " components");// 2
	}
	
}
