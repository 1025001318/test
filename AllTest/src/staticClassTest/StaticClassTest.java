package staticClassTest;

public class StaticClassTest {
	public static class InnerClass{
		public static void say() {
			System.out.println("静态内部类的静态方法");
		}
		public void say2() {
		
			System.out.println("静态内部类的实例方法");
		}
	}
	public class StaticInnerClass{
		//非静态内部类只有在类实例化的时候才会加载，
/*		public static void say3() {
			System.out.println("非静态内部类中不能有静态方法");
		}*/
		public void say2() {
		
			System.out.println("静态内部类的实例方法");
		}
		
	}
			public static void StaticMethod() {
			System.out.println("非静态类中的静态方法");
		}
}
