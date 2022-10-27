package day15;

public class LocalInnerTest {

}

class LocalInner {
	<T> Comparable<T> getCompable() {
//		class MyComparable implements Comparable<T> {
//
//			@Override
//			public int compareTo(Object o) {
//				return 0;
//			}
//			
//		}
//		return new MyComparable();
		
		// 匿名内部类的方式
		return new Comparable<T>() {
			@Override
			public int compareTo(Object o) {
				return 0;
			}
		};
	}
}
