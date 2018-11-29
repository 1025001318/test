package extendsTest;

public class MainTest {

	public static void main(String[] args) {
		Child c = new Child();
		Base b = c;
		System.out.println(b.str1);//Base 的 实例变量
		System.out.println(b.str2);//Base 的静态变量
		b.say1();//Child重写的实例方法
		b.say2();//Child静态方法
		
		System.out.println(c.str1);
		System.out.println(c.str2);
		c.say1();
		c.say2();
	}
}
