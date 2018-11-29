package fileTest;

import java.io.RandomAccessFile;

public class CharChange {
	public static void main(String[] args) throws Exception {
		RandomAccessFile raf = new RandomAccessFile("log.log","rw");
		
		for(int i=0; i < raf.length(); i++) {
			byte b = raf.readByte();
			char c = (char)b;
			if(c == '1') {
				raf.seek(i);
				raf.write('2');
			}
		}
	}
}
