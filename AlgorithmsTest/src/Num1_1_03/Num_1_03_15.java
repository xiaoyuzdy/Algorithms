package Num1_1_03;

/**
 * P103 T15 继承14题写的队列 再添加一个方法打印出倒数第K个字符串即可
 * args: 3
 * @author he
 *
 */

public class Num_1_03_15<Item> extends ResizingArrayQueueOfStings<Item> {
	private Item[] a;
	private int head;// 队列头
	private int taile;// 队列尾

	@SuppressWarnings("unchecked")
	public Num_1_03_15(int cap) {
		a = (Item[]) new Object[cap];
	}

	// 返回倒数第K个元素
	Item dequeueK(int k) {
		Item item = a[a.length - k-1];
		a[head] = null;// 避免对象游离
		return item;

	}
	@Override
	void enqueue(Item item) {
		a[taile++] = item;
	}

	public static void main(String[] args) {
		Num_1_03_15<Integer> a = new Num_1_03_15<Integer>(5);
		for (int i = 0; i < 4; i++) {
			a.enqueue(i);
		}
		
		System.out.println(a.dequeueK(Integer.parseInt(args[0])));

	}

}
