package day19;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {
	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(10);
		ThreadPoolExecutor executor = (ThreadPoolExecutor) service;
		executor.setMaximumPoolSize(20);
		executor.setKeepAliveTime(10, TimeUnit.SECONDS);
		service.execute(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 20; i++) {
					System.out.println(Thread.currentThread().getName() + " - " + i);
				}
			}
		});
		
		service.execute(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 20; i++) {
					System.out.println(Thread.currentThread().getName() + " - " + i);
				}
			}
		});
		
		service.shutdown();
	}
}
