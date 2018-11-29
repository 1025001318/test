package stringTest;
//String 赋值后不能改变的问题
public class StringTest {
	public static void main(String[] args) {
		String s = new String("123");
		String ss = "123";
		
		s += ss;
		System.out.println(s);
		ss += s;
		
		System.out.println(ss);
	}
}
