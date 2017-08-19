package Num1_1_04;

/**
 * P132 T10 样例测试通过
 * 
 * @author he
 *
 */

class BinarySearchChange {
	public static int firstIndexOf(int a[], int key) {
		int first = 0;
		int last = a.length - 1;

		while (first <= last) {
			int mid = first + (last - first) / 2;
			if (key < a[mid])
				last = mid - 1;
			// 修改,mid-1!=-1 防止数组越界
			else if (key == a[mid] && mid - 1 != -1 && a[mid - 1] == key) {
				last = mid - 1;
			} else if (key > a[mid])
				first = mid + 1;
			else
				return mid;

		}

		return -1;
	}

}

public class Num_1_04_10 {
	public static void main(String[] args) {
		int a[] = { 1, 2, 2, 2, 2, 2, 2, 2, 3 };
		System.out.println(BinarySearchChange.firstIndexOf(a, 2));// 1
		System.out.println(BinarySearchChange.firstIndexOf(a, 1));// 0

	}
}
