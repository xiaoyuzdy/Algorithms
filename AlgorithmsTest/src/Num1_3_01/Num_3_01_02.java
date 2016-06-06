package Num1_3_01;

/**
 * P246T02
 * 
 * @author he
 *
 */

class ArrayST<Key extends Comparable<Key>, Value> {
	private Key keys[];
	private Value values[];
	private int N = 0;

	@SuppressWarnings("unchecked")
	public ArrayST(int size) {
		keys = (Key[]) new Comparable[size];
		values = (Value[]) new Object[size];
	}

	public void put(Key key, Value value) {
		keys[N] = key;
		values[N] = value;
		N++;
	}

	public Value get(Key key) {
		for (int i = 0; i < N; i++) {
			if (keys[i].equals(key)) {
				return values[i];
			}
		}
		return null;
	}

}

public class Num_3_01_02 {
	public static void main(String[] args) {
		ArrayST<String, Integer> st = new ArrayST<String, Integer>(10);
		st.put("A", 1);
		st.put("B", 2);
		System.out.println(st.get("A"));
	}

}
