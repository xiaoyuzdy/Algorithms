package Num1_2_05;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * P224 T04
 * 
 * @author he
 *
 */
public class Num_2_05_04 {
	private static Object object[];
	public static Object[] dedup(String[] a) {
		Set<String> set = new TreeSet<String>();
		for (int i = 0; i < a.length; i++) {
			set.add(a[i]);
		}
		object = set.toArray();
		return object;
	}

	public static void show() {
		for (int i = 0; i < object.length; i++) {
			System.out.print(object[i] + " ");
		}
	}

	public static void main(String[] args) {
		String[] a = { "a", "c", "d", "b", "a", "c" };
		dedup(a);
		show();
	}

}
