package Numbe_1;

/**
 * 按值传递 不管有没有返回值都不变
 * 
 * @author he
 *
 */
public class P43 {
	static void f(int a) {
		a = 5;
	}

	static int f2(int a) {
		return a = 5;
	}

	public static void main(String[] args) {
		int a = 3;
		f(a);
		System.out.println(a);//3
		System.out.println("---------------");
		System.out.println(a);//3

	}
}
