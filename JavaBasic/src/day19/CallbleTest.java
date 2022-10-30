package day19;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

@SuppressWarnings("rawtypes")
class NumThread implements Callable {
	@Override
	public Object call() throws Exception {
		int sum = 0;
		for (int i = 0; i < 100; i++) {
			System.out.println("当前值: " + i);
			sum += i;
		}
		return sum;
	}
}

public class CallbleTest {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		NumThread numThread = new NumThread();
		FutureTask futureTask = new FutureTask<>(numThread);
		new Thread(futureTask).start();
		
		try {
			Object retObject = futureTask.get();
			System.out.println("最终结果：" + retObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
