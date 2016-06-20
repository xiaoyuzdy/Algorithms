package E01;

/**
 * 打印菱形优化版
 * 利用绝对值
 * args:7
 * @author he
 * 规律：比如args:7 则第1行有7/2=3个空格和（7/2+1-7/2）×2-1个“*”
 */
public class Rhombus02 {
	public static void main(String[] args) {
		
		int N=Integer.valueOf(args[0]);//菱形的行数，要为奇数
		int space=N/2;//第一行的空格数
         for(int i=space;Math.abs(i)<space+1;i--){
        	 //打印空格
        	 for(int j=Math.abs(i);j>0;j--){
        		 System.out.print(" ");
        	 }
        	 //打印“*”型
        	 for(int k=(space+1-Math.abs(i))*2-1;k>0;k--){
        		 System.out.print("*");
        	 }
        	 System.out.println();
        	 
         }
	}
}
