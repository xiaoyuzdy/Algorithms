package stack_queue;

import java.util.Stack;

/**
 * 使用两个stack实现一个queue，一个stack只用于进，一个stack只用于出
 *
 * @author Zcc
 * Create on  2018/9/2
 **/
public class StackPractice1 {

    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public StackPractice1() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void offer(int value) {
        inStack.push(value);
    }

    public int pop() {
        //先将outStack中的元素全部pop出
        if (!outStack.isEmpty()) {
            return outStack.pop();
        }
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
        return outStack.pop();
    }

    public static void main(String[] args) {
        StackPractice1 queue = new StackPractice1();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        queue.offer(4);
        queue.offer(5);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());

    }
}
