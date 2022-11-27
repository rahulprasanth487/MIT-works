package AssessPractice.UDP;
import java.net.*;
import java.io.*;

public class server {
      public static void main(String[] args) throws IOException
      {
            DatagramSocket ss = new DatagramSocket(4160);
            InetAddress inet=InetAddress.getByName("localhost");

            byte buf[]=new byte[1024];

            DatagramPacket pct=new DatagramPacket(buf, 0,buf.length);

            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

            while(true)
            {
                  String x,y;

                  x=br.readLine();
                  buf=x.getBytes();
                  if(x.equals("quit"))
                  {
                        System.out.println("Server is terminated");
                        break;
                  }
                  else{
                        ss.send(new DatagramPacket(buf, x.length(), inet, 4150));
                  }


                  ss.receive(pct);
                  String out=new String(pct.getData(),0,pct.getLength());
                  if(out.equals("quit"))
                  {
                        break;
                  }
                  else{
                        System.out.println("Client = "+out);
                  }
            }
            
      }
}
