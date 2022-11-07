package Set;

import com.sun.org.apache.xml.internal.utils.QName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class SetTest {
    @Test
    public void test1() {
        HashSet<User> set1 = new HashSet<>();
        set1.add(new User("xiaoming", 10));
        set1.add(new User("xiaoming", 10));
        System.out.println(set1);
    }
}
