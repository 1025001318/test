package threadTest;

public class TestMain {
	public static void main(String[] args) {
		//�̳�����̵߳Ŀ�����ʽ
		ThreadTest tt = new ThreadTest();
		//ʵ�ֽӿڵ��̵߳Ŀ�����ʽ
		Thread t = new Thread(new RunnableTest());
		t.start();
		tt.start();
	}
}
