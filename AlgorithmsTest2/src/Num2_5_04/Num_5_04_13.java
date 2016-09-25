package Num2_5_04;

import java.util.ArrayList;
import java.util.List;
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
		List<String> list = new ArrayList<String>();
		String temp[] = txt.split(" ");
		for (int i = 0; i < temp.length; i++)
			list.add(temp[i]);
		// 匹配含11和111
		pattern = Pattern.compile("(111|11)");
		matcher = pattern.matcher(txt);
		while (matcher.find())
			list.remove(matcher.group().trim());
		System.out.println(list.toString());
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

	// 匹配不存在连续两个1的所有字符串
	public static void matchD(String txt) {
		List<String> list = new ArrayList<String>();
		String temp[] = txt.split(" ");
		for (int i = 0; i < temp.length; i++)
			list.add(temp[i]);
		// 匹配含有两个1的字符串
		pattern = Pattern.compile("(\\s?[0|2-9]*11{1,}[0|2-9]*)");
		matcher = pattern.matcher(txt);
		while (matcher.find())
			list.remove(matcher.group().trim());
		System.out.println(list.toString());
	}

	public static void main(String[] args) {
//		 matchA("111 11 123 1123 11211 1113");
		// matchB("23 45 91 67 21 1");
		// matchC("123 900 789 551 90 112");
		matchD("11 222 112 331");

	}

}
