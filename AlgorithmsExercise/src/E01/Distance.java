package E01;

/**
 * 题目描述
 * 
 * 有一篇文章内含多个单词，现给定两个单词，请设计一个高效算法，找出文中这两个单词的最短距离(即最少相隔的单词数,也就是两个单词在文章中位置的差的绝对值)。
 * 给定一个string数组article，代表所给文章，同时给定文章的单词数n和待查找的两个单词x和y。请返回两个单词的最短距离。
 * 保证两个单词均在文中出现且不相同，同时保证文章单词数小于等于1000。
 * 
 * @author he
 *
 */
public class Distance {
	 public static int getDistance(String[] article, int n, String x, String y) {
	        int min=999;
	        int j=-1,k=-1;
	        for(int i=0;i<n;i++){
	            if(article[i].equals(x))
	                j=i;
	            else if(article[i].equals(y))
	                k=i;
	            if(j!=-1 && k!=-1 && Math.abs(k-j) <min)
	                min=Math.abs(k-j);
	        }
	        return min;
	    }
	 public static void main(String[] args) {
		System.out.println(getDistance(new String[]{"a","v","a","v","v"}, 5, "a", "v"));
	}

}
