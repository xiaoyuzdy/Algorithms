package Number_2;

/**
 * P153 排序算法类的模板，使用该模板的类必须支持Comparable
 * 
 * @author he
 *
 */
public class Example {
	// 排序
	public static void sort(Comparable[] a) {
		/* 见算法2.1 2.2 2.3 2.4 等 */
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
	
	//单行中打印数组
	public static void show(Comparable a[]){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	
	//测试数组是否有序
	public static boolean isShorted(Comparable[] a){
		for(int i=1;i<a.length;i++){
			if (less(a[i], a[i-1])) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		String[] a={"A","B","C"};
		assert isShorted(a);//断言 防止程序进入死循环导致系统崩溃
		show(a);
		System.out.println(isShorted(a));
	}

}
