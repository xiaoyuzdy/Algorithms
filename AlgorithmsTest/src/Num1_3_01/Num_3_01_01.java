package Num1_3_01;

import edu.princeton.cs.algs4.ST;


/**
 * P246 T1
 * args: A B+
 * @author he
 *
 */
public class Num_3_01_01 {
	public static void main(String[] args) {
		ST<String, Double> st = new ST<String, Double>();
		st.put("A+", 4.33);
		st.put("A", 4.00);
		st.put("A-", 3.67);
		st.put("B+", 3.33);
		st.put("B", 3.00);
		st.put("B-", 3.00);
		st.put("C+", 2.33);
		st.put("C", 2.00);
		st.put("C-", 1.67);
		st.put("D", 1.00);
		st.put("F", 0.00);

		int n = 0;
		double total = 0.0;

		for (n = 0; n<args.length; n++) {
			String s = args[n];
			double value = st.get(s);
			total += value;
		}
		System.out.println("GPA: " + total / n);

	}

}
