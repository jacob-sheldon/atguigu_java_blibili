package generics;

/**
 * 自定义泛型类
 * @param <T>
 */
public class Order<T> {
    T t;
    String name;
    int id;

    public Order() {
    }

    public Order(T t, String name, int id) {
        this.t = t;
        this.name = name;
        this.id = id;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "t=" + t +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
