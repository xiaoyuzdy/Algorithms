package Num1_1_04;

/**
 * 二分查找，顺便回忆一下
 * 
 * @author he
 *
 */
public class BinarySearch {
	public static int indexof(int a[], int key) {
		int first = 0;
		int last = a.length - 1;

		while (first <= last) {
			int mid = first + (last - first) / 2;
			if (key < a[mid])
				last = mid - 1;
			else if (key > a[mid])
				first = mid + 1;
			else
				return mid;

		}

		return -1;
	}

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5, 6 };
		System.out.println(indexof(a, 6));
	}

}
