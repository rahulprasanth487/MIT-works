import java.io.*;
import java.net.*;
import java.util.*;


public class DNSClient{
      public static void main(String[] args) throws Exception {
            DatagramSocket ss=new DatagramSocket(1490);
            byte buf[]=new byte[1024];
            InetAddress inet=InetAddress.getByName("localhost");
            DatagramPacket dp=new DatagramPacket(buf, 0,buf.length);
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

            String inp;
            System.out.println("Enter the IP Address = ");
            inp=br.readLine();

            buf=inp.getBytes();
            ss.send(new DatagramPacket(buf,inp.length(),inet,1390));

            //now to receive

            ss.receive(dp);
            String ans=new String(dp.getData());
            System.out.println("The output is = "+ans.trim());
      }
}