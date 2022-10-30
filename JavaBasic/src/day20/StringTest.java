package day20;

public class StringTest {
	public static void main(String[] args) {
		String s1 = new String("abc");
		String s2 = s1;
		s2 = "hello";
		
		System.out.println(s1); // abc
		System.out.println(s2); // hello
		
		String s3 = s1.replace('b', 'd');
		System.out.println(s1); // abc
		System.out.println(s3); // adc
	}
}
