import java.io.*;
import java.net.*;

public class Chat_Server {

    public static void main(String[] args) throws IOException {
        
        ServerSocket ss=new ServerSocket(1010);
        Socket s=ss.accept();
        System.out.println("Client Cnnected!!");
        InputStreamReader isr=new InputStreamReader(s.getInputStream());
        BufferedReader br=new BufferedReader(isr);
        
        InputStreamReader is=new InputStreamReader(System.in);
        BufferedReader br2=new BufferedReader(is);
        PrintWriter pr=new PrintWriter(s.getOutputStream(),true);
        
        String x,y;
        
        while(true)
        {
            x=br.readLine();
            System.out.println("Client = "+x);
            if(x.equals("Client down")) break;
            
            y=br2.readLine();
            if(y.equals("q")){pr.println("Server down");break;}
            else pr.println(y);
        }
        
        ss.close();
        
    }
    
}
