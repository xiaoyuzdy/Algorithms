package E01;

public class ArraysPrint {
	static void print(int a[][]) {
		int count = 0;
		for (int j = 0; j < a.length; j++) {
			for (int i = 0; i < a[0].length; i++) {
				System.out.print(a[j][i] + "\t");
				count++;
			}
			if (count % a[0].length == 0) {
				System.out.println();
			}
		}
	}
}
