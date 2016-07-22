package Number_3;

import java.util.HashMap;

/**
 * P323 能够完成点乘的稀疏向量
 * 
 * @author he
 *
 */
public class SparseVector {

	private HashMap<Integer, Double> st;

	public SparseVector() {
		st = new HashMap<Integer, Double>();
	}

	public int size() {
		return st.size();
	}

	public void put(int i, double j) {
		st.put(i, j);
	}

	public double get(int i) {
		if (!st.containsKey(i))
			return 0.0;
		else
			return st.get(i);
	}

	public double dot(double[] that) {
		double sum = 0.0;
		for (int i : st.keySet()) {
			sum += that[i] * this.get(i);
		}
		return sum;
	}

	public static void main(String[] args) {
		SparseVector[] a = new SparseVector[5];
		for(int i=0;i<a.length;i++){
			a[i]=new SparseVector();
		}
		a[0].put(1, .90);
		a[1].put(2, .36);
		a[1].put(3, .36);
		a[1].put(4, .18);
		a[2].put(3, .90);
		a[3].put(0, .90);
		a[4].put(0, .47);
		a[4].put(2, .47);
		double []x={.05,.04,.36,.37,.19};
		double []b = new double[5];
		
		for(int i=0;i<a.length;i++){
			b[i]=a[i].dot(x);
		}
		for(int i=0;i<b.length;i++){
			System.out.println(b[i]);
		}
		
		
	}

}
