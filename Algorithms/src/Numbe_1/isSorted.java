package Numbe_1;
/**
 * P50
 *检查一个字符串数组中的元素是否以按字母表顺序排列
 * @author he
 *
 */
public class isSorted {
  static boolean isSort(String []s){
	  boolean b=false;
	  for(int i=1;i<s.length;i++){
		  b=s[i-1].compareTo(s[i])>0? false:true;
	  }
	  return b;
  }
  public static void main(String[] args) {
	  String ss[]={"a","b"};
	System.out.println(isSort(ss));
}
}
