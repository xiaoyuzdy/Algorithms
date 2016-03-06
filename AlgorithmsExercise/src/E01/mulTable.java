package E01;

/**
 * 用一个for循环打印九九乘法表
 * 
 * @author he
 *
 */
public class mulTable {

	static void test() {
		int j = 1;
		for (int i = 1; i < 10; i++) {
			j = i;

			while (--j > 0) {
				System.out.print(i + "*" + j + "=" + i * j+" ");
			}
			System.out.println(i+"*"+i+"="+i*i+"\n");

		}
	}

	public static void main(String[] args) {
		test();
	}
}
