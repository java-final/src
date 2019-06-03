import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class Read {
    public static void read() {

        BufferedReader in;

        try{
            System.out.println(new String(Files.readAllBytes(Paths.get("Score.txt"))));;
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
