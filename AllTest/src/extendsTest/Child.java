package extendsTest;

import extendsTest.Base;

public class Child extends Base {
	//ʵ������
	public String str1 = "base_var2";
	//��̬����
	public static String str2 = "static_base_var2";
	//ʵ������
	public void say1() {
		System.out.println("base_method2");
	}
	//��̬����
	public static void say2() {
		System.out.println("static_base_method2");
	}
}
