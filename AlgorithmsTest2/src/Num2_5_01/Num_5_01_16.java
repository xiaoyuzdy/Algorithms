package Num2_5_01;

import java.util.Iterator;
import edu.princeton.cs.algs4.StdRandom;

/**
 * P472 T16 由于单链表的结构是Stack结构的所以是降序排序
 * 
 * @author he
 *
 */

class list<T extends Comparable<T>> implements Iterable<T> {
	private Node first;
	private int N;

	private class Node {
		Node next;
		T item;
	}

	public void push(T item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		N++;
	}

	public T pop() {
		T item = first.item;
		first = first.next;
		N--;
		return item;
	}

	public boolean isEmpty() {
		return N == 0;
	}

	// 转化为数组
	private Object[] toArray() {
		Object[] t = new Object[N];
		int i = 0;
		for (Node x = first; x != null; x = x.next)
			t[i++] = x.item;
		return t;
	}

	// 排序
	public list<T> srot(list<?> l) {
		Object[] a = l.toArray();
		sort(a, 0, a.length - 1, 0);
		list<T> tt = new list<T>();
		for (Object e : a) {
			@SuppressWarnings("unchecked")
			T x = (T) e;
			tt.push(x);
		}
		return tt;
	}

	private void sort(Object a[], int lo, int hi, int d) {
		if (lo >= hi)
			return;
		int lt = lo, gt = hi, i = lo + 1;
		int v = charAt(a[lo], d);
		while (i <= gt) {
			int t = charAt(a[i], d);
			if (t < v)
				exch(a, i++, lt++);
			else if (t > v)
				exch(a, i, gt--);
			else
				i++;
		}

		sort(a, lo, lt - 1, d);
		if (v > 0)
			sort(a, lo, hi, d + 1);
		sort(a, gt + 1, hi, d);

	}

	private int charAt(Object s, int d) {
		String a = s.toString();
		if (d < a.length())
			return a.charAt(d);
		else
			return -1;
	}

	private void exch(Object a[], int i, int j) {
		Object t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	@Override
	public Iterator<T> iterator() {
		return new listIterator();
	}

	private class listIterator implements Iterator<T> {
		private Node temp = first;

		@Override
		public boolean hasNext() {

			return temp != null;
		}

		@Override
		public T next() {
			T item = temp.item;
			temp = temp.next;
			return item;
		}

	}

}

public class Num_5_01_16 {
	public static void main(String[] args) {
		list<Integer> list = new list<Integer>();
		for(int i=0;i<10;i++)
			list.push(StdRandom.uniform(10));//添加10个随机数
		list<Integer> lt = list.srot(list);
		while (!lt.isEmpty())
			System.out.println(lt.pop());
	}
}
