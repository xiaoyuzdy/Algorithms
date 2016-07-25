package Num1_3_05;

import edu.princeton.cs.algs4.SparseVector;

/**
 * P327 T23 稀疏矩阵
 * 
 * @author he
 *
 */
class SparseMatrix {
	private int n;
	private SparseVector rows[];

	public SparseMatrix(int n) {
		this.n = n;
		rows = new SparseVector[n];
		for (int i = 0; i < n; i++)
			rows[i] = new SparseVector(n);
	}

	public void put(int i, int j, double value) {
		if (i >= n || i < 0 || j >= n || j < 0)
			throw new NullPointerException();
		rows[i].put(j, value);
	}

	public double get(int i, int j) {
		if (i >= n || i < 0 || j >= n || j < n)
			throw new NullPointerException();
		return rows[i].get(j);
	}

	
	//所有非0元素的个数
	public int nnz() {
		int sum = 0;
		for (int i = 0; i < n; i++)
			sum += rows[i].nnz();
		return sum;
	}

	// 矩阵相乘
	public SparseVector times(SparseVector x) {
		if (n != x.size())
			throw new IllegalArgumentException("Dimensions disagree");
		SparseVector b = new SparseVector(n);
		for (int i = 0; i < n; i++)
			b.put(i, rows[i].dot(x));
		return b;
	}

	// 矩阵相加
	public SparseMatrix plus(SparseMatrix that) {
		if (this.n != that.n)
			throw new RuntimeException("Dimensions disagree");
		SparseMatrix result = new SparseMatrix(n);
		for (int i = 0; i < n; i++)
			result.rows[i] = this.rows[i].plus(that.rows[i]);
		return result;
	}

	// return a string representation
	public String toString() {
		String s = "n = " + n + ", nonzeros = " + nnz() + "\n";
		for (int i = 0; i < n; i++) {
			s += i + ": " + rows[i] + "\n";
		}
		return s;
	}

}

public class Num_3_05_23 {
	public static void main(String[] args) {
		SparseMatrix A = new SparseMatrix(5);
		SparseVector x = new SparseVector(5);
		A.put(0, 0, 1.0);
		A.put(1, 1, 1.0);
		A.put(2, 2, 1.0);
		A.put(3, 3, 1.0);
		A.put(4, 4, 1.0);
		A.put(2, 4, 0.3);
		x.put(0, 0.75);
		x.put(2, 0.11);
		System.out.println("x     : " + x);
		System.out.println("A     : " + A);
		System.out.println("Ax    : " + A.times(x));
		System.out.println("A + A : " + A.plus(A));
	}

}
