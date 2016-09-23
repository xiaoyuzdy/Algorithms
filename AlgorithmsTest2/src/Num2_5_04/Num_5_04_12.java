package Num2_5_04;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * P527 T12
 * 
 * @author he
 *
 */
public class Num_5_04_12 {
	private static Pattern pattern;
	private static Matcher matcher;

	// ∆•≈‰µÁª∞∫≈¬Î
	public static void matchTel(String txt) {
		pattern = Pattern.compile("\\([0-9]{3}\\)[0-9]{3}-[0-9]{3}");
		matcher = pattern.matcher(txt);
		while (matcher.find())
			System.out.println(matcher.group());
	}

	// ∆•≈‰…Á±£∫≈
	public static void matchNum(String txt) {
		pattern = Pattern.compile("[0-9]{3}-[0-9]{2}-[0-9]{4}");
		matcher = pattern.matcher(txt);
		while (matcher.find())
			System.out.println(matcher.group());
	}

	// ∆•≈‰»’∆⁄,‘¬∑›Àı–¥
	public static void matchDate(String txt) {
		pattern = Pattern.compile("[a-z]{3,4},(3[0-1]|[1-2]?\\d),([1-9]{4}|[1-9]?[1-9]?\\d)");
		matcher = pattern.matcher(txt);
		while (matcher.find())
			System.out.println(matcher.group());
	}

	// ∆•≈‰IPµÿ÷∑
	public static void matchIP(String txt) {
		String t = "(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)){3}";
		pattern = Pattern.compile(t);
		matcher = pattern.matcher(txt);
		while (matcher.find())
			System.out.println(matcher.group());
	}

	// ∆•≈‰≥µ≈∆∫≈
	public static void matchCar(String txt) {
		String t = "[0-9]{4}[A-Z]{2}";
		pattern = Pattern.compile(t);
		matcher = pattern.matcher(txt);
		while (matcher.find())
			System.out.println(matcher.group());

	}

	public static void main(String[] args) {
		matchTel("(214)432-1234 765356-9865");
		matchNum("123-45-6789 234-W3-5643");
		matchDate("dec,31,199");
		matchIP("255.255.255.255");
		matchCar("7543DF");

	}

}
