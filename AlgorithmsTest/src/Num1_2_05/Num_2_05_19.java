package Num1_2_05;

import edu.princeton.cs.algs4.StdRandom;

/**
 * P225 T19 
 * @author he
 *
 */

class KendallTau {
	private static int t1[];// a[]的逆序
	private static int t2[];// 辅助数组

	/**
	 * 计算Kendall tau距离
	 * 
	 * @param a
	 *            数组
	 * @param b
	 *            数组
	 * @return 返回距离
	 * @throws Exception
	 */
	public static int distance(int a[], int b[]) {
		if (a.length != b.length) {
			throw new IllegalArgumentException("array dimensions disagree");
		}

		int N = a.length;
		t1 = new int[N];
		t2 = new int[N];
		// 逆序：t1[a[i]]=a[t1[i]]=i
		for (int i = 0; i < N; i++) {
			t1[a[i]] = i;
		}

		for (int i = 0; i < N; i++) {
			t2[i] = t1[b[i]];			
		}

		return count(t2);

	}
	
	//排序一个数组返回交换次数
	private static int count(int a[]){
		int N=a.length;
		int count=0;
		for(int i=1;i<N;i++){
			for(int j=i;j>0 && a[j]<a[j-1];j--){
				exch(a, j, j-1);
				count++;
			}
		}
		return count;
	}
	

	/**
	 * 交换元素
	 * 
	 * @param a
	 *            指定数组
	 * @param i
	 *            指定index
	 * @param j
	 *            指定index
	 */
	private static void exch(int a[], int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	//产生随机数组
	public static  int [] random(int N){
		int a[]=new int [N];
		for (int i = 0; i < N; i++) {
			a[i]=i;
		}
		StdRandom.shuffle(a);
		return a;
	}
	

}

public class Num_2_05_19 {
	public static void main(String[] args) {
		//distance = 4
//		int a[] = { 0, 3, 1, 6, 2, 5, 4 };
//		int b[] = { 1, 0, 3, 6, 4, 2, 5 }; 
	
		
        int N=Integer.valueOf(args[0]);//10
        int a[]=KendallTau.random(N);
        int b[]=KendallTau.random(N);
		System.out.println(KendallTau.distance(a, b));

	}

}
