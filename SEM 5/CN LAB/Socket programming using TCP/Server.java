
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException{
        ServerSocket ss=new ServerSocket(8080);
        Socket s=ss.accept();
        System.out.println("Press q to exit");
        System.out.println("Client Connected");
        
        InputStreamReader isr=new InputStreamReader (s.getInputStream());
        
        BufferedReader is=new BufferedReader(isr);
        String X;
        
        while(true)
        {
            X=is.readLine();
            System.out.println("Client = "+X);
            if(X.equals("Server down")) break;
        }
        
        ss.close();
    }
    
}
