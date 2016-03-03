package E01;

/**
 * 匹配字符，如果全都不同返回true，如果有相同的返回false
 * 
 * @author he
 *
 */
public class Different {

	public static boolean check(String string) {
		//       \\i 引用第i个捕获组
		return !string.matches(".*(.)(.*\\1)");
	}

	public static void main(String[] args) {
		System.out.println(check("ADFFFFF"));
		System.out.println(check("asdfg"));
	}

}
