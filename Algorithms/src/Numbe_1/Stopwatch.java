package Numbe_1;
/**
 * P110   计时器用于记录程序运行的时间
 * @author he
 *
 */

import edu.princeton.cs.algs4.StdRandom;

/**
 * 	P110
 * 统计所有和为0的三整数元组的数量
 *增长的数量级N3  （N的3次方）
 * 
 * @author he
 *
 */
class ThreeSum {
	public static int count(int a[]) {
		int N = a.length;
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				for (int k = j + 1; k < N; k++) {
					if (a[i] + a[j] + a[k] == 0) {
						cnt++;
					}
				}
			}

		}
		return cnt;
	}

}

public class Stopwatch {
	private final long start;

	public Stopwatch() {
		start=System.currentTimeMillis();//获取系统当前时间以毫秒为单位
	}
	
	public double elapsedTime(){
		long now=System.currentTimeMillis();
		return (now-start)/1000.0;
	}
	
	public static void main(String[] args) {
		int N=Integer.parseInt(args[0]);//1000
		int a[]=new int[N];
		for(int i =0;i<N;i++){
			a[i]=StdRandom.uniform(-1000000, 1000000);
		}
		Stopwatch s=new Stopwatch();
		int cnt=ThreeSum.count(a);
		double time=s.elapsedTime();
		System.out.println("count:"+cnt+" time:"+time+"seconds");
	}
	
	
}

















