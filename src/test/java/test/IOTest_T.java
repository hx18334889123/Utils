package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.junit.Test;

import com.hanxin.common.utils.IOUtil_T;

public class IOTest_T {
	@Test
	public void test01() throws Exception {
		File file1 = new File("D:/test/aa.mp4");
		File file2 = new File("D:/test/bb.mp4");
		FileInputStream inputStream = new FileInputStream(file1);
		FileOutputStream outputStream = new FileOutputStream(file2);
		IOUtil_T.copyTo(inputStream, outputStream, true, true);
	}
	
	@Test
	public void test02() throws Exception {
		File file=new File("C:\\Users\\liu\\Desktop\\三国演义.txt");
		String readTextFile = IOUtil_T.readTextFile(file);
		System.out.println(readTextFile);
	}
	
	@Test
	public void test03() throws Exception {
		File file=new File("C:\\Users\\liu\\Desktop\\三国演义.txt");
		List<String> readTextFileByLine = IOUtil_T.readTextFileByLine(file);
		for(String str:readTextFileByLine) {
			System.out.println(str);
		}
	}
	@SuppressWarnings("resource")
	@Test
	public void test04() throws Exception {
		File file1 = new File("C:\\Users\\liu\\Desktop\\三国演义.txt");
		FileOutputStream outputStream = new FileOutputStream(file1, true);
		outputStream.write("你好".getBytes());
	}
	
}
