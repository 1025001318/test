package extendsTest;

public class MainTest {

	public static void main(String[] args) {
		Child c = new Child();
		Base b = c;
		System.out.println(b.str1);//Base �� ʵ������
		System.out.println(b.str2);//Base �ľ�̬����
		b.say1();//Child��д��ʵ������
		b.say2();//Child��̬����
		
		System.out.println(c.str1);
		System.out.println(c.str2);
		c.say1();
		c.say2();
	}
}
