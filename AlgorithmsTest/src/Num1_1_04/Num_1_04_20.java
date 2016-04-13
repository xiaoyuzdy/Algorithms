package Num1_1_04;

/**
 * P133 T20
 * 
 * @author he
 *
 */
public class Num_1_04_20 {
	public static boolean contains(int a[], int key) {
		int first1 = 0;
		int last1 = a.length / 2;

		while (first1 <= last1) {
			int mid = first1 + (last1 - first1) / 2;
			if (a[mid] > key) {
				last1 = mid - 1;
			} else if (a[mid] < key) {
				first1 = mid + 1;
			} else if (a[mid] == key) {
				return true;
			}
		}

		int first2 = a.length / 2;
		int last2 = a.length - 1;

		while (first2 <= last2) {
			int mid = first2 + (last2 - first2) / 2;
			if (a[mid] > key) {
				last2 = mid - 1;
			} else if (a[mid] < key) {
				first2 = mid + 1;
			} else if (a[mid] == key) {
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		int a[] = { 2, 4, 6, 8, 10, 7, 5, 3, 1 };
		System.out.println(contains(a, 5)); // true
	}

}
