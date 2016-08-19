package Number_4_02;

/**
 * P415 加权有向边的数据结构
 * 
 * @author he
 *
 */
public class DirectedEdge {

	private final int v;// 有向边的起点
	private final int w;// 有向边的终点
	private final double weight;// 边的权重

	public DirectedEdge(int v, int w, double weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}

	/**
	 * 返回边的起点
	 * 
	 * @return
	 */
	public int from() {
		return v;
	}

	/**
	 * 返回边的终点
	 * 
	 * @return
	 */
	public int to() {
		return w;
	}

	/**
	 * 返回边的权重
	 * 
	 * @return
	 */
	public double weight() {
		return weight;
	}

	@Override
	public String toString() {
		return String.format("%d-->%d %.2f", v, w, weight);
	}

	public static void main(String[] args) {
		DirectedEdge e = new DirectedEdge(1, 0, .5);
		System.out.println(e);

	}

}
