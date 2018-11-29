package extendsTest;

import extendsTest.Base;

public class Child extends Base {
	//实例变量
	public String str1 = "base_var2";
	//静态变量
	public static String str2 = "static_base_var2";
	//实例方法
	public void say1() {
		System.out.println("base_method2");
	}
	//静态方法
	public static void say2() {
		System.out.println("static_base_method2");
	}
}
