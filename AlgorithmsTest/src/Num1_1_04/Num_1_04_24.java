package Num1_1_04;

/**
 * P133 T24 数组前面为false,后面为true
 * 
 * @author he
 *
 */
public class Num_1_04_24 {
	public static int whereF(boolean a[]) {
		int first = 0;
		int last = a.length - 1;
		while (first <= last) {
			int mid = first + (last - first) / 2;
			if (a[mid] == false) {
				first = mid + 1;
			} else if (a[mid] == true && mid - 1 != -1 && a[mid - 1] == true) {
				last = mid - 1;
			} else {
				return mid;
			}

		}
		return -1;

	}

	public static void main(String[] args) {
		 boolean a[] = { false, false, true, true, true };//2
//		boolean a[] = { true, true, true, true };//0
		System.out.println(whereF(a));
	}

}