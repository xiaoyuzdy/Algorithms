package Numbe_1;
/**
 * P84 一种表示泛型定容栈的抽象数据类型
 * @author he
 *
 * @param <T>
 */
public class FixedCapacityStack<T> {
	private T[] a;// statck entries
	private int N;// size
	private int cap;// 数组申请的长度

	@SuppressWarnings("unchecked")
	public FixedCapacityStack(int cap) {
		this.cap = cap;
		a = (T[]) new Object[cap];
	}

	void push(T item) {
		a[N++] = item;
	}

	T pop() {
		return a[--N];
	}

	boolean isEmpty() {
		return N == 0;
	}

	int size() {
		return N;
	}

	// 判断是否已满
	boolean isFull() {
		return N == cap;
	}

	public static void main(String[] args) {
		FixedCapacityStack<String> f=new FixedCapacityStack<String>(10);
		for (String string : args) {
			if (!string.equals("-")) {
				f.push(string);
			}
			else if (!f.isEmpty()) {
				System.out.print(f.pop()+" ");
			}
		}
		System.out.println("是否已满？"+ f.isFull());
		System.out.println("("+f.size()+" left on stack"+")");
	}	
}
