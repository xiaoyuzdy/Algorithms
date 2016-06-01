package E01;

import java.util.*;
import java.util.Map.Entry;

/**
 * 成绩排序
 * 题目：输入任意（用户，成绩）序列，可以获得成绩从高到低或从低到高的排列,相同成绩
      都按先录入排列在前的规则处理。
   例示：
   jack      70
   peter     96
   Tom       70
   smith     67
   从高到低  成绩            
   peter     96    
   jack      70    
   Tom       70    
   smith     67    
   从低到高
   smith     67  
   Tom       70    
   jack      70    
   peter     96      
 * @author he
 *
 *思路：
 *把数据存放到HashMap中再转换为list最后用Collections.sort指定比较器 进行排序
 *
 *
 */

//对存放在map中的Value值进行排序
class myCompare implements Comparator<Map.Entry<String, Integer>>{
	@Override
	public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
		//获取V映射进行比较
		return o2.getValue().compareTo(o1.getValue());
	}
	
}

public class MarkSort {
	
	public static void main(String[] args) {

		Map<String , Integer> map=new HashMap<String,Integer>();
		map.put( "jack" , 70);
		map.put("peter", 96);
		map.put("Tom",70);
		map.put("smith", 67);
		
		List<Map.Entry<String, Integer>> list=new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
		Collections.sort(list, new myCompare());
		for (Entry<String, Integer> entry : list) {
			System.out.println(entry.getKey()+" "+entry.getValue());
		}	
	}
}
