package Numbe_1;

import java.util.Arrays;

/**
 * P62
 * 
 * @author he
 *
 */
public class StaticSETofInts {
	private   int a[];

	public StaticSETofInts(int key[]) {
		a = new int[key.length];
		for (int i = 0; i < key.length; i++) {
			a[i] = key[i];
		}
		Arrays.sort(a);
	}

	public   boolean contains(int key) {
		return rank(key) != -1;
	}

	private  int rank(int key) {
		int first = 0;
		int last = a.length - 1;
		while (first <= last) {
			int mid = first + (last - first) / 2;
			if (key < a[mid]) {
				last = mid - 1;
			} else if (key > a[mid]) {
				first = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int key[]={1,2,3};
		StaticSETofInts s=new StaticSETofInts(key);
		System.out.println(s.contains(2));//true
		System.out.println(s.contains(4));//false
	}
}
