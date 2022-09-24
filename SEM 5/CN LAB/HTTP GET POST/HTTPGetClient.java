import java.io.*;
import java.net.*;

public class HTTPGetClient {
    public static void main(String[] args) throws Exception {
        BufferedReader ifu = new BufferedReader(new InputStreamReader(System.in));
        Socket clientSocket = new Socket("localhost", 8080);
        DataOutputStream ots = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader ifs = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        System.out.print("GET URL: ");
        String sentence = ifu.readLine();
        ots.writeBytes(sentence + '\n');
        String ms = ifs.readLine();
        System.out.println("Response:\n" + ms);
        clientSocket.close();
    }
}
