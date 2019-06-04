import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Write {
    public static void write(String p, String o, String w) {
        Path file = Paths.get("C:\\Users\\mn145140\\Desktop\\Java\\War\\src\\Score.txt");

        byte[] data = p.getBytes(); // p = how many games player won
        byte[] data1 = o.getBytes(); // o = how many games opponent won
        byte[] data2 = w.getBytes(); // w = winner of game
        try {
            BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream("Score.txt"));

            output.write(("\n# of rounds won by you : ").getBytes());
            output.write(data);
            output.write(System.lineSeparator().getBytes()); //Puts a line in between each String
            output.write(("\n# of rounds won by opponent : ").getBytes());
            output.write(data1);
            output.write(System.lineSeparator().getBytes());
            output.write(("\nWinner of game : ") .getBytes());
            output.write(data2);

            output.flush();
            output.close();
        } catch (Exception e) {
            System.out.println("Message:" + e);
            e.printStackTrace();
        }
    }
}