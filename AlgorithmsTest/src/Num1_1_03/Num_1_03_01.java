package Num1_1_03;



/**
 * P101 T1
 * @author he
 *
 */
public class Num_1_03_01 <T> {
	private T[] a;// statck entries
	private int N;// size
	private int cap;// 数组申请的长度

	@SuppressWarnings("unchecked")
	public Num_1_03_01(int cap) {
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
		Num_1_03_01<String> f=new Num_1_03_01<String>(10);
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
