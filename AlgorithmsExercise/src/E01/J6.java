package E01;

/**
 * 有一副由NxN矩阵表示的图像，这里每个像素用一个int表示，请编写一个算法，在不占用额外内存空间的情况下(即不使用缓存矩阵)，将图像顺时针旋转90度。
 * 给定一个NxN的矩阵，和矩阵的阶数N,请返回旋转后的NxN矩阵,保证N小于等于500，图像元素小于等于256。 测试样例：
 * [[1,2,3],[4,5,6],[7,8,9]],3 返回：[[7,4,1],[8,5,2],[9,6,3]]
 * 
 * @author he
 *
 *         思路，先二维数组转置 再将第j列和第n-1-j列交换
 *
 */
public class J6 {
	// 打印数组
	static void print(int a[][]) {
		int count = 0;
		for (int j = 0; j < a.length; j++) {
			for (int i = 0; i < a.length; i++) {
				System.out.print(a[j][i] + "\t");
				count++;
			}
			if (count % a.length == 0) {
				System.out.println();
			}
		}
	}

	public static int[][] trans(int a[][], int n) {
		int b[][] = new int[n][n];
		int temp;
		// 二维数组转置
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				b[i][j] = a[j][i];
			}
		}

		// 第i列和第n-1-i列交换
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n/2; j++) {
				temp=b[i][j];
				b[i][j] = b[i][n-j-1];
				b[i][n-j-1]=temp;
			}
		}
		return b;
	}

	public static void main(String[] args) {
		int a[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		print(a);
		// // trans(a, 3);
		System.out.println("-----------------");
		print(trans(a, 3));

	}

}
