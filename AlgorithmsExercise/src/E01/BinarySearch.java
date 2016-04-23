package E01;

/**
 * 二分查找
 * 
 * @author he
 *
 */
public class BinarySearch {
	// 返回下标index
	static int rank(int key, int[] a) {
		int start = 0;
		int end = a.length - 1;
		while (start < end) {
			int mid = start + (start + end) / 2;
			if (key < a[mid]) {
				end = mid - 1;
			} else if (key > a[mid]) {
				start = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
		
	}
}
