package Number_3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;

/**
 * P320 索引（以及反向索引）的查找
 * args[0]:aminoI.txt
 * args[1]:,
 * args[2]:Serine
 * @author he
 *
 */
public class LookupIndex {
	public static void main(String[] args) {

		In in = new In(args[0]);// 索引数据库
		String sp = args[1];// 分隔符
		ST<String, Queue<String>> st = new ST<String, Queue<String>>();
		ST<String, Queue<String>> ts = new ST<String, Queue<String>>();
		while (in.hasNextLine()) {
			String[] a = in.readLine().split(sp);
			String key = a[0];
			for (int i = 1; i < a.length; i++) {
				String val = a[i];
				if (!st.contains(key))
					st.put(key, new Queue<String>());
				if (!ts.contains(val))
					ts.put(val, new Queue<String>());
				st.get(key).enqueue(val);
				ts.get(val).enqueue(key);
			}
		}

		String query = args[2];// 要查询的键
		if (st.contains(query)) {
			for (String s : st.get(query)) {
				System.out.print(" " + s);
			}
		}

	}
}
