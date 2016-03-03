package Numbe_1_01;

/**
 * P15 二分查找的递归算法
 * 
 * @author he
 *
 */
public class BinarySerchGcd {
	public static int rank(int key, int[] a) {
		return rank(key, a, 0, a.length - 1);
	}

	public static int rank(int key, int[] a, int start, int end) {
		if (start > end) {
			return -1;
		}
		int mid = start + (end - start) / 2;
		if (key > a[mid]) {
			return rank(key, a, mid + 1, end);
		} else if (key < a[mid]) {
			return rank(key, a, start, mid - 1);
		} else {
			return mid;
		}

	}

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5 };
		
        
		System.out.println(rank(1, a));
	}
}
