package Numbe_1;

import java.util.Iterator;

/**
 * P88 下压栈（能动态调节数组的大小） 实现 iterable接口则该对象支持foreach
 * 
 * @author he
 *
 */
public class ResizingArrayStack<Item> implements Iterable<Item> {
	@SuppressWarnings("unchecked")
	private Item[] a = (Item[]) new Object[1];
	private int N;// 记录元素个数

	private void resize(int max) {
		@SuppressWarnings("unchecked")
		Item[] temp = (Item[]) new Object[max];
		for (int i = 0; i < N; i++) {
			temp[i] = a[i];
		}
		a = temp;
	}

	public void push(Item item) {
		if (N == a.length) {
			resize(a.length * 2);
		}
		a[N++] = item;

	}

	public Item pop() {
		Item item = a[--N];
		a[N] = null;// 避免对象游离

		if (N > 0 && N == a.length / 4) {
			resize(a.length / 2);
		}
		return item;

	}

	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new RecverseArrayIterator();
	}

	private class RecverseArrayIterator implements Iterator<Item> {

		private int i = N;

		public boolean hasNext() {
			// TODO Auto-generated method stub
			return i > 0;
		}

		public Item next() {

			return a[--i];
		}

		public void remove() {

		}
	}

	public static void main(String[] args) {
		ResizingArrayStack<Integer> s = new ResizingArrayStack<Integer>();

		for (int i = 0; i < 10; i++) {
			s.push(i);
		}

		for (Integer integer : s) {
			System.out.println("foreach:" + integer);
		}

		ResizingArrayStack<Integer>.RecverseArrayIterator r = (ResizingArrayStack<Integer>.RecverseArrayIterator) s
				.iterator();

		while (r.hasNext()) {
			System.out.println("iterator:" + r.next());
		}

	}

}
