package day21;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.jupiter.api.Test;

public class CompareTest {
	@Test
	public void test1() {
		String[] strs = new String[]{"aa", "ac", "bd", "aw"};
		Arrays.sort(strs);
		System.out.println(Arrays.toString(strs));
	}
	
	@Test
	public void test2() {
		Goods[] goods = new Goods[3];
		goods[0] = new Goods("饼干", 7.5);
		goods[1] = new Goods("汽水", 3.5);
		goods[2] = new Goods("巧克力", 8.5);
		
		Arrays.sort(goods);
		System.out.println(Arrays.toString(goods));
	}
	
	@Test
	public void test3() {
		Goods[] goods = new Goods[3];
		goods[0] = new Goods("饼干", 7.5);
		goods[1] = new Goods("汽水", 3.5);
		goods[2] = new Goods("巧克力", 8.5);
		
		Arrays.sort(goods, new Comparator<Goods>() {

			@Override
			public int compare(Goods o1, Goods o2) {
				if (o1.getName().equals(o2.getName())) {
					return Double.compare(o1.getPrice(), o2.getPrice());
				} else {
					return o1.getName().compareTo(o2.getName());
				}
			}
		});
		System.out.println(Arrays.toString(goods));
	}
}
