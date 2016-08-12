package Number_4_02;

/**
 * P394 带权重的边的数据类型
 * 
 * @author he
 *
 */
public class Edge implements Comparable<Edge> {

	private final int v;// 顶点之一
	private final int w;// 另一个顶点
	private final double weight;// 边的权重

	public Edge(int w, int v, double weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}

	/**
	 * 获取边的权重
	 * 
	 * @return
	 */
	public double weight() {
		return weight;
	}

	/**
	 * 获取一个顶点
	 * 
	 * @return
	 */
	public int either() {
		return w;
	}

	/**
	 * 获取另一个顶点
	 * 
	 * @param x
	 * @return
	 */
	public int other(int x) {
		if (v == w)
			return v;
		else if (x == v)
			return w;
		else
			throw new RuntimeException("不存在包含该顶点的边");
	}

	public int compareTo(Edge o) {
		if (this.weight < o.weight)
			return -1;
		else if (this.weight > o.weight)
			return +1;
		else
			return 0;
	}

	@Override
	public String toString() {
		return String.format("%d--%d  %.2f", w, v, weight);
	}

	public static void main(String[] args) {
		Edge e = new Edge(1, 0, 3.54);
		System.out.println(e.toString());
	}

}
