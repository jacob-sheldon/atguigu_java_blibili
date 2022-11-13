import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {
    @Test
    public void test1() {
        FileReader fr = null;
        try {
            fr = new FileReader(new File("c:\\test.txt"));
            char[] buf = new char[1024];
            int len;
            while ((len = fr.read(buf)) != -1) {
                System.out.println(new String(buf, 0, len));
            }
        } catch (IOException e) {
            System.out.println("read-Exception:" + e.getMessage());
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                System.out.println("close-Exception: " + e.getMessage());
            }
        }
    }
}
