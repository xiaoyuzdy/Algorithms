package Number_2;

/**
 * P176 自底向上的归并排序 先归并微型数组，再归并得到的子数组，直到将整个数组归并在一起，这种实现代码量更少
 * 
 * @author he
 *
 */
public class MergeBU {

	private static Comparable[] aux;// 辅助数组

	public static void sort(Comparable[] a) {
		int N = a.length;
		aux = new Comparable[N];
		for (int sz = 1; sz < N; sz += sz) {
			for (int firstIndex = 0; firstIndex < N - sz; firstIndex += sz + sz) {
                   merge(a, firstIndex, firstIndex+sz-1,Math.min(firstIndex+sz+sz-1,N-1) );
			}
		}

	}

	private static void merge(Comparable[] a, int firstIndex, int midIndex, int lastIndex) {
		int i = firstIndex;
		int j = midIndex + 1;

		System.arraycopy(a, firstIndex, aux, firstIndex, lastIndex-firstIndex+1);// 数组复制

		for (int k = firstIndex; k <= lastIndex; k++) {
			if (i > midIndex) {
				a[k] = aux[j++];
			} else if (j > lastIndex) {
				a[k] = aux[i++];
			} else if (aux[j].compareTo(aux[i]) < 0) {
				a[k] = aux[j++];
			} else {
				a[k] = aux[i++];
			}
		}

	}
	
	public static void show(Comparable a[]) {
		int N = a.length;
		for (int i = 0; i < N; i++) {
			System.out.print(a[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		String a[] = { "M", "E", "R", "G", "E", "S", "O", "R", "T","E","X","A","M","P","L","E" };
		sort(a);
		show(a);
	}

}
