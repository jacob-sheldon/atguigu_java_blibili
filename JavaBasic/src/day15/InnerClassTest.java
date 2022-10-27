package day15;

public class InnerClassTest {
	public static void main(String[] args) {
		// 创建静态内部类对象
		Person.Dog dog = new Person.Dog();
		System.out.println(dog);
		
		// 创建非静态内部类对象
		Person p = new Person();
		Person.Bird bird = p.new Bird();
		System.out.println(bird);
	}
}

class Person {
	String name;
	int age;
	
	static class Dog {
		String name;
		
		Dog() {
			
		}
	}
	
	class Bird {
		int legs;
		String name;
		
		void display(String name) {
			System.out.println(name);
			System.out.println(this.name);
			System.out.println(Person.this.name); // Person 是外部类
		}
	}
}