package Num2_5_03;

/**
 * P510 T07
 * 
 * @author he
 *
 */

class Search {
	private int count;
	private StringBuilder searchAll = new StringBuilder();

	public void search(String txt, String pat) {
		searchAll.append("index:");
		int i, N = txt.length();
		int j, M = pat.length();
		for (i = 0, j = 0; j < M && i < N; i++) {
			if (txt.charAt(i) == pat.charAt(j))
				j++;
			else {
				i -= j;
				j = 0;
			}
			if (j == M) {
				count++;
				int t = i - M + 1;
				searchAll.append(t + " ");
				j = 0;
			}
		}

	}

	public int ccount() {
		return count;
	}

	public String searchAll() {
		return searchAll.toString();
	}

}

public class Num_5_03_07 {
	public static void main(String[] args) {
		Search s = new Search();
		s.search("ABACADABRAC", "AB");
		System.out.println(s.ccount());
		System.out.println(s.searchAll());
	}

}
