package Num1_2_02;

import edu.princeton.cs.algs4.Queue;

/*
 * 一个队列如果取出一个元素后又想放回去同时保证队列的原始顺序
 * 不使用辅助内存
 * queue: 0 1 2 3 4 
 * 取出0后又放回去 并保持顺序
 * 0 1 2 3 4
 */
public class Fun {
	public static void main(String[] args) {
		Queue<Integer> queue = new Queue<Integer>();
		for (int i = 0; i < 5; i++) {
			queue.enqueue(i);
		}
        Integer t=queue.dequeue();
        int count=queue.size();
        queue.enqueue(t);
        while(count-->0){
        	queue.enqueue(queue.dequeue());
        }
        
        while(!queue.isEmpty()){
        	System.out.print(queue.dequeue()+" ");
        }
        
	}	
}
