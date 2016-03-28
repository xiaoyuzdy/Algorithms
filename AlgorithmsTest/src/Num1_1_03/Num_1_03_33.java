package Num1_1_03;

/**
 * P104 T33 双向链表的实现见T31，动态数组实现 功能实现,用例测试通过
 * 
 * @author he
 *
 */
class ResizingArrayDeque<Item> {
	private int N;// size
	private Item[] a;
	private int head;// 队列头指向数组的中间
	private int taile;// 队列尾

	@SuppressWarnings("unchecked")
	public ResizingArrayDeque() {
		a = (Item[]) new Object[1];
		head = a.length / 2;
		taile = head;
	}

	// 数组扩容
	private void resize(int max) {
		@SuppressWarnings("unchecked")
		Item[] temp = (Item[]) new Object[max];
		int newhead = (temp.length + 1) / 2 - (N + 1) / 2;// 新数组队列头的下标
		int count = 1;// 用于记录新数组中的元素个数
		for (int i = 0; i < N; i++) {
			temp[newhead + i] = a[head + i];
			count++;
		}
		head = newhead;// 重置head的指向
		taile = head + count - 1;// 重置tail的指向
		a = temp;// 让a指向新的数组
	}

	public int size() {
		return N;
	}

	// 右端添加元素
	void pushRight(Item item) {
		if (taile >= a.length - 1) {
			resize(2 * a.length);
		}

		a[taile++] = item;
		N++;
	}

	// 右端删除元素
	public Item popRight() {
		if (N == 0) {
			throw new IndexOutOfBoundsException();
		}
		N--;
		return a[--taile];
	}

	// 左端添加元素
	void pushLeft(Item item) {
		if (head <= 1) {
			resize(2 * a.length);
		}

		a[--head] = item;
		N++;
	}

	// 左端删除元素
	public Item popLeft() {
		if (N == 0) {
			throw new IndexOutOfBoundsException();
		}
		N--;
		return a[head++];
	}

}

public class Num_1_03_33 {
	public static void main(String[] args) {
		ResizingArrayDeque<Integer> r = new ResizingArrayDeque<Integer>();
		r.pushLeft(1);
		r.pushLeft(2);
		r.pushLeft(3);
		//// r.pushLeft(32);
//		System.out.println(r.popLeft());
//		System.out.println(r.popLeft());
//		System.out.println(r.popLeft());

		r.pushRight(4);
		// r.pushRight(5);
		// r.pushRight(6);
		System.out.println(r.popRight());
		System.out.println(r.popRight());
		System.out.println(r.popRight());
		System.out.println(r.popRight());

		System.out.println(r.size());
	}

}