package Num1_2_02;
/**
 * P180 T8
 * @author he
 *
 */

class mergeC{
	private static Comparable aux[];

	public static void sort(Comparable a[]) {
		aux = new Comparable[a.length];
		sort(a, 0, a.length - 1);

	}

	private static void sort(Comparable a[], int firstIndex, int lastIndex) {
		if (firstIndex>=lastIndex) {
			return;
		}
		int midIndex=firstIndex+(lastIndex-firstIndex)/2;
		sort(a,firstIndex,midIndex);//左边排序
		sort(a, midIndex+1, lastIndex);//右边排序
		if (a[midIndex].compareTo(a[midIndex+1])>0) {
			merge(a, firstIndex, midIndex, lastIndex);//归并结果
		}		
	}

	private static void merge(Comparable a[], int firstIndex, int midIndex, int lastIndex) {
		int i = firstIndex;
		int j = midIndex + 1;
		// 将数组a里的元素复制到aux中
		for (int k = firstIndex; k <= lastIndex; k++) {
			aux[k] = a[k];
		}

		for (int k = firstIndex; k <= lastIndex; k++) {
			if (i > midIndex) {
				a[k] = aux[j++];// 左边取完取右边
			} else if (j > lastIndex) {
				a[k] = aux[i++];// 右边取完取左边
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
}
public class Num_2_02_08 {
	public static void main(String[] args) {
		String a[] = { "E", "E", "G", "M", "R", "A", "F", "C", "R", "T" };
		mergeC.sort(a);
		mergeC.show(a);
	}

}
