package Num1_1_03;

/**
 * P107 T47 使用栈来写
 * 
 * @author he
 *
 */
class catenatQueue<T> {
	private int N;
	private Node first;
	private Node last;

	class Node {
		T item;
		Node next;
	}

	public void push(T item) {
		Node oldfirst = first;
		if (N == 1) {
			last = first;
		}
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

	public void catenation(Node node) {
		for(Node x=node;x!=null;x=x.next){
			N++;
		}
		last.next = node;//指向新的结点
	}
	public boolean isEmpty(){
		return N==0;
	}

}

public class Num_1_03_47 {
	
	public static void main(String[] args) {
		catenatQueue<Integer> c=new catenatQueue<Integer>();
		catenatQueue<Integer>.Node node=c.new Node();
		for(int i=0;i<5;i++){
			c.push(i);
		}
		node.item=5;
		node.next=c.new Node();
		node.next.item=6;	
		c.catenation(node);
		
		while(!c.isEmpty()){
			System.out.println(c.pop()); //4 3 2 1 0 5 6
		}
				
	}

}
