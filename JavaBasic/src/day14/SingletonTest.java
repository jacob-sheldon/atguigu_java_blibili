package day14;

public class SingletonTest {
	public static void main(String[] args) {
		Singleton s1 = Singleton.getInstance();
		System.out.println(s1);
		
		Singleton s2 = Singleton.getInstance();
		System.out.println(s2);
	}
}

class Singleton {
	private Singleton() {}
	
	private static Singleton single = new Singleton();
	
	public static Singleton getInstance() {
		return single;
	}
}
