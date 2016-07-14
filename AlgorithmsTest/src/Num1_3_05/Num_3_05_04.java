package Num1_3_05;

/**
 * P325 T04
 * 
 * @author he
 *
 */

class HashSTint<V> {
	private int keys[];
	private V values[];
	private int N;
	private int M;

	@SuppressWarnings("unchecked")
	public HashSTint(int cap) {
		this.M = cap;
		keys = new int[M];
		values = (V[]) new Object[M];
	}

	private int hash(int key) {
		if (key % M == 0)
			return 1;
		else
			return key % M;
	}

	public void put(int key, V value) {
		int i;
		for (i = hash(key); keys[i] != 0; i = (i + 1) % M) {
			if (keys[i] == key)
				values[i] = value;
			return;
		}
		keys[i] = key;
		values[i] = value;
		N++;
	}

	public V get(int key) {
		for (int i = hash(key); keys[i] != 0; i = (i + 1) % M) {
			if (keys[i] == key)
				return values[i];
		}
		return null;
	}

	private boolean contains(int key) {
		return get(key) != null;
	}

	public void delete(int key) {
		if (!contains(key))
			return;
		int i = hash(key);
		while (keys[i] != key) {
			i = (i + 1) % M;
		}
		keys[i] = 0;
		values[i] = null;
		i = (i + 1) % M;

		while (keys[i] != 0) {
			int kt = keys[i];
			V vt = values[i];

			keys[i] = 0;
			values[i] = null;
			N--;
			put(kt, vt);
			i = (i + 1) % M;
		}

		N--;

	}

}

public class Num_3_05_04 {
	public static void main(String[] args) {
		HashSTint<String> st = new HashSTint<String>(7);
		st.put(0, "S");
		st.put(1, "E");
		st.put(2, "A");
		st.put(3, "R");
		st.put(3, "H");
		st.put(5, "E");

		System.out.println(st.get(3));
		st.delete(5);
		System.out.println(st.get(5));

	}
}
