import java.net.*;
import java.io.*;
import java.util.Base64;

public class client{
    public static void main(String[] args) throws IOException{
        Socket s = new Socket("localhost",4999);

        // read file and encode
        File file = new File("./59160977.jpg");
        FileInputStream imageInFile = new FileInputStream(file);
        byte[] imageData = new byte[(int) file.length()];
        imageInFile.read(imageData);
        String base64Image = Base64.getEncoder().encodeToString(imageData);
        System.out.println("Encode file name is : " + file + " Success! ");

        // send to server
        PrintWriter pr = new PrintWriter(s.getOutputStream());
        pr.println(base64Image);
        pr.flush();
    }
}
