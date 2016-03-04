package E01;

import java.util.HashSet;
import java.util.Set;

/**
 * 请编写一个算法，若MxN矩阵中某个元素为0，则将其所在的行与列清零。
 * 给定一个MxN的int[][]矩阵(C++中为vector>)mat和矩阵的阶数n，请返回完成操作后的int[][]矩阵(C++中为vector>)，
 * 保证n小于等于300，矩阵中的元素为int范围内。 测试样例： [[1,2,3],[0,1,2],[0,0,1]]
 * 返回：[[0,0,3],[0,0,0],[0,0,0]]
 * 
 * @author he
 *
 *         用set记录行列
 *
 *
 */
public class J7 {
	public static int[][] clearZero(int[][] mat, int n) {
		Set<Integer> hang = new HashSet<>();
		Set<Integer> lie = new HashSet<>();
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (mat[i][j] == 0) {
					hang.add(i);
					lie.add(j);
				}
			}
		}

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (hang.contains(i) || lie.contains(j)) {
					mat[i][j] = 0;
				}
			}
		}
		return mat;
	}

	public static void main(String[] args) {
		int mat[][] = { { 1, 2, 3 }, { 0, 1, 2 }, { 0, 0, 1 } };
		ArraysPrint.print(clearZero(mat, 0));
	}
}
