package Number_2;

/**
 * P170 原地归并的抽象方法
 * 要求：左边数组和右边数组必须是有序的
 * @author he
 *
 */
public class AutochthonousMerge {
	private static Comparable aux[];

	public static void merge(Comparable a[], int first, int mid, int last) {
		aux = new Comparable[a.length];
		int i = first;
		int j = mid + 1;
		// 将数组a复制到数组aux
		for (int k = first; k <= last; k++) {
			aux[k] = a[k];
		}
		for (int k = first; k <= last; k++) {
			if (i > mid) {
				a[k] = aux[j++];//左边元素取完了取右边
			} 
			else if (j > last) {
				a[k] = aux[i++];//右边元素取完了取左边
			} 
			else if (aux[j].compareTo(aux[i]) < 0) {
				a[k] = aux[j++];//右边当前元素小于左边，取右边
			}else {
				a[k]=aux[i++];//取左边元素
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
		String a[]={"E","E","G","M","R","A","C","E","R","T"};
		merge(a, 0, 4,9 );
		show(a);
	}

}
