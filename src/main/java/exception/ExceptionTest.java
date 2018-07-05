package exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class ExceptionTest {
    public void fileRead(String name) throws FileNotFoundException {
        File file = new File("name");
        FileOutputStream os = new FileOutputStream(file);
        System.out.println("这是父类");
    }
}
