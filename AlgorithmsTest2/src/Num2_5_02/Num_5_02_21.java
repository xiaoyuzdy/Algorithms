package Num2_5_02;

import edu.princeton.cs.algs4.Queue;

/**
 * P491 T21 修改TST，增添一个方法返回第一个添加的key
 * 
 * @author he
 *
 */

class Pattern {
	private int N;// 字符串的数量
	private TST2<Integer> t[][];
	private int index = -1;

	@SuppressWarnings("unchecked")
	public Pattern(int N) {
		this.N = N;
		t = (TST2<Integer>[][]) new TST2[N][100];
	}

	public void put(String key) {
		if (index == N - 1)
			throw new RuntimeException("字符串的数量已满");
		int x = ++index;

		t[x][0] = new TST2<Integer>();
		t[x][0].put(key, key.length());// 只保存key键
		// t[x][]保存key的所有子字符串
		for (int length = 1; length <= key.length(); length++) {
			t[x][length] = new TST2<Integer>();
			for (int i = 0; i + length <= key.length(); i++) {
				String temp = key.substring(i, i + length);
				if (!t[x][length].contains(temp))
					t[x][length].put(temp, i);
			}
		}
	}

	// 返回所有包含字符串s的key
	public Iterable<String> get(String s) {
		Queue<String> queue = new Queue<String>();
		for (int i = 0; i < N; i++) {
			for (int j = 1; j <= s.length(); j++) {
				if (t[i][j].contains(s))
					queue.enqueue(t[i][0].firstKey());// 添加包含s的key键
			}

		}
		return queue;
	}

}

public class Num_5_02_21 {
	public static void main(String[] args) {
		Pattern p = new Pattern(5);
		p.put("string");
		p.put("she");
		p.put("sea");
		p.put("shells");
		p.put("by");
		for (String s : p.get("h"))
			System.out.println(s);

	}
}
