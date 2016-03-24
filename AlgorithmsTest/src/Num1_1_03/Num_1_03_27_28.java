package Num1_1_03;

/**
 * P103 T27 T28
 * 
 * @author he
 *
 */
public class Num_1_03_27_28 {
	private static int N;
	private static Node first;
	private static Node last;

	private static class Node {
		int item;
		Node next;
	}

	public static void enquueu(int item) {
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if (N == 0) {
			first = last;
		} else {
			oldlast.next = last;
		}
		N++;
	}

	//T 27 «Û max
	public static int max() {
		int temp = 0;
		for (Node x = first; x.next != null; x = x.next) {
			if (x.item > x.next.item) {
				temp = x.item;
				x.item = x.next.item;
				x.next.item = temp;
			}
		}
		if (N == 0) {
			return temp;
		} else {
			return last.item;
		}

	}
	
	//T28  π”√µ›πÈ
	public static int maxGcd(){
		if (N==0) {
			return 0;
		}
		
		if ( first.next!=null && first.item < first.next.item) {
			first=first.next;			
			return maxGcd();
		}
		else {
			return first.item;
		}
		
	}

	public static void main(String[] args) {
		//≤‚ ‘  T27
		for (int i = 0; i < 5; i++) {
			enquueu(i);
		}
		System.out.println(max());//4
		
		//≤‚ ‘T28	
		System.out.println(maxGcd());//4
	}

}
