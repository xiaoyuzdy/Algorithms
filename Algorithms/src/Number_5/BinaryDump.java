package Number_5;

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * P532 将比特流打印在标准输出上（字符形式）
 * args[0]:16 
 * console输入：ABRACADABRA!  ,用ctrl+z流终止输入，快捷键无效见我的博客
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
		//如果你不是通过控制台获取数据，而是直接定向到文件则不需要再减去16bit，具体看你的操作，在控制台定向文件见我博客
//		StdOut.println(cn+" bit");
		// 会多出一个16比特,因为Java采用的是unicode编码一个字符会占用两个字节，即16位（16比特）,完成某段的流输入需要按回车
		StdOut.println(cn-16 + " bit");
		/**
		 * 结果：
		 *  0100000101000010 
		 *  0101001001000001 
		 *  0100001101000001
		 *  0100010001000001 
		 *  0100001001010010 
		 *  0100000100001101 
		 *  0000110100001010--->这16比特是按回车导致的
		 *  96 bit
		 */

	}
}
