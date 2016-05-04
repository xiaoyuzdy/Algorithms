package Num1_2_02;

import edu.princeton.cs.algs4.Insertion;

/**
 * P180 T11 自顶向下归并排序的改进
 * 
 * @author he 算法2.4的改进：
 *           1、对于小规模的数组采用插入排序    以长度小于8的数组为小规模数组
 *           2、测试数组是否有序，如果a[mid]<=a[mid+1]则认为是有序
 *           3、不将元素复制到辅助数组 使用System.arraycopy 方法，
 *              Arrays.copyOf方法最终也是调用System.arraycopy 方法的，浅复制
 */

class QuickMerge{
	private static Comparable aux[];
    private static final int LENGTH=8;//定义一个小规模数组的长度
	public static void sort(Comparable a[]) {
		aux = new Comparable[a.length];
		sort(a, 0, a.length - 1);

	}

	private static void sort(Comparable a[], int firstIndex, int lastIndex) {
		/**
		 * 对于小规模数组采用插入排序
		 */
		if (lastIndex<firstIndex+LENGTH) {
			Insertion.sort(a);
			return;
		}
		
		int midIndex=firstIndex+(lastIndex-firstIndex)/2;
		sort(a,firstIndex,midIndex);//左边排序
		sort(a, midIndex+1, lastIndex);//右边排序
		
		/**
		 * 测试数组是否有序，如果a[mid]<=a[mid+1]则认为是有序,跳过merge();
		 */
		if (a[midIndex].compareTo(a[midIndex+1])>0) {
			merge(a, firstIndex, midIndex, lastIndex);//归并结果
		}		
	}

	private static void merge(Comparable a[], int firstIndex, int midIndex, int lastIndex) {
		int i = firstIndex;
		int j = midIndex + 1;
		
		/**
		 * 将数组a里的元素复制到aux中,使用System.arraycopy()
		 * 
		 */
		System.arraycopy(a, firstIndex, aux, firstIndex, lastIndex-firstIndex+1);

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
public class Num_2_02_11 {
	public static void main(String[] args) {
		String a[] = { "E", "E", "G", "M", "R", "A", "E", "C", "R", "T" };
		QuickMerge.sort(a);
		QuickMerge.show(a);
	}

}
