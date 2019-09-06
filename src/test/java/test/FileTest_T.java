package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import com.hanxin.common.utils.FileUtil_T;
public class FileTest_T {

	@Test
	public void test01() {
		String extensions = FileUtil_T.getExtensions("a.txt.xml");
		System.out.println(extensions);
		
	}
	
	
	@Test
	public void test02() {
		File file = new File("D:\\test\\新建文件夹");
		FileUtil_T.deleteFile(file);
	}
	
	@Test
	public void test03() {
		File userHome = FileUtil_T.getUserHome();
		System.out.println(userHome);
	}
	
	
	@Test
	public void test04() throws FileNotFoundException, IOException {
		String formatSize = FileUtil_T.getFormatSize(new File("D:/test/aa.mp4"));
		System.out.println(formatSize);
	}

	
}
