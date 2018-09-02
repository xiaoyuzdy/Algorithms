package stack_queue;

import java.util.Stack;

/**
 * 怎么使用两个stack排序一串乱序的数？
 * <p>
 * <p>
 * 使用两个stack排序一串乱序的数，一个stack1的元素添加到stack2中并记录global min和global min count，
 * 非global 的元素再返回stack1 中 如此反复
 *
 * @author Zcc
 * Create on  2018/9/2
 **/
public class StackPractice3 {
    private Stack<Integer> randomStack;
    private Stack<Integer> orderStack;


    public StackPractice3() {
        randomStack = new Stack<>();
        orderStack = new Stack<>();
    }

    public void push(int i) {
        randomStack.push(i);
    }

    public void sort() {
        //记录最小的元素
        int global = Integer.MAX_VALUE;
        //记录相同元素的数量
        int count = 0;

        //取出random中的所有元素，寻找global
        while (randomStack.size() > 0) {
            int value = randomStack.pop();
            if (value < global) {
                global = value;
            }
            //将取出的元素全部push到order中
            orderStack.push(value);

            //将order中不小于global中的元素全部弹出
            while (orderStack.size() > 0 && orderStack.peek() >= global) {
                int v = orderStack.pop();
                if (v != global) {
                    //大于global中的元素重新push到random中
                    randomStack.push(v);
                } else {
                    count++;
                }
            }
            // orderStack主动push和global值相等且count数量相等的元素
            for (int i = 0; i < count; i++) {
                orderStack.push(global);
            }

            //reset
            count = 0;
            global = Integer.MAX_VALUE;
        }
    }

    public int pop() {
        if (!randomStack.isEmpty()) {
            return randomStack.pop();
        } else {
            return orderStack.pop();
        }
    }

    public static void main(String[] args) {
        StackPractice3 sTest3 = new StackPractice3();
        sTest3.push(5);
        sTest3.push(4);
        sTest3.push(2);
        sTest3.push(2);
        sTest3.push(2);
        sTest3.sort();
        sTest3.push(7);
        sTest3.push(1);
        sTest3.sort();

        for (int i = 0; i < 7; i++) {
            System.out.print("  " + sTest3.pop());
        }

    }


}
