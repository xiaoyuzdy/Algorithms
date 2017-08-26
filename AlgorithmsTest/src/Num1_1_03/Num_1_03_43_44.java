package chapterOne.examination;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

import java.io.File;


/**
 * Created by tboevil on 5/23/17.
 */
public class L1343 {
    public static Queue<String> fileList = new Queue<String>();
    public static void getFiles(File file,String s){
        s = s+"  ";
        for (File subFile:file.listFiles()){
            if (subFile.isDirectory()){
                fileList.enqueue(s+subFile.toString());
                getFiles(subFile,s);
            }
            else fileList.enqueue(s+subFile.toString());
        }
    }
    public static void main(String[] args) {
        File file = new File("/home/tboevil/work/fanyi");
        getFiles(file,"");
        for (String curFile:fileList){
            StdOut.println(curFile);
        }

    }
}
