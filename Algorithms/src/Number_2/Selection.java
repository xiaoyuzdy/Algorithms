package Number_2;

/**
 * P156 选择排序
 * 
 * @author he
 *
 */
public class Selection {
	// 排序
	public static void sort(Comparable[] a) {
		//将数组a按升序排
		int N=a.length;
		for(int i=0;i<N;i++){
			int min=i;
			for(int j=i+1;j<N;j++){
				if (less(a[j], a[min])) {
					min=j;//交换索引，使min指向最小的元素下标
				}
			}
			exch(a, i, min);//交换元素位置
		}
	}

	// 元素之间进行比较
	public static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0; // 如果v<w则为true
	}

	// 交换元素位置
	public static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	// 单行中打印数组
	public static void show(Comparable a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	// 测试数组是否有序
	public static boolean isShorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
			if (less(a[i], a[i - 1])) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Integer a[]={2,3,4,1,55,6,3,6,7};
		sort(a);
		System.out.println(isShorted(a));
		show(a);
	}
}
