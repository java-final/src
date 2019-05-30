import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.CREATE;

public class Read {
    public static void read(int x){

        Path file = Paths.get("C:\\Users\\mn145140\\Desktop\\Java\\War\\src\\Score.txt");
        InputStream input;
        try{
            input = Files.newInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String s;
            s = reader.readLine();
            x = 10 + Integer.parseInt(s);
            System.out.println(x);
            input.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
