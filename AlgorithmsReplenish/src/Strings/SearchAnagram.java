package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 查找变位词，给定单词和字典，允许预处理 变位词：如单词 deposit 、dopiest、posited、topside 互为变位词
 * 
 * @author he
 * 
 * 思路：
 *1、将词典中的每个单词进行标识（按单词包含的字母顺序排序）并将字典排序
 *2、将单词的标识和字母对应起来 
 *3、计算给定单词的标识
 *4、利用二分搜索查找给定单词的变位词
 * 
 *         这里我直接用HashMap
 *
 *
 */
public class SearchAnagram {

	private static final String[] dictionary = { "dopiest", "posited", "hello", "topside", "world", "make" };
	private static Map<String, List<String>> map = new HashMap<>();

	static {
		preprocess();
	}

	private static String find(String word) {
		String key = sort(word);
		String temp = "";
		for (String s : map.get(key)) {
			temp += s + " ";
		}
		return temp;
	}

	/**
	 * 预处理
	 */
	private static void preprocess() {
		for (int i = 0; i < dictionary.length; i++) {

			String key = sort(dictionary[i]);
			if (map.get(key) == null) {
				List<String> list = new ArrayList<>();
				list.add(dictionary[i]);
				map.put(key, list);
			} else {
				List<String> l = map.get(key);
				l.add(dictionary[i]);
				map.put(key, l);
			}

		}
	}

	private static String sort(String s) {
		char[] a = s.toCharArray();
		Arrays.sort(a);
		String temp = "";
		for (int i = 0; i < a.length; i++) {
			temp += a[i];
		}
		return temp;
	}

	public static void main(String[] args) {
		System.out.println(find("dopiest"));

	}

}
