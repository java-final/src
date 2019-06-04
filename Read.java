import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class Read {
    public static void read() {

        try{
            System.out.println(new String(Files.readAllBytes(Paths.get("Score.txt"))));
            //Reads all bytes that are being written
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}