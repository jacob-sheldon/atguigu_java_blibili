package day10;

public class PersonTest {
	public static void main(String[] args) {
//		Student stu = new Student();
//		stu.eat();
		
		Person p = new Person();
		
		Object o1 = true ? new Integer(1) : new Double(2.0);
		System.out.println(o1);
		
		Object o2;
		if (true)
			o2 = new Integer(1);
		else
			o2 = new Double(2.0);
		System.out.println(o2.getClass());
	}
}

class Person {
	String name;
	int age;
	
	public Person() { System.out.println("Person constructor"); }
	
	public Person(String name) {
		this();
		this.name = name;
	}
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	Integer test() {
		System.out.println("test");
		return 3;
	}
	
	void eat() {
		System.out.println("Person eat");
	}
}

class Student extends Person {
	int grade;
	
	public Student() {
		System.out.println("Student constructor");
	}
	
	public Student(String name, int age, int grade) {
		this.name = name;
		this.age = age;
		this.grade = grade;
		System.out.println("Student constructor: name, age, grade");
	}
	
	void eat() {
		super.eat();
		System.out.println("Student eat");
	}
}
