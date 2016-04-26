package Num1_1_05;

import java.util.HashSet;
import java.util.Set;

/**
 * P151 T18 
 * 获取连接没必要用Connetcion，只要借助Set就可以了，
 * 如果非要加Connection还要写很多没用的代码，效果还是一样的
 * 
 * @author he
 *
 */
class RandomGrid {
	private static Set<String> set = new HashSet<String>();

	public static String generate(int N) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				set.add("(" + i + "," + j + ")");
			}
		}
		return set.toString();
	}
}

public class Num_1_05_18 {
	public static void main(String[] args) {
		System.out.println(RandomGrid.generate(2));
	}
}
