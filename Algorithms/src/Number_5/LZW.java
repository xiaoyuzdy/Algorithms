package Number_5;

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

/**
 * P552 算法5.11 LZW算法
 * 输入为8位的字节流输出为12位编码
 * 子字符串的编码从R+1开始
 * 压缩算法测试：将console的input定向到abra.txt，console的output定向到lzw.txt
 * 解压缩算法测试：将console的input定向到lzw.txt
 * 如何定向看我的博客:http://blog.csdn.net/fuckluy/article/details/50999238
 * @author he
 *
 */
public class LZW {
	private static final int R=256;//8为ASCII表的字符个数
	private static final int L=4096;//编码总数 2^12
	private static final int W=12;//编码宽度，12位编码
	
	//数据压缩
	public static void compress(){
		String input=BinaryStdIn.readString();
		TST<Integer> st=new TST<Integer>();
		for(int i=0;i<R;i++)
			st.put(""+(char)i, i);
		int code=R+1;//文件结束的编码
		
		while(input.length()>0){
			String s=st.longestPrefixOf(input);//找到input前缀最长的键
			BinaryStdOut.write(st.get(s),W);//打印s的编码(以Wbit)
			int t=s.length();
			if(t<input.length() && code<L)
				//t+1不包含
				st.put(input.substring(0 ,t+1),code++);
			input=input.substring(t);//去除子字符串s
		}
		BinaryStdOut.write(R,W);
		BinaryStdOut.close();
		
	}
	
	//数据展开
	public static void expand(){
		String st[]=new String[L];
		int i;//下一个待补全的编码值
		//初始化编译表
		for( i=0;i<R;i++)
			st[i]=""+(char)i;
		
		st[i++]=" ";//EOF对于的前瞻字符
		int codeword=BinaryStdIn.readInt(W);//读取Wbit获取编码
		String val=st[codeword];//获取单个字符
		while(true){
			BinaryStdOut.write(val);//输出当前子字符
			codeword=BinaryStdIn.readInt(W);
			if(codeword==R)
				break;
			String s=st[codeword];//获取下一个编码
			if(i==codeword)//前瞻字符不可用
				s=val+val.charAt(0);//根据上一个字符串的首字母得到编码的字符串
			if(i<L)
				st[i++]=val+s.charAt(0);//为编译表添加新条目
			val=s;//更新当前编码
		}
		BinaryStdOut.close();
	}
	
	public static void main(String[] args) {
		if (args[0].equals("-"))
			compress();
		else if (args[0].equals("+"))
			expand();
	}
	
}
