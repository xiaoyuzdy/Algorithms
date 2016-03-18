package Num1_1_03;

import edu.princeton.cs.algs4.Stack;

/**
 * P102 T4 遇到左边括号存入栈，遇到右边括号 取栈中元素进行匹配
 * 
 * @author he
 */
public class Num_1_03_4 {
	static boolean isParentheses(String s) {
		Stack<Character> stack = new Stack<>();
		char[] a = s.toCharArray();
		for (int i = 0; i < a.length; i++) {
			if (a[i] == '(' || a[i] == '[' || a[i] == '{') {
				stack.push(a[i]);
			} else if (a[i] == ')' && (stack.isEmpty() || stack.pop() != '(')
					|| a[i] == ']' && (stack.isEmpty() || stack.pop() != '[')
					|| a[i] == '}' && (stack.isEmpty() || stack.pop() != '{')) {
				return false;
			}

		}
		return true;
	}

	public static void main(String[] args) {
		String s = "[(])";
		System.out.println(isParentheses(s));
	}
}
