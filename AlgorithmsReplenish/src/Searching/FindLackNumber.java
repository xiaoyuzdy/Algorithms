package Searching;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目： 在一个包含40亿个随机排列的32位整数的顺序文件中（注意随机排序），找出一个不再文件中的32位整数（即int类型的整数），文件中
 * 至少缺少一个这样的数 要求：使用最少的内存
 * 
 * 思路：将每个数转换为2进制数，然后进行0/1探测，将为0的位保存在一块内存中，将为1的位保存在另一块内存中，
 * 一个文件中至多只有20亿个，因为40亿小于2的32次方，所以缺少的肯定很多，题目要求只要找到1个即可，书里面翻译有误导性
 * 我们应该以含有整数最少的文件再次作为数据源，进行0/1探测，这次探测的是第二位（从左至右）再进行分类，依次类推 这样算法时间复杂度只有O(n);
 * 
 * 这样的思路只能找到一个数，如果需要都找到且内存充足的情况下应该考虑位图排序
 * 
 * 
 * 
 * 
 * @author he
 *
 */

public class FindLackNumber {

	private static int bit = 4;// 总共的位数，int 32位

	private static Integer[] temp;
	private static ArrayList<Integer> zero;// 存放0
	private static List<Integer> one;// 存放1
	private static int number;

	// 找到数组a中缺少的整数
	public static int find(Integer[] a) {
		temp = a;
		zero = new ArrayList<>();
		one = new ArrayList<>();

		while (bit-- > 0) {
			zero.clear();
			one.clear();
			for (int i = 0; i < temp.length; i++) {
				// 高位为1
				if ((temp[i] & (1 << bit)) != 0) {
					one.add(temp[i]);
				} else {
					zero.add(temp[i]);
				}
			}

			if (zero.size() < one.size()) {
				temp = (Integer[]) zero.toArray(new Integer[zero.size()]);
				number |= 0 << bit;
			} else {
				temp = (Integer[]) one.toArray(new Integer[one.size()]);
				number |= 1 << bit;
			}
		}
		return number;

	}

	public static void main(String[] args) {
		Integer[] a = { 0, 1, 2, 3, 4, 5, 6, 7, 9, 10, 11, 12, 13, 14, 15 };
		System.out.println(find(a));

	}

}
