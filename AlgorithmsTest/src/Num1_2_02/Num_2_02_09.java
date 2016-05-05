package Num1_2_02;

/**
 * P180 T09
 * 
 * @author he
 *
 */

class Merge {
	public static void sort(Comparable[] a) {
		Comparable[] aux = new Comparable[a.length];
		sort(a, aux, 0, a.length - 1);

	}

	public static void show(Comparable a[]) {
		int N = a.length;
		for (int i = 0; i < N; i++) {
			System.out.print(a[i] + " ");
		}
	}

	private static void sort(Comparable[] a, Comparable[] aux, int firstIndex, int lastIndex) {
		if (firstIndex >= lastIndex) {
			return;
		}
		int midIndex = firstIndex + (lastIndex - firstIndex) / 2;
		sort(a, aux, firstIndex, midIndex);
		sort(a, aux, midIndex + 1, lastIndex);
		merge(a, aux, firstIndex, midIndex, lastIndex);
	}

	private static void merge(Comparable[] a, Comparable[] aux, int firstIndex, int midIndex, int lastIndex) {
		int i = firstIndex;
		int j = midIndex + 1;
		System.arraycopy(a, firstIndex, aux, firstIndex, lastIndex - firstIndex + 1);
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

}

public class Num_2_02_09 {
	public static void main(String[] args) {
		String a[] = { "E", "E", "G", "M", "R", "A", "E", "C", "R", "T" };
		Merge.sort(a);
        Merge.show(a);
	}
}
