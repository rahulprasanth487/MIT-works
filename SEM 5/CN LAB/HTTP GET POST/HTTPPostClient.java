import java.io.*;
import java.net.*;

public class HTTPPostClient {
    public static void main(String a[]) throws Exception {
        BufferedReader ifu = new BufferedReader(new InputStreamReader(System.in));
        Socket clientSocket = new Socket("localhost", 6789);
        DataOutputStream ots = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader ifs = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        System.out.println("\nPOST url : ");
        String sentence = ifu.readLine();
        ots.writeBytes(sentence + '\n');
        String ms = ifs.readLine();
        System.out.println("Response:\n" + ms);
        clientSocket.close();
    }
}
