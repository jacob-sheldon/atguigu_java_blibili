package generics;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class GenericsTest {
    @Test
    public void test1() {
        Order<String> order = new Order<>();
        order.setT("123");
        System.out.println(order);
    }

    @Test
    public void test2() {
        ArrayList<String> arr1 = new ArrayList<>();
        ArrayList<String> arr2 = new ArrayList<>();
        arr2.add("123");
        arr1 = arr2;
    }

    // 这才是泛型方法
    public <E> List<E> addElement(E e) {
        List<E> l = new ArrayList<>();
        l.add(e);
    }
}
