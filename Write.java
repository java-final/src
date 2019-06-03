import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Write {
    public static void write(String p, String o, String w) {
        Path file = Paths.get("C:\\Users\\mn145140\\Desktop\\Java\\War\\src\\Score.txt");

        byte[] data = p.getBytes();
        byte[] data1 = o.getBytes();
        byte[] data2 = w.getBytes();
        try {
            BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream("Score.txt"));


            output.write(("# of rounds won by you : ").getBytes());
            output.write(data);
            output.write(System.lineSeparator().getBytes());
            output.write((" \n# of rounds won by opponent : ").getBytes());
            output.write(data1);
            output.write(System.lineSeparator().getBytes());
            output.write(("Winner of game : ") .getBytes());
            output.write(data2);
            output.write(System.lineSeparator().getBytes());

            output.flush();
            output.close();
        } catch (Exception e) {
            System.out.println("Message:" + e);
            e.printStackTrace();
        }
    }
}