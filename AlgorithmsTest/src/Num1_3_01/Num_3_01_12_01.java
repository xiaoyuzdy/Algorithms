package Num1_3_01;

import edu.princeton.cs.algs4.Merge;

/**
 * P247 T12 
 * 用一个实体类保存键-值对 使用归并排序的原因：归并排序是稳定排序，见书P218 
 * 这题才是书中想要的答案
 * args:26
 * @author he
 */

//实体类，用于保存键值对
class Ite<K extends Comparable<K>, V> implements Comparable<K> {
	 K key;
	 V value;

	public Ite(K key, V value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public int compareTo(K o) {
		return o.compareTo(this.key);
	}
}

class Bina<Key extends Comparable<Key>, Value> {
	private Ite<Key, Value> item[];
	public Bina(Ite<Key, Value> a[]) {
		item = a;
		Merge.sort(a);
	}

	public Value get(Key key) {
		if (key == null) {
			throw new RuntimeException("key can't be null");
		}
		int N = item.length;
		for (int i = 0; i < N; i++) {
			if (item[i].key.equals(key)) {
				return item[i].value;
			}
		}
		return null;
	}
	
	public Key select(int k) {
		if (k < 0 || k >= item.length) {
			throw new IndexOutOfBoundsException();
		}
		return item[k].key;
	}
	
	public Key min(){
		return item[0].key;
	}
	
	public Key max(){
		return item[item.length-1].key;
	}
}

public class Num_3_01_12_01 {
	public static void main(String[] args) {
		int N=Integer.valueOf(args[0]);//26
		@SuppressWarnings("unchecked")
		Ite<String, Integer> a[] = new Ite[N];
		for (int i = 0; i < N; i++) {
			a[i] = new Ite<String, Integer>(String.valueOf(Character.toChars(i + 97)), i * i);
		}
		Bina<String, Integer> b = new Bina<String, Integer>(a);
		System.out.println(b.get("b"));// 1
		System.out.println(b.select(6));// g
		System.out.println(b.min());//a
		System.out.println(b.max());//z
	}

}
