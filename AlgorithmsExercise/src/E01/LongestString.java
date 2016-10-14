package E01;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 有一组单词，请编写一个程序，在数组中找出由数组中字符串组成的最长的串A，即A是由其它单词组成的(可重复)最长的单词。
 * 给定一个string数组str，同时给定数组的大小n。请返回最长单词的长度，保证题意所述的最长单词存在。 测试样例：
 * ["a","b","c","ab","bc","abc"],6 返回：3
 * 测试通过
 * 
 * @author he
 *
 */
public class LongestString {
	public static int getLongest(String[] str, int n) {
		//数组跑排序
		Arrays.sort(str, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});

		String temp = str[--n];
		int i = 0;
		while (!check(str, temp, ++i)) {
			temp = str[--n];
			check(str, temp, ++i);
		}
		return temp.length();
	}

	//检查字符串是否符合要求，即temp是由数组内的元素组成
	public static boolean check(String[] str, String temp, int count) {
		for (int i = str.length - count-1; i >=0 ; i--) {
			if (temp.contains(str[i])) {
				temp = temp.replace(str[i], "");// 去除已经包含的元素
				i = str.length - count-1;// 重置
			}
		}
		if (temp.length() > 0)
			return false;
		else
			return true;
	}

	public static void main(String[] args) {

		String str[] = { "fvcm", "kebh", "xro", "qk", "jalfoux", "zo", "k", "nil", "tjuy", "k", "pexi", "cznvz", "il",
				"lxqkke", "zom", "fvcmm", "lewvjw", "q", "vuns", "alfoux", "tjuyq", "xtotfmftjuy", "smhvoe", "vb",
				"vkf", "gwq", "npmavlz", "ebh", "xtotfmf", "j", "k", "n", "wtp", "smhvoeq", "dbgj", "m", "y", "avh",
				"zok", "xrofvcm", "p" };
		System.out.println(getLongest(str, 41));
	}

}
