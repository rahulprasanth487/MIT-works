package AssessPractice.TCP;

import java.net.*;
import java.util.*;
import java.io.*;

public class Client  {
      public static void main(String[] args) throws IOException {
            Socket s=new Socket("localhost",8080);

            System.out.println("Client is running..");

            InputStreamReader isr1 = new InputStreamReader(System.in);
            BufferedReader br1 = new BufferedReader(isr1);
            

            InputStreamReader isr2 = new InputStreamReader(s.getInputStream());
            BufferedReader br2 = new BufferedReader(isr2);
            PrintWriter pw = new PrintWriter(s.getOutputStream(),true);

            while (true) {
                  String x, y;
                  y = br2.readLine();
                  if (y.equals("q")) {
                        System.out.println("Server Down");
                        break;
                  } else {
                        System.out.println("Server : " + y);
                  }


                  x = br1.readLine();
                  if (x.equals("quit")) {
                        pw.println("Client Down");
                        break;
                  }
                  pw.println(x);

                  // to read the input from the client
                  
            }
      }
}
