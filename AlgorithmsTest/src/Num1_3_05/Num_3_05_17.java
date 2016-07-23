package Num1_3_05;

import java.awt.RenderingHints.Key;
import java.util.HashSet;
import java.util.Iterator;

/**
 * P326 T17
 * 
 * @author he
 *
 */

@SuppressWarnings("hiding")
class MathSET<Key> implements Iterable<Key> {
	private HashSet<Key> set;

	public MathSET() {
		set = new HashSet<Key>();
	}

	public void add(Key key) {
		set.add(key);
	}

	// 求并集
	public MathSET<Key> union(MathSET<Key> a) {
		MathSET<Key> temp = new MathSET<Key>();
		for (Key key : a) {
			if (!set.contains(key))
				temp.add(key);
		}
		for (Key key : this) {
			temp.add(key);
		}
		return temp;
	}

	// 求交集
	public MathSET<Key> intersection(MathSET<Key> a) {
		MathSET<Key> temp = new MathSET<Key>();
		for (Key key : a) {
			if (set.contains(key))
				temp.add(key);
		}
		return temp;
	}

	public void delete(Key key) {
		set.remove(key);
	}

	public boolean contains(Key key) {
		return set.contains(key);
	}

	public boolean isEmpty() {
		return set.isEmpty();
	}

	public int size() {
		return set.size();
	}

	@Override
	public Iterator<Key> iterator() {
		return set.iterator();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Key key : this) {
			sb.append(key + " ");
		}
		return sb.toString();
	}

}

public class Num_3_05_17 {
	public static void main(String[] args) {
		MathSET<Integer> s1 = new MathSET<Integer>();
		MathSET<Integer> s2 = new MathSET<Integer>();
		for (int i = 0; i < 10; i++) {
			if (i < 7)
				s1.add(i);
			if (i > 3)
				s2.add(i);
		}
	
		MathSET<Integer> s3 = s1.union(s2);
		System.out.println(s3.toString());

		MathSET<Integer> s4 = s1.intersection(s2);
		System.out.println(s4.toString());

	}

}
