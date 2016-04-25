package Num1_1_05;

/**
 * P151 T20 测试通过
 * 
 * @author he 用数组的hashCode作为标识符。
 *         数组扩容采用比参数大一的方式，这样做的目的是为了减少连通分量，最坏情况下扩容后连通分量也只比原先连通分量多一个不过数组扩容次数增多
 *         如果采用×2的方式扩容，则产生多个连通分量 应该采取哪种方式我不清楚
 *
 */

class ResizingUF {
	private int id[] = new int[1];
	private int count = 1;

	// 数组扩容
	private void resize(int max) {
		int temp[] = new int[max];
		for (int i = 0; i < id.length; i++) {
			temp[i] = id[i];
		}
		for (int j = id.length; j < temp.length; j++) {
			temp[j] = j;
		}
		count = count + max - id.length;// 连通分量为原先的连通分量加上新增加的元素
		id = temp;
	}

	public int find(int q) {
		if (q >= id.length) {
			resize(q*2);// 数组扩容
		}
		return id[q];
	}

	public void union(int p, int q) {
		int pRoot = find(p);
		int qRoot = find(q);
		if (pRoot == qRoot) {
			return;
		}
		for (int i = 0; i < id.length; i++) {
			if (id[i] == pRoot) {
				id[i] = qRoot;
			}
		}
		count--;
	}

	public boolean isConnected(int p, int q) {
		return find(p) == find(q);
	}

	public int count() {
		return count;
	}

	public int newSite() {
		return id.hashCode();
	}
}

public class Num_1_05_20 {

	public static void main(String[] args) {
		ResizingUF uf = new ResizingUF();
		for (int i = 0; i < args.length; i += 2) {
			int p = Integer.parseInt(args[i]);
			int q = Integer.parseInt(args[i + 1]);
			if (uf.isConnected(p, q)) {
				continue;
			}
			uf.union(p, q);
		}
		System.out.println(uf.count() + " components");// 8  多出的连通分量为多出的元素
		System.out.println(uf.newSite());// 我电脑中的hashCode 705927765
		uf.find(20);
		System.out.println(uf.newSite());// 我电脑中的hashCode 366712642

	}
}
