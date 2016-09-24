package Num2_5_04;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * P527 T13
 * 
 * @author he
 *
 */
public class Num_5_04_13 {
	private static Pattern pattern;
	private static Matcher matcher;

	// 匹配除了11和111的所有字符串
	public static void matchA(String txt) {
		pattern = Pattern.compile("[^1]{2,3}");
		matcher = pattern.matcher(txt);
		while (matcher.find())
			System.out.print(matcher.group());
	}

	// 奇数位为1，个位数为1？
	public static void matchB(String txt) {
		pattern = Pattern.compile("\\s?\\d*1");
		matcher = pattern.matcher(txt);
		while (matcher.find())
			System.out.print(matcher.group());
	}

	// 匹配至少含有两个0或不包含有一个1的所有字符串
	public static void matchC(String txt) {

		pattern = Pattern.compile("\\s?\\d*0{2,}\\d*|\\s?[^1]*");
		matcher = pattern.matcher(txt);
		while (matcher.find())
			System.out.print(matcher.group());
	}

	public static void matchD(String txt) {
		pattern = Pattern.compile("[^1]{2}");
		matcher = pattern.matcher(txt);
		while (matcher.find())
			System.out.print(matcher.group()+" ");

	}

	public static void main(String[] args) {
		// matchA("11112341111144115411234");
		// matchB("23 45 91 67 21 1");
		// matchC("123 900 789 551 90 112");
		matchD("11432425341143545657");

	}

}
