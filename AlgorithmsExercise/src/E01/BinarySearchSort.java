package E01;

/**
 * 利用二分查找(返回值做修改)在添加元素时排序
 * 
 * @author he
 *
 */
public class BinarySearchSort<T extends Comparable<T>> {

	private T a[];
	private int N;// 元素个数

	public BinarySearchSort(int N) {
		a = (T[]) new Comparable[N];
	}

	public int rank(T item) {
		int lo = 0, hi = N - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int cmp = item.compareTo(a[mid]);
			if (cmp > 0)
				lo = mid + 1;//注意这里,最后一次比较后，lo等于比item小的最大元素的下标+1
			else if (cmp < 0)
				hi = mid - 1;
			else
				return mid;
		}
		return lo;
	}

	public void put(T item) {
		int i = rank(item);// 如果未命中，则i等于比item小的最大元素的index+1
		for (int j = N; j > i; j--) {
			a[j] = a[j - 1];// 元素后移
		}
		a[i] = item;
		N++;
	}

	public void print() {
		for (int i = 0; i < N; i++) {
			System.out.print(a[i] + " ");
		}
	}

	public static void main(String[] args) {
		BinarySearchSort<Integer> b = new BinarySearchSort<>(10);
		b.put(1);
		b.put(3);
		b.put(3);
		b.put(3);
		b.put(2);
		b.put(0);
		b.put(5);
		b.put(4);
		b.print();// 0 1 2 3 3 3 4 5
	}

}
