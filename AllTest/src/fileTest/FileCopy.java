package fileTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCopy {
	
	public static void main(String[] args) throws Exception {
		File file = new File("‪log.log");
		System.out.println(file.getAbsolutePath());
		
		if(!file.exists()) {
			System.out.println("文件不存在");
			file.createNewFile();
		}
		
		FileInputStream fis = new FileInputStream(file);
		FileOutputStream fos = new FileOutputStream("‪log1.log");
		
		byte[] b = new byte[256];
		int len = 0;
		while((len=fis.read(b))>0) {//返回值为读取到的字节数
			fos.write(b, 0, len );
		}
		fis.close();
		fos.close();
	}
}
