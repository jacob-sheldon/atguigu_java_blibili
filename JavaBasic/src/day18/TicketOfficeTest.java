package day18;

/**
 * 1. 线程安全问题： 卖票过程中出现重票、错票问题
 * 2. 原因：一个线程在操作的过程中，另一个线程也进来了并使用了错误的变量值
 * 3. 如何解决：当一个线程在操作票（共享数据）的过程中，其他线程不能再次操作数据
 * 				只有当这个线程完成了操作，其他线程才能进入。
 *
 */
public class TicketOfficeTest {
	public static void main(String[] args) {
		TicketOffice tOffice = new TicketOffice();
		Thread t1 = new Thread(tOffice);
		t1.setName("售票口1");
		
		Thread t2 = new Thread(tOffice);
		t2.setName("售票口2");
		
		Thread t3 = new Thread(tOffice);
		t3.setName("售票口3");
		
		t2.start();
		t1.start();
		t3.start();
	}
}

class TicketOffice implements Runnable {
	private int tickets = 600;
	
	@Override
	public void run() {
		while (true) {
			synchronized (this) {
				if (tickets > 0) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + " - 卖出票号：" + tickets);
					tickets--;
				} else {
					break;
				}
			}
		}
	}
}
