package Num1_1_05;

/**
 * 根据高度加权的quick-union P150 T14
 * args:4 3 3 8 6 5 9 4 2 1 8 9 5 0 7 2 6 1 1 0 6 7
 * @author he
 *
 */

class WeightedQuickUnionByheight {
	private int id[];// 触点索引
	private int height[];// 树的高度
	private int count;

	public WeightedQuickUnionByheight(int N) {
		count = N;
		id = new int[N];
		height = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
			height[i] = 0;
		}
	}

	public int find(int p) {
		while (p != id[p]) {
			p = id[p];
		}
		return p;
	}

	public void union(int p, int q) {
		int pRoot = find(p);
		int qRoot = find(q);
		if (pRoot == qRoot) {
			return;
		}
		// 将高度小的树添加到高度大的数中
		if (height[pRoot] < height[qRoot]) {
			id[pRoot] = qRoot;
		} else if (height[pRoot] > height[qRoot]) {
			id[qRoot] = pRoot;
		} else {
			// 高度相等
			id[pRoot] = qRoot;
			// 高度加1
			height[pRoot]++;
		}
		count--;
	}

	public int count() {
		return count;
	}

	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

}

public class Num_1_05_14 {
	public static void main(String[] args) {
		System.out.println("y");
		WeightedQuickUnionByheight uf = new WeightedQuickUnionByheight(10);
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
