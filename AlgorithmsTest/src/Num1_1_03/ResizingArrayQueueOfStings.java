package Num1_1_03;

/**
 * P102 T14 通过数组实现一个队列并支持动态扩容
 * 
 * @author he
 *
 */
public class ResizingArrayQueueOfStings<Item> {

	private Item[] a;
	private int head;// 队列头
	private int taile;// 队列尾

	public ResizingArrayQueueOfStings() {
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings("unchecked")
	public ResizingArrayQueueOfStings(int cap) {
		a = (Item[]) new Object[cap];
	}

	// 数组扩容
	private void resize(int max) {
		@SuppressWarnings("unchecked")
		Item[] temp = (Item[]) new Object[max];
		int count = 1;// 用于记录新数组中的元素个数
		for (int i = 0; i < taile - head; i++) {
			temp[i] = a[head + i];
			count++;
		}
		head = 0;// 重置head的指向
		taile = count - 1;// 重置tail的指向
		a = temp;// 让a指向新的数组
	}

	// 添加元素
	void enqueue(Item item) {
		if (taile == a.length) {
			resize(2 * a.length);
		}
		a[taile++] = item;
	}

	// 删除元素
	Item dequeue() {
		Item item = a[++head];
		a[head] = null;// 避免对象游离
		// 对数组进行缩减
		if (taile > 0 && taile - head == a.length / 4) {
			resize(a.length / 2);
		}
		return item;
	}

	// 存放的元素个数
	int size() {
		return taile - head;
	}

	// 判断队列是否为空
	boolean isEmpty() {
		if (head == taile) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		ResizingArrayQueueOfStings<Integer> r = new ResizingArrayQueueOfStings<Integer>(1);
		for (int i = 0; i < 10; i++) {
			r.enqueue(i);
			if (i >= 5) {
				
				System.out.println("dequeue："+r.dequeue());
			}
		}
		System.out.println(r.isEmpty());// false
		System.out.println(r.size());// 5

		
		
	}

}
