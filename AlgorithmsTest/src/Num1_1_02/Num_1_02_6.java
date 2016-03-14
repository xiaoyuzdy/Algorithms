package Num1_1_02;

/**
 * p 71
 * 
 * @author he
 *
 */

public class Num_1_02_6 {
	static boolean circularRotation(String s1,String s2){
		return (s1+s1).contains(s2);
	}
	public static void main(String[] args) {
		System.out.println(circularRotation("ACTGACG", "TGACGAC"));
		
	}

}
