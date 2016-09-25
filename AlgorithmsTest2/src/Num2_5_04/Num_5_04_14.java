package Num2_5_04;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * P527 T14
 * 
 * @author he
 *
 */
public class Num_5_04_14 {
	private static Pattern pattern;
	private static Matcher matcher;

	// 被2整除的二进制数,末尾为0即可
	public static void matchA(String txt) {
		pattern = Pattern.compile("(\\s?[1|0]*0\\b)+");
		matcher = pattern.matcher(txt);
		while (matcher.find())
			System.out.println(matcher.group());
	}

	//匹配被3整除的二进制数,含有偶数个1
	public static void matchB(String txt) {
		pattern = Pattern.compile("(0|1(\1*0)*1)*");
		matcher = pattern.matcher(txt);
		while (matcher.find())
			System.out.println(matcher.group());
	}

	public static void main(String[] args) {
		matchA("121 100 110110 111");
//		matchB("1111 111");
		
		
	}

}
