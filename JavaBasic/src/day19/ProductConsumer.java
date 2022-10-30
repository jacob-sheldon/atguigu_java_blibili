package day19;

/**
 * 线程间通信：生产者-消费者
 *
 */
class Clerk {
	private int productNum = 0;
	
	private final int MAX_PRODUCT = 100;
	
	public synchronized void sold() {
		if (productNum < MAX_PRODUCT) {
			productNum++;
			System.out.println(Thread.currentThread().getName() + " 有" + productNum + "件商品可以出售");
			notify();
		} else {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public synchronized void buy() {
		if (productNum > 0) {
			System.out.println(Thread.currentThread().getName() + " 卖出第" + productNum + "件商品");
			productNum--;
			notify();
		} else {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Producer implements Runnable {
	
	private Clerk clerk;
	
	public Producer(Clerk clerk) {
		super();
		this.clerk = clerk;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " - 开始生产产品。。。");
		while (true) {
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			clerk.sold();
		}
	}
}

class Consumer implements Runnable {
	private Clerk clerk;
	
	public Consumer(Clerk clerk) {
		super();
		this.clerk = clerk;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " - 开始消费产品。。。");
		while (true) {
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			clerk.buy();
		}
	}
	
}

public class ProductConsumer {
	public static void main(String[] args) {
		Clerk clerk = new Clerk();
		Producer p1 = new Producer(clerk);
		Thread t1 = new Thread(p1);
		t1.setName("生产者线程1");
		
		Thread t3 = new Thread(p1);
		t3.setName("生产者线程2");
		
		Consumer c1 = new Consumer(clerk);
		Thread t2 = new Thread(c1);
		t2.setName("消费者线程1");
		
		t1.start();
		t2.start();
		t3.start();
	}
}
