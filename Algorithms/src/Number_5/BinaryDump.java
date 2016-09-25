package Number_5;

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * P532 将比特流打印在标准输出上（字符形式） args[0]:16 console输入：ABRACADABRA
 * 
 * @author he
 *
 */
public class BinaryDump {
	public static void main(String[] args) {
		int width = Integer.parseInt(args[0]);
		int cn;
		for (cn = 0; !BinaryStdIn.isEmpty(); cn++) {
			if (width == 0)
				continue;
			if (cn != 0 && cn % width == 0)
				StdOut.println();
			// 读取一位
			if (BinaryStdIn.readBoolean())
				StdOut.print("1");
			else
				StdOut.print("0");

		}

		StdOut.println();
		// 因为敲回车以后还会读取一个8比特的流（我猜测是按enter导致的）因此这里还需要减去8比特
		StdOut.println(cn - 8 + " bit");
		/**
		 * 结果：
		 *  0100000101000010 
		 *  0101001001000001 
		 *  0100001101000001
		 *  0100010001000001 
		 *  0100001001010010 
		 *  0100000100001101 
		 *  00001010 
		 *  96 bit
		 * 
		 */

	}
}
