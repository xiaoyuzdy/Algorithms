package Num2_5_02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.TST;
import edu.princeton.cs.algs4.TrieST;

/**
 * P490 T06 ≤ª÷ÿ∏¥ÃÌº” args[0]:shellsST.txt
 * 
 * @author he
 *
 */

class StringSET {
	private TrieST<Integer> set;

	public StringSET() {
		set = new TrieST<Integer>();
	}

	public void add(String key) {
		set.put(key, -1);
	}

	public void delete(String key) {
		set.delete(key);
		;
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

	public boolean containsPrefix(String s) {
		if (set.keysWithPrefix(s).toString().length() > 0)
			return true;
		return false;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (String t : set.keys())
			sb.append(t + " ");
		return sb.toString();
	}

}

public class Num_5_02_06_20 {
	public static void main(String[] args) {
		StringSET set = new StringSET();
		In in = new In(args[0]);
		while (!in.isEmpty()) {
			String key = in.readString();
			set.add(key);
		}
		System.out.println(set.toString());
		System.out.println(set.containsPrefix("shel"));
	}
}
