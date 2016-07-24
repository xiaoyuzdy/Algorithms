package Num1_3_05;

import java.util.HashSet;
import edu.princeton.cs.algs4.Queue;

/**
 * P327 T28
 * 
 * @author he
 *
 */

class uniQueue<Key> {
	private Queue<Key> q;
	private HashSet<Key> set;

	public uniQueue() {
		q = new Queue<Key>();
		set = new HashSet<Key>();
	}

	public void put(Key key) {
		if (!set.contains(key)) {
			set.add(key);
			q.enqueue(key);
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Key key : q) {
			sb.append(key + " ");
		}
		return sb.toString();
	}

}

public class Num_3_05_28 {
	public static void main(String[] args) {
		uniQueue<Integer> u = new uniQueue<Integer>();
		u.put(1);
		u.put(1);
		u.put(1);
		u.put(1);
		u.put(2);
		System.out.println(u.toString());
	}

}
