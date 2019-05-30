import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.CREATE;

public class Write {
    public static void write(String s, String o){
        Path file = Paths.get("C:\\Users\\mn145140\\Desktop\\Java\\War\\src\\Score.txt");

        byte [] data = s.getBytes();
        byte [] data1 = o.getBytes();
        OutputStream output;

        try{
            output = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            output.write("# of rounds you won : " .getBytes(s));
            output.write(System.lineSeparator().getBytes());
            output.write("# of rounds opponent won : " .getBytes(o));
            output.write(System.lineSeparator().getBytes());

            output.flush();
            output.close();
        } catch (Exception e) {
            System.out.println("Message:" + e);
            e.printStackTrace();
        }
    }
}
//"# of rounds you won : " .getBytes(s)
//  "# of rounds opponent won : " .getBytes(o)
