/**
 * @project JavaBasic
 *
 * @author shizhiang
 *
 * @date Nov 1, 2022 10:43:05 PM
 */
package day21;

/**
 * @description
 *
 * @author shizhiang
 *
 * @date Nov 1, 2022 10:43:05 PM
 *
 */
public class Goods implements Comparable<Goods> {
	private String name;
	private double price;

	public Goods() {
		super();
	} 

	public Goods(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Goods [name=" + name + ", price=" + price + "]";
	}

	@Override
	public int compareTo(Goods o) {
		if (o instanceof Goods) {
			return Double.compare(price, o.price);
		}
		throw new RuntimeException("类型错误");
	}

}
