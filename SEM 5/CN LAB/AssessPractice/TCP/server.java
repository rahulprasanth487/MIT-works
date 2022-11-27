package AssessPractice.TCP;

import java.net.*;
import java.util.*;
import java.io.*;

public class server{
      public static void main(String[] args) throws IOException {
            ServerSocket ss=new ServerSocket(8080);
            Socket s=ss.accept();

            System.out.println("Server is running..");

            InputStreamReader isr1=new InputStreamReader(System.in);
            BufferedReader br1=new BufferedReader(isr1);
            PrintWriter pw=new PrintWriter(s.getOutputStream(),true);

            InputStreamReader isr2=new InputStreamReader(s.getInputStream());
            BufferedReader br2=new BufferedReader(isr2);


            while(true)
            {
                  String x,y;
                  x=br1.readLine();
                  if(x.equals("q"))
                  {
                        pw.println("Server Down");
                        break;
                  }
                  pw.println(x);

                  //to read the input from the client
                  y=br2.readLine();
                  if(y.equals("quit"))
                  {
                        System.out.println("Client Down");
                        break;
                  }
                  else{
                        System.out.println("Client : "+y);
                  }
            }
      }
}
