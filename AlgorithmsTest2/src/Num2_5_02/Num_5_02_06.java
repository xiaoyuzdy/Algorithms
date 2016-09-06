package Num2_5_02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import edu.princeton.cs.algs4.In;

/**
 * P490 T06   ≤ª÷ÿ∏¥ÃÌº”
 * args[0]:shellsST.txt
 * @author he
 *
 */

class StringSET {
	private Set<String> set;

	public StringSET() {
		set = new HashSet<String>();
	}

	public void add(String key) {
		set.add(key);
	}

	public void delete(String key) {
		set.remove(key);
	}

	public boolean contains(String key) {
		return set.contains(key);
	}

	public boolean isEmpty() {
		return set.isEmpty();
	}

	public int size() {
		return set.size();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Iterator<String> i = set.iterator();
		while (i.hasNext()) {
			sb.append(i.next() + " ");
		}
		return sb.toString();
	}

}

public class Num_5_02_06 {
	public static void main(String[] args) {
		StringSET set = new StringSET();
		In in = new In(args[0]);
		while (!in.isEmpty()) {
			String key = in.readString();
			set.add(key);
		}
		System.out.println(set.toString());
	}
}
