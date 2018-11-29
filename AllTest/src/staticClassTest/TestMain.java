package staticClassTest;

import staticClassTest.StaticClassTest.InnerClass;

public class TestMain {
	public static void main(String[] args) {
		InnerClass.say();//调用静态内部类的静态方法
		InnerClass ic = new InnerClass();
		ic.say2();//调用静态内部类的实例方法
	}
}
