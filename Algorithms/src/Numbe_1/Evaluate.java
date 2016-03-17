package Numbe_1;

import edu.princeton.cs.algs4.Stack;

/**
 * P80 双栈算术表达式求值算法 限制必须要以")"结束才能进行运算
 * 
 * @author he
 *
 */
public class Evaluate {
	public static void main(String[] args) {
		Stack<String> ops = new Stack<String>();// 运算符栈
		Stack<Double> val = new Stack<Double>();// 操作数栈

		// 遍历命令行参数
		for (String string : args) {

			String s = string;

			if (s.equals("("))
				;
			else if (s.equals("+"))
				ops.push(s);
			else if (s.equals("-"))
				ops.push(s);
			else if (s.equals("*"))
				ops.push(s);
			else if (s.equals("/"))
				ops.push(s);
			else if (s.equals("sqrt"))
				ops.push(s);
			else if (s.equals(")")) {
				String op = ops.pop();// 弹栈
				double v = val.pop();

				if (op.equals("+"))
					v = val.pop() + v;
				else if (s.equals("-"))
					v = val.pop() - v;
				else if (s.equals("*"))
					v = val.pop() * v;
				else if (s.equals("/"))
					v = val.pop() / v;
				else if (s.equals("sqrt"))
					v = Math.sqrt(v);
				val.push(v);
			} else {
				val.push(Double.parseDouble(s));
			}

		}
		System.out.println(val.pop());
	}
}
