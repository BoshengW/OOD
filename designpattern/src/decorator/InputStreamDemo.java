package decorator;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class InputStreamDemo {

    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream io = new FileInputStream("/test/test.xml");
        BufferedInputStream bio = new BufferedInputStream(io);
        DataInputStream dio = new DataInputStream(bio);
    }
}
