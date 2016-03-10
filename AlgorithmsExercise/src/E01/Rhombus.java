package E01;

/**
 * 打印菱形
 * 
 * 打印空心菱形 即把*换成“ ” 然后一个for()循环结束后打印* 如图中的 - 打印的位置
 * 
 * @author he
 *
 */
public class Rhombus {
	public static void main(String[] args) {
		// 打印上面半部分菱形
		for (int i = 1; i < 5; i++) {
			// 打印空格
			for (int j = 1; j < 5 - i; j++) {
				System.out.print(" ");
			}
			System.out.print("-");
			for (int k = 0; k < i * 2 - 1; k++) {
				System.out.print("*");
			}
			System.out.print("-");
			System.out.println();
		}

		// 打印下部分菱形
		for (int i = 4; i > 1; i--) {
			for (int j = 0; j < 5 - i; j++) {
				System.out.print(" ");
			}
			for (int k = 2 * i - 3; k > 0; k--) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
