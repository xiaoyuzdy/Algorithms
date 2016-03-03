package Num1_1_01;

/**
 * 二维数组转置 交换行和列
 * 
 * @author he
 *
 */
public class Ex_1_1_13 {
	static int count = 1;
	// 打印数组 给定行列
	public static void array(int m, int n) {
		int a[][] = new int[m][n];
		for (int j = 0; j < m; j++) {
			for (int i = 0; i < n; i++) {
				a[j][i] = count++;
				System.out.print(a[j][i]);
				// 按行打印
				if (count % n == 1) {
					System.out.println();
				}
			}
		}
		System.out.println("-----------");
		//调用转置方法
		trans(a);
	}

	// 转置
	public static void trans(int a[][]) {
		int hang = a[0].length;// 4
		int lie = a.length;// 2
		int b[][] = new int[hang][lie];
		for (int i = 0; i < hang; i++) {
			for (int j = 0; j < lie; j++) {
				b[i][j] = a[j][i];
				System.out.print(b[i][j]);
			}
			if (count % lie == 1) {
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		array(2, 4);
	}

}
