package staticClassTest;

import staticClassTest.StaticClassTest.InnerClass;

public class TestMain {
	public static void main(String[] args) {
		InnerClass.say();//���þ�̬�ڲ���ľ�̬����
		InnerClass ic = new InnerClass();
		ic.say2();//���þ�̬�ڲ����ʵ������
	}
}
