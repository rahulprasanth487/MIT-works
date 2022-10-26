import java.io.*;
import java.net.*;
public class Chat_client {

    public static void main(String[] args) throws IOException {
        Socket s=new Socket("localhost",1010);
        System.out.println("Server Cnnected!!");
        PrintWriter pr=new PrintWriter(s.getOutputStream(),true);
        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);
        
        InputStreamReader is=new InputStreamReader(s.getInputStream());
        BufferedReader br2=new BufferedReader(is);
        
        String x,y;
        while(true)
        {
            x=br.readLine();
            if(x.equals("q")){ pr.println("Client down");break;}
            else pr.println(x);
             
            y=br2.readLine();
            System.out.println("Server = "+y);
            if(y.equals("Server down")) break;
            
        }
        s.close();
    }
    
}
