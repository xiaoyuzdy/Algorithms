package Number_3;

import java.io.File;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;

/**
 * P322 文件索引，将任意文件中的任意一个单词和一个出现过这个单词的所有文件的文件名构成的SET对象关联起来
 * args:ex*.txt
 * 
 * 
 * @author he
 *
 */
public class FileIndex {
	public static void main(String[] args) {
		ST<String, SET<File>> st = new ST<String, SET<File>>();
		for (String filename : args) {
			File file = new File(filename);
			In in = new In(file);
			while (!in.isEmpty()) {
				String word = in.readString();
				if (!st.contains(word))
					st.put(word, new SET<File>());
				SET<File> set = st.get(word);
				set.add(file);
			}
		}

		while (!StdIn.isEmpty()) {
			String query = StdIn.readString();
			if (st.contains(query))
				for (File file : st.get(query))
					System.out.println(" " + file.getName());
		}

	}
}
