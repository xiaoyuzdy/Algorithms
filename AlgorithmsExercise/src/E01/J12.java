package E01;

import java.util.Stack;

/**
 * 用两个栈实现一个队列
 * @author he
 *
 */

class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
       while(!stack1.isEmpty()){
    	   stack2.push(stack1.pop());
       }
       int first=stack2.pop();
       while(!stack2.isEmpty()){
    	   stack1.push(stack2.pop());
       }
       return first;
    }
}

public class J12 {
	public static void main(String[] args) {
		Solution solution=new Solution();
		for(int i=0;i<10;i++){
			solution.push(i);
		}
		for(int i=0;i<10;i++){
			System.out.println(solution.pop());
		}
	}

}
