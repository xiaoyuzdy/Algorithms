package Number_3;

import java.util.HashSet;

import edu.princeton.cs.algs4.In;

/**
 * P315 °×Ãûµ¥¹ýÂËÆ÷ 
 * args[0]:tinyTale.txt
 * args[1]:tale.ext
 * 
 * @author he
 *
 */
public class WhiteFilter {
	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>();
		In in = new In(args[0]);// args[0]:tinyTale.txt
		while (!in.isEmpty()) {
			set.add(in.readString());
		}
		In in2=new In(args[1]);//tale.ext
		while(!in2.isEmpty()){
			String word=in2.readString();
			if(set.contains(word))
				System.out.println(word+" ");
		}	
	}

}
