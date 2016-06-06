package Num1_3_01;

import java.util.Collections;
import java.util.LinkedList;

/**
 * P246 T3
 * 
 * @author he
 *
 */

class OrderedSequentialSearchST<Key extends Comparable<Key>, Value> {
	private LinkedList<Key> keys;
	private LinkedList<Value> values;

	public OrderedSequentialSearchST() {
		keys = new LinkedList<Key>();
		values = new LinkedList<Value>();
	}

	public void put(Key key, Value value) {
		if (key == null) {
			throw new RuntimeException("key can't be null");
		}
		if (keys.contains(key)) {
			int index = keys.indexOf(key);
			values.set(index, value);
		} else {
			keys.add(key);
			values.add(value);
		}

	}

	public Value get(Key key) {
		int index = keys.indexOf(key);
		if (index != -1) {
			return values.get(index);
		} else {
			return null;
		}
	}

	public Key min() {
		Collections.sort(keys);
		return keys.get(0);
	}

	public Key max() {
		Collections.sort(keys);
		return keys.getLast();
	}

}

public class Num_3_01_03 {
	public static void main(String[] args) {
		OrderedSequentialSearchST<String, Integer> st = new OrderedSequentialSearchST<String, Integer>();
		st.put("A", 1);
		st.put("B", 2);
		st.put("A", 3);
		System.out.println(st.min());
		System.out.println(st.max());
		System.out.println(st.get("A"));
	}

}
