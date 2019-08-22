import java.net.*;
import java.io.*;
import java.util.Scanner;
public class client{
    public static void main(String[] args) throws IOException{
        Socket s = new Socket("localhost",4999);
    
        // readfile and send to server
        PrintWriter pr = new PrintWriter(s.getOutputStream());
        Scanner file = new Scanner(new File ("./client.txt"));
        pr.println(file.nextLine());
        file.close();
        pr.flush();
        
        // print out
        InputStreamReader i = new InputStreamReader(s.getInputStream());
        BufferedReader bf = new BufferedReader(i);
        String str = bf.readLine();
        System.out.println("server : "+ str);
    }
}
