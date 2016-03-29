package Num1_1_03;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdRandom;

/**
 * P105 T35 测试用例通过,
 * 赋值时是a[taile-1]开始的，a[taile]为null
 * 所以在移除元素时也要从a[taile-1]开始
 * 
 * @author he
 *
 */
class RandomQueue<Item> implements Iterable<Item>{

	private Item[] a;
	private int N;// size
	private int head;// 队列头
	private int taile;// 队列尾

	@SuppressWarnings("unchecked")
	public RandomQueue() {
		a = (Item[]) new Object[1];
		head = (a.length + 1) / 2;
		taile = head;
	}

	// 数组扩容
	private void resize(int max) {
		@SuppressWarnings("unchecked")
		Item[] temp = (Item[]) new Object[max];
		int count = 1;// 用于记录新数组中的元素个数
		int newhead = (temp.length + 1) / 2;
		for (int i = 0; i < N; i++) {
			temp[newhead + i] = a[head + i];
			count++;
		}
		head = newhead;// 重置head的指向
		taile = head + count - 1;// 重置tail的指向
		a = temp;// 让a指向新的数组
	}

	// 队列头添加元素
	void enqueue(Item item) {
		if (head <= 1) {
			resize(2 * a.length);
		}
		a[--head] = item;
		N++;
	}

	// 队列尾删除元素
	Item dequeue() {
		// 获取head-taile之间的随机元素
//		int temp = head + (int) (Math.random() * (taile - head - 1));
		int temp =StdRandom.uniform(head, taile-1);
		Item item = a[temp];
		// 交换t随机数和队列尾的元素
		a[temp] = a[taile-1];
		a[taile-1] = item;
		N--;
		taile--;
		return item;
	}

	// 随机返回一个元素但不删除
	public Item sample() {
		// 获取head到taile之间的随机数
//		int temp = head + (int) (Math.random() * (taile - head - 1));
		int temp =StdRandom.uniform(head, taile);
		Item item = a[temp];
		return item;

	}

	// 判断队列是否为空
	boolean isEmpty() {
		return N == 0;
	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new RecverseArrayIterator();
	}
	private class RecverseArrayIterator implements Iterator<Item> {

		private int i = N;
		private int nhead=head;
		private int ntaile=taile;

		public boolean hasNext() {
			// TODO Auto-generated method stub
			return i > 0;
		}

		public Item next() {
			//获取随机下标
			int temp =StdRandom.uniform(nhead, ntaile-1);
			Item item = a[temp];
			// 交换随机数和队列尾的元素
			a[temp] = a[ntaile-1];
			a[ntaile-1] = item;
			N--;
			ntaile--;
			return item;
		}

		public void remove() {

		}
	}
}

public class Num_1_03_35_36 {
	public static void main(String[] args) {
		RandomQueue<Integer> r = new RandomQueue<Integer>();
		for (int i = 0; i < 10; i++) {
			r.enqueue(i);
			if (i >= 5) {
				System.out.println("dequeue:" + r.dequeue());
			}
			if (i > 0) {
				System.out.println("sample:" + r.sample());
			}
		}

		System.out.println(r.isEmpty());// false
	}

}
