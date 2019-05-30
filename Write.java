import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.CREATE;

public class Write {
    public static void write(String s){
        Path file = Paths.get("C:\\Users\\mn145140\\Desktop\\Java\\WarCardGame\\src");

        byte [] data = s.getBytes();
        OutputStream output;

        try{
            output = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            output.write(data);
            output.flush();
            output.close();
        } catch (Exception e) {
            System.out.println("Message:" + e);
        }
    }
}
