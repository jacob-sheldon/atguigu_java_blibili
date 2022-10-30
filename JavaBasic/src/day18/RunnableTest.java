package day18;

public class RunnableTest {
	public static void main(String[] args) {
		MyThread1 thread1 = new MyThread1();
		Thread thread = new Thread(thread1);
		thread.start();

		Thread thread2 = new Thread(thread1);
		thread2.start();
	}
}

class MyThread1 implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " - " + i);
		}
	}
}
