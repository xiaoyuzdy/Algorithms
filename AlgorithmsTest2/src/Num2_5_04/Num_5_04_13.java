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
	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("[^1]{2,3}");
		Matcher matcher = pattern.matcher("11 23");
		while (matcher.find())
			System.out.println(matcher.group());
	}

}
