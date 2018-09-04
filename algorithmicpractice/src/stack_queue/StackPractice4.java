package stack_queue;

import java.util.Stack;

/**
 * 怎么使用多个Stack实现一个de- Queue？时间复杂O(1)
 * <p>
 * 使用三个Stack
 *
 * @author Zcc
 * Create on  2018/9/4
 **/
public class StackPractice4 {
    private Stack<Integer> leftStack;
    private Stack<Integer> rightStack;
    private Stack<Integer> tempStack;

    public StackPractice4() {
        leftStack = new Stack<>();
        rightStack = new Stack<>();
        tempStack = new Stack<>();
    }

    public void addLeft(int i) {
        leftStack.add(i);
    }

    public void addRight(int i) {
        rightStack.add(i);
    }

    public int removeLeft() {
        if (leftStack.isEmpty()) {
            //将rightStack一半的元素push到tempStack
            int n = rightStack.size() / 2;
            for (int i = 0; i < n; i++) {
                tempStack.push(rightStack.pop());
            }
            while (!rightStack.isEmpty()) {
                leftStack.push(rightStack.pop());
            }
            //还原回去
            while (!tempStack.isEmpty()) {
                rightStack.push(tempStack.pop());
            }
        }
        return leftStack.pop();
    }

    public int removeRight() {
        if (rightStack.isEmpty()) {
            //将leftStack一半的元素push到tempStack
            int n = leftStack.size() / 2;
            for (int i = 0; i < n; i++) {
                tempStack.push(leftStack.pop());
            }
            while (!leftStack.isEmpty()) {
                rightStack.push(leftStack.pop());
            }
            //还原回去
            while (!tempStack.isEmpty()) {
                leftStack.push(tempStack.pop());
            }
        }
        return rightStack.pop();
    }

    public static void main(String[] args) {
        StackPractice4 sTest4_1 = new StackPractice4();
        sTest4_1.addLeft(2);
        sTest4_1.addLeft(1);
        sTest4_1.addRight(3);
        sTest4_1.addRight(4);
        sTest4_1.addRight(5);
        sTest4_1.addRight(6);
        sTest4_1.addRight(7);

        for (int i = 0; i < 7; i++) {
            System.out.println(sTest4_1.removeRight());
        }
    }

}
