package Num1_1_01;
/**
 * ตÝน้
 * @author he
 *
 */
public class Ex_1_1_16 {
	public static String  exR2(int n){
		if (n<=0) {
			return " ";
		}
		else{
			return exR2(n-3)+n+exR2(n-2)+n;
		}
		
	}
	public static void main(String[] args) {
		System.out.println(exR2(6));
		//311361142246
		 
	}

}
