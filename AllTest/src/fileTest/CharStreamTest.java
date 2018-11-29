package fileTest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CharStreamTest {
	public static void main(String[] args) throws Exception {
		InputStream is = new FileInputStream("log.log");
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		StringBuffer sb = new StringBuffer();
		String str = null;
		if((str = br.readLine()) != null) {
			sb.append(str);
		}
		System.out.println(sb);
	}
}
