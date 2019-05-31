import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.CREATE;

public class Write {
    public static void write(String p, String o) {
        Path file = Paths.get("C:\\Users\\mn145140\\Desktop\\Java\\War\\src\\Score.txt");

        byte[] data = p.getBytes();
        byte[] data1 = o.getBytes();
        try {
            BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream("Score.txt"));

            output.write(("# of rounds won by you : ").getBytes());
            output.write(data);
            output.write(System.lineSeparator().getBytes());
            output.write((" \n# of rounds won by opponent : ").getBytes());
            output.write(data1);

            output.flush();
            output.close();
        } catch (Exception e) {
            System.out.println("Message:" + e);
            e.printStackTrace();
        }
    }
}
