package Numbe_1;

import java.util.Arrays;
import java.util.Random;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.StdRandom;

/**
 * P119 统计所有和为0的二元整数数组数量 增长数量级 NlogN
 * 
 * @author he
 *
 */

public class TwoSumFast {
	public static int count(int a[]) {
		int cun = 0;// 统计和为0的二元数据的数目
		int N = a.length;
		Arrays.sort(a);
		for (int i = 0; i < N; i++) {
			if (BinarySearch.indexOf(a, -a[i]) > i) {
				cun++;
			}
		}
		return cun;
	}

	public static void main(String[] args) {
		int N = 1000;
		int a[] = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = StdRandom.uniform(-10000, 10000);
		}
		System.out.println(count(a));
	}
}
