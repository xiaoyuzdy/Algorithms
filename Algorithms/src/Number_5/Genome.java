package Number_5;

import edu.princeton.cs.algs4.Alphabet;
import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

/**
 * P537 数据压缩方法的打包方式
 * 压缩和解压缩的测试，见博客http://blog.csdn.net/fuckluy/article/details/50999238
 * a.txt用于保存字符串"ATAGATGCATAGCGCATAGCTAGATGTGCTAGC"压缩后的比特流
 * @author he
 *
 */
public class Genome {
	// 基因数据的压缩方法
	public static void compress() {
		Alphabet DNA = new Alphabet("ACTG");
//		 String s = BinaryStdIn.readString();// 读取字符串
		String s = "ATAGATGCATAGCGCATAGCTAGATGTGCTAGC";
		int N = s.length();
		BinaryStdOut.write(N);
		for (int i = 0; i < s.length(); i++) {
			int d = DNA.toIndex(s.charAt(i));// 获取索引
			BinaryStdOut.write(d, DNA.lgR());
		}
		BinaryStdOut.close();
	}

	// 基因数据的展开方法
	public static void expand() {
		Alphabet DNA = new Alphabet("ACTG");
		int w = DNA.lgR();// 一个索引所需的比特数
		 int N = BinaryStdIn.readInt();//读取字符串的长度
		for (int i = 0; i < N; i++) {
			// // 读取2比特，写入一个字符
			char c = BinaryStdIn.readChar(w);
			BinaryStdOut.write(DNA.toChar(c));// 转化为字符并输出
		}
		BinaryStdOut.close();
	}

	public static void main(String[] args) {
//		if (args[0].equals("-"))
//			compress();
//		if (args[0].equals("+"))
			expand();
	}

}
