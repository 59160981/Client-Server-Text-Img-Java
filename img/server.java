import java.net.*;
import java.io.*;
import java.util.Base64;

public class server{
    public static void main(String[] args) throws IOException{
        ServerSocket ss = new ServerSocket(4999);
        Socket s = ss.accept();

        System.out.println("Client Connected!!");


        // read file encode
        InputStreamReader i = new InputStreamReader(s.getInputStream());
        BufferedReader bf = new BufferedReader(i);
        String base64Image = bf.readLine();

        // decode
        String newfile = "./59160977-affter-decode.jpg";
        FileOutputStream imageOutFile = new FileOutputStream(newfile);
        byte[] imageByteArray = Base64.getDecoder().decode(base64Image);
        imageOutFile.write(imageByteArray);
        System.out.println("Decode Success! New file name is : "+newfile);
    }
}