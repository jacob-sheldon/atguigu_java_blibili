package day14;

/**
 * 成员变量的赋值顺序: 代码块和变量声明的顺序就是根据代码的顺序
 *
 */

public class CodeBlockTest {
	public static void main(String[] args) {
		Person p = new Person();
		System.out.println(p.name);
		
		System.out.println(Person.age);
	}
}

class Person {
	{
		System.out.println(this.name);
		name = "Xiaoming";
	}
	
	String name = "Tom";
	
	{
		System.out.println(this.name);
		name = "Jack";
	}
	
	static {
		System.out.println(Person.age);
		age = 10;
	}
	
	static int age = 1;
	
	void setName(String name) {
		this.name = name;
	}
}
