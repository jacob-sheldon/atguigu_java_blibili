package List;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ListTest {
    @Test
    public void test1() {
        Collection<Object> coll = new ArrayList<>();
        coll.add(1);
        coll.add("A");
        coll.add(new Object());
        Iterator<Object> iterator = coll.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test2() {
        Collection<Object> coll = new ArrayList<>();
        coll.add(3);
        coll.add("A");
        coll.add(new Object());
        coll.add(false);

        Iterator<Object> iterator = coll.iterator();
        while (iterator.hasNext()) {
            if ("A".equals(iterator.next())) {
                iterator.remove();
            }
        }

        iterator = coll.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void forEachTest() {
        Collection<Object> coll = new ArrayList<>();
        coll.add(4);
        coll.add("A");
        coll.add(new Object());
        coll.add(false);

        for (Object obj : coll) {
            System.out.println(obj);
        }
    }

    @Test
    public void remoteTEst() {
        List coll = new ArrayList();
        coll.add(1);
        coll.add(2);
        coll.add(3);

//        coll.remove(2);
//        System.out.println(coll); // [1, 2]

        coll.remove(new Integer(2));
        System.out.println(coll); // [1, 3]
    }
}