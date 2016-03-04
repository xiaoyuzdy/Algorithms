package Num1_1_01;

/**
 * 二维数组转置 交换行和列
 * 
 * @author he
 *
 */
public class Ex_1_1_13 {
	static int count = 0;
	// 打印数组
		static void print(int a[][]) {
			for (int j = 0; j < a.length; j++) {
				for (int i = 0; i < a[0].length; i++) {
					System.out.print(a[j][i] + "\t");
					count++;
				}
				if (count % a[0].length == 0) {
					System.out.println();
				}
			}
		}

	// 转置
	public static int[][] trans(int a[][]) {
		int hang = a[0].length;// 4
		int lie = a.length;// 2
		int b[][] = new int[hang][lie];
		
		for (int i = 0; i < hang; i++) {
			for (int j = 0; j < lie; j++) {
				b[i][j] = a[j][i];
			}
		}
		return b;
	}
	
	public static void main(String[] args) {
		int a[][]={{1,2},{3,4},{5,6}};
		print(a);
		System.out.println("-----------");
		print(trans(a));
	}

}
