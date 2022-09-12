import java.io.*;
import java.net.*;

public class Client {
   public static void main(String[] args) throws IOException
   {
       Socket s=new Socket("localhost",8080);
       System.out.println("Server Connection established");
       PrintWriter pr=new PrintWriter(s.getOutputStream(),true);
       InputStreamReader isr=new InputStreamReader(System.in);
       BufferedReader br=new BufferedReader(isr);
       
       String y;
       
       while(true)
       {
           y=br.readLine();
           if(y.equals("q")){pr.println("Client down");break;}
           else 
           {
               pr.println(y);
           }
       }
   }
}
