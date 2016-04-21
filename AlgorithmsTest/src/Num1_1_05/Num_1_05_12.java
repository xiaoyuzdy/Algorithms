package Num1_1_05;

/**
 * P150 T12 路径压缩算法，只需要在find()添加一个循环，将在路径上遇到的所有节点都直接连接到根节点
 *  args:4 3 3 8 6 5 9 4 2 1 8 9 5 0 7 2 6 1 1 0 6 7
 * 
 * @author he
 *
 */
class QuickUnionPath {
	private int id[];
	private int count;

	public QuickUnionPath(int N) {
		count = N;
		id = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
	}

	public int find(int p) {
		int root = p;
		while (root != id[root])
			root = id[root];  //获取根节点
		while (p != root) {
			int newp = id[p];
			id[p] = root;//将触点连接到根节点
			p = newp;
		}
		return root;
	}

	public void union(int p, int q) {
		int pRoot = find(p);
		int qRoot = find(q);
		if (pRoot == qRoot) {
			return;
		}
		id[pRoot] = qRoot;
		count--;
	}

	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	public int count() {
		return count;
	}
}

public class Num_1_05_12 {
	public static void main(String[] args) {
		QuickUnionPath uf = new QuickUnionPath(10);
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
