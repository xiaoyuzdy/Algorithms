package Num1_3_01;

/**
 * P247 T22
 * 
 * @author he
 *
 */

class ArrayST2<Key extends Comparable<Key>, Value> {
	private Key keys[];
	private Value values[];
	private int N = 0;

	@SuppressWarnings("unchecked")
	public ArrayST2(int size) {
		keys = (Key[]) new Comparable[size];
		values = (Value[]) new Object[size];
	}

	private int select(Key key) {
		for (int i = 0; i < N; i++) {
			if (keys[i].equals(key)) {
				return i;
			}
		}
		return -1;
	}

	public void put(Key key, Value value) {
		if (select(key) != -1) {
			values[select(key)] = value;
		} else {
			keys[N] = key;
			values[N] = value;
			N++;
		}

	}

	public Value get(Key key) {
		int i = select(key);
		if (i != -1) {
			Value v = values[i];
			Key k = keys[i];

			// 移动数组
			for (int j = i; j > 0; j--) {
				keys[j] = keys[j - 1];
				values[j] = values[j - 1];
			}
			keys[0] = k;
			values[0] = v;
			return v;
		}
		return null;
	}
    //最近访问的键值对
	public String recentlyGet() {
		return "Key:" + keys[0] + " Value:" + values[0];
	}

}

public class Num_3_01_22 {
	public static void main(String[] args) {
		ArrayST2<String, Integer> st = new ArrayST2<String, Integer>(10);
		st.put("A", 1);
		st.put("B", 2);
		st.put("A", 3);
		st.put("X", 8);
		
		System.out.println(st.get("A"));
		System.out.println(st.recentlyGet());

		System.out.println(st.get("X"));
		System.out.println(st.recentlyGet());
	}
}
