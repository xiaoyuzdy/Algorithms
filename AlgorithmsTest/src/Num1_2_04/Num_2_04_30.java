package Num1_2_04;

/**
 * P211 T30
 * 
 * @author he
 *
 */

class findMedian {
	private int a[];
	private int N;// 数组中元素的数量

	public findMedian() {
		a = new int[1];
	}

	public void insert(int i) {
		if (N == a.length) {
			resize(a.length * 2);
		}
		a[N++] = i;
	}

	// 返回中位数
	public double median() {
		if (N == 0) {
			System.out.println("有误");
			throw new RuntimeException();
		}
		int b[] = new int[N];
		System.arraycopy(a, 0, b, 0, N);// 因为使用SelectElement.findMedian时会打乱数组的顺序所以使用副本
		double median = SelectElement.findMedian(b);// 获取中位数
		return median;

	}

	// 数组扩容
	private void resize(int max) {
		int temp[] = new int[max];
		for (int i = 0; i < N; i++) {
			temp[i] = a[i];
		}
		a = temp;
	}

	public void show() {
		for (int i = 0; i < N; i++) {

			System.out.print(a[i] + " ");
		}
	}

}

public class Num_2_04_30 {
	public static void main(String[] args) {
		findMedian f = new findMedian();
		for (int i = 1; i < 6; i++) {
			f.insert(i);
		}

		f.show();
		System.out.println("\n" + "中位数：" + f.median());

	}

}
