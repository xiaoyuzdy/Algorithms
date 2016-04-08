package Num1_1_04;

/**
 * 在Java中int 32位，其中一位用来保存符号所以取值范围所以只有31位用于存值 -2147483648～2147483647
 * 既然是int溢出，必须条件就是存进去的数字并没有溢出只是进行相加操作后溢出 满足该条件可进行如下设计
 * 
 * @author he 测试通过
 *
 */

public class Num_1_04_02 {

	public static void main(String[] args) {
		int i = 2147483647;
		int b = 1;
		// int i = -2147483648;
		// int b = -1;
		if ((i > 0 && b > 0 && i + b < 0) || (i < 0 && b < 0 && i + b > 0)) {
			System.out.println("error");
		}

	}
}
