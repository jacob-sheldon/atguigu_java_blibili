package day19;

import java.util.concurrent.locks.ReentrantLock;

class TicketOffice implements Runnable {
	private int ticket = 100;

	ReentrantLock lock = new ReentrantLock();

	@Override
	public void run() {
		while (true) {
			try {
				lock.lock();
				if (ticket > 0) {
					try {
						Thread.sleep(30);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + "出票：" + ticket);
					ticket--;
				} else {
					break;
				}
			} finally {
				lock.unlock();
			}
		}
	}
}

public class LockTest {
	public static void main(String[] args) {
		TicketOffice to = new TicketOffice();
		Thread t1 = new Thread(to);
		Thread t2 = new Thread(to);
		Thread t3 = new Thread(to);
		t1.setName("窗口1");
		t2.setName("窗口2");
		t3.setName("窗口3");
		t1.start();
		t2.start();
		t3.start();
	}
}
