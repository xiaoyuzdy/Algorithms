package Number_3;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * P314
 * 
 * @author he
 *
 */
public class SET<Key extends Comparable<Key>> {
	private TreeSet<Key> set;
	
	public SET() {
		set = new TreeSet<Key>();
	}

	public void add(Key key) {
		set.add(key);
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
	public String toString() {
		Iterator<Key> iterator = set.iterator();
		StringBuilder sb = new StringBuilder();
		while (iterator.hasNext()) {
			sb.append(iterator.next());
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		SET<Integer> set = new SET<Integer>();
		for (int i = 0; i < 10; i++) {
			set.add(i);
		}
		System.out.println(set.toString());

	}

}
