package fileTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStreamTest {
	public static void main(String[] args) throws Exception, IOException {
		File file = new File("Student.dat");
		if(!file.exists()) {
			file.createNewFile();
		}
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		Student student = new Student("1","ls");
		oos.writeObject(student);
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		Object object = ois.readObject();
		Student stu = (Student)object;
		System.out.println(stu);
	}
}
