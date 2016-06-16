package Num1_3_02;

import java.util.Arrays;

import edu.princeton.cs.algs4.BST;

/**
 * P266 T25
 * 
 * @author he
 *
 */

class PerfectBalance {

	public void perfect(BST bst, String[] a) {
		Arrays.sort(a);
		perfect(bst, a, 0, a.length - 1);

	}

	private void perfect(BST bst, String[] a, int lo, int hi) {
		if (lo > hi) {
			return;
		}
		int mid = lo + (hi - lo) / 2;
		bst.put(a[mid], mid);
		System.out.print(a[mid] + " ");
		perfect(bst, a, lo, mid - 1);// Ìí¼Ó×ó±ß
		perfect(bst, a, mid + 1, hi);// Ìí¼ÓÓÒ±ß

	}

}

public class Num_3_02_25 {
	public static void main(String[] args) {
		BST bst = new BST();
		String a[] = { "A", "C", "B" };
		PerfectBalance p = new PerfectBalance();
		p.perfect(bst, a);
	}
}
