package day19;

/**
 * 线程间通信
 * 两个线程交替打印 0 ～ 100的整数
 *
 */
public class ThreadCommunication {
	public static void main(String[] args) {
		Number n = new Number();
		Thread t1 = new Thread(n);
		t1.setName("线程1");
		Thread t2 = new Thread(n);
		t2.setName("线程2");
		t1.start();
		t2.start();
	}
}

class Number implements Runnable {
	private int n = 1;
	@Override
	public void run() {
		while (true) {
			synchronized (this) {
				notify();
				if (n <= 100) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + " " + n);
					n++;
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					break;
				}
			}
		}
	}
}
