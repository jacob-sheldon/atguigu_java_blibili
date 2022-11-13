import org.junit.jupiter.api.Test;

import java.io.*;

public class SeriableTest {
    @Test
    public void test1() {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("data.txt"));
            Person p = new Person("韩梅梅", 18, "中华大街", new Pet("阿黄", 7));
            oos.writeObject(p);
            oos.flush();
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        } finally {
            try {
                oos.close();
            } catch (IOException e) {
                System.out.println(e.getStackTrace());
            }
        }
    }

    @Test
    public void test2() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("data.txt"));
            Person p = (Person) ois.readObject();
            System.out.println(p);
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                System.out.println(e.getStackTrace());
            }
        }
    }
}
