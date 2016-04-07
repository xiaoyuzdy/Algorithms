package Numbe_1;

import java.util.Arrays;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.StdRandom;

/*
 *P120  数量增长级N2logN(N的2次方) 
 */
public class ThreeSumFast {
	public static int count(int a[]) {
		int N = a.length;
		Arrays.sort(a);
		int cun = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				if (BinarySearch.indexOf(a, -a[i] - a[j]) > j) {
					cun++;
				}
			}
		}

		return cun;
	}

	public static void main(String[] args) {
		int N=1000;
		int a[]=new int[N];
		for(int i=0;i<N;i++){
			a[i]=StdRandom.uniform(-10000,10000);
		}	
	    System.out.println(count(a));			
	}
	
	
}
