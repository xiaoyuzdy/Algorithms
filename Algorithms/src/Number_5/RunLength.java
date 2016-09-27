package Number_5;

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

/**
 * P538 游程编码
 * 
 * @author he
 *
 */
public class RunLength {

	// 游程展开
	public static void expand() {
		boolean b = false;
		while (!BinaryStdIn.isEmpty()) {
			char cnt = BinaryStdIn.readChar();
			for (int i = 0; i < cnt; i++) {
				BinaryStdOut.write(b);
			}
			b = !b;
		}
		BinaryStdOut.close();
	}

	// 计算游程
	public static void compress() {
		char cnt = 0;
		boolean b, old = false;
		while (!BinaryStdIn.isEmpty()) {
			b = BinaryStdIn.readBoolean();
			if (b != old) {
				BinaryStdOut.write(cnt);// 写出当前值，即前面0或1的个数
				cnt = 0;// 重置
				old = !old;// 更新
			} else {
				// 游程长度达到最大
				if (cnt == 255) {
					BinaryStdOut.write(cnt);
					cnt = 0;
					BinaryStdOut.write(cnt);
				}
			}
			cnt++;
		}
		BinaryStdOut.write(cnt);// 最后一个游程的长度
		BinaryStdOut.close();
	}

	public static void main(String[] args) {
		if (args[0].equals("-"))
			compress();
		if (args[0].equals("+"))
			expand();
	}

}
