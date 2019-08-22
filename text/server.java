import java.net.*;
import java.io.*;

public class server{
    public static void main(String[] args) throws IOException{
        ServerSocket ss = new ServerSocket(4999);
        Socket s = ss.accept();

        System.out.println("Client Connected!!");

        // ser read file
        InputStreamReader i = new InputStreamReader(s.getInputStream());
        BufferedReader bf = new BufferedReader(i);
        String str = bf.readLine();
        System.out.println("client : "+ str);

        // uppercase
        PrintWriter pr = new PrintWriter(s.getOutputStream());
        pr.println(str + " --> " + str.toLowerCase());
        pr.flush();

		FileWriter fw = new FileWriter("./client_small.txt",false);
        fw.write(str.toLowerCase());
        fw.close();
		System.out.print("Write Success!");
		
    }
}