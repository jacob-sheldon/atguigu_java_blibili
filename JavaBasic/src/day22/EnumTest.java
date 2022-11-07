package day22;

import java.util.Arrays;

public class EnumTest {
	public static void main(String[] args) {
		Season fall = Season.FALL;
		System.out.println(fall);
		System.out.println(Season.class.getSuperclass());
		Season[] seasons = Season.values();
		for (Season season : seasons) {
			season.show();
		}
	}
}

interface Info {
	void show();
}

enum Season implements Info {
	SPRING("spring", "This is spring") {
		@Override
		public void show() {
			System.out.println("春天在哪里？");
		}
	},
	SUMMER("summer", "This is summer") {
		@Override
		public void show() {
			System.out.println("夏天悄悄的过去");
		}
	}, 
	FALL("fall", "This is fall") {
		@Override
		public void show() {
			System.out.println("秋天不回来");
		}
	},
	WINTER("winter", "This is winter") {
		@Override
		public void show() {
			System.out.println("冬天里的第一场雪");
		}
	};

	private String name;
	private String desc;

	private Season() {
	}

	private Season(String name, String desc) {
		this.name = name;
		this.desc = desc;
	}

	public String getName() {
		return name;
	}

	public String getDesc() {
		return desc;
	}

	@Override
	public void show() {
		System.out.println("这是一个季节");
	}
	
}
