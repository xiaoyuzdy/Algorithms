package Num1_1_05;

/**
 * P150 T7
 * 
 * @author he
 *
 */
class QuickFindUF {
	private int id[];
	private int count;

	public QuickFindUF(int N) {
		id = new int[N];
		count = N;
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
	}

	public void union(int p, int q) {
		int pID = find(p);
		int qID = find(q);
		if (pID == qID) {
			return;
		}
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
}


class QuickUnionUF{
	private int id[];
	private int count;

	public QuickUnionUF(int N) {
		id = new int[N];
		count = N;
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
	}

	public void union(int p, int q) {
		int pRoot=find(p);
		int qRoot=find(q);
		if (pRoot==qRoot) {
			return;
		}
		id[pRoot]=qRoot;
		count--;
	}

	public int find(int p) {
		while(p!=id[p]){
			p=id[p];
		}
		return p;
	}

	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	public int count() {
		return count;
	}
	
}

/**
 * args: 
 * @author he
 *args:4 3 3 8 6 5 9 4 2 1 8 9 5 0 7 2 6 1 1 0 6 7
 */
public class Num_1_04_07 {

	public static void main(String[] args) {
//		QuickFindUF uf=new QuickFindUF(10);
		QuickUnionUF uf=new QuickUnionUF(10);
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
