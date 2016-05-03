package Num1_2_02;

import java.util.Arrays;

/**
 * P180 T10
 * @author he
 *
 */
class AutochthonousMerge {
	private static Comparable aux[];

	public static void merge(Comparable a[], int first, int mid, int last) {
		aux = new Comparable[a.length];
		int i = first;
		int j = mid + 1;
		int temp=0;
		
		Arrays.sort(a,mid,last+1);//对数组后半部分排序
		// 将数组a复制到数组aux
		for (int k = first; k <mid; k++) {
			aux[k] = a[k];
			temp=k;
		}
		
		for(int k=last;k>=mid;k--){
			aux[++temp]=a[k];
		}
	
//		show(aux);
		for (int k = first; k <= last; k++) {
		 if (last<mid) {
				a[k] = aux[i++];// 右边元素取完了取左边
			} 
		 else if (aux[last].compareTo(aux[i]) < 0) {	
				a[k] = aux[last--];// 右边当前元素小于左边，取右边 
			} else {			
				a[k] = aux[i++];// 取左边元素
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

public class Num_2_02_10 {

	public static void main(String[] args) {
		String a[]={"E","E","G","M","R","A","E","C","R","T"};
		AutochthonousMerge.merge(a, 0, 4,9 );
		AutochthonousMerge.show(a);
	}
}
