package Num1_3_05;

import java.util.Map;

import edu.princeton.cs.algs4.In;

/**
 * P326 13 修改ST，添加新方法获取指定范围内的键值对的副本 
 * args[0]:ip.csv 文件名 
 * args[1]:1 指定键的位置（列）
 * args[2]:0 指定值的位置（列） 
 * args[3]:60.191.55.43 低键位
 * args[4]:63.111.66.11 高键位
 * 
 * @author he
 *
 */

public class RangeLookuoCSV {
	public static void main(String[] args) {
		In in = new In(args[0]);
		int keyField = Integer.valueOf(args[1]);
		int valField = Integer.valueOf(args[2]);
		ST<String, String> st = new ST<String, String>();
		
		while (!in.isEmpty()) {
			String line = in.readLine();
			String[] tokens = line.split(",");
			String key = tokens[keyField];
			String val = tokens[valField];
			st.put(key, val);
		}

		String fromKey = String.valueOf(args[3]);
		String toKey = String.valueOf(args[4]);
		Map<String, String> map = st.subMap(fromKey, true, toKey, true);
		for (String key : map.keySet()) {
			System.out.println("网址：" + map.get(key) + " 对应的IP " + key);
		}
	}
}
