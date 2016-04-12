package Num1_1_04;

import java.util.Arrays;

/**
 * P132 T11
 * 
 * @author he
 *
 */

class StaticSETofInts {
	private int a[];
	public StaticSETofInts(int key[]) {
		a = new int[key.length];
		for (int i = 0; i < key.length; i++) {
			a[i] = key[i];
		}
		Arrays.sort(a);
	}

	public boolean contains(int key) {
		return rank(key) != -1;
	}

	private int rank(int key) {
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

	public int howMany(int key) {
		if (!contains(key)) {
			return 0;
		}
		return count(key);
	}

	private int count(int key) {
		int count=0;
		int minIndex = minIndexOf(key);
		while (a[minIndex] == key) {
			count++;
			minIndex += 1;
		}
		return count;
	}

	// 获取元素的最小下标
	private int minIndexOf(int key) {
		int first = 0;
		int last = a.length - 1;

		while (first <= last) {
			int mid = first + (last - first) / 2;
			if (key < a[mid])
				last = mid - 1;
			// 修改,mid-1!=-1 防止数组越界
			else if (key == a[mid] && mid - 1 != -1 && a[mid - 1] == key) {
				last = mid;
			} else if (key > a[mid])
				first = mid + 1;
			else
				return mid;
		}
		return -1;
	}
}

public class Num_1_04_11 {
	public static void main(String[] args) {
		int a[] = { 1, 1, 1, 1, 1, 1, 2, 2, 1, 3 };
		StaticSETofInts s = new StaticSETofInts(a);
		System.out.println(s.howMany(1)); // 7
		System.out.println(s.howMany(2)); //2
	}

}
