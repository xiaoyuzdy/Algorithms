package stack_queue;

import java.util.Stack;

/**
 * 使用stack实现一个方法，可以返回最小值，时间复杂度O（1）
 * （使用两个Stack，stack1保存元素，stack2 保存当前最小值）
 *
 * @author Zcc
 * Create on  2018/9/2
 **/
public class StackPractice2 {
    private class State {
        int value;
        int size;
    }

    private Stack<Integer> stack;
    private Stack<State> min;

    public StackPractice2() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int value) {
        stack.push(value);
        if (min.isEmpty()) {
            pushNewState(value);
        } else {
            // no empty
            State headState = min.peek();
            // push min state into min stack
            if (headState.value > value) {
                pushNewState(value);
            } else if (headState.value == value) {
                headState.size++;
            } // else {} do nothing
        }
    }

    public int pop() {
        int value = stack.pop();
        State state = min.peek();
        if (value == state.value) {
            // update state
            if (state.size == 1) {
                min.pop();
            } else {
                state.size--;
            }
        }//else { }  do nothing
        return value;
    }

    /**
     * Looks at the min value of this stack without removing it from the min stack.
     *
     * @return
     */
    public int min() {
        return min.peek().value;
    }

    private void pushNewState(int value) {
        State state = new State();
        state.value = value;
        state.size = 1;
        min.push(state);
    }

    public static void main(String[] args) {
        StackPractice2 stack = new StackPractice2();
        stack.push(5);
        stack.push(4);
        stack.push(2);
        stack.push(2);
        stack.push(4);
        stack.push(2);
        stack.push(1);
        stack.push(5);

        for (int i = 0; i < 7; i++) {
            System.out.println("stack pop--->" + stack.pop());
            System.out.println("stack min--->" + stack.min());
            System.out.println("----------------------------------------");
        }
    }
}
