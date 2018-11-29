package threadTest;

public class TestMain {
	public static void main(String[] args) {
		//继承类的线程的开启方式
		ThreadTest tt = new ThreadTest();
		//实现接口的线程的开启方式
		Thread t = new Thread(new RunnableTest());
		t.start();
		tt.start();
	}
}
