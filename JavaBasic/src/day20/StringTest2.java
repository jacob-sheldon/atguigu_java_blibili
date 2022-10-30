package day20;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class StringTest2 {
	
	@Test
	public void test3() {
		String s1 = "abc123";
		byte[] bytes = s1.getBytes();
		System.out.println(Arrays.toString(bytes));
		
		String s2 = new String(bytes);
		System.out.println(s2);
	}
	
	/**
	 * String 与char型数组的转换
	 */
	@Test
	public void test2() {
		String s1 = "abc123";
		char[] charArray = s1.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			System.out.println(charArray[i]);
		}
		
		char[] arr = new char[]{'a', 'b', 'c'};
		String s2 = new String(arr);
		System.out.println(s2);
	}
	
	/**
	 * String 与基本数据类型的转换
	 */
	@Test
	public void test1() {
		String s1 = "123";
		int num = Integer.parseInt(s1);
		String s2 = String.valueOf(num);
		System.out.println(s1 == s2);
	}
}
