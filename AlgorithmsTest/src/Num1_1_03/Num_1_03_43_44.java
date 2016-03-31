package Num1_1_03;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * P106 T43 T44 参考前面的习题基本上一样的
 * 
 * 
 * @author he
 *
 */
public class Num_1_03_43_44 {
	private static List<File> directory = new ArrayList<File>();

	public static List<File> getFile(File file) {
		for (File file2 : file.listFiles()) {
			if (file2.isDirectory()) {
				directory.add(file2);
				getFile(file2);
			} else {
				directory.add(file2);
			}

		}

		return directory;
	}
	
	public static void main(String[] args) {
		File file=new File("F:/IOtest");//路径自己设置
		System.out.println(getFile(file));
	}

}
