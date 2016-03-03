package Num1_1_01;

/**
 * P35 加个递归深度
 * 
 * @author he
 *
 */
public class Ex_1_1_22 {
	static int count;// 计算递归深度

	public static String rank(int key, int[] a) {
		return rank(key, a, 0, a.length - 1);
	}

	public static String rank(int key, int[] a, int start, int end) {
		count++;
		if (start > end) {
			return "" + -1 + "深度：" + count;
		}

		int mid = start + (end - start) / 2;
		if (key < a[mid]) {
			return rank(key, a, start, mid - 1);
		} else if (key > a[mid]) {
			return rank(key, a, mid + 1, end);
		}

		else {
			return "下标：" + mid + " 深度：" + count;

		}

	}

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5 };

		System.out.println(rank(3, a));
	}

}
