package Num1_1_04;

import java.util.HashSet;
import java.util.Set;

/**
 * P132 T12 主要使用set里的contains方法
 * 
 * @author he
 *
 *         测试通过
 */

class sameElement<T> {
	private Set<T> set = new HashSet<T>();

	public void same(T a[], T b[]) {
		for (int i = 0; i < a.length; i++) {
			set.add(a[i]);
		}

		for (int j = 0; j < b.length; j++) {
			if (set.contains(b[j])) {
				System.out.println(b[j]);
			}
		}
	}
}

public class Num_1_04_12 {

	public static void main(String[] args) {
		sameElement<Integer> sElement = new sameElement<Integer>();

		Integer a[] = { 1, 2, 3, 6, 7 };
		Integer b[] = { 1, 2, 3, 4, 5, 6 };

		sElement.same(a, b);// 1 2 3 6

	}
}
