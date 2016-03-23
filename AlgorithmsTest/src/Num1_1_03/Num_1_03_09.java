package Num1_1_03;

import edu.princeton.cs.algs4.Stack;

/**
 * P102 T9 和P80 的Evaluate 类似， 只不过操作数栈用于存放操作数和计算表达式，运算符栈用于存放运算符，遇到“)” 进行弹栈操作
 * args:1 + 2 ) × 3 - 4 ) × 5 - 6 ) ) )
 * 
 * @author he
 *
 */
public class Num_1_03_09 {

	public static void main(String[] args) {
		Stack<String> val = new Stack<String>();// 操作数栈
		Stack<String> ops = new Stack<String>();// 运算符栈

		for (String string : args) {
			String s = string;

			if (s.equals("+")) {
				ops.push(s);
			} else if (s.equals("-")) {
				ops.push(s);
			} else if (s.equals("×")) {
				ops.push(s);
			}

			else if (s.equals(")")) {
				String op = ops.pop();
				String va = val.pop();

				if (op.equals("+")) {
					va = "(" + val.pop() + "+" + va + ")";
				} else if (op.equals("-")) {
					va = "(" + val.pop() + "-" + va + ")";
				} else if (op.equals("×")) {
					va = "(" + val.pop() + "*" + va + ")";
				}

				val.push(va);

			}

			else {
				val.push(s);
			}

		}
		while(!val.isEmpty()){
			System.out.print(val.pop());
		}
		
	}

}
