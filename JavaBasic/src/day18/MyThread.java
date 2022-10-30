package day18;

public class MyThread {
	public static void main(String[] args) {
		CustomThread1 t1 = new CustomThread1();
		t1.start();
		
		Thread t2 = new CustomThread1();
		t2.start();
		
	}
}

class CustomThread1 extends Thread {
	
	public void test1(String name) {
		
	}
	@Override
	public void run() {
		super.run();
		
		for (int i = 0; i < 100; i++) {
			if (i % 2 == 0) {
				System.out.println(this.getName() + ", i = " + i);
			}
		}
	}
}
