package Sorting;
/**
 * 位图排序
 * 适用条件（3个条件都要满足）：
 * 1、输入数据限制在较小的范围内
 * 2、数据没有重复
 * 3、对于每条记录而言，除了单一整数外，没有任何其他关联数据
 * 
 * 如果进行数据推算的话一定要使用二进制，不要转换为10进制，二进制便于理解
 * 该算法主要思想：通过二进制表现一个数的集合 比如 集合{1,2,3,5,8,13} 可转换为二进制
 * 0 1 1 1 0 1 0 0 1 0 0 0 0 1 0 0 0 0 0
 * 该二进制代表集合中数值的位置都置为1，其他位置都置为0，比如5，在二进制中第5个位置为1
 * 
 * @author he
 * 
 * 题目：
 * 	文件中有1千万条记录，每条记录都是7位整数，再无其他数据，每个整数最多只出现一次，现在要求对整数排序
 *
 *
 *
 */
public class BitmapSort {
	
	private static final int SHIFT=5;//右移的次数，2^5=32；
	private static final int BITSPERWPRD = 32;// int类型32位
	private static final int MASK = 0x1F;// 31,用于取余
	private static final int N = 10000000;//位长度
	private static int a[] = new int[1 + N / BITSPERWPRD];//数组长度
	
	
	/**
	 * 初始化，将所有位置都置于0
	 * @param i
	 *  i&MASK 表示取余
	 * 
	 *  举例，当 i=4，4对应的二进制为 100
	 *  31 对应的二进制为 11111
	 *  首先 4>>5 =0;相当于 4/32
	 *  4&31=4
	 *  1<<4=10000(二进制)
	 *  ~10000=01111
	 *  0&01111=00000
	 *  
	 * 
	 */
	public static void clear(int i){
		a[i>>SHIFT] &=~(1<<(i&MASK));
	}
	
	/**
	 * 将对应的位置置于1
	 * @param i
	 * 举例，当 i=4，4对应的二进制为 100
	 *  31 对应的二进制为 11111
	 *  首先 4>>5 =0;相当于 4/32
	 *  4&31=4
	 *  1<<4=10000(二进制)
	 *  0|10000=10000
	 *  即第四位置于1
	 * 
	 */
	public static void set(int i){
		a[i>>SHIFT] |=(1<<(i&MASK));
	}
	

	/**
	 * 检查对应的位置是否非0，非0表示该位置被标识了
	 * @param i
	 * 
	 * 举例，当 i=4，4对应的二进制为 100
	 *  31 对应的二进制为 11111
	 *  首先 4>>5 =0;相当于 4/32
	 *  4&31=4
	 *  1<<4=10000(二进制)
	 *  因为之前已将第四位置于1了，所以
	 *  0...010000&10000=10000
	 *  所以该位置不为0
	 */
	public static int test(int i){
		return a[i>>SHIFT] & (1<<(i&MASK));
	}
	
	
	
	/**
	 * 结果：4 10 200 999 20000
	 * @param args
	 */
	public static void main(String[] args) {
		
		for(int i=0;i<N;i++){
			clear(i);
		}
		
		set(4);
		set(6);
		set(999);
		set(10);
		set(200);
		set(20000);
		
		for(int i=0;i<N;i++){
			if (test(i)!=0) {
				System.out.println(i);
			}
		}
		
	 
	}
	
	
	
	
	
	
	
	

}
